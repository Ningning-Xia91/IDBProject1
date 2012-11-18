package happyH.tables;

import happyH.models.EvaluationFromUser;
import happyH.utils.DBUtil;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EvaluationFromUserTable {

	public final static String ETABLE = "Evaluations";
	public final static String RTABLE = "Restaurants";
	public final static String UTABLE = "Users";
	public final static String RID = "r_id";
	public final static String RNAME = "r_name";
	public final static String UNAME = "u_name";
	public final static String UID = "u_id";
	public final static String RATING = "rating";
	public final static String REVIEW = "review";
	public final static String ETIME = "e_time";

	public static ArrayList<EvaluationFromUser> getEvaluationByRID(String rid) {
		String sql1 = "SELECT * FROM " + ETABLE +", "+ RTABLE + ", " + UTABLE
	+ " WHERE "+ RID +" = '"+rid +"'";
		
		String sql = "SELECT r.r_id, r.r_name,u.u_id, u.u_name, e.rating, e.review, e.e_time " +
				" FROM Evaluations e, Restaurants r, Users u WHERE r.r_id = e.r_id AND " +
				"u.u_id = e.u_id AND e.r_id = "+rid;
		
		System.out.println(sql);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EvaluationFromUser> evalist = new ArrayList<EvaluationFromUser>();
		EvaluationFromUser eval = null;

		try {
			conn = DBUtil.getConnectionFromDataSource();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				eval = constructEvaluationFromResultSet(rs);
				evalist.add(eval);
			}
			return evalist;
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


	private static EvaluationFromUser constructEvaluationFromResultSet(ResultSet rs) {
		try {
			EvaluationFromUser evaluation = new EvaluationFromUser();
			evaluation.setU_id(rs.getString(UID));
			evaluation.setR_id(rs.getString(RID));
			evaluation.setRating(Double.parseDouble(rs.getString(RATING)));
			evaluation.setReview(rs.getString(REVIEW));
			evaluation.setE_time(rs.getString(ETIME));
			evaluation.setR_name(rs.getString(RNAME));
			evaluation.setU_name(rs.getString(UNAME));
			return evaluation;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
