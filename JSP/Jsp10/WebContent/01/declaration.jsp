<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>스트립트릿, 선언, 표현식10-1</title>
</head>
<body>
	<%!
		int i = 10;
		String str = "ABCDE";
	%>
	
	<%!
		public int sum(int a, int b) {
			return a+b;
	}
	%>
	
	<%
		out.println("i = " + i + "<br />");
		out.println("str = " + str + "<br />");
		out.println("sum = " + sum(1,5) + "<br />");
	%>
</body>
</html>