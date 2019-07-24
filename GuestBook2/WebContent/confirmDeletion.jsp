<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style></style>
</head>
<body>
	<h1>메세지 삭제 비밀번호 확인</h1>
	<form action="deleteMessage.jsp" method="post">
		메세지를 삭제하려면 비밀번호를 입력해주세요. <br>
		<input type="hidden" name="messageID" value="<%= request.getParameter("messageID")%>">
		비밀번호 <input type="password" name="password" required><br>
		<input type="submit" value="메세지 삭제">
		
		
		
		
	</form>
</body>
</html>