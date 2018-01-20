<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<br/>
<% out.println(new java.util.Date());%>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase1","root","root");
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select testid,testtitle,testcontent,testauthor from testtable1;");

%>
<table border = 1>
	<tr>
	<td>title id</td>
	<td>title </td>
	<td>title content </td>
	<td>author </td>
	</tr>
<%
while(rs.next()){
	%>
	<tr>
	<td><%=rs.getString(1) %></td>
	<td><%=rs.getString(2) %></td>
	<td><%=rs.getString(3) %></td>
	<td><%=rs.getString(4) %></td>
	</tr>
	<%
}
conn.close();
%>
</table>
<img src="testimg.jsp">
</body>
</html>