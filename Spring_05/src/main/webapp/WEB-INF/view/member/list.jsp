<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member 테이블 리스트</title>
</head>
<body>


<table border="1">
	<caption>Member 테이블 리스트</caption>
	<tr>
		<th>ID</th>
		<th>PW</th>
		<th>NAME</th>
	</tr>
	
	<c:forEach var="member" items="${list}">
		<tr>
			<td>${member.id }</td>
			<td>${member.pw }</td>
			<td>${member.name }</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>