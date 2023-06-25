<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file = "/WEB-INF/views/layout/header.jsp" %>
<%@include file = "/WEB-INF/views/layout/myHeader.jsp" %>

<div align="center">
	<table id="table">
		<tr>
			<td id="border" >이름</td>
			<td id="border">${vo.uuserName }</td>
		</tr>
		<tr>
			<td id="border">닉네임</td>
			<td id="border">${vo.uuserNickname }</td>
		</tr>
		<tr>
			<td id="border">비밀번호</td>
		</tr>
		<tr>
			<td id="border">이메일</td>
			<td id="border">${vo.uuserEmail}</td>
		</tr>
		<tr>
			<td id="border">전화번호</td>
			<td id="border">${vo.uuserPhone}</td>
		</tr>
		<tr>
			<td id="border">수신 이메일</td>
			<td id="border">${vo.uuserEcheck}</td>
		</tr>
		<tr>
			<td id="border">수신 SMS</td>
			<td id="border">${vo.uuserScheck}</td>
		</tr>
		<tr>
			<td colspan="2" align="right"  id="border">
				<input type="button" value = "수정" onclick="location.href = '${ pageContext.request.contextPath }/uuser/updateform'">
				<input type="button" value = "회원탈퇴" onclick="location.href = '${ pageContext.request.contextPath }/uuser/deleteform'">
			</td>
		</tr>
	</table>
</div>
<%@include file = "/WEB-INF/views/layout/footer.jsp" %>