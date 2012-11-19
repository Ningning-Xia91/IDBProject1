package happyH.tables;

import happyH.models.Location;
import happyH.utils.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationTable {

	public final static String TABLE_NAME = "Locations";
	public final static String LOCATIONID = "l_id";
	public final static String RESTID = "r_id";
	public final static String STREET = "street";
	public final static String ZIPCODE = "zipcode";

	public static ArrayList<Location> getlocationByRID(String id) {
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE "+ RESTID +" = '"+id +"'";
		
		System.out.println(sql);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Location> locList = new ArrayList<Location>();
		Location location = null;

		try {
			conn = DBUtil.getConnectionFromDataSource();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				location = constructlocationFromResultSet(rs);
				locList.add(location);
			}
			return locList;
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
	

	public static ArrayList<Location> searchLocationByStreet(String street) {
		String sql = "SELECT * FROM Locations WHERE UPPER(street) LIKE UPPER('%"+street+"%')";
		
		System.out.println(sql);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Location> locList = new ArrayList<Location>();
		Location location = null;

		try {
			conn = DBUtil.getConnectionFromDataSource();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				location = constructlocationFromResultSet(rs);
				locList.add(location);
			}
			return locList;
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



	private static Location constructlocationFromResultSet(ResultSet rs) {
		try {
			Location location = new Location();
			location.setL_id(rs.getString(LOCATIONID));
			location.setR_id(rs.getString(RESTID));
			location.setStreet(rs.getString(STREET));
			location.setZipcode(rs.getString(ZIPCODE));
			return location;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
