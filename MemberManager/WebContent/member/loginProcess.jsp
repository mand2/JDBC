<%@page import="util.CookieBox"%>
<%@page import="member.model.MemberVO"%>
<%@page import="member.model.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	request.setCharacterEncoding("utf-8");
%>    
<%-- 
<%
    	String userID = request.getParameter("id");
    	String userPW = request.getParameter("pw");
    	String saveID = request.getParameter("saveID");
    	
    	//1.사용자가 입력한 id로 회원정보 검색
    	//2.존재? 해당객체 받는다 - 그객체의 pw와 사용자가 입력한 pw비교, 
    	/* pw == userinputPW ? 로그인처리-세션영역에 회원정보저장 : 오류메세지전달-로그인p로 이동*/
    	//	 	(존재X): false처리== 오류메세지전달-로그인p로 이동
    	//
    	
    	boolean loginCheck = false;
    	
    	/* if(userID != null && userPW != null 
    		&& userID.equals("admin") && userPW.equals("admin")) {
    		
    		response.sendRedirect(request.getContextPath());  //request.getContextPath() == '/mm'
    	}
    	
    	
    	if(userID != null && userPW != null && userID.equals(userPW)) {
    		MemberInfo m = new MemberInfo(userID);
    		session.setAttribute("login", m);	
    		loginCheck = true;
    	}  */
    	
    	
    	
    	MemberVO member = (MemberVO)application.getAttribute(userID);
    	if(member != null && member.getPw().equals(userPW)){
    		//회원정보 존재시: 세션영역에 회원정보저장
    		session.setAttribute("loginInfo", member.toLoginInfo());

    		/* ---- COOKIE ---- */
    		response.addCookie(CookieBox.createCookie("ID", userID, -1));
    		/* 48시간동안 유지됨. 60*60*24*2*/
    		if(saveID != null){
    		response.addCookie(CookieBox.createCookie("saveID", userID, 60*60*24*2));
    		}
    		
    		//로그인처리후 메인페이지로 이동
    		response.sendRedirect(request.getContextPath());
    		loginCheck = true;
    	}else {
    		//id검색결과 null or 같지않은경우
    %>
		<script>
			alert("ID 혹은 비밀번호가 틀림\n다시 로그인 해 주세요.");
			history.go(-1);
		</script>
	<% 
		} 
	%> --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인::YONNY's JOURNEY</title>
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
	<div id="contents">
		<h1>로그인체크</h1>
		<hr>
		
		<c:if test="${loginChk}">
			${sessionScope.sessionID}
		
		</c:if>
		
		
		<c:if test="${!loginChk}">
			${msg}
		</c:if>
	
	
	
	</div>
<!-- contents 끝-->

<!-- footer 시작 -->
<%@ include file="../frame/footer.jsp" %>
<!-- footer 끝-->

</body>

</html>