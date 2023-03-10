package database;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteData {
	
	public static void delteOp() {
		String sql = "DELETE FROM EMP WHERE id=?";
		Scanner sc = new Scanner(System.in);
		
		try {
			PreparedStatement ps = Connectivity.connect().prepareStatement(sql);
			System.out.printf("Enter roll  : ");
			String roll = sc.nextLine();
			
			ps.setString(1, roll);
			
			int count = ps.executeUpdate();
			
			if(count>0) {
				System.out.println(count+" data delete ");
			}else {
				System.out.println("No data delete ");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		DELETE FROM EMP WHERE id='s-412';
		delteOp();
		
		
		

	}

}
