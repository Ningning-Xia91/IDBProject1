package happyH.tables;

import happyH.models.Restaurant;
import happyH.models.User;
import happyH.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecommendTable {
	
	public final static String TABLE_NAME = "Restaurants";
	public final static String ID = "r_id";
	public final static String NAME = "r_name";
	public final static String DETAILS = "r_details";
	public final static String AVERAGE_PRICE = "ave_price";
	public final static String CUISINE_TYPE_ID = "ct_id";
	
	public static List<Restaurant> RecommendByLocation(User user)
	{
		List<Restaurant> restList = new ArrayList<Restaurant> ();
		String sql = "SELECT * FROM "+TABLE_NAME;
		String area = user.getArea();
		String cname = user.getPref_type();
		System.out.println(cname);
		//String sql1 = "SELECT * FROM Restaurants WHERE default_area = '"+area+"' or ct_id ='"+cid+"'";
		String sql2 ="select r.r_id, r.r_name, r.r_details,  r.ave_price, r.ct_id , AVG(e.rating) rates from restaurants r, locations l, evaluations e " +
				"where r.r_id = e.r_id and r.r_id = l.r_id and l.area = '"+area+"' and r.ct_id= (select c.ct_id from cuisine_types c where c.ct_name ='"+
				cname+"' ) group by r.r_id, r.r_name, r.r_details, r.ave_price, r.ct_id order by rates desc";
		System.out.println(sql2);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnectionFromDataSource();
			pstmt = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				
					Restaurant restaurant = constructRestaurantFromResultSet(rs);
					restList.add(restaurant);
				
			}		
			return restList;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}
	
	private static Restaurant constructRestaurantFromResultSet(ResultSet rs) {
		try {
			Restaurant rest = new Restaurant();
			rest.setR_id(rs.getString(ID));
			rest.setR_name(rs.getString(NAME));
			rest.setR_details(rs.getString(DETAILS));
			rest.setAve_price(rs.getInt(AVERAGE_PRICE));
			rest.setCt_id(rs.getString(CUISINE_TYPE_ID));
			return rest;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
