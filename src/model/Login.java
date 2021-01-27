package model;
//ユーザーに関する情報を持つJavaBeans
import java.io.Serializable;

public class Login implements Serializable{
	//フィールドはプライべート
	private String userName; //ユーザー名
	private String pass; //パスワード

	public Login() {}
	public Login(String userName, String pass) {
		this.userName = userName;
		this.pass = pass;
	}

	public String getUserName() {return userName;}
	public String getPass() {return pass;}
}

