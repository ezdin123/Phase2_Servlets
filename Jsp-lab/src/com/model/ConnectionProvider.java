package com.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/ecommerce";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static Connection con = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
		} catch (Exception e) {
		}
	}

	public static Connection getCon() {
		return con;
	}
}
