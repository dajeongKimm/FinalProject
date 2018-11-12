<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<aside id = "left">

	<c:if test = "${empty isLogin || not isLogin}" var = "result">
	<center>
		<a href = "${pageContext.request.contextPath}/login"><span class="badge">로그인</span></a>
		<a href ="#" onclick="openWindow('${pageContext.request.contextPath}/regist')"><span class="badge">회원가입</span></a><br>
	</center>
	</c:if>
	<c:if test="${not result}">
		<p>'${loginMember.member_name}'님 환영합니다. </p>
		<center>
			<a href = "${pageContext.request.contextPath}/update"><span class="badge">회원정보수정</span></a>
			<a href = "${pageContext.request.contextPath}/logout"><span class="badge">로그아웃</span></a> <br>
			<c:if test="${loginMember.member_type eq 1 }">
				<hr>
				---------ADMIN---------<BR>
				<a href ="#" onclick="openWindow('${pageContext.request.contextPath}/addbook')"><span class="badge">도서 추가</span></a>
				<a href = "${pageContext.request.contextPath}/rentalContents" ><span class="badge">ADMIN</span></a><br>
			</c:if>
	</center>
	</c:if>

</aside>