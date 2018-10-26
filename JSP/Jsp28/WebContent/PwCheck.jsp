<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방비밀번호 체크</title>
<script>
	function PwCheck() {
		String RPwCheck = (String)session.getAttribute("RPw");
		
		if(RPw == RPwCheck) {
			System.out.println("Ok");
		} else {
			System.out.println("fail");
		}
	}
</script>

</head>
<body>

	<table cellpadding="0" cellspacing="0" border="1">
		<form action="client.do" method="post">
			
			<tr>
				<td> 비밀번호 번호를 입력하시오.</td>
			</tr>
			<tr>
				<td> 
					<input type="password" name="RPw" size="50">
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="확인" onclick="PwCheck()"> &nbsp;&nbsp;
					<input type="reset" value="취소" onclick="javascript:window.location='room.do'">
				<td> 
			</tr>
		</form>
	</table>
	
</body>
</html>