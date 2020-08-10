package com.wf.training.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyAppBatch {
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
			
			// create a batch of queries
			// in a batch we can put only DMQ (insert,update, delete)
			stmt.addBatch("");
			stmt.addBatch("");
			stmt.addBatch("");
			stmt.addBatch("");
			stmt.addBatch("");
			
			// fire batch queires
			int status[] = stmt.executeBatch();
			
			// clean the batch
			stmt.clearBatch();
			
  		    
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
