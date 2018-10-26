package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;
import com.study.jsp.RDao;

public class RWriteCommand implements BCommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		String RId = (String)session.getAttribute("id");
		RDao rdao = RDao.getInstance();
		
		String RName = request.getParameter("RName");
		String RPw = request.getParameter("RPw");
		rdao.MakeRoom(RName, RId, RPw);
		
	}

}
