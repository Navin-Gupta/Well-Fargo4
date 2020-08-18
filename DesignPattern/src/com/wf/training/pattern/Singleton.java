package com.wf.training.pattern;

// imperative
/*
class DbConnection{
	private static DbConnection connection;
	
	// restricts the object creation
	private DbConnection() {}
	
	// method to initiate and expose object
	public static DbConnection getIntance() {
		if(connection == null)
			connection = new DbConnection();
		return connection;
	}
	
	// functionality
	public void fun() {
		
	}
}
*/

//declarative
class DbConnection{
	private static DbConnection connection;
	
	// restricts the object creation
	private DbConnection() {}
	
	// method to initiate and expose object
	public static DbConnection getIntance() {
		return connection;
	}
	
	// object creation is delegated to static block
	static {
		connection = new DbConnection();
	}
	
	// functionality
	public void fun() {
		
	}
}


// client code
public class Singleton {
	public static void main(String args[]) {
		// if anyone wants instance
		DbConnection connection = DbConnection.getIntance();
		connection.fun();
	}
}
