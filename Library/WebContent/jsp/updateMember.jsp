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

div{
	float:left;
	width :400px;
	height:500px;
	border: 1px solid lightgray;
	margin:30px;
	text-align: center;
}
</style>
</head>
<body>

<%@ include file = "/jdbc/headerConfig.jsp" %>

<div>
<h4>회원정보 수정</h4>
<form action="${pageContext.request.contextPath}/updateMember" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<th> 이미지 </th>	
			<td>
				<img src="${pageContext.request.contextPath}${loginMember.member_photo}" width="120" height="150">
			</td>		
		</tr>
		<tr>
			<th></th>
			<td>
				<input type = "file" name="file">
			</td>
		</tr>
		<tr>
			<th> 아이디 </th>
			<td><input type = "text" name = "member_id"  value = "${loginMember.member_id}" readonly = "readonly"></td>
		</tr>
		<tr>
			<th> 패스워드 </th>
			<td><input type = "password" name = "member_password" ></td>
		</tr>
		<tr>
			<th> 이름 </th>
			<td>
				<input type = "text" name = "member_name"  value = "${loginMember.member_name}">
			</td>
		</tr>
		<tr>
			<th> 나이 </th>
			<td><input type = "text" name = "member_age"  value = "${loginMember.member_age}"></td>
		</tr>
		<tr>
			<th> 연락처 </th>
			<td><input type = "tel" name = "member_tel"  value = "${loginMember.member_tel}"></td>
		</tr>
		<tr>
			<th> 주소 </th>
			<td><input type = "text" name = "member_address"  value = "${loginMember.member_address}"></td>
		</tr>
		<tr>
			<th> 이메일 </th>
			<td><input type = "email" name = "member_email"  value = "${loginMember.member_email}"></td>
		</tr>
		<tr>
			<th> 성별 </th>
			<td>
				<input type = "radio" name = "member_gender" value = "M" checked = "checked">남
				<input type = "radio" name = "member_gender" value = "W">여
			</td>
		</tr>
		<tr>
			<td colspan = "2"> <input type = "submit" value = "회원정보 수정"> </td>
	</table>
</form>
</div>

<%@ include file = "/jdbc/footerConfig.jsp" %>

</body>
</html>