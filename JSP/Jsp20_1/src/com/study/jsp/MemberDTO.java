/*
 * DAO클래스를 이용하여 데이터를 관리할 때 
 * 해당 데이터의 클래스를 만들어 사용
 */
package com.study.jsp;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String gender;
	
	public MemberDTO(String id, String pw, String name, String phone, String gender) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw() {
		this.pw = pw;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName() {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone() {
		this.phone = phone;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender() {
		this.gender = gender;
	}
}
