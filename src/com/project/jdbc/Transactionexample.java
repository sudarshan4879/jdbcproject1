package com.project.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transactionexample {
	
	static Connection conn=null;
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
		try{
			
				Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//step2 create  the connection object  
			Connection conn=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","password");
			
			   //Assume a valid connection object conn
			   conn.setAutoCommit(false);
			   Statement stmt = conn.createStatement();
			   
			   String SQL = "insert into emp  values( 7300, 'Sudarshan1', 'MANAGER', 7839, to_date('2-4-1981','dd-mm-yyyy'), 2975, null, 20)";
			  int count= stmt.executeUpdate(SQL);  
			  System.out.println("count:"+count);
			   //Submit a malformed SQL statement that breaks
			  // String SQL = "INSERTED IN Employees  " +  "VALUES (107, 22, 'Sita', 'Singh')";
			   // stmt.executeUpdate(SQL);
			   // If there is no error.
			   conn.commit();
			}catch(SQLException e){
			   // If there is any error.
			   conn.rollback();
			}
		
		
	}

}
