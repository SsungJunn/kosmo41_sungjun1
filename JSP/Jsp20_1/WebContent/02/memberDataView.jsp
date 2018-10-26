<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charesultSetet=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%!
    	Connection con;
    	Statement stmt;
    	ResultSet resultSet;
    	
    	String driver = "oracle.jdbc.driver.OracleDriver";
    	String url = "jdbc:oracle:thin:@localhost:1521:xe";
    	String uid = "scott";
    	String upw = "tiger";
    	String query = "select * from member";
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charesultSetet=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, upw);
			stmt = con.createStatement();
			resultSet = stmt.executeQuery("select * from member");
			
			while(resultSet.next()) {
				String id = resultSet.getString("id");
				String pw = resultSet.getString("pw");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				String gender = resultSet.getString("gender");
					
				out.println("아이디 : " + id +
							", 비밀번호 : " + pw +
							", 이름 : " + name + 
							", 연락처 : " + phone + 
							", 성별 : " + gender + "<br>" );
				}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (Exception e) {}
		}
	%>
</body>
</html>