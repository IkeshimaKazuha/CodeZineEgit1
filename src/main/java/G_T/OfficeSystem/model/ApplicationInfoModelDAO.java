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
      
 public Integer CheckUser(String userId, String password,String email) {    
  String sql = "select count(*) from user_master where 1 = 1";    
      
  if(!userId.equals("")) {    
   sql += " and USER_ID = '" + userId + " '";   
  }    
      
  if(!password.equals("")) {    
   sql += " and PASSWORD = '" + password + "'";   
  }    
  
  if(!email.equals("")) {    
	   sql += " and EMAIL = '" + email + "'";   
	  } 
      
  try {    
   return getJdbcTemplate().queryForObject(sql, new Object[] { }, Integer.class);   
  } catch (EmptyResultDataAccessException e) {    
   return null;   
  }    
 }     
      
 public List<ApplicationInfoModel> ApplyUser(ApplicationConditionModel condition) { //「List」クラス     
  String sql = ApplicationInfoModelMapper.BASE_SQL ;    //登録済のユーザーだけを取得する
      
  if (condition != null) {    
      
		if (condition.getUserId() != null && !condition.getUserId().equals("")) {
			sql += " and USER_ID like '%" + condition.getUserId() + "%'";
		}

		if (condition.getApplyStatus() != null && !condition.getApplyStatus().equals("")) {
			sql += " and APPLY_STATUS like '%" + condition.getApplyStatus() + "%'";
		}
		if (condition.getTitle() != null && !condition.getTitle().equals("")) {
			sql += " and TITLE like '%" + condition.getTitle() + "%'";
		}
		if (condition.getApplyType() != null && !condition.getApplyType().equals("")) {
			sql += " and APPLY_TYPE like '%" + condition.getApplyType() + "%'";
		}
		if (condition.getApplyFile() != null && !condition.getApplyFile().equals("")) {
			sql += " and APPLY_FILE like '%" + condition.getApplyFile() + "%'";
		}
		if (condition.getNoticeMatter() != null && !condition.getNoticeMatter().equals("")) {
			sql += " and NOTICE_MATTER like '%" + condition.getNoticeMatter() + "%'";
		}
		if (condition.getApplyTime() != null && !condition.getApplyTime().equals("")) {
			sql += " and APPLY_TIME like '%" + condition.getApplyTime() + "%'";
		}
		if (condition.getApproveTime() != null && !condition.getApproveTime().equals("")) {
			sql += " and APPROVETIME like '%" + condition.getApproveTime() + "%'";
		}
		if (condition.getRemandTime() != null && !condition.getRemandTime().equals("")) {
			sql += " and REMAND_TIME like '%" + condition.getRemandTime() + "%'";
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
     