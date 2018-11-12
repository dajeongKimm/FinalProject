<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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

</style>
<script  type = "text/javascript">
	function openWindow(url){
		window.open(url,"Department ID 정보",  "width=400, height=400");
	}
</script>
</head>
<body>

<%@ include file = "/jdbc/headerConfig.jsp" %>


<form action="${pageContext.request.contextPath}/login" method = "post">
	<center>
	<table>
		<tr>
			<td ><input type = "text" name = "member_id" placeholder = "아이디"></td>
			
		</tr>
		<tr>
			<td ><input type = "password" name = "member_password" placeholder = "비밀번호"></td>
		</tr>
		<tr>
			<td>
				<center><input type = "submit" value = "Login"  ></center>
			</td>
			
		</tr>
	</table>
	</center>
</form>

<%@ include file = "/jdbc/footerConfig.jsp" %>


</body>
</html>