package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cul")
public class Cul extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		System.out.println("doPost");
		
		request.setCharacterEncoding("UTF-8");
		
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		String cul = request.getParameter("cul");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html><head></head><body>");
		writer.println("첫번째 수 : " + num1 + "<br>");
		writer.println("두번째 수 : " + num2 + "<br>");
		
		int nNum1 = Integer.parseInt(num1);
		int nNum2 = Integer.parseInt(num2);
		int nResult = 0;
		
		if(cul.equals("덧셈")) {
			nResult = nNum1 + nNum2; 
		} else if (cul.equals("뺄셈")) {
			nResult = nNum1 - nNum2;
		} else if (cul.equals("곱셈")) {
			nResult = nNum1 * nNum2;
		} else if (cul.equals("나눗셈")) {
			nResult = nNum1 / nNum2;
		}
		
		//doSuccess(request, response, nNum1, nNum2, cul, nResult);
		
		writer.println("</body></html>");
	}
	
	void doSuccess(HttpServletRequest request, HttpServletResponse response,
			String nNum1, String nNum2, String cul, int nResult)
	{
	
	}
	
}
