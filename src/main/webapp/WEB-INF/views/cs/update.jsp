<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function checkWrite() {
		if(document.write.csTitle.value == ""){
			alert("제목을 입력하십시오!");
		}else if(document.write.csContent.value == ""){
			alert("내용을 입력하십시오!")
		}else{
			document.write.submit();
		}
	}
</script>
<%@include file = "/WEB-INF/views/layout/header.jsp" %>
<div align="center">
	<form action="${ pageContext.request.contextPath }/cs/update" method="post" name = "write" >
		<input type="hidden" name="csNo" value="${vo.csNo }">
		<table class = "csTable">
			<tr>
				<th width="60">제목</th>
				<td><input type="text" value="${vo.csTitle }" name = "csTitle" size = "53"></td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea rows="15" cols="65" name = "csContent">${vo.csContent }</textarea>
				</td>
			</tr>
		</table>
		<div class = "btnBox">
			<input type="button" value="수정" onclick="javascript:checkWrite()">
		</div>
	</form>
</div>
<%@include file = "/WEB-INF/views/layout/footer.jsp" %>