package com.study.jsp.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;
import com.study.jsp.BDto;

public class modifyOk implements BCommand {

	public modifyOk() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request,
						HttpServletResponse response)
					throws ServletException, IOException{
System.out.println("modifyOk");
		
		request.setCharacterEncoding("UTF-8");
		String pw = request.getParameter("pw");
		String eMail = request.getParameter("eMail");
		String address = request.getParameter("address");
		BDao dao = BDao.getInstance();
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
	
		BDto dto = new BDto();
		dto.setId(id);
		dto.setPw(pw);
		dto.seteMail(eMail);
		dto.setAddress(address);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		session.setAttribute("eMail", eMail);
		session.setAttribute("address", address);
		
		int ri = dao.updateMember(dto);
		
		if(ri == 1) {
			writer.println("정보가 수정되었습니다.");
			response.sendRedirect("list.do");
			writer.close();

		} else {
			writer.println("정보수정에 실패했습니다.");
			response.sendRedirect("modify.jsp");
			writer.close();			
		}

	}

}
