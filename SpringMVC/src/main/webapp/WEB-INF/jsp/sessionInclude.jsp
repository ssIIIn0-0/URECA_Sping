<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String username = (String) session.getAttribute("username");
%>
<%
if (username == null) {
%>
<div>로그인 하지 않았습니다.</div>
<%
} else {
%>
<div>
	로그인 상태입니다.(
	<%=username%>)
</div>
<%
}
%>