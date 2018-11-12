<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 결과</title>
<%@ include file = "/jdbc/bootstrapConfig.jsp" %>
</head>
<body>

<c:if test ="${result eq 1}" var = "result">
	<center><p>가입을 축하합니다</p></center>
</c:if>
<c:if test = "${not result}">
	<center><p>가입 실패!! 다시 <a href = "${pageContext.request.contextPath}/regist">회원가입</a>하기</p></center>
</c:if>

</body>
</html>