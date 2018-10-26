package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.RDao;
import com.study.jsp.RDto;

public class ClientCommand implements BCommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	{	
		String RNum = request.getParameter("RNum");
		String RName = request.getParameter("RName");
		String RPw = request.getParameter("RPw");
		String RId = request.getParameter("RId");
		String RBoss = request.getParameter("RBoss");
		

		HttpSession session = null;
		session = request.getSession();
		
		session.setAttribute("RNum", RNum);
		
		RDao rdao = RDao.getInstance();
		RDto rdto = rdao.contentView(RNum, RName, RPw, RId, RBoss);
		request.setAttribute("RNum", RNum);
		request.setAttribute("RPw", RPw);
		request.setAttribute("RId", RId);
	}

}


