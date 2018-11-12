<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<c:if test="${result eq 0}">
	<script>
		alert('비밀번호가 일치하지 않아 회원 정보를 변경할 수 없습니다.')
		location.href="${pageContext.request.contextPath}/updateMember";
	</script>
</c:if>
<c:if test="${result eq 1 }">
	<script>
		alert("회원정보 변경 완료")
		location.href="${pageContext.request.contextPath}";
	</script>
	
</c:if>

</body>
</html>