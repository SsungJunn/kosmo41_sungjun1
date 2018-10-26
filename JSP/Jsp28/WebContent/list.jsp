<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
 
    <style>
   .class-name1 {
        width: 400px;          /* 100px, 90% */
        height: 100px;
        display: block;        /* none, block, inline, inline-block; */
        visibility: visible;   /* xxxxx : visible, hidden, collpase */
        float: right;           /* none, left, right */
        
        margin: 10px 10px 10px 10px;
        padding: 10px 10px 10px 10px;
    }
   </style>
</head>
<body>
	<ul class="nav nav-pills nav-fill">
	<li class="nav-item">
  		<a class="nav-link" href="list.do">Home</a>
  		</li>
  		<li class="nav-item">
  		<a class="nav-link" href="list.do?board=축구">축구게시판</a>
  		</li>
  		<li class="nav-item">
		<a class="nav-link" href="list.do?board=야구">야구게시판</a>
		</li>
		<li class="nav-item">
		<a class="nav-link" href="list.do?board=농구">농구게시판</a>
		</li>
		<li class="nav-item">
  		<a class="nav-link" href="room.do">채팅방보기</a>
  		</li>
	</ul>
<%
	if ( (String)session.getAttribute("name") == null) {
%>
		<div class=class-name1>Guest 님 반갑습니다.<br>		
<%
	} else {
		String name = (String)session.getAttribute("name");
%>
		<div class=class-name1><%= name %> 님 반갑습니다.<br>
<%	}  %>

	<input type="button" class="btn btn-outline-dark" value=정보수정 onclick="javascript:window.location='modify.jsp'">
	<input type="button" class="btn btn-outline-dark" value=로그아웃 onclick="javascript:window.location='logoutOk.do'">
	
	</div></div>

	<div class="container">
		<div class="row">
    		<div class="col"></div>
  	  		<div class="col-12">
		
			<table class="table table-striped table-hover">
				<thead class="thead-dark">
					<tr>
						<th scope="col">번호</th>
						<th scope="col">이름</th>
						<th scope="col">제목</th>
						<th scope="col">날짜</th>
						<th scope="col">히트</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="dto">
					<tr>
						<th scope="row">${dto.bId}</th>
						<th scope="row">${dto.bName}</th>
						<td>
							<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
							<a href="content_view.do?bId=${dto.bId}&bPw=${dto.bPw}">${dto.bTitle}</a>				
						</td>
						<th scope="row">${dto.bDate}</th>
						<th scope="row">${dto.bHit}</th>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="button" class="btn btn-outline-dark" value=글작성 onclick="javascript:window.location='write_view.do'">			
		
			</div>
			<div class="col"></div>
		</div>
	</div><br />
	<ul class="nav justify-content-center">
		<tr>
			<td colspan="5">
			<!-- 처음 -->
			<c:choose>
			<c:when test="${(page.curPage - 1) <  1}">
				<button type="button" class="btn btn-outline-dark">&lt;&lt;</button>&nbsp;&nbsp;
				
			</c:when>
			<c:otherwise>
				<a href="list.do?page=1<% if(session.getAttribute("board") != null && session.getAttribute("search") != null) { %>
														&board=${board}
														&search=${search}
														&choose=${choose}
									   <% } else if (session.getAttribute("board") == null && session.getAttribute("search") != null) { %>
														&search=${search}
														&choose=${choose}
									   <% } else if (session.getAttribute("board") != null && session.getAttribute("search") == null) { %>
														&board=${board}
									   <% }%>">
				<button type="button" class="btn btn-outline-dark">&lt;&lt;</button></a>&nbsp;&nbsp;
			</c:otherwise>
			</c:choose>
			<!-- 이전 -->
			<c:choose>
			<c:when test="${(page.curPage - 1) <  1}">
				<button type="button" class="btn btn-outline-dark">&lt;</button>&nbsp;&nbsp;
			</c:when>
			<c:otherwise>
				<a href="list.do?page=${page.curPage - 1}<% if(session.getAttribute("board") != null && session.getAttribute("search") != null) { %>
														&board=${board}
														&search=${search}
														&choose=${choose}
									   <% } else if (session.getAttribute("board") == null && session.getAttribute("search") != null) { %>
														&search=${search}
														&choose=${choose}
									   <% } else if (session.getAttribute("board") != null && session.getAttribute("search") == null) { %>
														&board=${board}
									   <% }%>">
				<button type="button" class="btn btn-outline-dark">&lt;</button></a>&nbsp;&nbsp;
			</c:otherwise>
			</c:choose> 

			<!-- 개별 페이지 -->
			<c:forEach var="fEach" begin="${page.startPage}" end="${page.endPage}" step="1">
			<c:choose>
			<c:when test="${page.curPage == fEach}">
				<button type="button" class="btn btn-outline-dark">${fEach}</button>&nbsp;&nbsp;
			</c:when>
			
			<c:otherwise>
				<a href="list.do?page=${fEach}<% if(session.getAttribute("board") != null && session.getAttribute("search") != null) { %>
														&board=${board}
														&search=${search}
														&choose=${choose}
										<% } else if (session.getAttribute("board") == null && session.getAttribute("search") != null) { %>
														&search=${search}
														&choose=${choose}
										<% } else if (session.getAttribute("board") != null && session.getAttribute("search") == null) { %>
														&board=${board}
										<% }%>"><button type="button" class="btn btn-outline-dark">${fEach}</button></a>&nbsp;&nbsp;
			</c:otherwise>	
			</c:choose>
			</c:forEach>				
			
			<!-- 다음 -->
			<c:choose>
			<c:when test="${(page.curPage + 1) > page.totalPage}">
				<button type="button" class="btn btn-outline-dark">&gt;</button>&nbsp;&nbsp;
			</c:when>
			<c:otherwise>
				<a href="list.do?page=${page.curPage + 1}<% if(session.getAttribute("board") != null && session.getAttribute("search") != null) { %>
														&board=${board}
														&search=${search}
														&choose=${choose}
										<% } else if (session.getAttribute("board") == null && session.getAttribute("search") != null) { %>
														&search=${search}
														&choose=${choose}
										<% } else if (session.getAttribute("board") != null && session.getAttribute("search") == null) { %>
														&board=${board}
										<% }%>">
				<button type="button" class="btn btn-outline-dark">&gt;</button></a>&nbsp;&nbsp;
			</c:otherwise>
			</c:choose>
			<!-- 끝 -->
			<c:choose>
			<c:when test="${page.curPage == page.totalPage}">
				<button type="button" class="btn btn-outline-dark">&gt;&gt;</button>&nbsp;&nbsp;
			</c:when>
			<c:otherwise>
				<a href="list.do?page=${page.totalPage}<% if(session.getAttribute("board") != null && session.getAttribute("search") != null) { %>
														&board=${board}
														&search=${search}
														&choose=${choose}
										<% } else if (session.getAttribute("board") == null && session.getAttribute("search") != null) { %>
														&search=${search}
														&choose=${choose}
										<% } else if (session.getAttribute("board") != null && session.getAttribute("search") == null) { %>
														&board=${board}
										<% }%>">
				<button type="button" class="btn btn-outline-dark">&gt;&gt;</button></a>&nbsp;&nbsp;
			</c:otherwise>
			</c:choose>  
			</td>		
		</tr>
	</ul>
	<br/>
	<ul class="nav justify-content-center">
	<form class="form-inline">
	  	<select name="choose" class="custom-select my-1 mr-sm-2">
   			<option selected>선택</option>
    		<option value="bId">번호</option>
    		<option value="bName">이름</option>
    		<option value="bTitle">제목</option>
    	</select>
  		<div class="form-row">
    		<div class="col">
      			<input type="text" name="search" class="form-control" placeholder="search...">
      			<button>검색</button>
      			
    		</div>
    	</div>
    </form>
	</ul>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>