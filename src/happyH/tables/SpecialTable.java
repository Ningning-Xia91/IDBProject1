package happyH.tables;

import happyH.models.Special;
import happyH.utils.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialTable {
	public final static String TABLE_NAME = "Special_cuisines";
	public final static String SID = "sc_id";
	public final static String RID = "r_id";
	public final static String SNAME = "sc_name";
	public final static String PRICE = "sc_price";
	public final static String DETAILS = "sc_details";

	public static List<Special> getSpecialsByRid(String rid) {
		List<Special> specialList = new ArrayList<Special>();
		
		String sql = "SELECT * FROM " + TABLE_NAME +" WHERE "+RID +"= '"+ rid+"'";
		System.out.println(sql);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnectionFromDataSource();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Special special = constructSpecialFromResultSet(rs);
				specialList.add(special);
			}
			return specialList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	private static Special constructSpecialFromResultSet(ResultSet rs) {
		try {
			Special special = new Special();
			special.setSc_id(rs.getString(SID));
			special.setR_id(rs.getString(RID));
			special.setSc_details(rs.getString(DETAILS));
			special.setSc_name(rs.getString(SNAME));
			special.setSc_price(Integer.parseInt(rs.getString(PRICE)));
			return special;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
