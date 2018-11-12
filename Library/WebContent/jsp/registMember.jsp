<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<h3>회원가입</h3>
<form action = "${pageContext.request.contextPath}/regist" method = "post"  enctype="multipart/form-data">
	<table>
		<tr>
			<th> 아이디 </th>
			<td><input type = "text" name = "member_id"></td>
		</tr>
		<tr>
			<th> 패스워드 </th>
			<td><input type = "password" name = "member_password"></td>
		</tr>
		<tr>
			<th> 이름 </th>
			<td><input type = "text" name = "member_name"></td>
		</tr>
		<tr>
			<th> 나이 </th>
			<td><input type = "text" name = "member_age"></td>
		</tr>
		<tr>
			<th> 연락처 </th>
			<td><input type = "tel" name = "member_tel" placeholder="010-0000-0000"></td>
		</tr>
		<tr>
			<th> 주소 </th>
			<td><input type = "text" name = "member_address"></td>
		</tr>
		<tr>
			<th> 이메일 </th>
			<td><input type = "email" name = "member_email" placeholder="abc@abc.com"></td>
		</tr>
		<tr>
			<th> 성별 </th>
			<td>
				<input type = "radio" name = "member_gender" value = "M" checked = "checked">남
				<input type = "radio" name = "member_gender" value = "W">여
			</td>
		</tr>
		<tr>
			<th> 이미지 </th>
			<td>
				<input type = "file" name="file">
			</td>
		</tr>
		<tr>
			<td colspan = "2"> 
				<input  type = "submit" value = "회원가입">
			</td>
		</tr>	
	</table>
</form>

</body>
</html>