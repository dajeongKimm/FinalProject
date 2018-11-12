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
		<th>RESERVATION_ID</th>
		<th>BOOK_TITLE</th>
		<th>RESERVATION_REGISTDATE</th>
	</tr>
	<c:forEach var="reservation" items="${reservation}">
		<tr>
			<td>${reservation.reservation_id}</td>
			<td>${reservation.book_title }</td>
			<td>${reservation.reservation_registdate}</td>
			
		</tr>
	</c:forEach>

</table>

</body>
</html>