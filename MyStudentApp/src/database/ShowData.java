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
