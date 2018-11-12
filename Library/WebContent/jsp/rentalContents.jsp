<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여목록</title>
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
aside#left{
	 float: left;
}

footer{
	width:100%
}

ul{
	text-align: center;
}
ul li{
	
	display:inline;
}
</style>
</head>
<body>

<%@ include file = "/jdbc/headerConfig.jsp" %>


<ul>
	<li><a href = "${pageContext.request.contextPath}/allRentalList" target = "frame">[전체]</a></li>
	<li><a href = "${pageContext.request.contextPath}/rentalingList" target = "frame">[대여중]</a></li>
	<li><a href = "${pageContext.request.contextPath}/returnList" target = "frame">[반납]</a></li>
</ul>

<center>
	<iframe name = "frame" width = "800" height = "600"  src = "${pageContext.request.contextPath}/allRentalList"></ifram>
</center>

<%@ include file = "/jdbc/footerConfig.jsp" %>



</body>
</html>