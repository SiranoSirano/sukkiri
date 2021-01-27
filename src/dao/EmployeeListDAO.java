package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.AccountInfo;

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
				accountinfo.setId(rs.getString("id"));
				accountinfo.setUserName(rs.getString("USERNAME"));
				accountinfo.setName(rs.getString("NAME"));
				accountinfo.setCall(rs.getString("CALL"));
				accountinfo.setBirth(rs.getString("BIRTH"));
				accountinfo.setAge(rs.getInt("AGE"));
				accountinfo.setGender(rs.getString("GENDER"));
				accountinfo.setCountry(rs.getString("COUTRY"));
				accountinfo.setPostal(rs.getInt("POSTAL"));
				accountinfo.setAddress(rs.getString("ADDRESS"));
				accountinfo.setentry(rs.getString("ENTRY"));
				accountinfo.setleave(rs.getString("LEAVE"));
				accountinfo.setreason(rs.getString("REASON"));
				accountinfo.setphone(rs.getString("PHONE"));
				accountinfo.setmail(rs.getString("MAIL"));
				accountinfo.setmynumber(rs.getInt("MYNUMBER"));
				accountinfo.settext(rs.getString("TEXT"));
				accountinfo.setpass(rs.getString("PASS"));

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

