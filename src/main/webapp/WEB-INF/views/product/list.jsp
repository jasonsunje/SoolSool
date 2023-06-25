<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<c:set var="cpath" value="${pageContext.request.contextPath }"/>		
	<div align="center">
		<table class="boardTable">
			<tr>
				<th>상품고유번호</th>
				<th>상품명</th>
				<th>상품이미지</th>
				<th>상품태그1</th>
				<th>상품태그2</th>
				<th>별점</th>
				<th>리뷰개수</th>
				<th>할인가</th>			
				<th>소개</th>
				<th>도수</th>
				<th>수정날짜</th>
				<th>판매가</th>
				<th>찜</th>
				<th>카테고리</th>
				<th>패키지</th>
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
					<c:forEach var="productrow" items="${list }">
						<tr>
							<td>${productrow.productNo }</td>
							<td>${productrow.productName }
								<a href="${cpath}/product/detail/${productrow.productNo}">상세 보기</a>
							</td>
							<td>${productrow.productImg }
								<img src="/images/${productrow.productImg }" width="100px" height="100px">
							</td>
							<td>${productrow.productTag1 }</td>
							<td>${productrow.productTag2 }</td>
							<td>${productrow.productStar }</td>
							<td>${productrow.productRcnt }</td>
							<td>${productrow.productDiscount }</td>
							<td>${productrow.productIntro }</td>
							<td>${productrow.productAlcohol }</td>
							<td>${productrow.productPrice }</td>
							<td>${productrow.productWish }</td>
							<td>${productrow.categoryNo }</td>
							<td>${productrow.packageNo }</td>
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
<!--  	<script type="text/javascript">

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
</script>-->
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>		



































