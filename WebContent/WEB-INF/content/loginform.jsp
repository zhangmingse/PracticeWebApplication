<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="loginPage"/></title>
<script>
function firstActionsubmit(){
	var targetForm = document.forms[0];
	targetForm.action = "/PracticeWebApplication/firstAction.action"
}

function secondActionsubmit(){
	var targetForm = document.forms[0];
	targetForm.action = "/PracticeWebApplication/secondAction.action"
}
</script>
</head>
<body>
<s:form action="/PracticeWebApplication/loginAction">
	<s:textfield name="username" key="user"/>
	<s:textfield name="password" key="pass"/>
	<s:submit key="loginAction"/>
	<s:submit key="firstAction" onclick="firstActionsubmit()"/>
	<s:submit key="secondAction" onclick="secondActionsubmit()"/>
</s:form>
</body>
</html>