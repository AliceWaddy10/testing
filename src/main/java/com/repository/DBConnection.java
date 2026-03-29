package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo_db","root","root");
			} catch (SQLException e) {
				System.out.println("Driver connection error : "+e.getMessage());
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Connection error : "+e.getMessage());
		}
		
		return con;
	}
}
