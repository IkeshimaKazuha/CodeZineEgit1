package G_T.OfficeSystem.model;      
      
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;      
      
public class ApplicationInfoModelMapper implements RowMapper<ApplicationInfoModel> {      
 public static final String BASE_SQL = "Select * from application_info where 1=1";   
      
 @Override     
 public ApplicationInfoModel mapRow(ResultSet rs, int rowNum) throws SQLException {     
  String userId = rs.getString("USER_ID");    
  String applyId = rs.getString("APPLY_ID");    
  String title = rs.getString("TITLE");    
  String applyType = rs.getString("APPLY_TYPE");    
  String applyFile = rs.getString("APPLY_FILE");    
  String noticeMatter = rs.getString("NOTICE_MATTER");    
  String applyStatus = rs.getString("APPLY_STATUS");    
  Timestamp applyTime = rs.getTimestamp("APPLY_TIME");    
  Timestamp approveTime = rs.getTimestamp("APPROVE_TIME");
  Timestamp remandTime = rs.getTimestamp("REMAND_TIME");
      
  return new ApplicationInfoModel(    
    userId,  
    applyId,
    title,    
    applyType,    
    applyFile,   
    noticeMatter,    
    applyStatus, 
    applyTime,   
    approveTime,
    remandTime
  );    
 }     
}      

