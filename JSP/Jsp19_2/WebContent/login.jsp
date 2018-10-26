<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<script src="http://code.jquery.com/jquery.js"></script>
	<script>
		function form_check() {
			submit_ajax();
		}
	
		function submit_ajax() {
			var queryString = $("#LogInProcess").serialize();			
			$.ajax({
				url : '/Jsp19_2/LogInProcess',
				type : 'POST',
				data : queryString,
				dataType : 'json',
				success : function(json){
					alert("1111111111");
					var results = eval(json);
					if(results[0].result == "ok") {
						alert("안녕하세요.")
						window.location.replace("loginResult.jsp");
					} else {
						alert(results[0].desc);
					}
				}
			});
		}
		</script>
</head>
<body>

	<form name="LogInProcess" id="LogInProcess">
		아이디 : <input type="text" name="id">
		비밀번호 : <input type="text" name="pw">
		<input type="button" value="로그인" onclick="form_check()" >
	</form>
	
</body>
</html>
