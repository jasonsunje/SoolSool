<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file = "/WEB-INF/views/layout/header.jsp" %>
<div align="center">
		<form action="${ pageContext.request.contextPath }/login/newPw" method="post" name = "updatePw">
 			<table id="table">
				<tr>
					
					<td id="border">새 비밀번호</td>
					<td id="border"><input type="password" name="uuserPassword"></td>
					<input type="hidden" name="UuserId" value="${UuserId}">
				</tr>
				<tr>
					<td id="border">비밀번호 확인</td>
					<td id="border"><input type="password" name = "checkPw"></td>
				</tr>
			 	<tr>
			 		<td colspan="2" align="right" id="border">
			 			<input type="button" value = "수정" onclick="javascript:check()">
			 			<input type="button" value = "돌아가기" onclick="location.href='${ pageContext.request.contextPath }/uuser/uuserInfo'">
			 		</td>
			 	</tr>
		 </table>	
 	</form>
</div>
<script>
	function check(){
		if(document.updatePw.uuserPassword.value == ""){
			alert("비밀번호를 입력하십시오!");
		}else if(document.updatePw.checkPw.value == ""){
			alert("비밀번호확인을 입력하십시오!");
		}else if(document.updatePw.uuserPassword.value != document.updatePw.checkPw.value){
			alert("비밀번호가 일치하지 않습니다.");
		}else{
			document.updatePw.submit();
		}
	}
</script>
<%@include file = "/WEB-INF/views/layout/footer.jsp" %>