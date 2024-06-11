package G_T.OfficeSystem.model;   
   
public class UserManageConditionModel {   
 private String userId;  
 private String email;
 private Integer type;
 private String nickName;  
 private String userName;  
 private Integer sex;  
 private String birthday1;  
 private String birthday2;  
 private String birthday3;  
 private String birthday;  
 private Integer age;  
 private String tel;  
 private String postcode;  
 private String address;  
 private String hireDate1;  
 private String hireDate2;  
 private String hireDate3;  
 private String hireDate;  
 private String affiliation;  
 private String position;  
 private String hobby;  
 private String specialSkill;  
 private String comment;  
   //検索条件に該当するフィールド
   
 public UserManageConditionModel() {  
   
 }  
   
 public UserManageConditionModel(  //引数ありコンストラクタ　引数名は上記のフィールド名と同じ
   String userId,
   String email,
   Integer type,
   String nickName,
   String userName,
   Integer sex,
   String birthday1,
   String birthday2,
   String birthday3,
   String birthday,
   Integer age,
   String tel,
   String postcode,
   String address,
   String hireDate1,
   String hireDate2,
   String hireDate3,
   String hireDate,
   String affiliation,
   String position,
   String hobby,
   String specialSkill,
   String comment
 ) {  
   this.userId = userId;
   this.email = email;
   this.type = type;
   this.nickName =  nickName;
   this.userName = userName;
   this.sex = sex;
   this.birthday1 = birthday1;
   this.birthday2 = birthday2;
   this.birthday3 = birthday3;
   this.birthday = birthday;
   this.age = age;
   this.tel = tel;
   this.postcode = postcode;
   this.address = address;
   this.hireDate1 = hireDate1;
   this.hireDate2 = hireDate2;
   this.hireDate3 = hireDate3;
   this.hireDate = hireDate;
   this.affiliation = affiliation;
   this.position = position;
   this.hobby = hobby;
   this.specialSkill = specialSkill;
   this.comment = comment;
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
 public Integer getType() {
	 return type;
 }
 public void setType(Integer type){
  this.type = type;
 }
 public String getNickName() {  
  return nickName; 
 }  
 public void setNickName(String nickName){  
  this.nickName = nickName; 
 }  
   
 public String getUserName() {  
  return userName; 
 }  
 public void setUserName(String userName){  
  this.userName = userName; 
 }  
   
 public Integer getSex() {  
  return sex; 
 }  
 public void setSex(Integer sex){  
  this.sex = sex; 
 }  
   
 public String getBirthday1() {  
  return birthday1; 
 }  
 public void setBirthday1(String birthday1) {  
  this.birthday1 = birthday1; 
 }  
 public String getBirthday2() {  
  return birthday2; 
 }  
 public void setBirthday2(String birthday2) {  
  this.birthday2 = birthday2; 
 }  
 public String getBirthday3() {  
  return birthday3; 
 }  
 public void setBirthday3(String birthday3) {  
  this.birthday3 = birthday3; 
 }  
   
 public String getBirthday() {  
  String s = getBirthday1() + getBirthday2() + getBirthday3(); 
  setBirthday(s); 
  return birthday; 
 }  
 public void setBirthday(String birthday){  
  //birthday = birthday.replaceAll(",", ""); 
  this.birthday = birthday; 
 }  
   
 public Integer getAge() {  
  return age; 
 }  
 public void setAge(Integer age){  
  this.age = age; 
 }  
   
 public String getTel() {  
  return tel; 
 }  
 public void setTel(String tel){  
  this.tel = tel; 
 }  
   
 public String getPostcode() {  
  return postcode; 
 }  
 public void setPostcode(String postcode){  
  this.postcode = postcode; 
 }  
   
 public String getAddress() {  
  return address; 
 }  
 public void setAddress(String address){  
  this.address = address; 
 }  
   
 public String getHireDate1() {  
  return hireDate1; 
 }  
 public void setHireDate1(String hireDate1) {  
  this.hireDate1 = hireDate1; 
 }  
 public String getHireDate2() {  
  return hireDate2; 
 }  
 public void setHireDate2(String hireDate2) {  
  this.hireDate2 = hireDate2; 
 }  
 public String getHireDate3() {  
  return hireDate3; 
 }  
 public void setHireDate3(String hireDate3) {  
  this.hireDate3 = hireDate3; 
 }  
   
 public String getHireDate() {  
  //hireDate = hireDate.replaceAll(",", ""); 
  String s = getHireDate1() + getHireDate2() + getHireDate3(); 
  setHireDate(s); 
  return hireDate; 
 }  
 public void setHireDate(String hireDate){  
  this.hireDate = hireDate; 
 }  
   
 public String getAffiliation() {  
  return affiliation; 
 }  
 public void setAffiliation(String affiliation){  
  this.affiliation = affiliation; 
 }  
   
 public String getPosition() {  
  return position; 
 }  
 public void setPosition(String position){  
  this.position = position; 
 }  
   
 public String getHobby() {  
  return hobby; 
 }  
 public void setHobby(String hobby){  
  this.hobby = hobby; 
 }  
   
 public String getSpecialSkill() {  
  return specialSkill; 
 }  
 public void setSpecialSkill(String specialSkill){  
  this.specialSkill = specialSkill; 
 }  
   
 public String getComment() {  
  return comment; 
 }  
 public void setComment(String comment){  
  this.comment = comment; 
 }  
}   
