/*
1. import ----> Java.sql.*;
2. load and register driver
3. create connection
4. create statement
5. execute the query
6. Process The result
7. close

 */



package database;

import java.sql.*;


public class MyCon {
	public static Connection con;
	
	public static Connection connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
			System.out.println("Connection established ....");
		}
		catch(Exception e) {
			System.out.println("Exception Occure : "+e);
		}
		
		return con;
	}
	public static void main(String[] args) {
		String sql="select * from student";
		
		try {
			Statement smt=  connect().createStatement();
			
			ResultSet rs = smt.executeQuery(sql);
			
			System.out.println("Roll\tName");
			
			while(rs.next()) {
				String roll=rs.getString("roll");
				String name=rs.getString("name");
				System.out.println(roll+"\t"+name);
			}
			
		}
		catch(Exception e) {
			System.out.println("Something went to wrong...");
		}
		
		 
		
	}

}
