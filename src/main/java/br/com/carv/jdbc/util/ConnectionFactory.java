package br.com.carv.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public static Connection getConnection() {

		final String driver = "com.mysql.cj.jdbc.Driver"; 
		final String url = "jdbc:mysql://localhost:3306/jdev?serverTimezone=UTC";
		final String user = "adm"; 
		final String password = "123456789";
		
		Connection connection = null; 
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} 
		
		return connection;
	}

}
