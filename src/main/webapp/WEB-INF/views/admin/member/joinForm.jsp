<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin/layout/header.jsp" %>


<%
  // 고유번호 생성
  String uniqueNumber = java.util.UUID.randomUUID().toString();
%>


<form action="${ pageContext.request.contextPath }/admin/member/join" method="post" name="join">
	<table>
		<tr>
			<input type="hidden" id="adminNo" name="adminNo" autocomplete="off" value="<%= uniqueNumber %>">
		</tr>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" id="adminId" name = "adminId" autocomplete="off">
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name = "adminPw"></td>
		</tr>
		<tr>
			<td>비밀번호 재확인</td>
			<td><input type="password" name = "adminRePw"></td>
		</tr>
		<tr>
		  <td>E-mail</td>
		  <td>
		    <%-- adminemail1과 adminemail2를 합쳐서 adminemail 변수에 저장 --%>
		    <% String adminemail1 = request.getParameter("adminEmail"); %>
		    <% String adminemail2 = request.getParameter("adminEmail2"); %>
		    <% String adminEmail = adminemail1 + adminemail2; %>
		    <input type="text" name="adminEmail" value="<%= adminEmail %>">
		    <%-- adminemail1 입력 필드와 adminemail2 입력 필드는 사용하지 않으므로 제거 --%>
		    <select name="adminemaildo" onchange="adminemaildo_change()">
		      <option value="email0">--이메일 선택--</option>
		      <option value="@gmail.com">구글</option>
		      <option value="@naver.com">네이버</option>
		      <option value="@daum.net">다음</option>
		      <option value="custom">직접입력</option>
		    </select>
		  </td>
		</tr>
		<tr>
			<td>휴대전화</td>
			<td><input type="text" name = "adminPhone"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name = "adminName"></td>
		</tr>
		<tr>
			<td>소속명</td>
			<td>
				<select name = "adminTeam">
					<option value="00">--소속명--</option>
					<option value="인사">인사</option>
					<option value="경영지원">경영지원</option>
					<option value="IT">IT</option>
					<option value="마케팅">마케팅</option>
					<option value="CS">CS</option>
					<option value="협력사">협력사</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>접근 권한</td>
			<td>
				<select name = "adminPosition">
					<option value="0_position">--권한--</option>
					<option value="협력">협력업체</option>
					<option value="관리자">관리자</option>
					<option value="마스터">super</option>					
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" id ="join" value="join">
				<input type="button" value="Reset" onclick="document.join.reset()">
			</td>
		</tr>
	</table>
</form>
<script type="text/javascript">

<script type="text/javascript">

<!-- 이메일 선택시 자동 완성 -->
function adminemaildo_change() {
  var select = document.getElementsByName('adminemaildo')[0];
  var input = document.getElementById('adminEmail2');
  var selectedOption = select.options[select.selectedIndex].value;

  if (selectedOption === 'custom') {
    input.disabled = false;
    input.value = '';
  } else {
    input.disabled = true;
    input.value = selectedOption;
  }
}

</script>


<%@ include file="/WEB-INF/views/admin/layout/footer.jsp" %>











