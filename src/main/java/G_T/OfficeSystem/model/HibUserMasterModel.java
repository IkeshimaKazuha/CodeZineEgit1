package G_T.OfficeSystem.model;

import java.sql.Timestamp;

public class HibUserMasterModel {
	private String userId;
	private String password;
	private String email;
	private Timestamp updatetime;
	private Timestamp inserttime;
	private String lastlogindate;
	private String registerLink;
	private Timestamp registerLinkTime;
	private Integer type;
	private HibProfileInfoModel hibProfileInfoModel;
	
	public HibUserMasterModel() {

	}

	public HibUserMasterModel(
			String userId,
			String password,
			String email,
			Timestamp updatetime,
			Timestamp inserttime,
			String lastlogindate,
			String registerLink,
			Timestamp registerLinkTime,
			Integer type,
			HibProfileInfoModel hibProfileInfoModel) {

		this.userId = userId;
		this.password = password;
		this.email = email;
		this.updatetime = updatetime;
		this.inserttime = inserttime;
		this.lastlogindate = lastlogindate;
		this.registerLink = registerLink;
		this.registerLinkTime = registerLinkTime;
		this.type = type;
		this.hibProfileInfoModel = hibProfileInfoModel;

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Timestamp getInserttime() {
		return inserttime;
	}

	public void setInserttime(Timestamp inserttime) {
		this.inserttime = inserttime;
	}

	public String getLastlogindate() {
		return lastlogindate;
	}

	public void setLastlogindate(String lastlogindate) {
		this.lastlogindate = lastlogindate;
	}

	public String getRegisterLink() {
		return registerLink;
	}

	public void setRegisterLink(String registerLink) {
		this.registerLink = registerLink;
	}

	public Timestamp getRegisterLinkTime() {
		return registerLinkTime;
	}

	public void setRegisterLinkTime(Timestamp registerLinkTime) {
		this.registerLinkTime = registerLinkTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public HibProfileInfoModel getHibProfileInfoModel() {
		return hibProfileInfoModel;
	}

	public void setHibProfileInfoModel(HibProfileInfoModel hibProfileInfoModel) {
		this.hibProfileInfoModel = hibProfileInfoModel;
	}
}