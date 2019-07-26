<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드::폼</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style></style>
</head>
<body>

	<h1>과제제출</h1>
	<hr>
	<form method="post" action="fileUpload.jsp" enctype="multipart/form-data">
		이름: <input id="uName" name="uName" type="text"><br>
		학번: <input id="sNumber" name="sNumber" type="text"><br>
		과제: <input id="report" name="report" type="file"><br>
		<input type="submit" value="업로드">
	</form>
</body>
</html>