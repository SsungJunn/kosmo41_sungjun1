package com.study.jsp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.RDao;
import com.study.jsp.RDto;
import com.study.jsp.RPageInfo;

public class RListCommand implements BCommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	{		
		
		int nPage = 1;
		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
		} catch (Exception e) {
		}
		String choose = request.getParameter("choose");
		String search = request.getParameter("search");
		String RPw = request.getParameter("RPw");
		
		
		
		RDao rdao = RDao.getInstance();
		RPageInfo rpinfo = rdao.articlePage(nPage, choose, search);
		request.setAttribute("page", rpinfo);
		
		nPage = rpinfo.getRcurPage();
		
		HttpSession session = null;
		session = request.getSession();
		
		session.setAttribute("cpage", nPage);
		session.setAttribute("choose", choose);
		session.setAttribute("search", search);
		
		ArrayList<RDto> rdtos = rdao.list(nPage, choose, search, RPw);
		request.setAttribute("roomlist", rdtos);
		session.setAttribute("RPw", RPw);
		session.getAttribute(RPw);
		
		
		
	}

}


