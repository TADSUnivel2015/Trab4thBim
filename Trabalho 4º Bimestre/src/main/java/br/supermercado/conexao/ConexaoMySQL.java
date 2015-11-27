package br.supermercado.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMySQL {

	public static Connection conn;
	// public static ConexaoMysql conexao;
	private static String url;
	private static String nomeDataBase;
	private static String driver;
	private static String user;
	private static String pass;

	private ConexaoMySQL() {
		url = "jdbc:mysql://localhost:3306/";
		nomeDataBase = "tabalho4thbim";
		driver = "com.mysql.jdbc.Driver";
		user = "root";
		pass = "tezza";
		try {
			Class.forName(driver).newInstance();
			ConexaoMySQL.conn = DriverManager.getConnection(url + nomeDataBase, user, pass);
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
