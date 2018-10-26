<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="./naver_editor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
</head>
<script>
	function form_check() {
		// 에디터의 내용이 textarea에 적용된다.
		oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
		document.modify_form.submit();

	}
</script>
<body>

	<table width="800" cellpadding="0" cellspacing="0" border="1">
		<form name="modify_form" action="modify" method="post">
			<input type="hidden" name="bId" value="${modify_view.bId }">
			<tr>
				<td>번호</td>
				<td>${modify_view.bId}</td>
			</tr>
			<tr>
				<td>히트</td>
				<td>${modify_view.bHit}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName"
					value="${modify_view.bName}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle"
					value="${modify_view.bTitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="bContent" id="ir1" rows="10" cols="100">${modify_view.bContent}</textarea>
				</td>
			</tr>

			<td colspan="2"><input type="submit" value ="수정완료"></a>&nbsp;&nbsp;
				<a href="content_view?bId=${content_view.bId}">취소</a>
				&nbsp;&nbsp; <a
				href="list.do?page=<%=session.getAttribute("cpage")%>">목록보기</a>&nbsp;&nbsp;

			
		</form>
	</table>
</body>
</html>