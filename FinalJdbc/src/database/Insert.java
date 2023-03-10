package database;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert {
	
	public static void insertOp() {
		String sql = "insert into emp values(?,?)";
		Scanner sc = new Scanner(System.in);
		
		try {
			PreparedStatement ps = Connectivity.connect().prepareStatement(sql);
			
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
				
				int count =ps.executeUpdate();
				if(count>0) {
					System.out.println(count+" Record inserted...");
				}else {
					System.out.println("No record inserted...");
				}
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertOp();

	}

}
