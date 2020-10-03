package com.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {

	public static void main(String[] args) {
		

		String jdbcUrl ="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user ="hbstudent";
		String password ="hbstudent";
		
		try{
			System.out.println("Connecting to database: "+ jdbcUrl);
		Connection Myconnection = DriverManager.getConnection(jdbcUrl, user, password);
		System.out.println("The Connection is a Success");
		}
		
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
		
	}

}
