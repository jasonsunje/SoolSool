<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/admin/layout/header.jsp" %>
	<h2>회원 목록</h2>
	<div align="center">
		<table class="boardTable">
			<tr>
				<th>회원 고유 번호</th>
				<th>회원 등급 번호</th>
				<th>회원 이름</th>
				<th>회원 구분</th>
				<th>회원 닉네임</th>
				<th>회원 이미지</th>
				<th>회원 소개</th>
				<th>회원 가입 날짜</th>			
				<th>회원 정보 수정 날짜</th>
				<th>회원 주소</th>
				<th>회원 상태</th>
				<th>회원가입 동의</th>
				<th>회원 전화번호</th>
				<th>회원 이메일</th>
				<th>회원 생일</th>
				<th>회원 성별</th>
				<th>회원 인증 날짜</th>
				<th>회원 SNS ID</th>
				<th>회원 SNS 연동1</th>
				<th>회원 SNS 연동2</th>
				<th>회원 ID</th>
				<th>이메일 수신 동의</th>
				<th>문자 수신 동의</th>
			</tr>
			<c:choose>
			
				<c:when test="${list == null }">
					<tr>
						<td colspan="5" align="center">
							<span style="font-weight: bold;">등록된 회원이 없습니다.</span>
						</td>
					</tr>
				</c:when>
				
				<c:otherwise>
					<c:forEach var="userrow" items="${list }">
						<tr>
							<td>${userrow.uuserNo }</td>
							<td>${userrow.gradeNo }</td>
							<td>${userrow.uuserName }</td>
							<td>${userrow.uuserType }</td>
							<td>${userrow.uuserNickname }</td>
							<td>${userrow.uuserImg }</td>
							<td>${userrow.uuserIntro }</td>
							<td>${userrow.uuserJoindate }</td>
							<td>${userrow.uuserUpdate }</td>
							<td>${userrow.uuserAddress }</td>
							<td>${userrow.uuserStatus }</td>
							<td>${userrow.uuserAgree }</td>
							<td>${userrow.uuserPhone }</td>
							<td>${userrow.uuserEmail }</td>
							<td>${userrow.uuserBirth }</td>
							<td>${userrow.uuserGender }</td>
							<td>${userrow.uuserAuthdate }</td>
							<td>${userrow.uuserSnsid }</td>
							<td>${userrow.uuserSnscode1 }</td>
							<td>${userrow.uuserId }</td>
							<td>${userrow.uuserEcheck }</td>
							<td>${userrow.uuserScheck }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
<%-- 		<form action="${cpath }/board/list" method="get" onsubmit="return check(this)" >
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
	</div>	 --%>
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
<%@ include file="/WEB-INF/views/admin/layout/footer.jsp" %>		



































