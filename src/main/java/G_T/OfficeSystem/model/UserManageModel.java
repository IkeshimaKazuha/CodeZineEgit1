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
public class UserManageModel {
	// private List<UserInfoModel> allUserList;  //検索結果一覧
	// private List<UserInfoModel> showUserList;
	 @Autowired
	 private SessionFactory sessionFactory;
	 //Hibernate対応
	 private List<HibUserMasterModel> allUserManageList;
	 private List<HibUserMasterModel> showUserManageList;

	 private int showNumber;
	 private int currentPage;
	 private String sortOrder;
	 private String sortColumn;

	 @Autowired
	 private UserManageInfoModelDAO userManageInfoModelDAO;

	 public UserManageModel() {
	  showNumber = 10;
	  currentPage = 1;
	  sortOrder = "▲";
	  sortColumn = "氏名";
	 }

	 public List<HibUserMasterModel> getAllUserManageList() {
	  return allUserManageList;
	 }
	 public void setAllUserManageList(List<HibUserMasterModel> allUserManageList) {
	  this.allUserManageList = allUserManageList;
	 }

	 //ユーザー情報を検索し、検索結果一覧に設定する
	 public void MUser(UserManageConditionModel condition) {
	//  setAllUserList(userInfoModelDAO.FindUser(condition));

		 /*List<HibUserMasterModel> results = UserManageByCondition(condition);
		    setAllUserManageList(results); // これは全件リストの設定
		    setShowUserManageList(results); // こちらが表示用リストの設定
		 */
	  setAllUserManageList(UserManageByCondition(condition));

	  SortAll(sortColumn, sortOrder);
	  GetPage(showNumber, 1);

	 }

	 public void SortAll(String sortColumn, String sortOrder)
	{

	 Collections.sort(this.allUserManageList, new Comparator<HibUserMasterModel>(){
	   public int compare(HibUserMasterModel u1, HibUserMasterModel u2){
	    int invertFlag = -1;
	    if (sortOrder == null || sortOrder.equals("▲") || sortOrder.equals("")){
	     invertFlag = 1;//正負を入れ替える
	    }
	    if(sortColumn == null) {
	    	return invertFlag * 1;
	    }
	    if (("氏名").equals(sortColumn)) {
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
	    else if(("生年月日").equals(sortColumn)) {
		     return invertFlag * (u1.getHibProfileInfoModel().getBirthday().compareTo(u2.getHibProfileInfoModel().getBirthday()) >= 0 ? 1 : -1 );
		    }
	    
	    else if(("電話番号").equals(sortColumn)) {
	     return invertFlag * (u1.getHibProfileInfoModel().getTel().compareTo(u2.getHibProfileInfoModel().getTel()) >= 0 ? 1 : -1 );
	    }
	    else if(("メール").equals(sortColumn)) {
		     return invertFlag * (u1.getEmail().compareTo(u2.getEmail()) >= 0 ? 1 : -1 );
		    }
	    else if(("住所").equals(sortColumn)) {
	     return invertFlag * (u1.getHibProfileInfoModel().getAddress().compareTo(u2.getHibProfileInfoModel().getAddress()) >= 0 ? 1 : -1 );
	    }
	    
	    else if(("所属").equals(sortColumn)) {
		     return invertFlag * (u1.getHibProfileInfoModel().getAffiliation().compareTo(u2.getHibProfileInfoModel().getAffiliation()) >= 0 ? 1 : -1 );
		    }
	    else if(("役職").equals(sortColumn)) {
		     return invertFlag * (u1.getHibProfileInfoModel().getPosition().compareTo(u2.getHibProfileInfoModel().getPosition()) >= 0 ? 1 : -1 );
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
	  if (showNumber == 0 || allUserManageList.size() <= showNumber)  //改ページが必要ない
	  {
	   showUserManageList = allUserManageList;
	  }
	  else
	  {

	   showUserManageList = IntStream.range(0, allUserManageList.size())
	        .filter(index -> index >= (currentPage - 1) * showNumber && index < currentPage * showNumber)
	        .mapToObj(allUserManageList::get)
	        .collect(Collectors.toList());
	  }
	  this.showNumber = showNumber;
	  this.currentPage = currentPage;
	 }

	 public List<HibUserMasterModel> getShowUserManageList() {
	  return showUserManageList;
	 }
	 public void setShowUserManageList(List<HibUserMasterModel> showUserManageList) {
	  this.showUserManageList = showUserManageList;
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
	 System.out.println("UserManageModel. getSortOrder");
	 return sortOrder;
	 }

	 public void setSortOrder(String sortOrder) {
	 System.out.println("UserManageModel. setSortOrder");
	 this.sortOrder = sortOrder;
	 }

	 public String getSortColumn() {
	 System.out.println("UserManageModel. getSortColumn");
	 return sortColumn;
	 }

	 public void setSortColumn(String sortColumn) {
	 System.out.println("UserManageModel. setSortColumn");
	 this.sortColumn = sortColumn;
	 }

	 public void Sort(String sortColumn, String sortOrder) {
	  SortAll(sortColumn, sortOrder);
	  GetPage(showNumber, 1);
	 }

	 public List<HibUserMasterModel> UserManageByCondition(UserManageConditionModel condition) {
	  Session session = null;
	  try {
	   session = sessionFactory.openSession();
	   Criteria criteria = session.createCriteria(HibUserMasterModel.class)
	     .createAlias("hibProfileInfoModel", "p", JoinType.INNER_JOIN);
	   criteria.add(Restrictions.eqProperty("p.userId","userId"));

		if (condition != null) {
			if (condition.getType() != null) {
				criteria.add(Restrictions.eq("type",condition.getType()));
			}
	   }
		//List<HibUserMasterModel> results = criteria.list();
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
