package com.method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyConnection {

	private Connection con;
	private PreparedStatement ps;

	public MyConnection(String url, String username, String password) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.con = DriverManager.getConnection(url, username, password);
	}

	public int runMysqlQuery(String sql) throws Exception {
		ps = this.con.prepareStatement(sql);
		return ps.executeUpdate();
	}

	public ResultSet fetchData(String sql) throws Exception {
		ps = this.con.prepareStatement(sql);
		return ps.executeQuery();

	}

}
