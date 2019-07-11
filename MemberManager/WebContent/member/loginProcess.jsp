<%@page import="util.CookieBox"%>
<%@page import="member.MemberVO"%>
<%@page import="member.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>    

<jsp:useBean id="vo" class="member.MemberVO" scope="session"/>
<jsp:setProperty property="*" name="vo"/>
<jsp:useBean id="dao" class="member.MemberDAO" scope="session"/>

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
	%>
	
	
<!-- 확인용으로 그냥 둠. -->

<%-- 
<jsp:useBean id="loginInfo" class="usebean.MemberInfo" scope="session"/>
<jsp:setProperty property="id" value="<%=userID %>" name="loginInfo"/>
<jsp:setProperty property="pw" value="<%=userPW %>" name="loginInfo"/> --%>
</body>

</html>