<%@ page import="java.util.Enumeration" %>
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
	String sSession;
	String stest;
	
	Enumeration enumeration = session.getAttributeNames();
	while(enumeration.hasMoreElements()){
		sSession = enumeration.nextElement().toString();
		stest = session.getAttribute(sSession).toString();
		
		if(sSession.equals("myPassword"))
		{
			continue;
		}
			out.println(sSession +" : " + stest + "<br>");
		}
	%>
</body>
</html>