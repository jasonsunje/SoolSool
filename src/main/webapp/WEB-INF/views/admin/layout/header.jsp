<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="Ko-kr">
<head>
<meta charset="UTF-8">
<title>술술</title>
<style type="text/css">
	
</style>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/style.css">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</head>
<body>
	<div align="center">
	<h2>술술 admin</h2>
		<div class="header">
 			<c:choose>
				<c:when test="${!empty login }">
					<a href="${pageContext.request.contextPath }/admin/member/myPage">MyPage</a> | 
					<a href="${pageContext.request.contextPath }/admin/login/logout">Logout</a> | 
					<a href="${pageContext.request.contextPath }/admin/product/insertForm">Admin_product_insert</a> |
					<a href="${pageContext.request.contextPath }/admin/product/list">Admin_product_board</a> | 
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath }/admin/login/loginForm">Login</a> | 
					<a href="${pageContext.request.contextPath }/admin/member/joinForm">Join</a> | 
				</c:otherwise>
			</c:choose>
			<a href="${pageContext.request.contextPath }">Home</a>
		</div>
		<div class="main">
		<nav class="gnb">
		<ul>
		    <li><a href="#">홈</a></li>
		    <li><a href="#">탁주</a></li>
		    <li><a href="#">청주</a></li>
		    <li><a href="#">증류주</a></li>
		    <li><a href="#">과실주</a></li>
		    <li><a href="#">전체상품</a></li>
		  </ul>
		</nav>
