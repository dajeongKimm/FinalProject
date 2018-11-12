package mvc.util;

import java.sql.*;

public class JDBCCloser {
	
	public static void close(Connection obj) {
		try {
			if( obj != null )
				obj.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public static void close(Statement obj) {
		try {
			if( obj != null )
				obj.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement obj) {
		try {
			if( obj != null )
				obj.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet obj) {
		try {
			if( obj != null )
				obj.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}

}






