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

	

	public static List<Event> getAllEvents() {
		List<Event> eventList = new ArrayList<Event>();
		String sql1 = "SELECT * FROM " + TABLE_NAME;
		String sql = "SELECT Events.*, to_char(start_time,'yyyy-mm-dd') as stime," +
				" to_char(end_time,'yyyy-mm-dd') as etime from Events"; 
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
		String sql = "SELECT  Events.*, to_char(start_time,'yyyy-mm-dd') as stime," +
				" to_char(end_time,'yyyy-mm-dd') as etime FROM " + TABLE_NAME + " WHERE "+ EID +" = '"+eid +"'";
		
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
	

	public static List<Event> searchEventByTitle(String title) {
		String sql = "SELECT Events.*, to_char(start_time,'yyyy-mm-dd') as stime," +
				" to_char(end_time,'yyyy-mm-dd') as etime FROM Events WHERE UPPER(evt_title) LIKE UPPER('%"+title+"%')";
		System.out.println(sql);
		List<Event> eventList = new ArrayList<Event>();

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

	private static Event constructEventFromResultSet(ResultSet rs) {
		try {
			Event event = new Event();
			event.setR_id(rs.getString(RID));
			event.setEvt_id(rs.getString(EID));
			event.setEvt_title(rs.getString(TITLE));
			event.setStart_time(rs.getString("stime"));
			event.setEnd_time(rs.getString("etime"));
			event.setE_details(rs.getString(DETAILS));
			return event;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
