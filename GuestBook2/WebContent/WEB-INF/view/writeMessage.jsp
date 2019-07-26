<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeMessage</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style></style>
</head>
<body>

	<h1>${resultCnt}</h1>
	<h1>
		<c:if test="${result == 1}">
			정상적으로 입력됨!
		</c:if>	
		
		<c:if test="${!(result == 1) }">
			입력실패
		</c:if>
	</h1>
	<a href="<c:url value="/guestList" />">list</a>
                                                                                                                                                 

</body>
</html>