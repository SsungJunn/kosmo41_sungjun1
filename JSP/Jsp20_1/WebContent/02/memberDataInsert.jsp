<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    	Connection con;
    	PreparedStatement pstmt;
    	ResultSet resultSet;
    	
    	String driver = "oracle.jdbc.driver.OracleDriver";
    	String url = "jdbc:oracle:thin:@localhost:1521:xe";
    	String uid = "scott";
    	String upw = "tiger";
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, upw);
			int n;
			String query = "insert into member values (?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, "abc");
			pstmt.setString(2, "123");
			pstmt.setString(3, "홍길동");
			pstmt.setString(4, "010-1234-5678");
			pstmt.setString(5, "man");
			n = pstmt.executeUpdate();
			
			pstmt.setString(1, "def");
			pstmt.setString(2, "456");
			pstmt.setString(3, "전우치");
			pstmt.setString(4, "010-1111-1111");
			pstmt.setString(5, "man");
			n = pstmt.executeUpdate();
			
			pstmt.setString(1, "ghi");
			pstmt.setString(2, "789");
			pstmt.setString(3, "손오공");
			pstmt.setString(4, "010-2222-2222");
			pstmt.setString(5, "man");
			n = pstmt.executeUpdate();
			
			if(n == 1) {
				out.println("insert success");
			}
		} catch(Exception e) {
			//System.out.println(e.getMessage());
			//ORA=00001: unique constraint (SCOTT.SYS_C007030) violated
			if(e.getMessage().contains("ORA-00001")) {
				out.println("중복되는 회원아이디 데이터가 있습니다.");
			}
		} finally {
			try{
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {}
		}
	%>
	
	<br />
	<a href="memberDataView.jsp">회원정보 보기</a>
</body>
</html>