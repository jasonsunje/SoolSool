<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script>
	
	function deleteAction() {
		var check = confirm("삭제 하시겠습니까?");
		
		if(!check){
			return;
		}
		
		location.href = '${pageContext.request.contextPath }/uuser/rDelete?seq=${vo.REVIEW_NO}';
	}
	
</script>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<div align="center">
	<table class="boardTable" style="table-layout: fixed;">
		<tr>
			<th>닉네임</th>
			<td>${vo.UUSER_NICKNAME }</td><!--  -->
		</tr>
		<tr>
			<th>상품사진</th>
			<td>${vo.REVIEW_PHOTO }</td>
			<th>작성일</th>
			<td>${vo.REVIEW_DATE }</td>
			<th>별점</th>
			<td>${vo.REVIEW_STAR }</td>
		</tr>
		<tr>
			<th>리뷰</th>
			<td colspan="4">
				${vo.REVIEW_CONTENT }
			</td>
		</tr>
	</table>
	<div class="btnBox">
		<c:if test="${login == vo.UUSER_NO }">
			<input type="button" value="수정" onclick="location.href='${pageContext.request.contextPath }/uuser/rUpdateform?seq=${vo.REVIEW_NO}'">
			<input type="button" value="삭제" onclick="deleteAction()">
		</c:if>
		<!-- 로그인이 되어야지만 댓글 작성 가능 -->
	<%-- 	<c:if test="${!empty login }">
			<input type="button" value="답글쓰기" onclick="location.href='${pageContext.request.contextPath}/uuser/reply/${vo.REVIEW_NO}'">
		</c:if> --%>
		<input type="button" value="목록" onclick="location.href='${pageContext.request.contextPath }/uuser/reviewList'">
	</div>
</div>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
















