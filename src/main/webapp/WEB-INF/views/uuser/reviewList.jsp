<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<%@include file = "/WEB-INF/views/layout/myHeader.jsp" %>
	<c:set var="cpath" value="${pageContext.request.contextPath }"/>		
	<div align="center">
		<table class="reviewTable">
			<tr>
				<th>닉네임</th>
				<th>글내용</th>
				<th>아이디</th>
				<th>작성일</th>
				<th>별점</th>
			</tr>
			<c:choose>
				<c:when test="${list == null }">
					<tr>
						<td colspan="5" align="center">
							<span style="font-weight: bold;">작성한 글이 없습니다.</span>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="dto" items="${list }">
						<tr>
							<td>${dto.UUSER_NICKNAME }</td>
							<td>
								<c:forEach var="i" begin="1" end="${dto.DEPTH }" step="1">
									[댓글]
								</c:forEach>
								<a href="${pageContext.request.contextPath }/uuser/content?seq=${dto.REVIEW_NO }">${dto.REVIEW_CONTENT }</a>
							</td>
							<td>${dto.UUSER_ID }</td>
							<td>${dto.REVIEW_DATE }</td>
							<td>${dto.REVIEW_STAR }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<c:if test="${login != null }">
			<div class="btnBox">
				<button onclick="document.location.href='${pageContext.request.contextPath }/uuser/reviewform'">글쓰기</button>
			</div>
		</c:if>
		<div align="center">
			<c:if test="${paging.prev }">
				<a href="${cpath }/uuser/list?page=${paging.begin - 1}&type=${param.type}&word=${param.word}">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${paging.begin }" end="${paging.end }" step="1">
				<c:choose>
					<c:when test="${i == paging.page }">
						<strong>[${i}]</strong>
					</c:when>
					<c:otherwise>
						<a href="${cpath }/uuser/list?page=${i}&type=${param.type}&word=${param.word}">[${i }]</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.next }">
				<a href="${cpath }/uuser/list?page=${paging.end + 1}&type=${param.type}&word=${param.word}">[다음]</a>
			</c:if>
		</div>
	</div>	
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>		
