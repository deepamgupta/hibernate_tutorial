package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";

		String user = "root";
		String pass = "";

		try {
			System.out.println("Connecting to db: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection Successful!!!");
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
