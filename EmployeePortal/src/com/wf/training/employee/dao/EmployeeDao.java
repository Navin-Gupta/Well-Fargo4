package com.wf.training.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wf.training.employee.model.Employee;

public class EmployeeDao {

	// delegate/outsource the details to web.xml as context-parameters
	private String driverName;
	private String url;
	private String username;
	private String password;
	
	private Connection connection;
	
	public EmployeeDao(String driverName, String url, String username, String password) {
		this.driverName = driverName;
		this.url = url;
		this.username = username;
		this.password = password;
	}

	private void connect() throws ClassNotFoundException, SQLException {
		if(this.connection == null || this.connection.isClosed()) {
			Class.forName(driverName);
			this.connection = DriverManager.getConnection(this.url, this.username, this.password);
		}
	}
	
	private void disConnect() throws SQLException {
		if(this.connection!=null && !this.connection.isClosed())
			this.connection.close();
	}

	public List<Employee> getEmployeeRecords() throws ClassNotFoundException, SQLException {
		String sql = "select * from employee";
		this.connect();
		
		Statement stmt = this.connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		// map it to model
		List<Employee> employees = new ArrayList<Employee>();
		while(rs.next()) {
			Employee employee = new Employee(rs.getInt("id"), 
											 rs.getString("empname"), 
											 rs.getString("email"), 
											 rs.getInt("age"));
			employees.add(employee);		
		}
		
		rs.close();
		stmt.close();
		this.disConnect();
		
		return employees;
	}

}











