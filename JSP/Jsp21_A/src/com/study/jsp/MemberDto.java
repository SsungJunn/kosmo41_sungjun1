/*
 * DAO클래스를 이용하여 데이터를 관리할 때 
 * 해당 데이터의 클래스를 만들어 사용
 */
package com.study.jsp;

import java.sql.Timestamp;

public class MemberDto {
	
	private String id;
	private String pw;
	private String name;
	private String eMail;
	private Timestamp rDate;
	private String address;
	
//	public MemberDTO(String id, String pw, String name, String phone, String gender) {
//		this.id = id;
//		this.pw = pw;
//		this.name = name;
//		this.phone = phone;
//		this.gender = gender;
//	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String geteMail() {
		return eMail;
	}
	
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public Timestamp getrDate() {
		return rDate;
	}
	
	public void setrDate(Timestamp rDate) {
		this.rDate = rDate;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
}
