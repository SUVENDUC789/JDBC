import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "");
		
		System.out.println("Success...");
		

	}

}
