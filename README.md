# JDBC

## Steps :
```
1. import ----> Java.sql.*;
2. load and register driver
3. create connection
4. create statement
5. execute the query
6. Process The result
7. close

```
### Connect Mysql
```
String DRIVER="com.mysql.cj.jdbc.Driver";
String URL="jdbc:mysql://localhost:3306/test";
String USER = "root";
String PASSWD = "";
```
## Connection :

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

# Insert

```java
package database;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert {

	public static void main(String[] args) {
		
		

		String sql = "insert into emp values(?,?)";
		Scanner sc = new Scanner(System.in);
		try {
			
			PreparedStatement ps = DbCon.connect().prepareStatement(sql);
			
			System.out.print("Enter number of record you want to inserted : ");
			int n = sc.nextInt();
			sc.nextLine();
			
			for(int i=0;i<n;i++) {
				
				System.out.printf("Enter roll [%d] : ",i+1);
				String roll = sc.nextLine();
				
				System.out.printf("Enter Name [%d] : ",i+1);
				String name= sc.nextLine();
				
				ps.setString(1, roll);
				ps.setString(2, name);
				
				int count = ps.executeUpdate();
				if(count>0) {
					System.out.println(count+" Record inserted...");
				}else {
					System.out.println("No record inserted...");
				}
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Insertion operation completed successfull ");

	}

}


```

# Select
```java
package database;

import java.sql.ResultSet;
import java.sql.Statement;

public class ShowData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String sql="select * from emp";
		
		try {
			Statement smt=  DbCon.connect().createStatement();
			
			ResultSet rs = smt.executeQuery(sql);
			
			System.out.println("Roll\tName");
			
			while(rs.next()) {
				String roll=rs.getString(1);
				String name=rs.getString(2);
				System.out.println(roll+"\t"+name);
			}
			
		}
		catch(Exception e) {
			System.out.println("Something went to wrong...");
		}
		

	}

}
```

