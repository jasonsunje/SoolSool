<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/admin/layout/header.jsp" %>
	<c:set var="cpath" value="${pageContext.request.contextPath }"/>		
	<div align="center">
		<table class="boardTable">
			<tr>
				<th>번호</th>
				<th>상품이미지</th>
				<th>상품명</th>
				<th>판매가</th>
				<th>대분류</th>
				<th>소분류</th>
				<th>기획전</th>
				<th>상태</th>			
				<th>재고</th>
				<th>등록일</th>
				<th>수정일</th>
			</tr>
			<c:choose>
			
				<c:when test="${list == null }">
					<tr>
						<td colspan="5" align="center">
							<span style="font-weight: bold;">등록된 상품이 없습니다.</span>
						</td>
					</tr>
				</c:when>
				
				<c:otherwise>
					<c:forEach var="dto" items="${list }">
						<tr>
							<td>${dto.seq }</td>
							<td>
								<c:forEach var="i" begin="1" end="${dto.depth}" step="1">
									[댓글]
								</c:forEach>
								<a href="${pageContext.request.contextPath }/board/content?seq=${dto.seq }">${dto.title }</a>
							</td>
							<td>${dto.id }</td>
							<td>${dto.logtime }</td>
							<td>${dto.hit }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<form action="${cpath }/board/list" method="get" onsubmit="return check(this)" >
			<span style="float: left;">
				<select name="type">
					<option value="seq" ${param.type == 'seq' ? 'selected' : '' }>글번호로 검색</option>
					<option value="title" ${param.type == 'title' or empty param.type ? 'selected' : '' }>제목으로 검색</option>
					<option value="id" ${param.type == 'id' ? 'selected' : '' }>아이디로 검색</option>
					<option value="content" ${param.type == 'content' ? 'selected' : '' }>내용으로 검색</option>
				</select>
				<input type="text" name="word" placeholder="검색어를 입력하세요" value="${param.word }" autocomplete="off">
				<input class="btn" type="submit"  value="검색">
			</span>
		</form>		
		<c:if test="${login != null }">
			<div class="btnBox">
				<button onclick="document.location.href='${pageContext.request.contextPath }/board/writeform'">글쓰기</button>
			</div>
		</c:if>
		<div align="center">
			<c:if test="${paging.prev }">
				<a href="${cpath }/board/list?page=${paging.begin - 1}&type=${param.type}&word=${param.word}">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${paging.begin }" end="${paging.end }" step="1">
				<c:choose>
					<c:when test="${i == paging.page }">
						<strong>[${i}]</strong>
					</c:when>
					<c:otherwise>
						<a href="${cpath }/board/list?page=${i}&type=${param.type}&word=${param.word}">[${i }]</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.next }">
				<a href="${cpath }/board/list?page=${paging.end + 1}&type=${param.type}&word=${param.word}">[다음]</a>
			</c:if>
		</div>
	</div>	
	<script type="text/javascript">

	function check(f) {
		alert("실행");
		if(f.type.value == "seq"){
			var num_pattern = /^[0-9]{1,20}$/;
			
			if(f.word.value == "" || !num_pattern.test(f.word.value)){
				alert("글번호를 입력하십시오!");
				return false;
			}
		}else if(f.word.value == ""){
			alert("검색어를 입력하십시오!");
			return false;
		}
		
		return true;
	}
</script>
<%@ include file="/WEB-INF/views/admin/layout/footer.jsp" %>		



































