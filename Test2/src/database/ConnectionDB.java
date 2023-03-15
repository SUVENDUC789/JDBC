package database;

//1. import ----> Java.sql.*;
//2. load and register driver
//3. create connection
//4. create statement
//5. execute the query
//6. Process The result
//7. close

import java.sql.*;

public class ConnectionDB {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from friend";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(sql);
		
//		rs.next();
//		System.out.println(rs.getString(1)+" "+rs.getString(2));
//		
//		rs.next();
//		System.out.println(rs.getString(1)+" "+rs.getString(2));
//
//		
//		rs.next();
//		System.out.println(rs.getString(1)+" "+rs.getString(2));
		
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2));
		}

		
	}

}
