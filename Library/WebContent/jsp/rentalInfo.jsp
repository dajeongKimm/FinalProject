<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>'${rental.book_title}' 의 정보</title>
<%@ include file = "/jdbc/bootstrapConfig.jsp" %>
</head>
<body>

<h3>'${rental.member_id}' 님의 대여정보</h3>

<table class="table table-hover">
	<tr>
		<th>RENTAL_ID</th>
		<td>${rental.rental_id}</td>
	</tr>
	<tr>
		<th>MEMBER_ID</th>
		<td>${rental.member_id}</td>
	</tr>
	<tr>
		<th>MEMBER_NAME</th>
		<td>${rental.member_name}</td>
	</tr>
	<tr>
		<th>BOOK_TITLE</th>
			<td>${rental.book_title}</td>
	</tr>
	<tr>
		<th>REGIST_DATE</th>
		<td>${rental.rental_registdate}</td>
	</tr>
	<tr>
		<th>RETURN_DATE</th>
		<td>${rental.rental_returndate}</td>
	</tr>
	<tr>
		<th colspan = "2">
			<form action = "${pageContext.request.contextPath}/return" method = "post">
					<input type="submit" value = "RETURN">
			</form>
		</th>
	</tr>
</table>

</body>
</html>