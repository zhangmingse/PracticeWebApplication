<%@page import="test.OnlineListener"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户在线信息</title>
</head>
<body>
<table border="1" width="500">
<%
Map<String,String> online = (Map<String,String>)application.getAttribute(OnlineListener.ONLINE_STR);
for(String sessionid : online.keySet()){
	%>
	<tr>
	<td><%=sessionid %></td>
	<td><%=online.get(sessionid) %></td>
	<td><%=session.getAttribute("name") %></td>
	</tr>
	<%
}
%>
</table>
</body>
</html>