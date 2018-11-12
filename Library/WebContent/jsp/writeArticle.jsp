<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<%@ include file = "/jdbc/bootstrapConfig.jsp" %>
<style>
nav{
	margin: 10px;
}

nav ul{
	list-style: none;
	text-align: center;
	border-top: 1px solid orange;
	border-bottom: 1px solid orange;
	padding: 10px 0;
}

nav ul li{
	display: inline;
	text-transform: uppercase;
	padding:0 10px;
	letter-spacing: 10px;
}

nav ul li a{
	text-decoration:none;
	color: black;
}

nav ul li a:hover{
	text-decoration: underline;
}
footer{
	clear : both;
	width:100%
}

div{
	float:left;
	width :900px;
	height:700px;
	border: 1px solid lightgray;
	margin:30px;
	text-align: center;
}
</style>
</head>
<body>

<%@ include file = "/jdbc/headerConfig.jsp" %>

<div>
<form action="${pageContext.request.contextPath}/writeArticle" method="post" >
	<table class="table table-striped">
	<caption><h4>게시글 작성</h4></caption>
		<tr>
			<th>NAME</th>
			<td> <input type="text" name = "member_name" value="${loginMember.member_name}" disabled="disabled" size = "90"></td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td> <input type = "text" name="title" size = "90"></td>
		</tr>
		<tr>
			<th>CONTENTS</th>
			<td><textarea name = "contents" rows ="20" cols="100"></textarea></td>
		</tr>
		<tr>
			<td></td>
			<td><input type = "submit" value = "WRITE"></td>
		</tr>
	</table>
</form>
</div>
<%@ include file = "/jdbc/footerConfig.jsp" %>
</body>
</html>