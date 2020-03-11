package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	private static final String CONN = "jdbc:mysql://localhost:3306/proj3kt";
	private static final String USER = "root";
	private static final String PW = "";

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(CONN, USER, PW);

		} catch (ClassNotFoundException e) {
			System.out.println("class not found" + e.getMessage());
			return null;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
