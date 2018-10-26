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
		Object obj1 = session.getAttribute("myName");
		String mySessionName = (String)obj1;
		out.println(mySessionName + "<br>");
	
		Object obj2 = session.getAttribute("myId");
		String mySessionId = (String)obj2;
		out.println(mySessionId + "<br>");
		
		Object obj3 = session.getAttribute("myPassword");
		Integer myPW = (Integer)obj3;
		out.println(myPW + "<br>");
		
		out.println(mySessionName + "님 안녕하세요." + "<br>");
	%>
	
	<a href="logout.jsp">로그아웃</a>
	
	<a href="sessiontest.jsp">세션테스트</a>
</body>
</html>