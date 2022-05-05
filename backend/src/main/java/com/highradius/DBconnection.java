package com.highradius;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	public static Connection createConnect() {
		Connection con = null;
		final String URL="jdbc:mysql://localhost:3306/grey_goose?zeroDateTimeBehavior=convertToNull";
		final String USER="root";
		final String PASS="Ayush@123";
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");//driver load 
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			con = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Post establishing a DB connection - " +con);
			
		}
		catch(SQLException e)
		{
			System.out.println("Error Occurred");
			e.printStackTrace();
		}
		return con;
		
	}	
}






