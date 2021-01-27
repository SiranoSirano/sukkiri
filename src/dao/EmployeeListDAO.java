package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.AccountInfo;
import model.Employee;

public class EmployeeListDAO {

	//	DB接続に使用する情報
	private final String URL = "jdbc:h2:tcp://localhost/~/社員情報管理システムDB接続";
	private final String USER = "sa";
	private final String PASS = "";

	//	DB接続のメソッド
	public final Connection getConnection() {
		try {
			Connection con = DriverManager.getConnection(this.URL, this.USER, this.PASS);
			return con;
		}catch(Exception e){
			throw new IllegalStateException(e);
		}
	}
	//		DBから全ユーザーの情報検索を行うメソッド
	//	戻り値としてArrayList<AccountInfo> をつかう
	public ArrayList<AccountInfo> selectAll(){
		//	変数宣言
		Connection con = null;
		Statement smt = null;
		//		return用オブジェクトの生成
		ArrayList<AccountInfo> list = new ArrayList<AccountInfo>();
		//		SQL文
		String sql ="SELECT * FROM EMPLOYEE";


		try {
			con = this.getConnection();
			smt = con.createStatement();


			//			SQL文をDBに出力
			ResultSet rs = smt.executeQuery(sql);
			//			検索結果を配列で取得

			while(rs.next()) {
				AccountInfo accountinfo =new AccountInfo();
				int id = rs.getInt("ID");
				String userName = rs.getString("USERNAME");
				String name = rs.getString("NAME");
				String call = rs.getString("CALL");
				String birth = rs.getString("BIRTH");
				int age = rs.getInt("AGE");
				String gender = rs.getString("GENDER");
				String country = rs.getString("COUTRY");
				int postal = rs.getInt("POSTAL");
				String address = rs.getString("ADDRESS");
				String entry = rs.getString("ENTRY");
				String leave = rs.getString("LEAVE");
				String reason = rs.getString("REASON");
				String phone = rs.getString("PHONE");
				String mail = rs.getString("MAIL");
				int mynumber = rs.getInt("MYNUMBER");
				String text = rs.getString("TEXT");
				String pass = rs.getString("PASS");
				list.add(accountinfo);
			}

		}catch(Exception e){
			throw new IllegalStateException(e);
		}finally {
			//			リソースの解放
			if(smt != null) {
				try{smt.close();}catch(SQLException ignore){}
			}
			if(con != null) {
				try{con.close();}catch(SQLException ignore){}
			}
		}
		return list;
	}
}

