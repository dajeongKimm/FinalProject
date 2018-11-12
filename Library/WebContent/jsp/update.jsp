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


<form action="${pageContext.request.contextPath}/updatePassword">
<div>
	<p></p>
	<h4> 비밀번호  </h4>
	 비밀번호 <input type="submit" value="변경하기"> 
</div>
</form>

<form action="${pageContext.request.contextPath}/updateMember" >
<div>
	<h4> 회원정보  </h4>
	 회원정보 <input type="submit" value="변경하기"> 
</div>
</form>


<%@ include file = "/jdbc/footerConfig.jsp" %>

</body>
</html>