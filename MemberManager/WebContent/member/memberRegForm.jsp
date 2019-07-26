<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member REG FORM</title>
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
	<h1>REGISTER for OUR MEMBER</h1>
	<hr>
	
	<form action="memReg" method="post">
		<span class="inputBox">	I D </span><input type="text" name = "id" placeholder="id를 입력해주세요" required> <br>
		<span class="inputBox">	P W </span><input type="password" name = "pw"  placeholder="pw를 입력해주세요" required> <br>
		<span class="inputBox">NAME</span><input type="text" name = "name"  placeholder="이름을 입력해주세요" required> <br>
		<span class="inputBox">PHOTO</span><input type="file" name = "photo"> <br>
		<input type = "submit" value="회원가입">	
	</form>
</div>
<!-- contents 끝-->

<!-- footer 시작 -->
<%@ include file="../frame/footer.jsp" %>
<!-- footer 끝-->

</body>

</html>