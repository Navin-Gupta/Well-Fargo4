package com.wf.training.jdbcapp;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



class Sample{
	
}


public class MyApp {

	private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String MYSQL_URL = "jdbc:mysql://localhost/trainingdb";
	private static final String MYSQL_USERNAME = "root";
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
			// statement class exposes all method to talk with DB 
			
			// fire the query
			ResultSet rs = stmt.executeQuery("select * from employee"); // select 
			
			// conn.close();
			/*if(rs.next()) {
				rs.getString(1);  // col indexing is 1 based
				rs.getString("empname");
			}*/

			while(rs.next()) {
				System.out.println(rs.getString(2) 
								   + " | "  
								   + rs.getString(3)
								   + " | "
								   + rs.getInt(4));
			}
  		    rs.close();
			conn.close();
			// int n = stmt.executeUpdate(""); // insert, update, delete(DMQ)
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
