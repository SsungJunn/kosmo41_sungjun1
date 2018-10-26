<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String	uid = "scott";
	String upw = "tiger";
	String query = "select * from member";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, uid, upw);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
		//	connection = DriverManager.getConnection(url, uid, upw);
		//	String sql = "select * from CHAT";
		//	statement = connection.createStatement();
			//resultSet = statement.executeQuery(sql);
			
			//connection = DriverManager.getConnection(url, uid, upw);
			//String sql2 = "insert into Room values(?, ?, ?, ?)";
			//statement = connection.createStatement();
			//statement.setString(1, name);
			//statement.setString(2, pw);			
			
			//pstmt.clearParameters();
			//sql = "delete from CHAT where player = ?";
			//pstmt = con.prepareStatement(sql);
			//pstmt.setString(1, name);
			//pstmt.executeUpdate();
			
			while(resultSet.next()) {
				String id = resultSet.getString("id");
				String pw = resultSet.getString("pw");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				
				out.println("아이디 : " + id + ", 비밀번호 : " + pw + ", 이름 : " + name + ", 전화번호 : " + phone + "<br />");
			}
		} catch(Exception e) { 
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {	}
		}
	%>
</body>
</html>