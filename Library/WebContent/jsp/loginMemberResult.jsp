<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "/jdbc/bootstrapConfig.jsp" %>
</head>
<body>

<c:if test="${result eq 0}">
	<script>
		alert('아이디와 패스워드가 일치하지 않습니다.')
		location.href="${pageContext.request.contextPath}/login";
	</script>
</c:if>
<c:if test="${result eq 1 }">
	<script>
		alert("'${loginMember.member_name}'님 환영합니다.")
		location.href="${pageContext.request.contextPath}";
	</script>
	
</c:if>
</body>
</html>