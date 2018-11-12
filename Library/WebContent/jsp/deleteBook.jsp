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
		alert('도서 삭제 실패')
		location.href="${pageContext.request.contextPath}";
	</script>
</c:if>
<c:if test="${result eq 1 }">
	<script>
		alert("도서가 삭제 되었습니다.")
	</script>
	
</c:if>


</body>
</html>