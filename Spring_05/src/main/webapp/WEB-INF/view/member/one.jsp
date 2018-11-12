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
	<caption>${one.name}님의 정보</caption>
	<tr>
		<th>ID</th>
		<th>PW</th>
		<th>NAME</th>
	</tr>
	<tr>
		<td>${one.id }</td>
		<td>${one.pw }</td>
		<td>${one.name }</td>
	</tr>
</table>
</body>
</html>