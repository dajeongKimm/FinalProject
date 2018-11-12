package mvc.util;

import java.sql.*;

public class JDBCConnection {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:test");
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return conn;
	}
}






