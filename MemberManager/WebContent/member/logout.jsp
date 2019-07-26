<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
<% 
//	현재 session 객체 소멸시키기.	
	request.getSession(false).invalidate();

	response.sendRedirect(request.getContextPath());
	
	/* 쿠키 삭제 */
	response.addCookie(CookieBox.createCookie("ID", "", 0));
	
%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGOUT</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<link href="/mm/css/default.css" rel="stylesheet" type="text/css">
<style>
</style>
</head>

<body>

<!-- header 시작 -->
<%@ include file="../frame/header.jsp" %>
<!-- header 끝-->
	
<!-- nav 시작 -->
<%@ include file="../frame/nav.jsp" %>
<!-- nav 끝-->

<!-- contents 시작 -->
	<div id="contents" class = "main">
		<h1>로그아웃완료</h1>
		<hr>
		<div>
			<a href = "<c:url value="/"/>"> 홈으로 </a>
		</div>		
	</div>
<!-- contents 끝-->

<!-- footer 시작 -->
<%@ include file="../frame/footer.jsp" %>
<!-- footer 끝-->
</body>

</html>