<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list_view page</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style></style>
<link href="default_css.css" type="text/css" rel="stylesheet">
</head>
<body>
	<!-- board List 보여주기~ MessageListView -->
	<c:if test="${viewData.messageTotalCount > 0}">
	<div>
		<h4>
		<!-- 그 전에 확인,, -->
			${viewData.messageTotalCount} <br>
			${viewData.curruntPageNumber} <br>
			${viewData.pageTotalCount} <br>
			${viewData.messageCountPerPage} <br>
			${viewData.firstRow} <br>
		
		</h4>
	</div>
	
	<div class="menu">
		<h1><a href="guestWriteForm">방명록 남기기</a></h1>
	</div>
	
			
	<!-- board List 보여주기~ MessageListView -->
		<c:forEach items="${viewData.messageList}" var="message">
			<div>
				메세지번호: ${message.id}<br>
				작성자: ${message.guestName}<br>
				내용: ${message.message}<br>
				<a href="guestDelForm?messageID=${message.id}">삭제하기</a>
			</div>
		</c:forEach>
	
	<!-- page numbering -->
		<c:forEach begin="1" end="${viewData.pageTotalCount}" step="1" var="num">
			<a href="guestList?page=${num}"> [${num}] </a> 
		</c:forEach>
	</c:if>
	
	
</body>
</html>