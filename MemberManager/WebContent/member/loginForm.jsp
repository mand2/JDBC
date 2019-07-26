<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>

<%
	CookieBox cBox = new CookieBox(request);
	boolean idChk = cBox.exists("saveID");
	
	String id = "";
	String inputID = cBox.getValue("saveID");
	if (idChk && inputID.equals(cBox.getValue("ID"))){
		id = inputID;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login::YONNY's JOURNEY</title>
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
		<h1>log-in</h1>
		<hr>
	<form action="login" method="post">
		<!-- jsp로 사용할 거라 name값으로 연결. -->
		<span class="inputBox">	I D </span><input type="text" name = "id" value="<%= id %>"  placeholder="id를 입력해주세요" required> <br>
		<span class="inputBox">	P W </span><input type="password" name = "pw"  placeholder="pw를 입력해주세요" required> <br>
			
			<!-- 로그인한 후 혹은 로그인 전 어느때든 상관없음. -->
			아이디 저장 <input type="checkbox" name="saveID" checked ><br>
			<input type = "submit" value="로그인">
		</form>
	
	</div>
<!-- contents 끝-->

<!-- footer 시작 -->
<%@ include file="../frame/footer.jsp" %>
<!-- footer 끝-->

</body>

</html>