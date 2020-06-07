package DAOs;

import java.sql.*;

public class MySQL {
	
	public static void test() throws SQLException {
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=GMT-3", "admin", "admin");
		System.out.println(connection.getCatalog());
		
		Statement stat = connection.createStatement();
		ResultSet result = stat.executeQuery("select * from test_table");
		if (result != null && result.next()) {
			System.out.println(result.getString(2));
		}
		
	}

}
