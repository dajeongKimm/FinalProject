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
<script  type = "text/javascript">
	function openWindow(url){
		window.open(url,"Department ID 정보",  "width=500, height=300");
	}
</script>
<h4>현재 대여중인 목록</h4>
<table class="table table-hover" >
	<tr>
		<th>RENTAL_ID</th>
		<th>MEMBER_ID</th>
		<th>MEMBER_NAME</th>
		<th>BOOK_TITLE</th>
		<th>REGIST_DATE</th>
		<th>RETURN_DATE</th>
		<th>RETURN</th>
	</tr>

	<c:forEach var = "rental" items="${rental}">
		<tr>
			<td>${rental.rental_id}</td>
			<td>${rental.member_id}</td>
			<td>${rental.member_name}</td>
			<td>${rental.book_title}</td>
			<td>${rental.rental_registdate}</td>
			<td>${rental.rental_returndate}</td>
			<td >
				<a href = "#" onclick="javascript:openWindow('${pageContext.request.contextPath}/rentalInfo?rental_id=${rental.rental_id}' )">반납하기</a>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>