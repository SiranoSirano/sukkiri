package model;

import dao.EmployeeDAO;

public class LoginLogic {
	public boolean execute(Login login) {
		EmployeeDAO dao = new EmployeeDAO();
		Employee employee = dao.findByLogin(login);
		return employee != null;
		//ここをDBと連携させて,ユーザー名とpasswordの情報を社員の情報と一致させる

	}
}
