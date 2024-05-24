package G_T.OfficeSystem.model;

public class ApplicationConditionModel {
	private String userId;
	private String email;

	private String applyId;
	private Integer applyStatus;
	private String title;
	private String applyType;
	private String applyFile;
	private String noticeMatter;
	private String applyTime;
	private String approve;
	private String remandTime;

	public ApplicationConditionModel() {

	}

	public ApplicationConditionModel(
			String userId,
			String email,

			String applyId,
			Integer applyStatus,
			String title,
			String applyType,
			String applyFile,
			String noticeMatter,
			String applyTime,
			String approve,
			String remandTime
			) {
		this.userId = userId;
		this.email = email;

		this.applyId = applyId;
		this.applyStatus = applyStatus;
		this.title = title;
		this.applyType = applyType;
		this.applyFile = applyFile;
		this.noticeMatter = noticeMatter;
		this.applyTime = applyTime;
		this.approve = approve;
		this.remandTime = remandTime;
	}

	 public String getUserId() {  
		  return userId; 
		 }  
		 public void setUserId(String userId){  
		  this.userId = userId; 
		 }  
		   
		 public String getEmail() {  
		  return email; 
		 }  
		 public void setEmail(String email){  
		  this.email = email; 
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

	public String getTitel() {
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
	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}
	
	public String getRemandTime() {
		return remandTime;
	}

	public void setRemandTime(String remandTime) {
		this.remandTime = remandTime;
	}
	
}
