package database;


public class ExampleOfClassforName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Dump dp = new Dump();
		try {
			Class.forName("Pgr");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		

	}

}

class Pgr{
	//This is a static block
	static {
		System.out.println("In Static Block");
	}
	
	//It is a instace block	
	{
		System.out.println("In Instace Block");
	}
}


