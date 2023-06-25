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
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div align="center">
	<form action="${ pageContext.request.contextPath }/cs/write" method="post" name = "write" enctype="multipart/form-data"> <!-- enctype 파일 업로드시 필수  -->
		<c:if test="${seq != null }">
			<input type ="hidden" name="csNo" value="${csNo }">
		</c:if>
		<table class = "csTable">
			<tr>
				<th width="60">제목</th>
				<td><input type="text" name = "csTitle" size = "53"></td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea id="summernote" rows="15" cols="65" name="csContent"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="file" name = "csFile" size = "400">
				</td>
			</tr>
		</table>
		<div class = "btnBox">
			<input type="button" value="쓰기" onclick="javascript:checkWrite()">
		</div>
	</form>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		  $('#summernote').summernote();
		});
</script>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
