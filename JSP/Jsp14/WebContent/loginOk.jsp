<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
	
		if(id.equals("abcde") && pw.equals("12345")) {
			session.setAttribute("myName", "준");
			session.setAttribute("myId", "abcde");
			session.setAttribute("myPassword", 12345);
			
			response.sendRedirect("welcome.jsp");
		} else {
			response.sendRedirect("login.html");
		}
		
		
		
	%>
</body>
</html>