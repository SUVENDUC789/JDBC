package database;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateData {
	
	public static void deleteOp() {
//		UPDATE EMP SET ID='EO4' WHERE ID='E04';
		
		String sql="UPDATE EMP SET name=? WHERE ID=?";
		Scanner sc = new Scanner(System.in);
		
		try {
			PreparedStatement ps = Connectivity.connect().prepareStatement(sql);
			
			System.out.printf("Enter roll  : ");
			String roll = sc.nextLine();
			
			System.out.printf("Enter Name (Update) : ");
			String name = sc.nextLine();
			
			ps.setString(2, roll);
			ps.setString(1, name);
			
			
			int count = ps.executeUpdate();
			
			if(count>0) {
				System.out.println(count+" data Update ");
			}else {
				System.out.println("No data Update ");
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		deleteOp();

	}

}
