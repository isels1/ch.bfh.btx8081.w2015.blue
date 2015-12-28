package ch.bfh.btx8081.w2015.blue.HealthVisApp.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {

	private final String URI = "jdbc:sqlserver://localhost;integratedSecurity=true";
	private final String USER = "";
	private final String PW = "";
	
	private ResultSet resSet;
	
	private static Connector conn = null;
	
	private void Connector(){
		
	}
	
	public static Connector getConnection(){
		if (conn == null) {
			conn = new Connector();
		}
		return conn;
	}
	
	public ResultSet executeQuery(String sqlQuery){
		Connection c = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			c = DriverManager.getConnection(URI, USER, PW);
			stmt = c.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			resSet = rs;
			
			rs.close();
			stmt.close();
			c.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return resSet;	
	}
	
}
