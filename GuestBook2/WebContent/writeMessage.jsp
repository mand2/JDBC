<%@page import="guestbook.service.WriteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");	
%>    

<!-- scope page default. 갔다가 올거니까 -->
<jsp:useBean id="message" class="guestbook.model.Message"/>    
<jsp:setProperty property="*" name="message"/>
<%
	WriteMessageService service = WriteMessageService.getInstance();
	int cnt = service.write(message);
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
	<%= cnt>0 ? "방명록에 메세지를 남겼습니다.":"메세지 등록이 되지 않았습니다." %>
	</h1>
	
	<a href="list.jsp">목록보기</a>
	
</body>
</html>