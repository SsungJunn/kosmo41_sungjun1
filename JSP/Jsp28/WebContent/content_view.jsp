<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    
    <script>

	function onDownload(bId) {

	var o = document.getElementById("ifrm_filedown");	

	o.src = "download.do?bId="+bId;

}

</script>	

    
</head>
<body>
<iframe id="ifrm_filedown"  style="position:absolute; z-index:1;visibility : hidden;"></iframe>
  	
 	<table width="500" cellpadding="0" cellspacing="0" border="1">
 	
		<tr>
			<td> 번호 </td>
			<td> ${content_view.bId} </td>
		</tr>
		<tr>
			<td> ID </td>
			<td> ${dto.id} </td>
		</tr>
		<tr>
			<td> 히트 </td>
			<td> ${content_view.bHit} </td>
		</tr>
		<tr>
			<td> 이름 </td>
			<td> ${content_view.bName} </td>
		</tr>
		<tr>
			<td> 제목 </td>
			<td> ${content_view.bTitle} </td>
		</tr>
		<tr>
			<td> 내용 </td>
			<td> ${content_view.bContent} </td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td>
				<a href="#" onclick="onDownload('${content_view.bId}')">${content_view.filename}</a>

			</td>

		</tr>
		
		<tr>
			<td colspan="2">
			<a href="modify_view.do?bId=${content_view.bId}">수정</a> &nbsp;&nbsp;
			<a href="list.do?page=<%= session.getAttribute("cpage")%>">목록</a> &nbsp;&nbsp;
			<a href="delete.do?bId=${content_view.bId}">게시글 삭제</a> &nbsp;&nbsp;
			<a href="reply_view.do?bId=${content_view.bId}">답변</a></td> 
		</tr>
	</table>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
   
    
</body>
</html>


