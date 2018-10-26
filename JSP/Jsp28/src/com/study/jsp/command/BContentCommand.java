package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;
import com.study.jsp.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		String bpw = request.getParameter("bPw");
		String id = request.getParameter("id");
		
		HttpSession session = null;
		session = request.getSession();
		
		String bId = request.getParameter("bId");
		BDao dao = BDao.getInstance();
		BDto dto = dao.contentView(bId);
		
		BDto dto2 = dao.getMember(id);
		
		System.out.println(dto2);
		
		request.setAttribute("dto", dto2);
		request.setAttribute("content_view", dto);
	}
}
