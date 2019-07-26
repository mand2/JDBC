<%@page import="member.model.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- <%
	LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
%> --%>

<!-- EL로 쓴다면 session.getAttribute를
${loginInfo}
 -->
<%request.setCharacterEncoding("utf-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<link href="/mm/css/default.css" rel="stylesheet" type="text/css">

<style>
	
</style>
</head>

<body>

<%-- <% 
	/* String userID = request.getParameter("id");
	String userPW = request.getParameter("pw"); */
	
	/* 
	if(userID != null && userPW != null 
		&& userID.equals("admin") && userPW.equals("admin")) {
		
		response.sendRedirect(request.getContextPath());  //request.getContextPath() == '/mm'
	} */
	
	MemberInfo userInfo = (MemberInfo)session.getAttribute("login");
		
%> --%>

<!-- header 시작 -->
<%@ include file="../frame/header.jsp" %>
<!-- header 끝-->
	
<!-- nav 시작 -->
<%@ include file="../frame/nav.jsp" %>
<!-- nav 끝-->

<!-- contents 시작 -->
	<div id="contents" class = "main">
		<h1>회원 정보</h1>
		<hr>

	<!-- APPLICATION에서 가져온 값 -->
	
	<%-- ${sessionScope.loginInfo}<br>
	<hr> --%>
		<form>
			<c:if test="${sessionID ne null}">
				<%-- <img src="../images/${loginInfo.photo}" width="70px" > <br> --%>
				<span class="inputBox">	I D </span> ${loginInfo.id}<br>
				<span class="inputBox">	P W </span>${loginInfo.pw}<br>
				<span class="inputBox">NAME</span> ${loginInfo.name}<br>
				<span class="inputBox">PHOTO</span>${loginInfo.photo}<br>
				<span class="inputBox">regDate</span><fmt:formatDate value="${loginInfo.regDate}" pattern ="yyyy.MM.dd H:mm a" /><br>
			</c:if>
		</form>
		
	</div>
<!-- contents 끝-->

<!-- footer 시작 -->
<%@ include file="../frame/footer.jsp" %>
<!-- footer 끝-->
	<c:if test="${sessionID eq null }">
		<script>
		alert ("로그인이 필요한 페이지 입니다.\n로그인 해 주세요");
		location.href= "loginForm";
	</script>
	</c:if>
</body>

</html>