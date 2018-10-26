/*
 * DAO클래스를 이용하여 데이터를 관리할 때 
 * 해당 데이터의 클래스를 만들어 사용
 */
package com.study.jsp;


public class RDto {
	
	// 방 정보
	String RId;
	int RNum;
	String RName;
	String RPw;
	String RBoss;
	
	public String getRBoss() {
		return RBoss;
	}

	public void setRBoss(String rBoss) {
		this.RBoss = rBoss;
	}

	public String getRId() {
		return RId;
	}

	public void setRId(String rId) {
		this.RId = rId;
	}

	public int getRNum() {
		return RNum;
	}

	public void setRNum(int RNum) {
		this.RNum = RNum;
	}

	public String getRName() {
		return RName;
	}

	public void setbRName(String RName) {
		this.RName = RName;
	}
	
	public String getRPw() {
		return RPw;
	}

	public void setRPw(String RPw) {
		this.RPw = RPw;
	}
	
	public RDto(int RNum, String RName, String RPw, String rId, String RBoss) {
		
		this.RNum = RNum;
		this.RName = RName;
		this.RId = rId;
		this.RPw = RPw;
		this.RBoss = RBoss;
	}

}
