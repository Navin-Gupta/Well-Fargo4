package com.wf.training.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Sample{
	
}


public class MyApp {

	private static final String MYSQL_DRIVER = "";
	private static final String MYSQL_URL = "";
	private static final String MYSQL_USERNAME = "";
	private static final String MYSQL_PASSWORD = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// load the mysql driver (class) in memory
		try {
			// to load any java class in memory
			// Class.forName("com.wf.training.jdbcapp.Sample");
			Class.forName(MYSQL_DRIVER);
			Connection conn = 
					DriverManager.getConnection(MYSQL_URL, 
												MYSQL_USERNAME, 
												MYSQL_PASSWORD);
			Statement stmt = conn.createStatement();
			
			// fire the query
			ResultSet rs = stmt.executeQuery(""); // select 
			
			
			int n = stmt.executeUpdate(""); // insert, update, delete
			// n : number of rows affected
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
