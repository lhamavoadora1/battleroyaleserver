package DAOs;

import java.sql.*;

public class MySQL {
	
	static final String DATABASE_LOCATION = "jdbc:mysql://localhost/test?serverTimezone=GMT-3";
	
	public static void getConnection(String username, String password) throws SQLException {
		
		Connection connection = DriverManager.getConnection(DATABASE_LOCATION, username, password);
		System.out.println(connection.getCatalog());
		
		Statement stat = connection.createStatement();
		ResultSet result = stat.executeQuery("select * from test_table");
		if (result != null && result.next()) {
			System.out.println(result.getString(2));
		}
		
	}
	
	public static String buildInsertDml(String table_name, String[] columnArray, String[] valueArray) {
		return "INSERT INTO " + table_name + " (" + String.join(", ", columnArray) + ") " +
			   "VALUES (" + String.join(", ", valueArray) + ")";
	}

}
