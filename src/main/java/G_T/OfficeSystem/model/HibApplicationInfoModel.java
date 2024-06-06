package G_T.OfficeSystem.model;

import java.sql.Timestamp;


public class HibApplicationInfoModel {
	private String userId;
	private Integer applyId;
	private String title;
	private String applyType;
	private String applyFile;
	private String noticeMatter;
	private String applyStatus;
	private String applyTime;
	private String approveTime;
	private Timestamp remandTime;

	public HibApplicationInfoModel() {

	}


	public HibApplicationInfoModel(
			String userId,
			Integer applyId,
			String title,
			String applyType,
			String applyFile,
			String noticeMatter,
			String applyStatus,
			String applyTime,
			String approveTime,
			Timestamp remandTime
			) {

		
		this.userId = userId;
		this.applyId = applyId;
		this.title = title;
		this.applyType = applyType;
		this.applyFile = applyFile;
		this.noticeMatter = noticeMatter;
		this.applyStatus = applyStatus;
		this.applyTime = applyTime;
		this.approveTime = approveTime;
		this.remandTime = remandTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;		
	}
	
	public String getApplyFile() {
		return applyFile;
	}

	public void setApplyFile(String applyFile) {
		this.applyFile = applyFile;
	}
	
	public String getNoticeMatter() {
		return noticeMatter;
	}

	public void setNoticeMatter(String noticeMatter) {
		this.noticeMatter = noticeMatter;
	}
	
	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(String approveTime) {
		this.approveTime = approveTime;
	}
	
	public Timestamp getRemandTime() {
		return remandTime;
	}

	public void setRemandTime(Timestamp remandTime) {
		this.remandTime = remandTime;
	}

}
