package com.hcmus.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	private static Connection connection = null;
	
	public static Connection openConnection() {
		if(connection != null) {
			return connection;
		}else {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "xe", "xe");
				if(connection != null) {
					System.out.println("Connect to Oracle successfully");
				}else {
					System.out.println("Connect to Oracle failed");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
