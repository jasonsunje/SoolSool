<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function check(){
		if(document.del.withdrawalReason.value == ""){
			alert("탈퇴 사유를 적어주세요");
		}else{
			alert("탈퇴 하시겠습니까?");
			document.del.submit();
		}
	}
</script>
<%@include file="/WEB-INF/views/layout/header.jsp" %>
<div align="center">
		<form action="${ pageContext.request.contextPath }/uuser/delete" method="post" name = "del">
		<table border="1">
			<tr>
				<th>탈퇴 사유를 적어주세요</th>
			</tr>
			<tr>
				<td>
					<input type="text" name = "withdrawalReason" placeholder="내용">
				</td>
			</tr>
			<tr>
				<td align="right">
					<input type="button" value="탈퇴" onclick="javascript:check()">
					<input type="button" onclick="location.href='${ pageContext.request.contextPath }/uuser/mypage'" value="돌아가기">				
				</td>
			</tr>
		</table>
	</form>
</div>


<%@include file="/WEB-INF/views/layout/footer.jsp" %>