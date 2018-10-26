package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class joinOk implements Service {

	public joinOk() {
	}

	@Override
	public void execute(HttpServletRequest request,
						HttpServletResponse response) 
						throws ServletException, IOException {
		
		{
			System.out.println("joinOk");
			
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter writer = response.getWriter();
			HttpSession session = request.getSession();
			
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String eMail = request.getParameter("eMail");
			String address = request.getParameter("address");
			
			MemberDao dao = MemberDao.getInstance();
			
			MemberDto dto = new MemberDto();
			dto.setId(id);
			dto.setPw(pw);
			dto.seteMail(eMail);
			dto.setrDate(new Timestamp(System.currentTimeMillis()));
			dto.setAddress(address);		
			
			if(dao.confirmId(dto.getId()) == MemberDao.MEMBER_EXISTENT) {
				writer.println("아이디가 이미 존재 합니다.");
				writer.close();
		
				response.sendRedirect("join.jsp");
				
			} else {
				
				int ri = dao.insertMember(dto);
				
				session.setAttribute("id", id);
				
				if (ri == MemberDao.MEMBER_JOIN_SUCCESS) {
					session.setAttribute("id", dto.getId());

					writer.println("회원가입을 축하 합니다.");
					response.sendRedirect("login.jsp");
					writer.close();				
				
				} else {
					writer.println("회원가입에 실패했습니다.");
					writer.close();
					response.sendRedirect("join.jsp");
				}
			}
		}
	}
}
