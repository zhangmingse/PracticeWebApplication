<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" session="false"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<ul>
<c:forEach items="${books}" var="book" >
<li>${book}</li>
</c:forEach>
</ul>