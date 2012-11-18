package happyH.tables;

import happyH.models.Event;
import happyH.models.User;
import happyH.utils.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventTable {

	public final static String TABLE_NAME = "Events";
	public final static String EID = "evt_id";
	public final static String RID = "r_id";
	public final static String TITLE = "evt_title";
	public final static String STIME = "start_time";
	public final static String ETIME = "end_time";
	public final static String DETAILS = "evt_details";

	private static List<Event> eventList = new ArrayList<Event>();

	public static List<Event> getAllEvents() {
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
				Event event = constructEventFromResultSet(rs);
				eventList.add(event);
			}
			return eventList;
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
	
	public static Event getEventByEid(String eid) {
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE "+ EID +" = '"+eid +"'";
		
		System.out.println(sql);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Event event = null;

		try {
			conn = DBUtil.getConnectionFromDataSource();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				event = constructEventFromResultSet(rs);		
			}
			return event;
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
	
	/*public static Event getEventWithRestaurant(String eid) {
		String sql = "SELECT e.*, r.name FROM Evaluations e, Restaurants r WHERE e.r_id = r.r_id AND e.evt_id = "+ eid;
		
		System.out.println(sql);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Event event = null;

		try {
			conn = DBUtil.getConnectionFromDataSource();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				event = constructEventFromResultSet(rs);		
			}
			return event;
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
	}*/
	

	private static Event constructEventFromResultSet(ResultSet rs) {
		try {
			Event event = new Event();
			event.setR_id(rs.getString(RID));
			event.setEvt_id(rs.getString(EID));
			event.setEvt_title(rs.getString(TITLE));
			event.setStart_time(rs.getString(STIME));
			event.setEnd_time(rs.getString(ETIME));
			event.setE_details(rs.getString(DETAILS));
			return event;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
