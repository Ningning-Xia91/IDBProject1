package happyH.tables;

import happyH.models.Evaluation;
import happyH.models.User;
import happyH.utils.DBUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EvaluationTable {

	public final static String TABLE_NAME = "Evaluations";
	public final static String RID = "r_id";
	public final static String UID = "u_id";
	public final static String RATING = "rating";
	public final static String REVIEW = "review";
	public final static String ETIME = "e_time";
	
	public static void insertOneEvaluation(Evaluation evaluation) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "Insert Into " + TABLE_NAME + 
				" ( " + RID + ", " + UID+ ", " + RATING + ", " + REVIEW + ", " + ETIME
				  + ") VALUES (?, ?, ?, ?, to_date(?, 'yyyy-mm-dd'))";
		System.out.print(sql);

		
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, evaluation.getR_id());
			ps.setString(2, evaluation.getU_id());
			ps.setDouble(3, evaluation.getRating());
			ps.setString(4, evaluation.getReview());
			ps.setString(5, evaluation.getE_time());
			
			System.out.println(evaluation.getE_time());
			
			ps.addBatch();
			ps.executeBatch();
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Evaluation getEvaluationByRidUid(String uid, String rid) {
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE "+ RID +" = '"+rid +"' AND "+ UID+" = '"+uid+"'" ;
		
		System.out.println("get "+sql);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Evaluation eval = null;

		try {
			conn = DBUtil.getConnectionFromDataSource();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				eval = constructEvaluationFromResultSet(rs);
			}
			return eval;
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
	
	public static Evaluation deleteEvaluationByRidUid(String uid, String rid) {
		String sql = "DELETE FROM " + TABLE_NAME + " WHERE "+ RID +" = '"+rid +"' AND "+ UID+" = '"+uid+"'" ;
		
		System.out.println("get "+sql);

		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;

		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate(sql);
			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static ArrayList<Evaluation> getEvaluationByRID(String rid) {
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE "+ RID +" = '"+rid +"'";
		
		System.out.println(sql);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Evaluation> evaList = new ArrayList<Evaluation>();
		Evaluation eval = null;

		try {
			conn = DBUtil.getConnectionFromDataSource();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				eval = constructEvaluationFromResultSet(rs);
				evaList.add(eval);
			}
			return evaList;
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

	private static Evaluation constructEvaluationFromResultSet(ResultSet rs) {
		try {
			Evaluation evaluation = new Evaluation();
			evaluation.setU_id(rs.getString(UID));
			evaluation.setR_id(rs.getString(RID));
			evaluation.setRating(Double.parseDouble(rs.getString(RATING)));
			evaluation.setReview(rs.getString(REVIEW));
			evaluation.setE_time(rs.getString(ETIME));
			return evaluation;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
