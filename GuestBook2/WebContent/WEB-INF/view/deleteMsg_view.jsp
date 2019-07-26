<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteMsg_view</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style></style>
<link href="default_css.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div>
		<c:if test="${chk}">
			${result} 개의 행이 삭제되었습니다.
		</c:if>
		<c:if test="${!chk}">
			${msg}
		</c:if>
	</div>	
	
	
	<h1>
		<a href="<c:url value="/guestList"/>">
			list로 돌아가기
		</a>
	</h1>
</body>
</html>