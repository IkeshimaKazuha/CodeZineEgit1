package G_T.OfficeSystem.model;

import java.util.List;

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
public class ApplicationModel {

 @Autowired
 private SessionFactory sessionFactory;
// private List<UserInfoModel> allUserList;  //検索結果一覧
// private List<UserInfoModel> showUserList;

 //Hibernate対応
 private List<HibApplicationInfoModel> allUserList; //HibUserMasterModel
 private List<HibApplicationInfoModel> showUserList; //HibUserMasterModel
 private int showNumber;
 private int currentPage;
 private String sortOrder;
 private String sortColumn;


 @Autowired
 private ApplicationInfoModelDAO applicationInfoModelDAO;

 @Autowired

	public ApplicationModel(){

		showNumber = 10;
		currentPage = 1;
		sortOrder = "▼";
		sortColumn = "申請ID";

	}


 public List<HibApplicationInfoModel> getAllUserList() {
  return allUserList;
 }
 public void setAllUserList(List<HibApplicationInfoModel> allUserList) {
  this.allUserList = allUserList;
 }

 //ユーザー情報を検索し、検索結果一覧に設定する
 public void ApplyUser(ApplicationConditionModel condition) {
  //setAllUserList(ApplicationInfoModelDAO.ApplyUser(condition));
  setAllUserList(FindUserByCondition(condition));
	setAllUserList(FindUserByCondition(condition));
	SortAll(sortColumn, sortOrder);
	GetPage(showNumber, 1);
 }

 public List<HibApplicationInfoModel> getShowUserList() {
	  return showUserList;
	 }
	 public void setShowUserList(List<HibApplicationInfoModel> showUserList) {
	  this.showUserList = showUserList;
	 }


 public List<HibApplicationInfoModel> FindUserByCondition(ApplicationConditionModel condition) {
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
        criteria.add(Restrictions.like("a.applyId", "%" + condition.getApplyId() + "%"));
       }
    if (condition.getApplyStatus() !=null) {
        criteria.add(Restrictions.eq("a.applyStatus", "%" + condition.getApplyStatus() + "%"));
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
 this.sortColumn = sortColumn;
	this.sortOrder = sortOrder;
	GetPage(showNumber, 1);
}
}