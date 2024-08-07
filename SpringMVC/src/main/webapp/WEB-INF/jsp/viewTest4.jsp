<%@page import="com.mycom.myapp.dto.CarDto"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<% int seq = Integer.parseInt( (String) request.getAttribute("seq"));
CarDto carDto = (CarDto) request.getAttribute("carDto"); %>

<body>
	<h1>viewTest4.jsp</h1>
	<hr>
	<p>seq : <%= seq %></p>
	<hr>
	<p>name : <%= carDto.getName() %></p>
	<p>price : <%= carDto.getPrice() %></p>
	<p>brand : <%= carDto.getBrand() %></p>

</body>
</html>