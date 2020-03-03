package com.allanudemy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Testing class for connection between MySQL database and eclipse java
 * 1. url of database
 * 2. username and password that can access the database 
 * @author Allan Yu
 *
 */
public class TestJdbc {
	
	public static void main(String []args) {
		
		//connecting to sql database with java 
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connecting to DataBase: "+jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connection successful");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
