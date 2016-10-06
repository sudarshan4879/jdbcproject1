package com.project.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {
	
	public static void main(String[] args) throws Exception, SQLException {
		System.out.println(" inside  main ");
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","password");
			
			
			//step3 create the statement object  
			Statement stmt=con.createStatement();
			
			//PreparedStatement stmt = con.prepareStatement("select * from emp");
			
			// Three interface in jdbc...PreparedStatement, Statement, CollableStatement.

			ResultSet rs=stmt.executeQuery("select * from emp");
			while(rs.next()){
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			}
			
			con.close();		
		
		
	
	}
		
	}
