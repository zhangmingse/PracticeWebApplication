<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br/>
<% out.println(new java.util.Date());%>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select user from user;");

%>
<table border = 1>
<%
while(rs.next()){
	%>
	<tr>
	<td><%=rs.getString(1) %></td>
	</tr>
	<%
}
conn.close();
%>
</table>

</body>
</html>