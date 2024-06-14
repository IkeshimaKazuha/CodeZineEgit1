package G_T.OfficeSystem.model;      
      
import java.util.List; //「List」クラスを使っているのでクラス定義をインポートする

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;      
      
@Repository      
@Transactional //データベースとのやり取りする処理が失敗した場合、データを前の状態に戻す      
public class UserManageInfoModelDAO extends JdbcDaoSupport {      
      
 @Autowired//アノテーション「@Autowired」を利用されている為、     
 public UserManageInfoModelDAO(DataSource dataSource) {     
 this.setDataSource(dataSource);     
 }     
      
 public Integer CheckUser(LoginModel model) { //Findのまま    
  String sql = "select count(*) from user_master where 1 = 1";    
      
  if(model.getUserId() != "") {    
   sql += " and USER_ID = '" + model.getUserId() + " '";   
  }    
      
  if(model.getPassword() != "") {    
   sql += " and PASSWORD = '" + model.getPassword() + "'";   
  }    
  
  if(model.getEmail() != "") {    
	   sql += " and EMAIL = '" + model.getEmail() + "'";   
	  } 
      
  try {    
   return getJdbcTemplate().queryForObject(sql, new Object[] { }, Integer.class);   
  } catch (EmptyResultDataAccessException e) {    
   return null;   
  }    
 }     
      
 public List<UserManageInfoModel> MUser(UserManageConditionModel condition) { //「List」クラス     
  String sql = UserManageInfoModelMapper.BASE_SQL + " and u.TYPE = 2 ";    //登録済のユーザーだけを取得する
      
  if (condition != null) {    
            
   if (condition.getUserName() != null && !condition.getUserName().equals("")) {   
    sql += " and p.USER_NAME like '%" + condition.getUserName() + "%'";  
   }   
   if (condition.getSex() != null && !condition.getSex().equals("")) {   
	    sql += " and p.SEX like '%" + condition.getSex() + "%'";  
	   }             
   if (condition.getBirthday1() == "") {   
    sql += "and p.BIRTHDAY like '%" + "___" + condition.getBirthday2() +  
      condition.getBirthday3()+ "%'";
   } else if(condition.getBirthday2() == "") {   
    sql += "and p.BIRTHDAY like '%" + condition.getBirthday1() + "__" +  
      condition.getBirthday3() + "%'";
   } else if(condition.getBirthday3() == "") {   
    sql += "and p.BIRTHDAY like '%" + condition.getBirthday1() +  
      condition.getBirthday2() + "__" + "%'";
   } else {   
    sql += "and p.BIRTHDAY like '%" + condition.getBirthday1() +  
      condition.getBirthday2() + condition.getBirthday3() + "%'";
   }    
   if (condition.getTel() != null && !condition.getTel().equals("")) {   
    sql += " and p.TEL like '%" + condition.getTel() + "%'";  
   }   
   if (condition.getEmail() != null && !condition.getEmail().equals("")) {   
	    sql += " and u.EMAIL like '%" + condition.getEmail() + "%'";  
	   }      
   if (condition.getAddress() != null && !condition.getAddress().equals("")) {   
    sql += " and p.ADDRESS like '%" + condition.getAddress() + "%'";  
   }    
   if (condition.getAffiliation() != null && !condition.getAffiliation().equals("")) {   
    sql += " and p.AFFILIATION like '%" + condition.getAffiliation() + "%'";  
   }   
      
   if (condition.getPosition() != null && !condition.getPosition().equals("")) {   
    sql += " and p.POSITION like '%" + condition.getPosition() + "%'";  
   }   
   if (condition.getType() != null && !condition.getType().equals("")) {   
	    sql += " and u.TYPE like '%" + condition.getType() + "%'";  
	   }   
  }    
      
  UserManageInfoModelMapper mapper = new UserManageInfoModelMapper();    
  try {    
   List<UserManageInfoModel> list = this.getJdbcTemplate().query(sql, mapper);   //クエリを実行して、取得した結果を「UserInfoModel」のリストに代入して、呼んでいるところにリストを返す。
   return list;   //FindModel FindUserへ
  } catch (EmptyResultDataAccessException e) {    
   return null;   
  }    
      
 }     
      
}