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
		<form action="write.do?board=${sports}" method="post" enctype="multipart/form-data">
			<tr>
				<td> 이름 </td>
				<%
					if ( (String)session.getAttribute("name") == null) {
				%>
					<td>Guest<br>		
				<%
					} else {
						String name = (String)session.getAttribute("name");
				%>
					<td><%= name %><br>
				<%	}  %>

			</tr>
			<tr>
				<td> 비밀번호 </td>
				<td> <input type="password" name="bPw" size="50">
		  			 <input type="radio" name="password" value="pb" checked="checked" />공개,
					 <input type="radio" name="password" value="pw" />비공개<br/>
				</td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="bTitle" size="50">
					 <select name="sports" class="custom-select my-1 mr-sm-2">
					 <option selected>작성할 게시판 선택</option>
					 <option value="축구">축구게시판</option>
					 <option value="야구">야구게시판</option>
					 <option value="농구">농구게시판</option><br/>
					 </select>
				</td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> 
					<textarea name="bContent" id="editor1" rows="10" cols="80">
            		</textarea>
            		<script>
               		 // Replace the <textarea id="editor1"> with a CKEditor
               		 // instance, using default configuration.
               		 CKEDITOR.replace( 'editor1' );
            		</script>
				
				</td>
			</tr>
			<tr>
				<td> 파일 </td>
				<td> <input type="file" name="filename" ></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="입력"> &nbsp;&nbsp;
					<a href="list.do?board">목록</a>
				<td> 
			</tr>
		</form>
	</table>
	
</body>
</html>