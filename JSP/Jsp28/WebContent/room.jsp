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
	<!-- <div>
	<iframe name="aaa" src="http://localhost:8081/Jsp28/clientwait.jsp" width="350" height="400"></iframe>
	</div> -->
	<!-- <div>
	<iframe name="waitlist" src="http://localhost:8081/Jsp28/waitinglist.jsp" width="350" height="400"></iframe>
	</div> -->
	</div></div>

	<div class="container">
		<div class="row">
    		<div class="col"></div>
  	  		<div class="col-12">
		
			<table class="table table-striped table-hover">
				<thead class="thead-dark">
					<tr>
						<th scope="col">방번호</th>
						<th scope="col">방제목</th>
						<th scope="col">ID</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${roomlist}" var="rdto">
					<tr>
						<th scope="row">${rdto.RNum}</th>
						<td>
							<%-- <%
							if((String)session.getAttribute("RPw") == null) {
							%> --%>
							<a href="client.do?RNum=${rdto.RNum}&RPw=${rdto.RPw}">${rdto.RName}</a>
							<%-- <%} else { %>
							<a href="PwCheck.do">${rdto.RName}</a>
							<%} %>		 --%>
						</td>
						<th scope="row">${rdto.RId}</th>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="button" class="btn btn-outline-dark" value=방만들기 onclick="javascript:window.location='rwrite_view.do'">			
			<input type="button" class="btn btn-outline-dark" value=게시판보기 onclick="javascript:window.location='list.do'">
		
			</div>
			<div class="col"></div>
		</div>
	</div><br />
	 <ul class="nav justify-content-center">
		<tr>
			<td colspan="5">
			<!-- 처음 -->
			<c:choose>
			<c:when test="${(page.rcurPage - 1) <  1}">
				<button type="button" class="btn btn-outline-dark">&lt;&lt;</button>&nbsp;&nbsp;
				
			</c:when>
			<c:otherwise>
				<a href="room.do?page=1">
				<button type="button" class="btn btn-outline-dark">&lt;&lt;</button></a>&nbsp;&nbsp;
			</c:otherwise>
			</c:choose>
			<!-- 이전 -->
			<c:choose>
			<c:when test="${(page.rcurPage - 1) <  1}">
				<button type="button" class="btn btn-outline-dark">&lt;</button>&nbsp;&nbsp;
			</c:when>
			<c:otherwise>
				<a href="room.do?page=${page.rcurPage - 1}">
				<button type="button" class="btn btn-outline-dark">&lt;</button></a>&nbsp;&nbsp;
			</c:otherwise>
			</c:choose> 

			<!-- 개별 페이지 -->
			<c:forEach var="fEach" begin="${page.rstartPage}" end="${page.rendPage}" step="1">
			<c:choose>
			<c:when test="${page.rcurPage == fEach}">
				<button type="button" class="btn btn-outline-dark">${fEach}</button>&nbsp;&nbsp;
			</c:when>
			
			<c:otherwise>
				<a href="room.do?page=${fEach}"><button type="button" class="btn btn-outline-dark">${fEach}</button></a>&nbsp;&nbsp;
			</c:otherwise>	
			</c:choose>
			</c:forEach>				
			
			<!-- 다음 -->
			<c:choose>
			<c:when test="${(page.rcurPage + 1) > page.rtotalPage}">
				<button type="button" class="btn btn-outline-dark">&gt;</button>&nbsp;&nbsp;
			</c:when>
			<c:otherwise>
				<a href="room.do?page=${page.rcurPage + 1}">
				<button type="button" class="btn btn-outline-dark">&gt;</button></a>&nbsp;&nbsp;
			</c:otherwise>
			</c:choose>
			<!-- 끝 -->
			<c:choose>
			<c:when test="${page.rcurPage == page.rtotalPage}">
				<button type="button" class="btn btn-outline-dark">&gt;&gt;</button>&nbsp;&nbsp;
			</c:when>
			<c:otherwise>
				<a href="room.do?page=${page.rtotalPage}">
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
    		<option value="RNum">방번호</option>
    		<option value="RName">방제목</option>
    		<option value="RId">ID</option>
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