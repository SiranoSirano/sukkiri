package model;
//登録情報を持つJava Beans

import java.io.Serializable;

public class Employee implements Serializable{
	private int id;//ユーザーID
	private String userName; //ユーザー名
	private String name; //名前
	private String call; //読み方
	private String  birth; //誕生日
	private int age; //年齢
	private String gender; //性別
	private String country; //	国籍
	private int postal; //郵便番号
	private String address;//住所
	private String  entry; //雇入の年月日
	private String  leave;//退職の年月日
	private String reason;//退職事由
	private String phone;//電話番号
	private String mail;//メールアドレス
	private int mynumber;//個人ナンバー
	private String text; //備考
	private String pass; //パスワード

	public Employee() {}

	public Employee(int id,String userName,String name, String call,String  birth,int age, String gender,
			String country,int postal, String address,String  entry, String leave,String reason,
			String phone,String mail,int mynumber,String text,String pass) {
		this.id = id;
		this.userName = userName;
		this.name= name;
		this.call= call;
		this.birth= birth;
		this.age= age;
		this.gender= gender;
		this.country= country;
		this.postal= postal;
		this.address= address;
		this.entry= entry;
		this.leave= leave;
		this.reason= reason;
		this.phone= phone;
		this.mail= mail;
		this.mynumber= mynumber;
		this.text = text;
		this.pass = pass;
	}
	public int getId(){return this.id;}
	public String getUserName() {return this.userName;}
	public String getName(){return this.name;}
	public String getCall(){return this.call;}
	public String getBirth(){return this.birth;}
	public int getAge(){return this.age;}
	public String getGender(){return this.gender;}
	public String getCountry(){return this.country;}
	public int getPostal(){return this.postal;}
	public String getAddress(){return this.address;}
	public String getEntry(){return this.entry;}
	public String getLeave(){return this.leave;}
	public String getReason(){return this.reason;}
	public String getPhone(){return this.phone;}
	public String getMail(){return this.mail;}
	public int getMynumber(){return this.mynumber;}
	public String getText() {return this.text;}
	public String getPass() {return this.pass;}


	public void setId(int id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCall(String call) {
		this.call = call;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPostal(int postal) {
		this.postal = postal;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public void setLeave(String leave) {
		this.leave = leave;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setMynumber(int mynumber) {
		this.mynumber = mynumber;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
