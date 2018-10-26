package com.study.jsp.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;
import com.study.jsp.BDto;

public class loginOk implements  BCommand {

	public loginOk() {
	}

	@Override
	public void execute(HttpServletRequest request, 
				HttpServletResponse response)
				throws ServletException, IOException {
		{
			System.out.println("loginOk");
			
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			
			BDao dao = BDao.getInstance();
			int checkNum = dao.userCheck(id, pw);
			if(checkNum == -1) {
				// html 출력
				writer.println("<script>alert('존재하지 않는 아이디입니다.');");
				writer.println("javascript:window.location='login.jsp';</script>");
				writer.close();
				
			} else if(checkNum == 0) {
				// html 출력
				writer.println("<script>alert('비밀번호가 틀립니다.');");
				writer.println("javascript:window.location='login.jsp';</script>");
				writer.close();
				
			} else if(checkNum == 1) {
				BDto dto = dao.getMember(id);
				
				if(dto == null) {
					writer.println("<script>alert('존재하지않는 회원입니다.');");
					writer.println("javascript:window.location='login.jsp';</script>");
					writer.close();
				} else {
					String name = dto.getName();
					
					HttpSession session = request.getSession();
					
					session.setAttribute("id", id);
					session.setAttribute("name", name);
					session.setAttribute("ValidMem", "yes");
					writer.println("<script>javascript:window.location='list.do';</script>");
					writer.close();
				}
			}
		}
	}
}
