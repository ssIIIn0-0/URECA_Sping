<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String username = (String) session.getAttribute("username");
// 브라우저가 보낸 sessionid로 session 공간을 찾는다. 공간이 있으면 username
System.out.println(username);
%>
<%
if (username == null) {
%>
<div>로그인하지 않았습니다.</div>
<%
} else {
%>
<div>
	로그인 상태입니다. (
	<%=username%>
	)
</div>
<%
}
%>