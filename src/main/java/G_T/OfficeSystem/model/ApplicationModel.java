package G_T.OfficeSystem.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	//Hibernate対応
	private List<HibApplicationInfoModel> allApplicationList; //HibUserMasterModel
	private List<HibApplicationInfoModel> showApplicationList; //HibUserMasterModel
/*	private int showNumber;
	private int currentPage;*/


	@Autowired
	private ApplicationInfoModelDAO applicationInfoModelDAO;

	public ApplicationModel() {
/*		showNumber = 10;
		currentPage = 1;*/


	}

	public List<HibApplicationInfoModel> getAllApplicationList() {
		return allApplicationList;
	}

	public void setAllApplicationList(List<HibApplicationInfoModel> allApplicationList) {
		this.allApplicationList = allApplicationList;
	}

	//ユーザー情報を検索し、検索結果一覧に設定する
	public void ApplyUser(ApplicationConditionModel condition) {
		//setAllUserList(ApplicationInfoModelDAO.ApplyUser(condition));
		setAllApplicationList(ApplyUserByCondition(condition));
	//	GetPage(showNumber, currentPage);
	}

	public List<HibApplicationInfoModel> ApplyUserByCondition(ApplicationConditionModel condition) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(HibApplicationInfoModel.class);
			//criteria.add(Restrictions.ilike(condition.getApplyStatus(),"applyStatus"));

			/*if (condition != null) {
				if (condition.getUserId() != null && !condition.getUserId().equals("")) {
					criteria.add(Restrictions.like("userId", "%" + condition.getUserId() + "%"));
				}
				if (condition.getApplyId() != null && !condition.getApplyId().equals("")) {
					criteria.add(Restrictions.like("applyId", "%" + condition.getApplyId() + "%"));
				}
				if (condition.getTitle() != null && !condition.getTitle().equals("")) {
					criteria.add(Restrictions.like("title", "%" + condition.getTitle() + "%"));
				}
				if (condition.getApplyType() != null && !condition.getApplyType().equals("")) {
					criteria.add(Restrictions.like("applyType", "%" + condition.getApplyType() + "%"));
				}
				if (condition.getNoticeMatter() != null && !condition.getNoticeMatter().equals("")) {
					criteria.add(Restrictions.like("noticeMatter", "%" + condition.getNoticeMatter() + "%"));
				}
				if (condition.getApplyStatus() != null && !condition.getApplyStatus().equals("")) {
					criteria.add(Restrictions.like("applyStatus", "%" + condition.getApplyStatus() + "%"));
				}
				if (condition.getApplyTime() != null && !condition.getApplyTime().equals("")) {
					criteria.add(Restrictions.like("applyTime", "%" + condition.getApplyTime() + "%"));
				}
				if (condition.getApproveTime() != null && !condition.getApproveTime().equals("")) {
					criteria.add(Restrictions.like("approveTime", "%" + condition.getApproveTime() + "%"));
				}
			}*/
			List<HibApplicationInfoModel> results = criteria.list();
		return criteria.list();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public List<HibApplicationInfoModel> getShowApplicationList() {
		return showApplicationList;
	}

	public void setShowUserList(List<HibApplicationInfoModel> showApplicationList) {
		this.showApplicationList = showApplicationList;
	}

/*	public int getShowNumber() {
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

	public void GetPage(int showNumber, int currentPage) {
		if (showNumber == 0 || allUserList.size() <= showNumber) {
			showUserList = allUserList;
		} else {
			showUserList = IntStream.range(0, allUserList.size())
					.filter(index -> index >= (currentPage - 1) * showNumber && index < currentPage * showNumber)
					.mapToObj(allUserList::get)
					.collect(Collectors.toList());
		}
		this.showNumber = showNumber;
		this.currentPage = currentPage;
	 }
*/
}
