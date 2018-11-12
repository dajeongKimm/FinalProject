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
		alert('게시글이 등록되지 않았습니다.')
		location.href="${pageContext.request.contextPath}/writeArticle";
	</script>
</c:if>
<c:if test="${result eq 1 }">
	<script>
		alert("게시글 작성 완료")
		location.href="${pageContext.request.contextPath}/article";
	</script>
	
</c:if>
</body>
</html>