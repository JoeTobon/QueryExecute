package com.collabera.jump.GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static Connection connection;
	
	public static Connection getConnection(Properties properties) throws SQLException {
		if(connection == null) {
			 connection = DriverManager.getConnection(properties.getProperty("url"),
					properties.getProperty("name"), properties.getProperty("password"));
			 return connection;
		}
		else {
			return connection;
		}
	}
}
