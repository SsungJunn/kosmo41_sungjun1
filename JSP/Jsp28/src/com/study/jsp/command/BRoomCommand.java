package com.study.jsp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;
import com.study.jsp.BDto;
import com.study.jsp.BPageInfo;

public class BRoomCommand implements BCommand {
	
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
		String board = request.getParameter("board");
		
		BDao dao = BDao.getInstance();
		BPageInfo pinfo = dao.articlePage(nPage, choose, search, board);
		request.setAttribute("page", pinfo);
		
		nPage = pinfo.getCurPage();
		
		HttpSession session = null;
		session = request.getSession();
		
		session.setAttribute("cpage", nPage);
		session.setAttribute("choose", choose);
		session.setAttribute("search", search);
		session.setAttribute("board", board);
		
		ArrayList<BDto> dtos = dao.list(nPage, choose, search, board);
		request.setAttribute("list", dtos);
		
		
	}

}


