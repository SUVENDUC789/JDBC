package database;
//1. import ----> Java.sql.*;
//2. load and register driver
//3. create connection
//4. create statement
//5. execute the query
//6. Process The result
//7. close

import java.sql.*;

public class InsertData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String roll="S-416";
		String name="Bristi Bhat";
//		String sql = "insert into friend values('"+roll+"','"+name+"')";
		String sql = "insert into friend values(?,?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
		
//		Statement st= con.createStatement();
//		int count = st.executeUpdate(sql);
		
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, roll);
		psmt.setString(2, name);
		int count = psmt.executeUpdate();
		
		
		System.out.println(count+" rows effected");

	}

}
