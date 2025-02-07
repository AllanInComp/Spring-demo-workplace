package com.allanudemy.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServer
 */
@WebServlet("/TestDbServer")
public class TestDbServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setup connection variables 
		String user = "springstudent";
		String pass = "springstudent";
		String jdbcUrl=  "jdbc:mysql://localhost:3306/web_customer_tracker?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.jdbc.Driver";
		
		
		//get connection to database
		
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database: "+jdbcUrl);
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			out.println("Connection successful");
			System.out.println("Success");
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
