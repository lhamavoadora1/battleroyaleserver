package DAOs;

import java.sql.*;

//Reference: https://github.com/danielscarvalho/FTT-PEOPLE-WEB-DB

public class DbUtil {
	
//	public static void getConnection(String username, String password) throws SQLException {
//		
//		Connection connection = DriverManager.getConnection(DATABASE_LOCATION, username, password);
//		System.out.println(connection.getCatalog());
//		
//		Statement stat = connection.createStatement();
//		ResultSet result = stat.executeQuery("select * from test_table");
//		if (result != null && result.next()) {
//			System.out.println(result.getString(2));
//		}
//		
//	}

	static final String DATABASE_LOCATION = "jdbc:mysql://localhost/battleroyale?serverTimezone=GMT-3";
	static final String USERNAME = "admin";
	static final String PASSWORD = "admin";
	
    static Connection connection;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {

        		Connection connection = DriverManager.getConnection(DATABASE_LOCATION, USERNAME, PASSWORD);
            
                System.out.println(connection);
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            return connection;
        } //if

    } //getConnection
} //DbUtil
