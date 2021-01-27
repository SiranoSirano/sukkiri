package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}