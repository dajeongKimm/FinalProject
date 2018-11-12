<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
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
div{
	padding-left:30px;
	padding-right:30px;
	border-bottom: 1px solid lightgray;
	border-top: 1px solid lightgray;
	width: 100%;
	height: 500px;
}
</style>
</head>
<body>

<%@ include file = "/jdbc/headerConfig.jsp" %>


<table class="table table-hover">
	<caption>게시글을 확인하려면 'TITLE'을 클릭 해 주세요.</caption>
	<tr>
		<th>ARTICLE_NO</th>
		<th>TITLE</th>
		<th>MEMBER_NAME</th>
		<th>REGISTDATE</th>
		<th>COUNT</th>
	</tr>
	<c:forEach var="article" items="${article}">
	<tr>
		<td>${article.article_no}</td>
		<td>
			<a href="${pageContext.request.contextPath}/readArticle?article_no=${article.article_no}">${article.title}</a>	
		</td>
		<td>${article.member_name}</td>
		<td>${article.regdate}</td>
		<td>${article.read_count}</td>
	</tr>
	</c:forEach>
	
</table>

<a href = "${pageContext.request.contextPath}/writeArticle" >[게시글작성]</a>

<div style = "text-align: center">

<c:if test = "${page != 1 }">
	<a href ="${pageContext.request.contextPath}/article">처음</a>
</c:if>

<c:if test="${startPage != 1 }">
	<a href = "${pageContext.request.contextPath}/article?page=${startPage-1}">이전</a>
</c:if>

<c:forEach var="i" begin="${startPage}" end="${endPage }">

	<c:if test="${i==page}" var="result">
		<b>${i}</b>
	</c:if>
	<c:if test="${not result}">
		<a href = "${pageContext.request.contextPath}/article?page=${i}">${i}</a>
	</c:if>

</c:forEach>

<c:if test="${endPage != totalPage }">
	<a href = "${pageContext.request.contextPath}/article?page=${endPage+1}">다음</a>
</c:if>

<c:if test="${page != totlaPage }">
	<a href = "${pageContext.request.contextPath}/article?page=${totalPage}">끝</a>
</c:if>

</div>

<%@ include file = "/jdbc/footerConfig.jsp" %>


</body>
</html>