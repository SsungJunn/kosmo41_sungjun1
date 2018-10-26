<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 시작</title>
<script src="https://cdn.ckeditor.com/4.10.0/standard/ckeditor.js"></script>

</head>
<body>

	<table cellpadding="0" cellspacing="0" border="1">
		<form action="rwrite.do?" method="post">
			<tr>
				<td> ID </td>
				<%
					if ( (String)session.getAttribute("id") == null) {
				%>
					<td>Guest<br>		
				<%
					} else {
						String id = (String)session.getAttribute("id");
				%>
					<td><%= id %><br>
				<%	}  %>

			</tr>
			<tr>
				<td> 비밀번호 </td>
				<td> <input type="password" name="RPw" size="50">
		  			 <input type="radio" name="password" value="pb" checked="checked" />공개,
					 <input type="radio" name="password" value="pw" />비공개<br/>
				</td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="RName" size="50">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="방만들기"> &nbsp;&nbsp;
					<a href="room.do?">목록</a>
				<td> 
			</tr>
		</form>
	</table>
	
</body>
</html>