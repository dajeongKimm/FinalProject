<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여 리스트</title>
<%@ include file = "/jdbc/bootstrapConfig.jsp" %>
</head>
<body>

<table class="table table-hover">
	<tr>
		<th>RENTAL_ID</th>
		<th>BOOK_TITLE</th>
		<th>RENTAL_REGISTDATE</th>
		<th>RENTAL_RETURNDATE</th>
	</tr>
	<c:forEach var="rental" items="${rental}">
		<tr>
			<td>${rental.rental_id}</td>
			<td>${rental.book_title }</td>
			<td>${rental.rental_registdate}</td>
			<td>${rental.rental_returndate }</td>
			
		</tr>
	</c:forEach>

</table>

</body>
</html>