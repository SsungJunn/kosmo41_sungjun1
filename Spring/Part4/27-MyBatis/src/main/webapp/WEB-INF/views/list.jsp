<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td align="center">번호</td>
			<td align="center">이름</td>
			<td align="center">제목</td>
			<td align="center">날짜</td>
			<td align="center">히트</td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.bId}</td>
				<td>${dto.bName}</td>
				<td><c:forEach begin="1" end="${dto.bIndent}">-</c:forEach> <a
					href="content_view?bId=${dto.bId}&page=$">${dto.bTitle}</a></td>
				<td>${dto.bDate}</td>
				<td>${dto.bHit}</td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="5"><a href="write_view">글작성</a></td>
		</tr>
		<tr>
			<td colspan="5">
				<!-- 처음 --> <c:choose>
					<c:when test="${(page.curPage-1)<1}">
				[처음]
			</c:when>
					<c:otherwise>
						<a href="list.do?page=1">[ 처음 ]</a>
					</c:otherwise>
				</c:choose> <!-- 이전 --> <c:choose>
					<c:when test="${(page.curPage -1) < 1}">
				[ &lt; ]
			</c:when>
					<c:otherwise>
						<a href="list.do?page=${page.curPage -1}">[ &lt;]</a>
					</c:otherwise>
				</c:choose> <!-- 개별 페이지 --> <c:forEach var="num" begin="${page.startPage}"
					end="${page.endPage}" step="1">
					<c:choose>
						<c:when test="${page.curPage == num}">
            	[${num}] &nbsp;
            </c:when>

						<c:otherwise>
							<a href="list.do?page=${num}">[${num}]</a> &nbsp;	
            </c:otherwise>
					</c:choose>
				</c:forEach> <!-- 다음 --> <c:choose>
					<c:when test="${(page.curPage +1 ) > page.totalPage }">
				[ &gt; ]
			</c:when>
					<c:otherwise>
						<a href="list.do?page=${page.curPage +1 }">[ &gt;]</a>
					</c:otherwise>
				</c:choose> <!-- 끝 --> <c:choose>
					<c:when test="${page.curPage == page.totalPage}">
				[끝]
			</c:when>
					<c:otherwise>
						<a href="list.do?page=${page.totalPage}">[끝]</a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>

	</table>

	totalCount : ${page.totalCount}
	<br> listCount : ${page.listCount }
	<br> totalPage : ${page.totalPage }
	<br> curPage : ${page.curPage }
	<br> pageCount : ${page.pageCount }
	<br> startPage : ${page.startPage }
	<br> endPage : ${page.endPage }
	<br>

</body>
</html>