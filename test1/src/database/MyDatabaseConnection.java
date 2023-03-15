package database;
//Steps
//1. import ----> Java.sql.*;
//2. load and register driver
//3. create connection
//4. create statement
//5. execute the query
//6. Process The result
//7. close

import java.sql.*;

public class MyDatabaseConnection {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM FRIEND";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");	
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
				
		Statement smt = con.createStatement();
		
		
		
		ResultSet rs = smt.executeQuery(sql);
		
		rs.next();
		System.out.println(rs.getString("name"));
				
//		while(rs.next()) {
//			String roll=rs.getString(1);
//			String name=rs.getString(2);
//			System.out.println(roll+"\t"+name);
//		}
		
//		System.out.println("Table create successfull !");
		

	}

}
