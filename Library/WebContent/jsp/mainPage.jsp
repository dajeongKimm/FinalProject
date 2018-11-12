<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관</title>
<%@ include file = "/jdbc/bootstrapConfig.jsp" %>
<script  type = "text/javascript">
	function openWindow(url){
		window.open(url,"Department ID 정보",  "width=500, height=500");
	}
</script>
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
	 margin: 30px;
}

footer{
	width:100%
}
</style>
</head>
<body>

<%@ include file = "/jdbc/headerConfig.jsp" %>
<%@ include file = "/jdbc/asideConfig.jsp" %>

<section id = "main">
	<article id = "article1">
		<iframe name = "iframe1" src="${pageContext.request.contextPath}/allbooklist" width = "900" height = "550" frameborder=0></iframe>
	</article>
</section>

<%@ include file = "/jdbc/footerConfig.jsp" %>

</body>
</html>