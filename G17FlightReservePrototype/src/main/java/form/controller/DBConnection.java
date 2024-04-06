package form.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con = null;

	public static Connection getDBConnection() {
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3306/";
		final String USERNAME = "root";
		final String PASSWORD = "Pratham#1234";
		final String SCHEMA = "database_1";

		try {
			if (con == null) {
				Class.forName(DRIVER);
				con = DriverManager.getConnection(URL + SCHEMA, USERNAME, PASSWORD);
				System.out.println("Connected");

			}
		} catch (Exception e) {
			System.out.println("The error in  Connection :" + e.getMessage());

		}

		return con;

	}

}
