package com.wf.training.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyAppPro {

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
			// config the ResultSet
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
												  ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = stmt.executeQuery("select * from employee"); // select 
			
			// navigation method : all return boolean
			/*rs.next();
			rs.previous();
			rs.last();
			rs.first();
			rs.beforeFirst();
			rs.afterLast();
			rs.absolute(4); // 0 based
			rs.relative(3);
			rs.relative(-3);
			*/
			
			// update, delete, insert using ResultSet (without writing query)
			
			
			// updating a specific record
			// if cursor is at an active link
			rs.updateString(2, "NewName");
			// -----------------------
			// -----------------------
			rs.updateRow(); // changes will pushed
			rs.refreshRow(); // refresh the RS with new data
			
			
			// insert a new Record
			// current location can be any
			rs.insertRow(); // add a new blank row 
			rs.moveToInsertRow(); // cursor placed at new inserted row
			rs.updateString(2, "NewName");
			// -----------------------
			// -----------------------
			rs.updateRow(); // changes will pushed
			rs.refreshRow(); // refresh the RS with new data
			rs.moveToCurrentRow(); // cursor placed at original location
			
			
			// delete a record
			// if cursor is at an active link
			rs.deleteRow();
			rs.refreshRow();
			
			
  		    rs.close();
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
