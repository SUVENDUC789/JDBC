# JDBC
## Connection

```java
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dbcon {
	
	public static Connection con ;
	public static Connection connect() {		
		String DriverName="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String userName="system";
		String password="admin";
		
		try {
			//Driverclass load
			Class.forName(DriverName);
			con=DriverManager.getConnection(url,userName,password);
			System.out.println("Connection established ....");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	} 
	

	public static void main(String[] args) {
		try {
			//System.out.println(connect());
			Connection con = connect();
			
			String sql="CREATE TABLE EMP(\r\n"
					+ "	ID VARCHAR2(5),\r\n"
					+ "	NAME VARCHAR2(25),\r\n"
					+ "	SALARY NUMBER(5),\r\n"
					+ "	CITY VARCHAR2(15),\r\n"
					+ "	DOB DATE\r\n"
					+ ")";
			

			
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
		

	}

}

```
