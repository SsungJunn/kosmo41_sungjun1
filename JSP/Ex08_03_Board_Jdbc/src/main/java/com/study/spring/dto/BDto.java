package com.study.spring.dto;

import java.sql.Timestamp;

public class BDto {
	int bId;
	String bName;
	String bTitle;
//	String bPw;
	String bContent;
	Timestamp bDate;
	int bHit;
	int bGroup;
	int bStep;
	int bIndent;
//	String bBoard;
//	String filename;
	public BDto() {}
	
	public BDto(int bId, String bName, String bTitle, String bContent, 
			Timestamp bDate, int bHit, int bGroup, int bStep, int bIndent) {
	
	this.bId = bId;
	this.bName = bName;
	this.bTitle = bTitle;
//	this.bPw = bPw;
	this.bContent = bContent;
	this.bDate = bDate;
	this.bHit = bHit;
	this.bGroup = bGroup;
	this.bStep = bStep;
	this.bIndent = bIndent;
//	this.bBoard = bBoard;
//	this.filename = filename;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

//	public String getbPw() {
//		return bPw;
//	}
//
//	public void setbPw(String bPw) {
//		this.bPw = bPw;
//	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public int getbGroup() {
		return bGroup;
	}

	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}

	public int getbStep() {
		return bStep;
	}

	public void setbStep(int bStep) {
		this.bStep = bStep;
	}

	public int getbIndent() {
		return bIndent;
	}

	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}

//	public String getbBoard() {
//		return bBoard;
//	}
//
//	public void setbBoard(String bBoard) {
//		this.bBoard = bBoard;
//	}
//
//	public String getFilename() {
//		return filename;
//	}
//
//	public void setFilename(String filename) {
//		this.filename = filename;
//	}
}



