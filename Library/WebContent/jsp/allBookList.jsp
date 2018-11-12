<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 도서 리스트</title>
<%@ include file = "/jdbc/bootstrapConfig.jsp" %>
</head>
<body>

<script  type = "text/javascript">
	function openWindow(url){
		window.open(url,"Department ID 정보",  "width=500, height=500");
	}
</script>
<h4>All Book List</h4>

<!--  여기서부터  -->
<form action="${pageContext.request.contextPath}/searchBook"  method = "POST">
	<select name = "searchKey">
		<option value = "">검색 옵션</option>
		<option value = "전체">전체</option>	
		<option value = "타이틀">타이틀</option>
		<option value = "저자">저자</option>
		<option value = "출판사">출판사</option>
	</select>
	<input type = "text" name = "key" size = "100">
	<input type = "submit" value = "검색">
	
	<table class="table table-hover" >
	<caption style="color:orange">대여/예약을 원하시면 BOOK_ID 를 클릭 해 주세요.</caption>
	<tr>
		<th>BOOK_ID</th>
		<th>BOOK_IMAGE</th>
		<th>BOOK_TITLE</th>
		<th>BOOK_AUTHOR</th>
		<th>BOOK_PUBLISHER</th>
		<th>BOOK_PRICE</th>
		<th>BOOK_REGISTDATE</th>
	</tr>
	<c:forEach var = "book" items="${book}">
	<tr>
		<td>
			<a href = "#" onclick="javascript:openWindow('${pageContext.request.contextPath}/bookInfo?book_id=${book.book_id}' )">${book.book_id}</a>
		</td>
		<td>
			<img src="${pageContext.request.contextPath}${book.book_image}" width="90" height="120">
		</td>
		<td>${book.book_title}</td>
		<td>${book.book_author}</td>
		<td>${book.book_publisher}</td>
		<td>${book.book_price}원</td>
		<td>${book.book_registdate}</td>
	</tr>
	</c:forEach>
</table>
	
</form>
</body>
</html>