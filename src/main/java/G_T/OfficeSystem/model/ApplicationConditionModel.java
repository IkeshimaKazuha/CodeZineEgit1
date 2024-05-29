package G_T.OfficeSystem.model;

public class ApplicationConditionModel {
	private String userId;
	private String applyId;
	private Integer applyStatus;
	private String title;
	private String applyType;
	private String applyFile;
	private String noticeMatter;
	private String applyTime;
	private String approveTime;
	private String remandTime;

	public ApplicationConditionModel() {

	}

	public ApplicationConditionModel(
			String userId,
			String applyId,
			Integer applyStatus,
			String title,
			String applyType,
			String applyFile,
			String noticeMatter,
			String applyTime,
			String approveTime,
			String remandTime) {
		this.userId = userId;
		this.applyId = applyId;
		this.applyStatus = applyStatus;
		this.title = title;
		this.applyType = applyType;
		this.applyFile = applyFile;
		this.noticeMatter = noticeMatter;
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

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public Integer getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
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

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getApproveTime() {
		return approveTime;
	}

	public void setApprove(String approveTime) {
		this.approveTime = approveTime;
	}

	public String getRemandTime() {
		return remandTime;
	}

	public void setRemandTime(String remandTime) {
		this.remandTime = remandTime;
	}

}
