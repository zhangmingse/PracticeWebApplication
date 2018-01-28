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

<br/>
<s:set var="age" value="65"/>
<s:if test="#age > 60"><s:text name="old"/></s:if>
<s:elseif test="#age>35"><s:text name="middle"/></s:elseif>
<s:elseif test="#age>18"><s:text name="yound"/></s:elseif>
<s:else><s:text name="tenneger"/></s:else>
<table border="1" width="200">
<s:iterator status="st" value="{'疯狂java讲义','轻量级javaee企业应用实战','疯狂IOS讲义'}" var="name">
<tr>
<td><s:property value="#st.count"/></td>
<td><s:property value="name"/></td>
</tr>
</s:iterator>
</table>

<br/>

<table border="1" width="350">
<tr>
<th>书名</th>
<th>作者</th>
</tr>
<s:iterator status="st" value="#{'疯狂java讲义':'李刚','轻量级javaee企业应用实战':'李刚','疯狂IOS讲义':'ligang'}" >
<tr
<s:if test = "#st.odd">
style="background-color:#bbbbbb"
</s:if>>
<td><s:property value="key"/></td>
<td><s:property value="value"/></td>
</tr>
</s:iterator>
</table>
<br/>
<s:bean name="bean.Person" var="p">
<s:param name="name" value="'yeeku'"></s:param>
<s:param name="age" value="29"></s:param>
</s:bean>
<s:property value="#p.name"/><br/>
<s:property value="#p.age"/><br/>
<br/>
<s:debug/>
</body>
</html>