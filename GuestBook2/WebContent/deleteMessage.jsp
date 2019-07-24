<%@page import="guestbook.service.InvalidMessagePasswordException"%>
<%@page import="guestbook.service.MessageNotFoundException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="guestbook.service.DeleteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	request.setCharacterEncoding("utf-8");	
%> 

<%
	int messageID = Integer.parseInt(request.getParameter("messageID"));
	String password = request.getParameter("password"); 
	
	
	/*변수설명
	@cnt: 서비스 몇개 완료되었는지 확인.
	@chk: 서비스 제대로 완료되었는지 확인
	@msg: 예외발생시 문구 처리.
	*/
	int cnt = 0;
	boolean chk = false;
	String msg ="";
	
	//서비스객체생성
	DeleteMessageService service = DeleteMessageService.getInstance();
	
	
	try{
		cnt = service.deleteMessage(messageID, password);
		chk = true;
		
	} catch(SQLException e) {
		msg = e.getMessage();
		
	} catch(MessageNotFoundException e) {
		msg = e.getMessage();
		
	} catch(InvalidMessagePasswordException e){
		msg = e.getMessage();
		
	}
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style></style>
</head>
<body>
	<h1>
		<%
			if(chk){
		%>
		
		<%= cnt %> 개의 행이 삭제되었습니다.
		<%
			} else {
		%>	
			<%=msg %>
		<%
			}
		%>
		
	</h1>
	
	<a href="list.jsp">리스트</a>
</body>
</html>