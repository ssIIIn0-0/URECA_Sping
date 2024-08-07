<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jsp를 servlet으로 변환하기 전에 sessionInclude.jsp의 내용이 
	sessionTest1.jsp의 일부가 된 후 servlet으로 변환된다. -->
	<%@ include file="sessionInclude.jsp" %>
	<h1>sessionTest1.jsp</h1>
</body>
</html>