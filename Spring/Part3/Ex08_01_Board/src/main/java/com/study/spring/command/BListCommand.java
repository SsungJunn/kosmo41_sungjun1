package com.study.spring.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.study.spring.dao.BDao;
import com.study.spring.dto.BDto;

public class BListCommand implements BCommand {
	
	@Override
	public void execute(Model model)
	{		
		
//		int nPage = 1;
//		try {
//			String sPage = request.getParameter("page");
//			nPage = Integer.parseInt(sPage);
//		} catch (Exception e) {
//		}
//		
//		BDao dao = BDao.getInstance();
//		BPageInfo pinfo = dao.articlePage(nPage);
//		model.addAttribute("page", pinfo);
//		
//		nPage = pinfo.getCurPage();
//		
//		HttpSession session = null;
//		session = request.getSession();
//		session.setAttribute("cpage", nPage);
		
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);
		
	}

}
