package com.study.spring.dao;

import java.util.ArrayList;

import com.study.spring.dto.BDto;

public interface IDao {
	public ArrayList<BDto> listDao();

	public void writeDao(String bName, String bTitle, String bContent);

	public BDto viewDao(String bId);

	public void deleteDao(String bId);

	public void modifyDao(String bId, String bName, String bTitle, String bContent);

	public void replyDao(String bName, String bTitle, String bContent, String bGroup, int bStep, int bIndent);
	
	public void replysDao(String strGroup, String strstep);
	
}
