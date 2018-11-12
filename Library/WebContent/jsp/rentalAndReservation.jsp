<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여 / 예약 리스트</title>
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
	width:100%
}
</style>
</head>
<body>

<%@ include file = "/jdbc/headerConfig.jsp" %>

<center>
<h4> <b>${loginMember.member_name}</b> 's Rental List </h4>
<iframe src ="${pageContext.request.contextPath}/rentalList" name = "frame" width ="800" height="500"></iframe>

<h4> <b>${loginMember.member_name}</b> 's Reservation List </h4>
<iframe src ="${pageContext.request.contextPath}/reservationList" name = "frame" width ="800" height="500"></iframe>
</center>

<%@ include file = "/jdbc/footerConfig.jsp" %>

</body>
</html>