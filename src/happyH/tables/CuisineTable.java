package happyH.tables;

import happyH.models.Cuisine;
import happyH.utils.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CuisineTable {
	public final static String TABLE_NAME = "Cuisine_types";
	public final static String CID = "ct_id";
	public final static String CNAME = "ct_name";
	public final static String CDETAILS = "ct_details";

	public static List<Cuisine> getAllCuisines() {
		List<Cuisine> cuisineList = new ArrayList<Cuisine>();
		
		String sql = "SELECT * FROM " + TABLE_NAME;
		System.out.println(sql);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnectionFromDataSource();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Cuisine cuisine = constructCuisineFromResultSet(rs);
				cuisineList.add(cuisine);
			}
			return cuisineList;
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
	
	public static Cuisine getCuisineByCid(String cid) {
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE "+ CID +" = '"+cid +"'";
		
		System.out.println(sql);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Cuisine cuisine = null;

		try {
			conn = DBUtil.getConnectionFromDataSource();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cuisine = constructCuisineFromResultSet(rs);		
			}
			return cuisine;
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
	
	public static List<Cuisine> searchCuisineByName(String cname) {
		List<Cuisine> cuisineList = new ArrayList<Cuisine>();
		
		String sql = "SELECT * FROM Cuisine_types WHERE UPPER(ct_name) LIKE UPPER('%"+cname+"%')";
		System.out.println(sql);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnectionFromDataSource();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Cuisine cuisine = constructCuisineFromResultSet(rs);
				cuisineList.add(cuisine);
			}
			return cuisineList;
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
	

	private static Cuisine constructCuisineFromResultSet(ResultSet rs) {
		try {
			Cuisine cuisine = new Cuisine();
			cuisine.setCt_id(rs.getString(CID));
			cuisine.setCt_name(rs.getString(CNAME));
			cuisine.setCt_details(rs.getString(CDETAILS));
			return cuisine;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
