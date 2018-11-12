<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여 결과 확인</title>
</head>
<body>

BOOK_TITLE : '${selectedBook.book_title}'<br>
${result == 0 ? '예약 실패' : '예약 성공'}

</body>
</html>