package dao;





import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Employee;

public class ListDao extends DAO{


	//		DBから全ユーザーの情報検索を行うメソッド
	//	戻り値としてArrayList<Employee> をつかう
	public ArrayList<Employee> selectAll(){
		//	変数宣言
		Connection con = null;
		Statement smt = null;
		//		return用オブジェクトの生成
		ArrayList<Employee> list = new ArrayList<Employee>();
		//		SQL文
		String sql ="SELECT * FROM EMPLOYEE";


		try {
			con = this.getConnection();
			smt = con.createStatement();


			//			SQL文をDBに出力
			ResultSet rs = smt.executeQuery(sql);
			//			検索結果を配列で取得


			//set文をスッキリから持ってくる
			while(rs.next()) {
				Employee employee =new Employee();
				employee.setId(rs.getInt("ID"));
				employee.setUserName(rs.getString("USERNAME"));
				employee.setName(rs.getString("NAME"));
				employee.setCall(rs.getString("CALL"));
				employee.setBirth(rs.getString("BIRTH"));
				employee.setAge(rs.getInt("AGE"));
				employee.setGender(rs.getString("GENDER"));
				employee.setCountry(rs.getString("COUTRY"));
				employee.setPostal(rs.getInt("POSTAL"));
				employee.setAddress(rs.getString("ADDRESS"));
				employee.setEntry(rs.getString("ENTRY"));
				employee.setLeave(rs.getString("LEAVE"));
				employee.setReason(rs.getString("REASON"));
				employee.setPhone(rs.getString("PHONE"));
				employee.setMail(rs.getString("MAIL"));
				employee.setMynumber(rs.getInt("MYNUMBER"));
				employee.setText(rs.getString("TEXT"));
				employee.setPass(rs.getString("PASS"));
				list.add(employee);
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

