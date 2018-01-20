<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
</head>
<body>
<span style="color:red;font-weight:bold">
<%if(request.getAttribute("err")!=null){
	out.println(request.getAttribute("err") + "<br/>");
} %>
</span>
请输入用户名和密码
<form id = "login" method="post" action="login">
用户名:<input type="text" name="username"><br/>
密码:<input type="password" name= "pass"><br/>
<input type= "submit" value="登录"/><br/>
</form>
</body>
</html>