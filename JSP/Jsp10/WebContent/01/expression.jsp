<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>스트립트릿, 선언, 표현식10-1</title>
</head>
<body>
	<%-- <%!는 전역변수 --%>
	<%!
		int i = 10;
		String str = "abc";
		
		public int sum(int a, int b) {
			return a+b;
	}
	%>
	
	숫자 1의 값은 <%= i %>입니다. <br />
	문자변수에는 <%= str %> 값이 저장되어 있습니다. <br />
	두 수의 합은 <%= sum(1, 5) %>입니다.
	
</body>
</html>