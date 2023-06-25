<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/admin/layout/header.jsp" %>
	<div align="center">
		<form action="${pageContext.request.contextPath}/admin/login/checkLogin" method="post" onsubmit="return check(this)">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="adminId" value="${adminId}"></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" name="adminPw" value="${adminPw}"></td>
				</tr>
				<tr>
					<th colspan="2" align="right">
						<span class="ckid">
							<c:choose>
								<c:when test="${check }">
									<input type="checkbox" name="ckid" value="true" checked="checked">
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="ckid" value="true">
								</c:otherwise>
							</c:choose>
							<font class="ckid_text">아이디 기억하기</font>
						</span>
						<input type="submit" value="Login">
					</th>
				</tr>
			</table>
		</form>
	</div>
	
	<script type="text/javascript">
		function check(f) {
			if(f.id.value == ""){
				alert("ID를 입력하십시오!");
				f.id.focus();
				return false;
			}else if(f.password.value == ""){
				alert("PW를 입력하십시오!");
				f.password.focus();
				return false;
			}
			
			return true;
		}
	</script>
<%@ include file="/WEB-INF/views/admin/layout/footer.jsp" %>

