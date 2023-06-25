<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script>
	
	function deleteAction() {
		var check = confirm("삭제 하시겠습니까?");
		
		if(!check){
			return;
		}
		
		location.href = '${pageContext.request.contextPath }/cs/delete?seq=${vo.CS_NO}';
	}
	
</script>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<div align="center">
	<table class="csTable" style="table-layout: fixed;">
		<tr>
			<th>제목</th>
			<td>${vo.CS_TITLE }</td><!--  -->
			<th>조회수</th>
			<td>${vo.CS_HIT }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${vo.UUSER_NICKNAME }</td>
			<th>작성일</th>
			<td>${vo.CS_DATE }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="4">
				${vo.CS_CONTENT }
			</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td colspan="3">
				<a href="/images/${vo.CS_FILETITLE}" download=''>${vo.CS_FILETITLE}</a>
			</td>
		</tr>
	</table>
	<div class="btnBox">
		<c:if test="${login == vo.UUSER_NO }">
			<input type="button" value="수정" onclick="location.href='${pageContext.request.contextPath }/cs/updateform?seq=${vo.CS_NO}'">
			<input type="button" value="삭제" onclick="deleteAction()">
		</c:if>
		<!-- 로그인이 되어야지만 댓글 작성 가능 -->
		<c:if test="${!empty login }">
			<input type="button" value="답글쓰기" onclick="location.href='${pageContext.request.contextPath}/cs/reply/${vo.CS_NO}'">
		</c:if>
		<input type="button" value="목록" onclick="location.href='${pageContext.request.contextPath }/cs/list'">
	</div>
</div>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
















