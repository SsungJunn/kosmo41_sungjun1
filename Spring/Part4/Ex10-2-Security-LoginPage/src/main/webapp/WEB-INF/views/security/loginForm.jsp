<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<form action="<c:url value="j_spring_security_check"/>" method="post">
		ID:<input type="text" name="j_username" id="j_username"><br />
		PW:<input type="text" name="j_password" id="j_password"><br />
		<input type="submit" value="LOGIN"><br />
	</form>

</body>
</html>