package G_T.OfficeSystem.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

public class ApplicationInfoModelMapper implements RowMapper<ApplicationInfoModel> {
	public static final String BASE_SQL = "Select * from application_info where 1=1";

	@Override
	public ApplicationInfoModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		String userId = rs.getString("USER_ID");
		Integer applyId = rs.getInt("APPLY_ID");
		String title = rs.getString("TITLE");
		String applyType = rs.getString("APPLY_TYPE");
		String applyFile = rs.getString("APPLY_FILE");
		String noticeMatter = rs.getString("NOTICE_MATTER");
		String applyStatus = rs.getString("APPLY_STATUS");
		//Timestamp applyTime = rs.getTimestamp("APPLY_TIME");    
		Timestamp approve = rs.getTimestamp("APPROVE_TIME");
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
		String approveTime = simpleDateFormat2.format(approve);
		Timestamp remandTime = rs.getTimestamp("REMAND_TIME");

		Timestamp apply = rs.getTimestamp("APPLY_TIME"); // rsはResultSet
		// String型に変換
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
		String applyTime = simpleDateFormat1.format(apply);

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
				remandTime);
	}
}
