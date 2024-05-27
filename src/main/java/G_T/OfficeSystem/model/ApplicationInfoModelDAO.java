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
public class ApplicationInfoModelDAO extends JdbcDaoSupport {      
      
 @Autowired//アノテーション「@Autowired」を利用されている為、     
 public ApplicationInfoModelDAO(DataSource dataSource) {     
 this.setDataSource(dataSource);     
 }     
      
 public Integer CheckUser(LoginModel model) {     
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
      
 public List<ApplicationInfoModel> ApplyUser(ApplicationConditionModel condition) { //「List」クラス     
  String sql = UserInfoModelMapper.BASE_SQL ;    //登録済のユーザーだけを取得する
      
  if (condition != null) {    
      
		if (condition.getApplyId() != null && !condition.getApplyId().equals("")) {
			sql += " and APPLY_ID like '%" + condition.getApplyId() + "%'";
		}

		if (condition.getApplyStatus() != null && !condition.getApplyStatus().equals("")) {
			sql += " and APPLY_STATUS like '%" + condition.getApplyStatus() + "%'";
		}


		}
 ApplicationInfoModelMapper mapper = new ApplicationInfoModelMapper();
	try {
		List<ApplicationInfoModel> list = this.getJdbcTemplate().query(sql, mapper);
		return list;
	} catch (EmptyResultDataAccessException e) {
		return null;
	}

}     
 }     
     