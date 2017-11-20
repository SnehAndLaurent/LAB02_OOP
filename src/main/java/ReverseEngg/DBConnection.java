package ReverseEngg;
//Import
import org.apache.log4j.*; 
import java.sql.*;
import java.lang.String.*;
import java.util.*;
import java.io.*; 

class DBConnection {
	
	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBConnection.class);
	/*
	* Variable Declarations
	*/
	private static final String url = "jdbc:mysql://localhost:3306/sakila";
	private static final String user = "root";
	private static final String pass = "root";
	/*
	* Default Constructor
	*/
	public DBConnection() {
		// TODO Auto-generated constructor stub
		
	}
	Connection getDBConnetion() {
		// TODO Auto-generated method stub
		Connection dbConnection = null;
		/* 1. Load JDBC Driver. */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		/* 2. Connect to bdd */
		try {
			/* 
			 *2.1 Connect to database through getConnection a static method of Driver Manager 
			 */
			dbConnection = DriverManager.getConnection(url, user, pass);
			/* Requests to bdd will be here */
			System.out.println("Database Connection Established");
			return dbConnection;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return dbConnection;
	}

}
