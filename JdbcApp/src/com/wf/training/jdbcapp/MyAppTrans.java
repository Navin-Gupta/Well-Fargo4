package com.wf.training.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyAppTrans {
	private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String MYSQL_URL = "jdbc:mysql://localhost/trainingdb";
	private static final String MYSQL_USERNAME = "root";
	private static final String MYSQL_PASSWORD = "";
	
	public static void main(String[] args) {
		
		try {
		
			Class.forName(MYSQL_DRIVER);
			Connection conn = 
					DriverManager.getConnection(MYSQL_URL, 
												MYSQL_USERNAME, 
												MYSQL_PASSWORD);
			Statement stmt = conn.createStatement();
			
			// create a trans block
			try {
				// need to stop the command to update the DB
				// need to tell do changes in views
				conn.setAutoCommit(false);
				stmt.executeUpdate(""); // directly updates the DB
				stmt.executeUpdate("");
				stmt.executeQuery("");
				// business logic
				stmt.executeQuery("");
				stmt.executeUpdate("");
				// success
				conn.commit(); // explicitly commit the changes
			}
			catch(Exception ex) {
				// failed
				conn.rollback(); // rollback changes in views 
			}
  		    finally {
  		    	conn.setAutoCommit(true); // set the default state
  		    }
			
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
}
