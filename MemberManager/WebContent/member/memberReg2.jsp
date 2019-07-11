<%@page import="member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="vo" class="member.MemberVO" scope="session"/>
<jsp:setProperty property="*" name="vo"/>
<jsp:useBean id="dao" class="member.MemberDAO" scope="session"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<link href="/mm/css/default.css" rel="stylesheet" type="text/css">

<style>
	
</style>
</head>

<body>
<%-- <%
	request.setCharacterEncoding("utf-8");	
	/* String userID = request.getParameter("uId");
	String userPW = request.getParameter("uPw");
	String userName = request.getParameter("uName"); */
%>
 --%>
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
	
	<%
	if(dao.memberInsert(vo) > 0){
		
	%>
    <form >
	
		<span class="inputBox">	I D </span>${vo.id} <br>
		<span class="inputBox">	P W </span>${vo.pw} <br>
		<span class="inputBox">NAME</span>${vo.name} <br>
		<span class="inputBox">PHOTO</span>${vo.photo}  <br>
		<span class="inputBox">가입시각</span>${vo.regDate} <br>
	</form>
	
	<h1>가입을 축하드립니다.</h1>
    	<p><a href = "../index.jsp">홈으로</a></p>
		<a href = "login.jsp">로그인</a>
    
    <%
	}else{
		out.print("<script>");
        out.print("alert('회원가입이 정상적으로 완료되지 않았습니다.');");  
        out.print("location.href='../index.jsp';");        
        out.print("</script>");
	%>
        
        <p><a href = "../index.jsp">홈으로</a></p>
      
    <% } %>
	

	<%-- ${member} <br>
	id | ${member.id} <br>
	pw | ${member.pw} <br>
	name | ${member.name} <br>
	photo | ${member.photo} <br>
	가입시각 | ${member.regDate} <br> --%>
	</div>
<!-- contents 끝-->

<!-- footer 시작 -->
<%@ include file="../frame/footer.jsp" %>
<!-- footer 끝-->

</body>

</html>