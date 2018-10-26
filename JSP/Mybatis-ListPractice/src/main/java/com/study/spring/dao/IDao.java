package com.study.spring.dao;

import java.util.ArrayList;

import com.study.spring.dto.ContentDto;

public interface IDao {

	public ArrayList<ContentDto> listDao();
	public ContentDto viewDao(String strID);
	public ContentDto contentDao(String bId);
	public void writeDao(String bName, String bTitle, String bContent);
	public void deleteDao(String bId);
	public void modifyDao(String bId, String bName, String bTitle, String bContent);
	public ContentDto replyViewDao(String bId);
	public void replyDao(String bName, String bTitle, String bContent,
			int bGroup, int bStep, int bIndent);
	public void replyShape(int bGroup, int bStep);
	public void upHit(String bId);
}
