<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<%@ include file = "/jdbc/bootstrapConfig.jsp" %>
<style>
table{
	margin:10px;
}
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
	width:100%
}
div{
	float:left;
	width :400px;
	height:200px;
	border: 1px solid lightgray;
	margin:30px;
	text-align: center;
}

footer{
	clear: both;
}
</style>
</head>
<body>

<%@ include file = "/jdbc/headerConfig.jsp" %>

<div>
	 <h4>비밀번호 변경</h4>
	<form action="${pageContext.request.contextPath}/updatePassword" method="post">
	<table>
		<tr>
			<th>아이디 </th>
			<td>
				<input type = "text" name = "member_id" value = "${loginMember.member_id}" readonly = "readonly" > 
			</td>
		</tr>
		<tr>
			<th>패스워드 </th>
			<td>
				 <input type = "password" name = "member_password">
			</td>
		</tr>
		<tr>
			<th> 새로운 패스워드 </th>
			<td>
				<input type = "password" name = "newPassword" placeholder="New Password">
			</td>
		</tr>
		<tr>
			<td colspan = "2"> <input type = "submit" value = "비밀번호 수정"> </td>
	</table>
</form>
	 
</div>

<%@ include file = "/jdbc/footerConfig.jsp" %>

</body>
</html>