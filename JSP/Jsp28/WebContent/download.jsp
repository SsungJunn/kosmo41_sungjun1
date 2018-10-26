<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>본격! 게시판 - 게시글 조회</title>	

<script>

function onDownload(bId) {

	var o = document.getElementById("ifrm_filedown");	

	o.src = "download.do?bId="+bId;

}

</script>	

</head>

<body>				

<iframe id="ifrm_filedown"  style="position:absolute; z-index:1;visibility : hidden;"></iframe>  			
<h1>게시글 조회</h1>						

	<table border="1">							<!-- border은 테두리를 표시하는 속성입니다. -->

		<tr>									

			<th>번호</th>						

			<td>${content_view.bId}</td>

			<th>작성자</th>

			<td>${content_view.writer}</td>

			<th>ip</th>

			<td>${content_view.regip}</td>

			<th>날짜</th>

			<td>${content_view.regdate}</td>

			<th>조회수</th>

			<td>${content_view.count}</td>

		</tr>

		<tr>

			<th colspan="2">제목</th>			<!-- colspan은 행병합 속성입니다. -->

			<td colspan="8">${content_view.title}</td>

		</tr>

		<tr>

			<th colspan="2">내용</th>						

			<td colspan="8">${content_view.content}</td>

		</tr>

		<tr>

			<th colspan="2">첨부파일</th>			

			<td colspan="8">

<a href="#" onclick="onDownload('${content_view.bId}')">${content_view.filename}</a>

</td>

		</tr>

	</table>

	<a href="delete.do?bId=${content_view.bId}">게시글삭제</a>

	<a href="list.do">목록으로</a> 

</body>

</html>