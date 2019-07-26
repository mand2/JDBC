<%@page import="member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 chk</title>
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
	<h1>회원정보입력 확인^*^</h1>
	<hr>
	
<!-- 	<form action="memberRegEnd.jsp" method="post"> -->
	
	<c:if test="${result>0}">
	
	    <form>
			<span class="inputBox">	I D </span>${member.id} <br>
			<span class="inputBox">	P W </span>${member.pw} <br>
			<span class="inputBox">NAME</span>${member.name} <br>
			<span class="inputBox">PHOTO</span>${member.photo}  <br>
			<span class="inputBox">가입시각</span>${member.regDate} <br>
		</form>
	
		<h1>가입을 축하드립니다.</h1>
	    	<p><a href = "../index.jsp">홈으로</a></p>
			<a href = "loginForm">로그인</a>
	</c:if>
	
	<c:if test="${!(result>0)}">
		<script>
			alert('회원가입이 정상적으로 완료되지 않았습니다.');
		</script>
        <p><a href = "../index.jsp">홈으로</a></p>
	</c:if>

	</div>
<!-- contents 끝-->

<!-- footer 시작 -->
<%@ include file="../frame/footer.jsp" %>
<!-- footer 끝-->

</body>

</html>