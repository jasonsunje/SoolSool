<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script>
	
	function deleteAction() {
		var check = confirm("삭제 하시겠습니까?");
		
		if(!check){
			return;
		}
		
		location.href = '${pageContext.request.contextPath }/uuser/delete?seq=${vo.REVIEWNO}';
	}
	
</script>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<div align="center">
	<table class="boardTable" style="table-layout: fixed;">
		<tr>
			<th>닉네임</th>
			<td>${vo.UUSERNICKNAME }</td><!--  -->
		</tr>
		<tr>
			<th>상품사진</th>
			<td>${vo.REVIEWPHOTO }</td>
			<th>작성일</th>
			<td>${vo.REVIEWDATE }</td>
		</tr>
		<tr>
			<td colspan="4">
				${vo.REVIEWCONTENT }
			</td>
		</tr>
		<tr>
			<th>첨부파일</th>
		<td colspan="3">
				<a href="${pageContext.request.contextPath }/storage/${vo.FILENAME }" download>${vo.FILENAME }</a> 
			</td>
		</tr>
	</table>
	<div class="btnBox">
		<c:if test="${login == vo.NO }">
			<input type="button" value="수정" onclick="location.href='${pageContext.request.contextPath }/uuser/updateform?seq=${vo.REVIEWNO}'">
			<input type="button" value="삭제" onclick="deleteAction()">
		</c:if>
		<!-- 로그인이 되어야지만 댓글 작성 가능 -->
		<c:if test="${!empty login }">
			<input type="button" value="답글쓰기" onclick="location.href='${pageContext.request.contextPath}/uuser/reply/${vo.REVIEWNO}'">
		</c:if>
		<input type="button" value="목록" onclick="location.href='${pageContext.request.contextPath }/uuser/reviewList'">
	</div>
</div>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
















