<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header>
	<h1> 
		<img src = "${pageContext.request.contextPath}/upload/libraryIcon.png" width = "50" height = "50"> 
		<a href = "${pageContext.request.contextPath}/" style="color:black">Library</a>
	</h1>
</header>

<nav>
	<ul>
		<li><a href = "${pageContext.request.contextPath}/" >[ HOME ]</a></li>
		
		<li><a href = "${pageContext.request.contextPath}/rentalAndReservationContents" >[ RENTAL & RESERVATION LIST ]</a></li>
		<li><a href = "${pageContext.request.contextPath}/article" >[ ARTICLE ]</a></li>
	</ul>
</nav>