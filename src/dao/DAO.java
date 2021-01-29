package dao;

import java.sql.Connection;
import java.sql.DriverManager;
// DAOの親クラス、継承させることで共通処理部分のコードをまとめる
public class DAO {

	//	DB接続に使用する情報
	private final String URL = "jdbc:h2:tcp://localhost/~/社員情報管理システムDB接続";
	private final String USER = "sa";
	private final String PASS = "";

	//	DB接続のメソッド
	public Connection getConnection() {
		try {
			Connection con = DriverManager.getConnection(this.URL, this.USER, this.PASS);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
}
