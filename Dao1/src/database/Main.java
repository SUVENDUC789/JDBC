package database;

//1. import ----> Java.sql.*;
//2. load and register driver
//3. create connection
//4. create statement
//5. execute the query
//6. Process The result
//7. close


import java.sql.*;
import java.util.Scanner;

public class Main {
	
	public static Connection con ;
	
	public static Connection connectDB() {
//		String sql = "CREATE TABLE students (SL INT NOT NULL AUTO_INCREMENT , Roll VARCHAR(10) NOT NULL , Name VARCHAR(100) NOT NULL , DateTimeNow DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP , PRIMARY KEY (SL));";
		try {
			String DRIVER="com.mysql.cj.jdbc.Driver";
			String URL="jdbc:mysql://localhost:3306/dao";
			String USER = "root";
			String PASSWD = "";
			
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL, USER, PASSWD);
//			System.out.println("Connection established");
		}
		catch(Exception e) {
			System.out.println("Exception Occure : "+e);
		}		
		
		return con;
	}
	
	public void showData() throws Exception{
		Connection con = connectDB();
		
		String sql="select * from students";
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(sql);
		System.out.println("SL"+"\troll"+"\tName");
		while(rs.next()) {
			int sl=rs.getInt(1);
			String roll = rs.getString(2);
			String name = rs.getString(3);
			
			
			System.out.println(sl+"\t"+roll+"\t"+name);
		}
	}
	
	public void insertData() throws Exception{
		Connection con = connectDB();
		
		String sql = "INSERT INTO students (Roll,Name) VALUES(?,?)";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of students Details you enter : ");
		int n = sc.nextInt();
		PreparedStatement psmt = con.prepareStatement(sql);
		
		for(int i=0;i<n;i++) {			
			System.out.printf("Enter roll [%d] : ",i+1);
			String roll=sc.next();
			System.out.printf("Enter Name [%d] : ",i+1);
			String name=sc.next();
			psmt.setString(1, roll);
			psmt.setString(2, name);
			int count = psmt.executeUpdate();	
			System.out.println(count+ " row effected.");
			
		}		
			
		
	}
	
	public void deleteData() throws Exception{
		Connection con = connectDB();
		String sql="DELETE FROM students WHERE Roll = ?";
		Scanner sc = new Scanner(System.in);
		
		PreparedStatement psmt = con.prepareStatement(sql);
		System.out.printf("Enter roll  : ");
		String roll=sc.next();
		psmt.setString(1, roll);
		int count = psmt.executeUpdate();
		if(count>0)
			System.out.println(count+ " row effected.");
		else
			System.out.println("No row effected.");
		
		
	}
	
	public void updateData() throws Exception {
		Connection con = connectDB();
		Scanner sc = new Scanner(System.in);
		
		String sql1="UPDATE students SET Name = ? WHERE Roll = ?";
		
		PreparedStatement psmt = con.prepareStatement(sql1);
		
		System.out.printf("Enter roll (Select) : ");
		String roll=sc.next();
		System.out.printf("Enter Name (Update) : ");
		String name=sc.next();
		
		psmt.setString(1, name);
		psmt.setString(2, roll);
		
		int count = psmt.executeUpdate();
		if(count>0)
			System.out.println(count+ " row effected.");
		else
			System.out.println("No row effected.");
		
		
	}
	


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Main Dao = new Main();
		while (true) {
			String note ="1. Insert\n2. Delete\n3. Update\n4. Show\n5. EXIT";
			System.out.println(note);
			System.out.print("Enter your Choice : ");
			char ch = sc.next().charAt(0);
			
			try {
				if (Integer.parseInt(ch+"")==1)
					Dao.insertData();
				else if (Integer.parseInt(ch+"")==2) 
					Dao.deleteData();
				else if (Integer.parseInt(ch+"")==3) 
					Dao.updateData();
				else if (Integer.parseInt(ch+"")==4)
					Dao.showData();
				else
					break;

			} catch (Exception e) {			
				System.out.println(e);
			}
			
		}
		System.out.println("Thank you for using my programme");
	}

}
