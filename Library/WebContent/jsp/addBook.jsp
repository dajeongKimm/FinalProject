<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 추가</title>
</head>
<body>

<h3>도서 추가</h3>
<form action = "${pageContext.request.contextPath}/addbook" method = "post"  enctype="multipart/form-data">
<table>
	
		
		<tr>
			<th> 책제목 </th>
			<td><input type = "text" name = "book_title"></td>
		</tr>
		<tr>
			<th> 저자 </th>
			<td><input type = "text" name = "book_author"></td>
		</tr>
		<tr>
			<th> 출판사 </th>
			<td><input type = "text" name = "book_publisher"></td>
		</tr>
		<tr>
			<th> 가격 </th>
			<td><input type = "text" name = "book_price"></td>
		</tr>
		<tr>
			<th> 이미지 </th>
			<td><input type = "file" name = "file"></td>
		</tr>
		
		<tr>
			<td colspan = "2"> 
				<input  type = "submit" value = "도서추가">
			</td>
		</tr>
	
</table>
</form>
</body>
</html>