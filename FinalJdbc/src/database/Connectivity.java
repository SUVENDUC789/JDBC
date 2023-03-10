package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connectivity {
	public static Connection con;	
	public static Connection connect() {	
		String DriverName="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String userName="system";
		String password="admin";
		
		try {
			Class.forName(DriverName);
			con=DriverManager.getConnection(url, userName, password);
			System.out.println("Connection established ....");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return con;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String sql="CREATE TABLE EMP(\r\n"
				+ "	ID VARCHAR2(5),\r\n"
				+ "	NAME VARCHAR2(25)\r\n"				
				+ ")";
		
		try {
			Connection con = connect();
			Statement stmt = con.createStatement();
			
			
			try {
				ResultSet rs=stmt.executeQuery(sql);
				System.out.println("Table Created...");
			}
			catch(Exception e) {
				System.out.println("Table already created...");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		

	}

}
