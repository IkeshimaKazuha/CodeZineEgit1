package G_T.OfficeSystem.model;

import java.sql.Timestamp;


public class HibApplicationInfoModel {
	private Integer applyId;
	private Integer applyStatus;
	private String applyFile;
	private String title;
	private Timestamp applyTime;
	private Timestamp approveTime;
	private String noticeMatter;
	private String userId;
	private HibUserMasterModel hibUserMasterModel;

	public HibApplicationInfoModel() {

	}


	public HibApplicationInfoModel(
			Integer applyId,
			Integer applyStatus,
			String applyFile,
			String title,
			String userId,
			Timestamp applyTime,
			Timestamp approveTime,
			String noticeMatter,
			HibUserMasterModel hibUserMasterModel) {


		this.applyId = applyId;
		this.applyStatus = applyStatus;
		this.applyFile = applyFile;
		this.title = title;
		this.userId = userId;
		this.applyTime = applyTime;
		this.approveTime = approveTime;
		this.noticeMatter = noticeMatter;
		this.hibUserMasterModel = hibUserMasterModel;
	}

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public Integer getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

	public String getApplyFile() {
		return applyFile;
	}

	public void setApplyFile(String applyFile) {
		this.applyFile = applyFile;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getNoticeMatter() {
		return noticeMatter;
	}

	public void setNoticeMatter(String noticeMatter) {
		this.noticeMatter = noticeMatter;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public HibUserMasterModel getHibUserMasterModel() {
		return hibUserMasterModel;
	}

	public void setHibUserMasterModel(HibUserMasterModel hibUserMasterModel) {
		this.hibUserMasterModel = hibUserMasterModel;
	}
}
