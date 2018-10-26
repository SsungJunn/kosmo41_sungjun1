<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String num1, num2, cul;
		int nNum1, nNum2;
	%>
	
	<%		
		request.setCharacterEncoding("UTF-8");
		
		num1 = request.getParameter("num1");
		num2 = request.getParameter("num2");
		
		cul = request.getParameter("cul");
		%>
		
		<%
			nNum1= Integer.parseInt(num1);
			nNum2 = Integer.parseInt(num2);
			int nResult = 0;
		%>
		
		<%
		if(cul.equals("덧셈")) {
			nResult = nNum1 + nNum2; 
		} else if (cul.equals("뺄셈")) {
			nResult = nNum1 - nNum2;
		} else if (cul.equals("곱셈")) {
			nResult = nNum1 * nNum2;
		} else if (cul.equals("나눗셈")) {
			nResult = nNum1 / nNum2;
		}
		%>

		<%= nNum1 %> <%= cul %> <%= nNum2 %> <%= nResult %>
		
</body>
</html>