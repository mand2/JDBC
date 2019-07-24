<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeForm</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style></style>
</head>
<body>
		<h3>방명록 글쓰기</h3>
		<hr>
		
		<form action="guestWrite" method="post">
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
				<tr colspan="2">
					<td><input type="submit" value="글쓰기"></td>
				</tr>
			</table>
		</form>

</body>
</html>