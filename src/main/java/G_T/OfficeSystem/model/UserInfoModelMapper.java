package G_T.OfficeSystem.model;      
      
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;      
      
public class UserInfoModelMapper implements RowMapper<UserInfoModel> {      
 public static final String BASE_SQL = "Select u.USER_ID," +      
   "u.PASSWORD," +    
   "u.EMAIL," +    
   "u.LASTLOGINDATE," +    
   "u.REGISTER_LINK," +    
   "u.REGISTER_LINK_TIME," +    
   "u.TYPE," +    
   "p.NICK_NAME," +    
   "p.USER_NAME," +    
   "p.BIRTHDAY," +     
   "p.SEX," +    
   "p.POSTCODE," +    
   "p.ADDRESS," +    
   "p.TEL," +    
   "p.HIRE_DATE," +    
   "p.AFFILIATION," +    
   "p.POSITION," +    
   "p.HOBBY," +    
   "p.SPECIAL_SKILL," +    
   "p.COMMENT," +    
   "p.IMAGE_LINK " +   
   "from user_master u " +   
   "    left join profile_info p on u.USER_ID = p.USER_ID " +   
   "where 1=1";   
      
 @Override     
 public UserInfoModel mapRow(ResultSet rs, int rowNum) throws SQLException {     
  String userId = rs.getString("USER_ID");    
  String password = rs.getString("PASSWORD");    
  String email = rs.getString("EMAIL");    
  Timestamp lastlogindate = rs.getTimestamp("LASTLOGINDATE");    
  String registerLink = rs.getString("REGISTER_LINK");    
  Timestamp registerLinkTime = rs.getTimestamp("REGISTER_LINK_TIME");    
  Integer type = rs.getInt("TYPE");    
  String nickName = rs.getString("NICK_NAME");    
  String userName = rs.getString("USER_NAME");    
  String birthday = rs.getString("BIRTHDAY");    
  Integer sex = rs.getInt("SEX");    
  String postcode = rs.getString("POSTCODE");    
  String address = rs.getString("ADDRESS");    
  String tel = rs.getString("TEL");    
  String hireDate = rs.getString("HIRE_DATE");    
  String affiliation = rs.getString("AFFILIATION");    
  String position = rs.getString("POSITION");    
  String hobby = rs.getString("HOBBY");    
  String specialSkill = rs.getString("SPECIAL_SKILL");    
  String comment = rs.getString("COMMENT");    
  String imageLink = rs.getString("IMAGE_LINK");    
      
  return new UserInfoModel(    
    userId,  
    password,  
    email,  
    lastlogindate,  
    registerLink,  
    registerLinkTime,  
    type,  
    nickName,  
    userName,  
    birthday,  
    sex,  
    postcode,  
    address,  
    tel,  
    hireDate,  
    affiliation,  
    position,  
    hobby,  
    specialSkill,  
    comment,  
    imageLink  
  );    
 }     
}      

