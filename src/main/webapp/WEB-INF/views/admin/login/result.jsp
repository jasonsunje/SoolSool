<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/admin/layout/header.jsp" %>
	${msg }<br>
	<c:choose>
		<c:when test="${check }">
			<a href="${pageContext.request.contextPath }admin/member/mypage">MyPage</a>
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath }admin/login/loginform">Login</a>
		</c:otherwise>
	</c:choose>
<%@ include file="/WEB-INF/views/admin/layout/footer.jsp" %>


		
		