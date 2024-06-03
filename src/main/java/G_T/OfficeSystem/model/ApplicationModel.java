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

	private int showNumber2;
	private int currentPage2;
	private String sortOrder;
	private String sortColumn;
	@Autowired
	private ApplicationInfoModelDAO applicationInfoModelDAO;

	public ApplicationModel() {
		showNumber2 = 10;
		currentPage2 = 1;
		sortOrder = "▲";
		sortColumn = "申請ID";
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
		SortAll2(sortColumn, sortOrder);
		GetPage2(showNumber2, currentPage2);
	}
	public void SortAll2(String sortColumn, String sortOrder) {
		Collections.sort(this.allApplicationList, new Comparator<HibApplicationInfoModel>() {
			public int compare(HibApplicationInfoModel a1, HibApplicationInfoModel a2) {
				int invertFlag = -1;
				if (sortOrder == null || sortOrder.equals("") || sortOrder.equals("▲")) 
				{
					invertFlag = 1;//正負を入れ替える
				}
				if(sortColumn == null) {
					return invertFlag * 1;
				}
				if (("申請ID").equals(sortColumn)) {
					return invertFlag * (a1.getApplyId().compareTo(a2.getApplyId()) >= 0 ? 1 : -1);
				} else if (("タイトル").equals(sortColumn)) {
					return invertFlag * (a1.getTitle().compareTo(a2.getTitle()) >= 0 ? 1 : -1);
				} else if (("状態").equals(sortColumn)) {
					return invertFlag * (a1.getApplyStatus().compareTo(a2.getApplyStatus()) >= 0 ? 1 : -1);
				} else if (("申請種類").equals(sortColumn)) {
					return invertFlag * (a1.getApplyType().compareTo(a2.getApplyType()) >= 0 ? 1 : -1);
				} else if (("申請日").equals(sortColumn)) {
					return invertFlag * (a1.getApplyTime().compareTo(a2.getApplyTime()) >= 0 ? 1 : -1);
				} else if (("承認日").equals(sortColumn)) {
					return invertFlag * (a1.getRemandTime().compareTo(a2.getRemandTime()) >= 0 ? 1 : -1);
				} else {
					return invertFlag * 1;
				}
			}
		});
		this.sortColumn = sortColumn;
		this.sortOrder = sortOrder;
		GetPage2(showNumber2, 1);

	}

	public void GetPage2(int showNumber2, int currentPage2) {
		if (showNumber2 == 0 || allApplicationList.size() <= showNumber2) //改ページが必要ない
		{
			showApplicationList = allApplicationList;
		} else {

			showApplicationList = IntStream.range(0, allApplicationList.size())
					.filter(index -> index >= (currentPage - 1) * showNumber && index < currentPage * showNumber)
					.mapToObj(allApplicationList::get)
					.collect(Collectors.toList());
		}
		this.showNumber = showNumber;
		this.currentPage = currentPage;
	}

	public List<HibApplicationInfoModel> getShowApplicationList() {
		return showApplicationList;
	}

	public void setShowApplicationList(List<HibApplicationInfoModel> showApplicationList) {
		this.showApplicationList = showApplicationList;
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

/*	public String getSortOrder() {
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
		SortAll2(sortColumn, sortOrder);
		GetPage2(showNumber2, 1);
	}*/

	public List<HibApplicationInfoModel> ApplyUserByCondition(ApplicationConditionModel condition) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(HibApplicationInfoModel.class);
			//criteria.add(Restrictions.ilike(condition.getApplyStatus(),"applyStatus"));

			if (condition != null) {
				if (condition.getApplyStatus() != null) {
					criteria.add(Restrictions.like("applyStatus", "%" + condition.getApplyStatus() + "%"));
				}
			}
			//List<HibApplicationInfoModel> results = criteria.list();
			return criteria.list();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

}
