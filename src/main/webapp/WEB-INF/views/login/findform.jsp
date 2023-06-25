<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<div align="center">
		<form method="post" name="find" id="findForm">
			<c:choose>
				<c:when test="${param.mode == 'id' }">
					<input type="hidden" name="mode" value="id">
					<h3>아이디찾기</h3>
					<table>
						<tr>
							<th>NAME</th>
							<td><input type="text" name="uuserName"></td>
						</tr>
						<tr>
							<th>TEL</th>
							<td><input type="text" name="uuserPhone"></td>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<input type="button" value="find" onclick="javascript:check('${param.mode}')">
								<input type="button" value="Reset" onclick="document.find.reset()">
							</td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<input type="hidden" name="mode" value="pw">					
					<h3>비밀번호 재설정</h3>
				</c:otherwise>
			</c:choose>
			<table>
				<c:if test="${param.mode == 'pw' }">
					<tr>
						<th>ID</th>
						<td><input type="text" name="uuserId"></td>
					</tr>
					<tr>
						<th>NAME</th>
						<td><input type="text" name="uuserName"></td>
					</tr>
					<tr>
						<th>TEL</th>
						<td><input type="text" name="uuserPhone"></td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input type="button" value="update" onclick="javascript:check('${param.mode}')">
							<input type="button" value="Reset" onclick="document.find.reset()">
						</td>
					</tr>
				</c:if>
			</table>
		</form>
	</div>
<script type="text/javascript">
let f = document.getElementById('findForm');
	function check(param){
		console.log(f);
		let mode = param;
		
		if(mode == "id"){
			f.action = "${ pageContext.request.contextPath }/login/find";
			if(f.uuserName.value == ''){
				alert("이름를 입력 하십시오!");
				f.uuserName.focus();
			}
			if(f.uuserPhone.value == ''){
				alert("전화번호를 입력하십시오!");
				f.uuserPhone.focus();
			}
		}else{
			f.action = "${ pageContext.request.contextPath }/login/updatePw";
			if(f.uuserId.value == ''){
				alert("아이디를 입력 하십시오!");
				f.uuserId.focus();
				return false;
			}
			if(f.uuserName.value == ''){
				alert("이름를 입력 하십시오!");
				f.uuserName.focus();
				return false;
			}
			
			if(f.uuserPhone.value == ''){
				alert("전화번호를 입력하십시오!");
				f.uuserPhone.focus();
				return false;
			}
		}
		f.submit();
	}
	
</script>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>