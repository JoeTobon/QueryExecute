package com.collabera.jump.Connection;

import java.sql.Connection;

public class DBConnection 
{
	private static Connection connection;
	
	public static Connection getConnection() 
	{
		return connection;
	}
	
	public static void setConnection(Connection connection) 
	{
		DBConnection.connection = connection;
	}
}
