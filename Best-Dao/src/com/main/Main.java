package com.main;

import java.sql.ResultSet;

import com.method.MyConnection;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		MyConnection dao = new MyConnection("jdbc:mysql://localhost:3306/test", "root", "");

		String name = "suvu";
		String phone = "000";
		String email = "suvu@";

		String sql = "INSERT INTO `register` (`sl`, `name`, `phone`, `email`) VALUES (NULL, '" + name + "', '" + phone
				+ "', '" + email + "');";
		int n = dao.runMysqlQuery(sql);

		if (n == 0) {
			System.out.println("Data not insert");
		} else {
			System.out.println(n + " row inserted.");
		}

		String showdata = "SELECT * FROM register";

		ResultSet rs = dao.fetchData(showdata);
		System.out.println("SL\tNAME\tEMAIL\tPHONE");
		while (rs.next()) {
			int sl = rs.getInt("sl");
			String namep = rs.getString("name");
			String emailp = rs.getString("email");
			String phonep = rs.getString("phone");

			System.out.println(sl + "\t" + namep + "\t" + emailp + "\t" + phonep);

		}

	}

}
