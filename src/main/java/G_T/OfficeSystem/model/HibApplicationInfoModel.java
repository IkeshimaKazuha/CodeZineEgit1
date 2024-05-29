package G_T.OfficeSystem.model;

import java.sql.Timestamp;


public class HibApplicationInfoModel {
	private String userId;
	private Integer applyId;
	private String title;
	private String applyType;
	private String applyFile;
	private String noticeMatter;
	private Integer applyStatus;
	private Timestamp applyTime;
	private Timestamp approveTime;

	public HibApplicationInfoModel() {

	}


	public HibApplicationInfoModel(
			String userId,
			Integer applyId,
			String title,
			String applyType,
			String applyFile,
			String noticeMatter,
			Integer applyStatus,
			Timestamp applyTime,
			Timestamp approveTime
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
	
	public Integer getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

	public Timestamp getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Timestamp applyTime) {
		this.applyTime = applyTime;
	}

	public Timestamp getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(Timestamp approveTime) {
		this.approveTime = approveTime;
	}
}
