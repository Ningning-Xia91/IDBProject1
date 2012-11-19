package happyH.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class DBUtil {
	private static OracleDataSource ods;
	//private static String dbUser = "nx2120";
	//private static String dbPassword = "idbidb";
	private static String dbUser = "yy2429";
	private static String dbPassword = "XnKykzSr";

	public static void main(String[] args) throws Exception {

		System.out.println("start");
		if (ods == null) {
			System.out.println("ods==null");
			createDataSource();
		}
		
/*        Connection conn = ods.getConnection();

        String query = new String();
        Statement s = conn.createStatement();

        query = "select * from events";

        ResultSet r = s.executeQuery(query);
        while(r.next()){
           System.out.println("Today's Date: "+r.getString(1)+" ");
        }
        r.close();
        s.close();*/

		System.out.println("end");
		
	}

	public static void createDataSource() throws Exception {
		try {

			ods = new oracle.jdbc.pool.OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@//w4111b.cs.columbia.edu:1521/ADB");
			ods.setUser(dbUser);
			ods.setPassword(dbPassword);
			
			if(ods!=null)
			{
				System.out.println("get datasource succeed!");
			}

			if (ods == null) {
				throw new Exception("get datasource failed!");
			}
		} catch (NamingException ne) {
			throw ne;
		} catch (Exception e) {
			throw e;
		}
	}

	public static OracleDataSource getDataSource() {
		try {
			if (ods == null) {
				createDataSource();
			}
			return ods;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Connection getConnection() {
		OracleDataSource oracleDataSource = getDataSource();
		try {
			return oracleDataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Connection getConnectionFromDataSource() {
		try {
			Connection con = null;
			if (ods == null) {
				createDataSource();
			}
			con = ods.getConnection();
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet execuateQuery(String sql) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnectionFromDataSource();
			pstmt = conn.prepareStatement(sql);
			return pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
