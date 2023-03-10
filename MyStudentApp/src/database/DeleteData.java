package database;


import java.sql.Statement;

public class DeleteData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Statement smt = DbCon.connect().createStatement();
			String roll="s-411";
			int count= smt.executeUpdate("delete from emp where ID="+roll);
			
			if(count==1)
				System.out.println(count+" row deleted");
			else
				System.out.println("No row deleted");
				
		}
		catch(Exception e) {
			System.out.println("Something went to wrong...");
		}
		

	}

}
