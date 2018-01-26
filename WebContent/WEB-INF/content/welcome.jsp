<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
welcome
本站访问次数为：${applicationScope.counter}
</br>
${sessionScope.user} ： 您已经登陆</br>
${requestScope.tip}
<br/>
---------
<br/>
username:<s:property value="username"/>
<br/>
<s:text name="target"/>
</body>
</html>