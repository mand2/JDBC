<%@page import="member.model.LoginInfo"%>
<%@page import="member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
%>

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

<%
	if(loginInfo != null){
%>
	<div id="contents">
	<h3>회원 정보 페이지입니다.^*^</h3>
	<hr>
	
	<%-- <%= loginInfo %> --%>
	<form>
		<table>
			<tr>
				<td>i d(이메일)</td>
				<td> <%= loginInfo.getId() %></td>
			</tr>
			<tr>
				<td>p w(비밀번호)</td>
				<td><input type="text" name="pw" value="정보수정에서만 확인가능"></td>
			</tr>
			<tr>
				<td>이 름</td>
				<td><%= loginInfo.getName() %></td>
			</tr>
			<tr>
				<td>사 진</td>
				<td><%= loginInfo.getPhoto() %></td>
			</tr>
			<tr>
				<td>가입일</td>
				<td><%= loginInfo.getRegDate() %></td>
			</tr>
		</table>
	</form>
	<hr>

	<h3> APPLICATION에서 가져온 값</h3>
	${sessionScope.loginInfo}<br>
		<%= loginInfo.toString() %>

	<img src="../images/<%= loginInfo.getPhoto() %>" width="50px"><br><br>
	<img src="../images/${loginInfo.photo}" width="50px">
	<h4>이름 : <%= loginInfo.getName() %> / ${sessionScope.loginInfo.name} </h4>
 	<h4>아이디 : <%= loginInfo.getId() %> / ${sessionScope.loginInfo.id} </h4>
	</div>
<!-- contents 끝-->

<!-- footer 시작 -->
<%@ include file="../frame/footer.jsp" %>
<!-- footer 끝-->
	
<%} else {%>
	<script>
	alert ("로그인이 필요한 페이지 입니다.\n로그인 해 주세요");
	location.href= "login.jsp";
	</script>
	<% } %>

</body>

</html>