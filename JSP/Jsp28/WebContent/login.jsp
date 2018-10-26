<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if(session.getAttribute("ValidMem") != null) { %>
	<jsp:forward page="client.jsp"></jsp:forward>
<% } %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1, maximum-scale=1.0, minimum-scale=1.0, shrink-to-fit=no">
<meta name="google-signin-client_id" content="650184249424-mjgdh07iqavref0nu1leflb4svh9ml6o.apps.googleusercontent.com">
<title>Insert title here</title>

</head>
<body>
	<form action="loginOk.do" method="post">
		아이디 : <input type="text" name="id"
						value="<% if(session.getAttribute("id") != null)
									 out.println(session.getAttribute("id"));
								%>"> <br>
		비밀번호 : <input type="password" name="pw" ><br><p>
		<input type="submit" value="로그인" > &nbsp;&nbsp;
		<input type="button" value="회원가입" onclick="javascript:window.location='join.jsp'">
		<input type="button" value="게스트접속" onclick="javascript:window.location='list.do'">
	</form>

</body>
</html>