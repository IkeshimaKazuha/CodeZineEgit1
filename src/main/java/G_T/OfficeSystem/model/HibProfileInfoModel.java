package G_T.OfficeSystem.model;

import java.sql.Timestamp;

public class HibProfileInfoModel {
//	@Id
//	@Column(name = "user_id")
	private String userId;

	private String nickName;
	private String userName;
	private String birthday;
	private Integer sex;
	private String postcode;
	private String address;
	private String tel;
	private String hireDate;
	private String affiliation;
	private String position;
	private String hobby;
	private String specialSkill;
	private String comment;
	private String imageLink;
	private Timestamp updatetime;
	private Timestamp inserttime;

//	@OneToOne
//	@MapsId
//	@JoinColumn(name = "user_id")
	private HibUserMasterModel hibUserMasterModel;

	public HibProfileInfoModel() {

	}

	public HibProfileInfoModel(
			String userId,
			String nickName,
			String userName,
			String birthday,
			Integer sex,
			String postcode,
			String address,
			String tel,
			String hireDate,
			String affiliation,
			String position,
			String hobby,
			String specialSkill,
			String comment,
			String imageLink,
			Timestamp updatetime,
			Timestamp inserttime,
			HibUserMasterModel hibUserMasterModel) {

		this.userId = userId;
		this.nickName = nickName;
		this.userName = userName;
		this.birthday = birthday;
		this.sex = sex;
		this.postcode = postcode;
		this.address = address;
		this.tel = tel;
		this.hireDate = hireDate;
		this.affiliation = affiliation;
		this.position = position;
		this.hobby = hobby;
		this.specialSkill = specialSkill;
		this.comment = comment;
		this.imageLink = imageLink;
		this.updatetime = updatetime;
		this.inserttime = inserttime;
		this.hibUserMasterModel = hibUserMasterModel;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getSpecialSkill() {
		return specialSkill;
	}

	public void setSpecialSkill(String specialSkill) {
		this.specialSkill = specialSkill;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
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

	public HibUserMasterModel getHibUserMasterModel() {
		return hibUserMasterModel;
	}

	public void setHibUserMasterModel(HibUserMasterModel hibUserMasterModel) {
		this.hibUserMasterModel = hibUserMasterModel;
	}
}
