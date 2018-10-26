package com.study.jsp.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;
import com.study.jsp.BDto;

public class joinOk implements BCommand {

	public joinOk() {
	}

	@Override
	public void execute(HttpServletRequest request,
						HttpServletResponse response) 
						throws ServletException, IOException {
		
		{
			System.out.println("joinOk");
			System.out.println("1111111");
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter writer = response.getWriter();
			HttpSession session = request.getSession();
			
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String eMail = request.getParameter("eMail");
			String address = request.getParameter("address");
			
			BDao dao = BDao.getInstance();
			
			BDto dto = new BDto();
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.seteMail(eMail);
			dto.setrDate(new Timestamp(System.currentTimeMillis()));
			dto.setAddress(address);		
			
			if(dao.confirmId(dto.getId()) == BDao.MEMBER_EXISTENT) {
				writer.println("아이디가 이미 존재 합니다.");
				response.sendRedirect("join.jsp");
				
				writer.close();				
				
			} else {
				
				int ri = dao.insertMember(dto);
				
				session.setAttribute("id", id);
				System.out.println("12345");
				
				if (ri == BDao.MEMBER_JOIN_SUCCESS) {
					session.setAttribute("id", dto.getId());
					
					writer.println("<script>alert('회원가입을 축하합니다.');");
					writer.println("javascript:window.location='login.jsp';</script>");
					writer.close();
				}
			}
		}
	}
}
