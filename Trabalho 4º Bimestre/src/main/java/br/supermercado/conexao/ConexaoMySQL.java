package br.supermercado.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMySQL {

	public static Connection conn;
	// public static ConexaoMysql conexao;
	private static String url;
	private static String dbName;
	private static String driver;
	private static String userName;
	private static String password;

	private ConexaoMySQL() {
		url = "jdbc:mysql://localhost:3306/";
		dbName = "tabalho4thbim";
		driver = "com.mysql.jdbc.Driver";
		userName = "root";
		password = "tezza";
		try {
			Class.forName(driver).newInstance();
			ConexaoMySQL.conn = DriverManager.getConnection(url + dbName, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static Connection getConexaoMySQL() {
		if (conn == null) {
			new ConexaoMySQL();
		}

		return conn;
	}
}
