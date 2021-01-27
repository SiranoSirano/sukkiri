package test;

import dao.EmployeeDAO;
import model.Employee;
import model.Login;

public class EmployeeDAOTest {

	public static void main(String[] args) {
		testFindByLogin1(); //ユーザーが見つかる場合のテスト
		testFindByLogin2(); //ユーザーが見つからない場合のテスト

	}

	public static void testFindByLogin1() {
		Login login = new Login("saitou", "1234");
		EmployeeDAO dao = new EmployeeDAO();
		Employee result = dao.findByLogin(login);
		if ((result != null) &&
				result.getUserName().equals("saitou") &&
				result.getName().equals("斎藤 将来") &&
				result.getCall().equals("さいとうまさき") &&
				result.getBirth().equals(1993 - 11 - 23) &&
				(result.getAge() == (27)) &&
				result.getGender().equals("男") &&
				result.getCountry().equals("日本") &&
				(result.getPostal() == (1200013)) &&
				result.getAddress().equals("東京都足立区") &&
				result.getEntry().equals(2019 - 07 - 31) &&
				result.getLeave().equals(2999 - 12 - 31) &&
				result.getReason().equals("なし") &&
				result.getPhone().equals("09061988884") &&
				result.getMail().equals("masaki.saitou@innovacess.com") &&
				(result.getMynumber() == (123456789)) &&
				result.getText().equals("なし") &&
				result.getPass().equals("1234")) {
			System.out.println("testFindByLogin1:成功しました");
		} else {
			System.out.println("testFindByLogin1:失敗しました");
		}
	}

	public static void testFindByLogin2() {
		Login login = new Login("saitou", "12345");
		EmployeeDAO dao = new EmployeeDAO();
		Employee result = dao.findByLogin(login);
		if (result == null) {
			System.out.println("testFindByLogin2:成功しました");
		} else {
			System.out.println("testFindByLogin2:失敗しました");
		}
	}

}
