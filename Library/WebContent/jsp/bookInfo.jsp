<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>'${book.book_title}' 의 정보</title>
<%@ include file = "/jdbc/bootstrapConfig.jsp" %>
</head>
<body>

<h3>'${book.book_title}' 의 정보</h3>

<table class="table table-hover">
	<tr>
		<th>BOOK_ID</th>
		<td>${book.book_id}</td>
	</tr>
	<tr>
		<th>BOOK_TITLE</th>
		<td>${book.book_title}</td>
	</tr>
	<tr>
		<th>BOOK_AUTHOR</th>
		<td>${book.book_author}</td>
	</tr>
	<tr>
		<th>BOOK_PUBLISHER</th>
		<td>${book.book_publisher}</td>
	</tr>
	<tr>
		<th>BOOK_PRICE</th>
		<td>${book.book_price}</td>
	</tr>
	<tr>
		<th>BOOK_IMAGE</th>
		<td>
			<img src="${pageContext.request.contextPath}${book.book_image}" width="90" height="120">
		</td>
	</tr>
	<tr>
		<th>
			<form action = "${pageContext.request.contextPath}/rental" method = "post">
				<c:if test="${empty selectedRental && (empty selectedReservation || selectedReservation.member_id eq loginMember.member_id)}" var = "result">
					<input type="submit" value = "RENTAL">
				</c:if>
				<c:if test = "${not result}">
					<input type="submit" value = "대여중" disabled="disabled">
				</c:if>
			</form>
		</th>
		<th>
			<form action = "${pageContext.request.contextPath}/reservation" method = "post">
				<c:if test = "${(not empty  selectedRental && empty selectedReservation)
								|| (empty selectedRental && not empty selectedReservation && empty 	selectedReservation) }" var = "result">
					<input type = "submit" value = "RESERVATION">
				</c:if>
				<c:if test = "${not result}">
					<input type="submit" value = "예약불가" disabled="disabled">
				</c:if>
			</form>
		</th>
	</tr>
	
	<c:if test = "${loginMember.member_type eq '1'}" var = "result">
		<tr>
			<td colspan = "2">
			<form action = "${pageContext.request.contextPath}/deleteBook" method = "post">
				<c:if test = "${empty selectedRental }" var = "result2">
					<center><input type = "submit" value = "Delete"></center>
				</c:if>
				<c:if test = "${not result2}">
					<center><input type = "submit" value = "대여중-삭제불가" disabled="disabled"></center>
				</c:if>
				</form>
			</td>
		</tr>
	</c:if>
</table>

</body>
</html>