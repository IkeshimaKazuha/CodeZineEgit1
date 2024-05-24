package G_T.OfficeSystem.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import G_T.OfficeSystem.model.ApplicationConditionModel;
import G_T.OfficeSystem.model.HibUserMasterModel;
import G_T.OfficeSystem.model.UserInfoModelDAO;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ApplicationModel {

 @Autowired
 private SessionFactory sessionFactory;
// private List<UserInfoModel> allUserList;  //検索結果一覧
// private List<UserInfoModel> showUserList;

 //Hibernate対応
 private List<HibUserMasterModel> allUserList;
 private List<HibUserMasterModel> showUserList;

 private int showNumber;
 private int currentPage;
 private String sortOrder;
 private String sortColumn;

 @Autowired
 private UserInfoModelDAO userInfoModelDAO;

 public ApplicationModel() {
  showNumber = 10;
  currentPage = 1;
  sortOrder = "▲";
  sortColumn = "申請ID";
 }

 public List<HibUserMasterModel> getAllUserList() {
  return allUserList;
 }
 public void setAllUserList(List<HibUserMasterModel> allUserList) {
  this.allUserList = allUserList;
 }

 //ユーザー情報を検索し、検索結果一覧に設定する
 public void ApplyUser(ApplicationConditionModel condition) {
//  setAllUserList(userInfoModelDAO.FindUser(condition));

  setAllUserList(FindUserByCondition(condition));

  SortAll(sortColumn, sortOrder);
  GetPage(showNumber, currentPage);

 }

 public void SortAll(String sortColumn, String sortOrder)
 {

  Collections.sort(this.allUserList, new Comparator<HibUserMasterModel>(){
   public int compare(HibUserMasterModel u1, HibUserMasterModel u2){
    int invertFlag = -1;
    if (sortOrder == null || sortOrder.equals("▲") || sortOrder.equals("")){
     invertFlag = 1;//正負を入れ替える
    }
    if (("ユーザーID").equals(sortColumn)) {
     return invertFlag * (u1.getUserId().compareTo(u2.getUserId()) >= 0 ? 1 : -1);
    }
    else if (("氏名").equals(sortColumn)) {
     return invertFlag * (u1.getHibProfileInfoModel().getUserName().compareTo(u2.getHibProfileInfoModel().getUserName()) >= 0 ? 1 : -1);
    }
    else if(("性別").equals(sortColumn)) {
     //return 1;
     int a = u1.getHibProfileInfoModel().getSex().compareTo(u2.getHibProfileInfoModel().getSex());
     int b = a >= 0 ? 1 : -1 ;
     int c = invertFlag * b;
     System.out.println(a + "*" + b + "*" + c + "*" + u1.getUserId() + "*" + u2.getUserId());
     return c;
     //return invertFlag * (u1.getSex().compareTo(u2.getSex()) > 0 ? 1 : -1 );
    }
    else if(("電話番号").equals(sortColumn)) {
     return invertFlag * (u1.getHibProfileInfoModel().getTel().compareTo(u2.getHibProfileInfoModel().getTel()) >= 0 ? 1 : -1 );
    }
    else if(("郵便番号").equals(sortColumn)) {
     return invertFlag * (u1.getHibProfileInfoModel().getPostcode().compareTo(u2.getHibProfileInfoModel().getPostcode()) >= 0 ? 1 : -1 );
    }
    else if(("住所").equals(sortColumn)) {
     return invertFlag * (u1.getHibProfileInfoModel().getAddress().compareTo(u2.getHibProfileInfoModel().getAddress()) >= 0 ? 1 : -1 );
    }
    else if(("コメント").equals(sortColumn)) {
        return invertFlag * (u1.getHibProfileInfoModel().getComment().compareTo(u2.getHibProfileInfoModel().getComment()) >= 0 ? 1 : -1 );
       }
    else {
     return invertFlag * 1;
    }
   }
  });

  this.sortColumn = sortColumn;
  this.sortOrder = sortOrder;
  GetPage(showNumber, 1);

 }

 public void GetPage(int showNumber, int currentPage)
 {
  if (showNumber == 0 || allUserList.size() <= showNumber)  //改ページが必要ない
  {
   showUserList = allUserList;
  }
  else
  {

   showUserList = IntStream.range(0, allUserList.size())
        .filter(index -> index >= (currentPage - 1) * showNumber && index < currentPage * showNumber)
        .mapToObj(allUserList::get)
        .collect(Collectors.toList());
  }
  this.showNumber = showNumber;
  this.currentPage = currentPage;
 }

 public List<HibUserMasterModel> getShowUserList() {
  return showUserList;
 }
 public void setShowUserList(List<HibUserMasterModel> showUserList) {
  this.showUserList = showUserList;
 }

 public int getShowNumber() {
  return showNumber;
 }
 public void setShowNumber(int showNumber) {
  this.showNumber = showNumber;
 }

 public int getCurrentPage() {
  return currentPage;
 }
 public void setCurrentPage(int currentPage) {
  this.currentPage = currentPage;
 }


 public String getSortOrder() {
 System.out.println("ApplicationModel. getSortOrder");
 return sortOrder;
 }

 public void setSortOrder(String sortOrder) {
 System.out.println("ApplicationModel. setSortOrder");
 this.sortOrder = sortOrder;
 }

 public String getSortColumn() {
 System.out.println("ApplicationModel. getSortColumn");
 return sortColumn;
 }

 public void setSortColumn(String sortColumn) {
 System.out.println("ApplicationModel. setSortColumn");
 this.sortColumn = sortColumn;
 }

 public void Sort(String sortColumn, String sortOrder) {
  SortAll(sortColumn, sortOrder);
  GetPage(showNumber, 1);
 }

 public List<HibUserMasterModel> FindUserByCondition(ApplicationConditionModel condition) {
  Session session = null;
  try {
   session = sessionFactory.openSession();
   Criteria criteria = session.createCriteria(HibUserMasterModel.class)
     .createAlias("hibApplicationInfoModel", "a", JoinType.INNER_JOIN);
   criteria.add(Restrictions.eqProperty("a.userId","userId"));

   if (condition != null) {
    if (condition.getUserId() != "") {
     criteria.add(Restrictions.like("userId", "%" + condition.getUserId() + "%"));
    }
    if (condition.getEmail() != "") {
     criteria.add(Restrictions.like("email", "%" + condition.getEmail() + "%"));
    }

    if (condition.getApplyId() != "") {
        criteria.add(Restrictions.like("applyId", "%" + condition.getApplyId() + "%"));
       }
    if (condition.getApplyStatus() != "") {
        criteria.add(Restrictions.like("applyStatus", "%" + condition.getApplyStatus() + "%"));
       }
   }

   return criteria.list();
  }
  catch (Exception ex) {
   ex.printStackTrace();
   return null;
  }
  finally {
   session.close();
  }
 }
}