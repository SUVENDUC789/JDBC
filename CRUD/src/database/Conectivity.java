package database;

import java.sql.*;

public class Conectivity {

	public static Connection con;
	
	public static Connection connect() {
		String DriverName="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String userName="system";
		String password="admin";
		
		try {
			
			Class.forName(DriverName);
			con=DriverManager.getConnection(url,userName,password);
			System.out.println("Connection established ....");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		String sql="CREATE TABLE stu(\r\n"
				+ "	ROLL VARCHAR2(5),\r\n"
				+ "	NAME VARCHAR2(25)\r\n"				
				+ ")";
		

		try {
			Statement stmt = con.createStatement();
			try {
				
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("Table Created...");
			}
			catch(Exception e) {
				System.out.println("Table already created...");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	

}
