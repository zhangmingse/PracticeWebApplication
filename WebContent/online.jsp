<%@page import="test.OnlineListener"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib uri="http://localhost/mylib" prefix="mytag"%>
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
if(online!=null){
	for(String sessionid : online.keySet()){
		%>
		<tr>
		<td><%=sessionid %></td>
		<td><%=online.get(sessionid) %></td>
		</tr>
		<%
	}
}
%>
</table>
<br/>
<mytag:query user="root" url="jdbc:mysql://localhost:3306/testdatabase1" pass="root" driver="com.mysql.jdbc.Driver" sql="select * from online_info"/>

</body>
</html>