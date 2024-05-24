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

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class FindModel {

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

 public FindModel() {
  showNumber = 10;
  currentPage = 1;
  sortOrder = "▲";
  sortColumn = "ユーザーID";
 }

 public List<HibUserMasterModel> getAllUserList() {
  return allUserList;
 }
 public void setAllUserList(List<HibUserMasterModel> allUserList) {
  this.allUserList = allUserList;
 }

 //ユーザー情報を検索し、検索結果一覧に設定する
 public void FindUser(FindConditionModel condition) {
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
 System.out.println("FindModel. getSortOrder");
 return sortOrder;
 }

 public void setSortOrder(String sortOrder) {
 System.out.println("FindModel. setSortOrder");
 this.sortOrder = sortOrder;
 }

 public String getSortColumn() {
 System.out.println("FindModel. getSortColumn");
 return sortColumn;
 }

 public void setSortColumn(String sortColumn) {
 System.out.println("FindModel. setSortColumn");
 this.sortColumn = sortColumn;
 }

 public void Sort(String sortColumn, String sortOrder) {
  SortAll(sortColumn, sortOrder);
  GetPage(showNumber, 1);
 }

 public List<HibUserMasterModel> FindUserByCondition(FindConditionModel condition) {
  Session session = null;
  try {
   session = sessionFactory.openSession();
   Criteria criteria = session.createCriteria(HibUserMasterModel.class)
     .createAlias("hibProfileInfoModel", "p", JoinType.INNER_JOIN);
   criteria.add(Restrictions.eqProperty("p.userId","userId"));

   if (condition != null) {
    if (condition.getUserId() != "") {
     criteria.add(Restrictions.like("userId", "%" + condition.getUserId() + "%"));
    }
    if (condition.getEmail() != "") {
     criteria.add(Restrictions.like("email", "%" + condition.getEmail() + "%"));
    }

    if (condition.getNickName() != "") {
     criteria.add(Restrictions.like("p.nickName", "%" + condition.getNickName() + "%"));
    }

    if (condition.getUserName() != "") {
     criteria.add(Restrictions.like("p.userName", "%" + condition.getUserName() + "%"));
    }

    if (condition.getSex() != null) {
     criteria.add(Restrictions.eq("p.sex", condition.getSex()));
    }


//    if (condition.getBirthday() != "") {
//     criteria.add(Restrictions.eq("p.birthday", condition.getBirthday()));
//    }

          if (condition.getBirthday() != null && !condition.getBirthday().equals("")) {
           if(condition.getBirthday1() != null && !condition.getBirthday1().equals("")) {
            criteria.add(Restrictions.like("p.birthday", condition.getBirthday1() + "%"));
           }
           if(condition.getBirthday2() != null && !condition.getBirthday2().equals("")) {
            criteria.add(Restrictions.like("p.birthday", "____" + condition.getBirthday2() + "%"));
           }
           if(condition.getBirthday3() != null && !condition.getBirthday3().equals("")) {
             criteria.add(Restrictions.like("p.birthday", "%" + condition.getBirthday3()));
           }
          }

    if (condition.getTel() != "") {
     criteria.add(Restrictions.like("p.tel", "%" + condition.getTel() + "%"));
    }

    if (condition.getPostcode() != "") {
     criteria.add(Restrictions.like("p.postcode", "%" + condition.getPostcode() + "%"));
    }

    if (condition.getAddress() != "") {
     criteria.add(Restrictions.like("p.address", "%" + condition.getAddress() + "%"));
    }

//    if (condition.getHireDate() != "") {
//     criteria.add(Restrictions.eq("p.hireDate", condition.getHireDate()));
//    }

          if (condition.getHireDate() != null && !condition.getHireDate().equals("")) {
           if(condition.getHireDate1() != null && !condition.getHireDate1().equals("")) {
            criteria.add(Restrictions.like("p.hireDate", condition.getHireDate1() + "%"));
           }
           if(condition.getHireDate2() != null && !condition.getHireDate2().equals("")) {
           criteria.add(Restrictions.like("p.hireDate", "____" + condition.getHireDate2() + "%"));
           }
           if(condition.getHireDate3() != null && !condition.getHireDate3().equals("")) {
            criteria.add(Restrictions.like("p.hireDate", "%" + condition.getHireDate3()));
           }
          }

    if (condition.getAffiliation() != "") {
     criteria.add(Restrictions.eq("p.affiliation", condition.getAffiliation()));
    }

    if (condition.getPosition() != "") {
     criteria.add(Restrictions.like("p.position", "%" + condition.getPosition() + "%"));
    }

    if (condition.getSpecialSkill() != "") {
     criteria.add(Restrictions.like("p.specialSkill", "%" + condition.getSpecialSkill() + "%"));
    }

    /*if (condition.getComment() != "") {
     criteria.add(Restrictions.like("p.comment", "%" + condition.getComment() + "%"));
    }*/
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