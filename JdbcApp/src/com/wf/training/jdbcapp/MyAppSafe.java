package com.wf.training.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MyAppSafe {

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
			 
			 // fixed templated/prepared query
			 PreparedStatement pstmt =  
					 conn.prepareStatement("insert into employee values(?,?,?)");
			 
			String name = "";
			String email = "";
			int age = 20;
			 // set values in placeholder
			 pstmt.setString(0, name);
			 pstmt.setString(1, email);
			 pstmt.setInt(2, age);
			 
			 // pstmt.setBlob(parameterIndex, x);
			 
			
			 // pstmt.executeQuery(); // select
			 pstmt.executeUpdate(); // DMQ
			 
			 pstmt.clearParameters();
			
			String query = "insert into employee values('" + name + "','" + email + "'," + age + ")";
			
  		    
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
