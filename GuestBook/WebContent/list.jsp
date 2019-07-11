<%@page import="guestbook.model.Message"%>
<%@page import="guestbook.model.MessageListView"%>
<%@page import="guestbook.service.GetMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	String pageNumberStr = request.getParameter("page");
	
	int pageNumber = 1 ; //default page
	
	if(pageNumberStr != null){ //값이 있다면
		pageNumber = Integer.parseInt(pageNumberStr); //변환.
	}
	
	//핵심처리할 서비스 객체
	GetMessageService service = GetMessageService.getInstance();
	
	//응답 데이터의 결과
	MessageListView viewData = 
		service.getMessageListView(pageNumber);
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록::글쓰기</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
	* {margin, padding : 0}
	div {
		border : 2px solid #333;
		margin : 5px 0px;
		width: 300px;
	}

</style>
</head>
<body>
		<h3>방명록 글쓰기</h3>
		<hr>
		
		<form action="writeMessage.jsp" method="post">
			<table>
				<tr>
					<td>이름</td>
					<td><input type="text" name="guestName"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea rows="3" cols="30" name="message"></textarea>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="글쓰기"></td>
				</tr>
			</table>
		</form>
		
		<hr>
		<!-- board List 보여주기~ MessageListView -->
		
		<%
			if(viewData.isEmpty()){ //게시글없다.
		%> 
			<h4>등록된 메세지가 없습니다.</h4>
		<%
			} else { //게시글있다
				/*-- 게시글 보여주기 -- */
				for( Message message : viewData.getMessageList()) {
				%>
				
					<div>
						메세지번호: <%= message.getId() %><br>
						작성자: <%= message.getGuestName() %><br>
						내용: <%= message.getMessage() %>
					</div>
					
				<%	
					}
			}
		
		
			//페이지 넘버링: [1][2][3] 형식으로 게시판 페이지 보여주기 
			for(int i = 1; i <= viewData.getPageTotalCount();i++){
			%> 
			
			<a href="list.jsp?page=<%= i%>">[<%=i %>]</a>
			<%-- 
			<a href="list.jsp?page = <%= i%>">
				[ <%= i %> ]
			</a> --%>
		<%	
			}
		%>
		
</body>
</html>