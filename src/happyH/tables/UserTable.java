package happyH.tables;

import happyH.models.User;
import happyH.utils.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTable {

	public final static String TABLE_NAME = "Users";
	public final static String ID = "u_id";
	public final static String NAME = "u_name";
	public final static String EMAIL = "u_email";
	public final static String ACCOUNT = "u_account";
	public final static String PASSWORD = "u_password";
	public final static String PREFERENCE_TYPE = "pref_type";

	private static List<User> userList = new ArrayList<User>();

	public static void insertOneUser(User user) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "Insert Into " + TABLE_NAME + 
				" ( " + ID + ", " + ACCOUNT+ ", " + PASSWORD + ", " + NAME + ", " 
				+ EMAIL + ", "+ PREFERENCE_TYPE  + ") VALUES (?, ?, ?, ?, ?, ?)";
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getU_id());
			ps.setString(2, user.getU_account());
			ps.setString(3, user.getU_password());
			ps.setString(4, user.getU_name());
			ps.setString(5, user.getU_email());
			ps.setString(6, user.getPref_type());
			
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
	
	public static User getUserByAccount(String account) {
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE "+ ACCOUNT +" = '"+account +"'";
		
		System.out.println(sql);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;

		try {
			conn = DBUtil.getConnectionFromDataSource();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				user = constructUserFromResultSet(rs);
/*				System.out.println(user.getU_account());
				System.out.println(user.getU_password());
				System.out.println(user.getU_name());
				System.out.println(user.getU_id());*/
			}
			return user;
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


	public static List<User> getAllUsers() {
		String sql = "SELECT * FROM " + TABLE_NAME;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnectionFromDataSource();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				User user = constructUserFromResultSet(rs);
				userList.add(user);
			}
			return userList;
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

	private static User constructUserFromResultSet(ResultSet rs) {
		try {
			User user = new User();
			user.setU_id(rs.getString(ID));
			user.setU_name(rs.getString(NAME));
			user.setU_password(rs.getString(PASSWORD));
			user.setU_email(rs.getString(EMAIL));
			user.setU_account(rs.getString(ACCOUNT));
			user.setPref_type(rs.getString(PREFERENCE_TYPE));
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}