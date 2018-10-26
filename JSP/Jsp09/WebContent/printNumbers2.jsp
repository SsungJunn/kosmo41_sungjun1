<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>printNumbers2</title>
</head>
<body>

<%
	String max = request.getParameter("max");
	int maxValue = Integer.parseInt(max);
	
	for(int i=0; i<maxValue; i++){
		out.println(i + "<br>");
	}
%>
</body>
</html>