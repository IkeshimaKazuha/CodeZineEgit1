package G_T.OfficeSystem.model;   
   
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;   
   
public class UserInfoModel {   
   
 private String userId;  
 private String password;  
 private String email;  
 private Timestamp lastlogindate;  
 private String registerLink;  
 private Timestamp registerLinkTime;  
 private String type;  
 private String profileId;  
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
 private Integer role;  
   
 public UserInfoModel() {  
   
 }  
   
 public UserInfoModel(  
   String userId,
   String password,
   String email,
   Timestamp lastlogindate,
   String registerLink,
   Timestamp registerLinkTime,
   String type,
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
   String imageLink) {
   
  this.userId = userId; 
  this.password = password; 
  this.email = email; 
  this.lastlogindate = lastlogindate; 
  this.registerLink = registerLink; 
  this.registerLinkTime = registerLinkTime; 
  this.type = type; 
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
 public Timestamp getLastlogindate() {  
  return lastlogindate; 
 }  
 public void setLastlogindate(Timestamp lastlogindate) {  
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
 public String getType() {  
  return type; 
 }  
 public void setType(String type) {  
  this.type = type; 
 }  
 public String getProfileId() {  
  return profileId; 
 }  
 public void setProfileId(String profileId) {  
  this.profileId = profileId; 
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
 public Integer getRole() {  
  return role; 
 }  
 public void setRole(Integer role) {  
  this.role = role; 
 }  
 public Integer getYearOld() {  
  if (birthday != null) { 
   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
   LocalDate birth = LocalDate.parse(birthday, formatter);
   LocalDate today = LocalDate.now();
         return Period.between(birth, today).getYears();  
  } 
  else { 
   return null;
  } 
 }  
}   
