package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.AccountInfo;
import model.Employee;
import model.Login;

public class EmployeeDAO {
	//	DB接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/社員情報管理システムDB接続";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";



	public Employee findByLogin(Login login) {
		Employee employee = null;

		//		DBとの接続
		try (Connection conn = DriverManager.getConnection(this.JDBC_URL, this.DB_USER, this.DB_PASS)) {
			//		SELECT文の準備
			String sql = "SELECT ID,USERNAME,NAME,CALL,BIRTH,AGE,GENDER,COUTRY,POSTAL,ADDRESS,ENTRY,LEAVE,REASON,PHONE,MAIL,MYNUMBER,TEXT,PASS FROM EMPLOYEE WHERE USERNAME = ? AND PASS = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserName());
			pStmt.setString(2, login.getPass());


			//			SELECTの実行
			ResultSet rs = pStmt.executeQuery();

			//			一致したユーザーアカウントを示すEmployeeインスタンスを生成
			if (rs.next()) {
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
				employee = new Employee(id, userName, name, call, birth, age, gender, country, postal, address, entry,
						leave, reason, phone, mail, mynumber, text, pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			//　DBを検索して見つかったアカウントか,見つからない場合nullを返す
		}
		return employee;
	}
	//	メイン画面への表示

	//SELECTしてArrayListに入力内容を格納する
	public List<Employee> findAll(){
		List<Employee> employeeList = new ArrayList<>();

		//		DBとの接続
		try(Connection conn = DriverManager.getConnection(this.JDBC_URL,this.DB_USER,this.DB_PASS)){
			//		SELECT文の準備
			String sql = "SELECT  ID,USERNAME,NAME,CALL,BIRTH,AGE,GENDER,COUTRY,POSTAL,ADDRESS,ENTRY,LEAVE,REASON,PHONE,MAIL,MYNUMBER,TEXT,PASS FROM EMPLOYEE ORDER BY ID DSC ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//			SELECTの実行
			ResultSet rs = pStmt.executeQuery();

			//			SELECT文の結果をArrayListに格納
			while(rs.next()) {
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
				Employee employee = new Employee(id, userName, name, call, birth, age, gender, country, postal, address, entry,
						leave, reason, phone, mail, mynumber, text, pass);
				employeeList.add(employee);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}return employeeList;
	}
	public Employee <employee> selectAll(){
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

}
