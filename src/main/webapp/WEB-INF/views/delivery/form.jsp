<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="/WEB-INF/views/layout/myHeader.jsp"%>
<div class="deivery" align="center">
	<div class="delivery_soolHeaderWrapper">
		<div class="delivery_soolSubheader" align="center">그 외 배송지 목록</div>
	</div>

	<c:choose>
		<c:when test="${fn:length(list) == 0 }">
			<span> 등록된 배송지가 없습니다.</span>
		</c:when>
		<c:otherwise>
			<c:forEach var="dto" items="${list }">
				<table style="border: 1px solid;">
					<c:if test="${dto.mngdeliveryBasic == 1}">
						<tr>
							<td>기본배송지</td>
						</tr>
					</c:if>
					<tr>
						<td>${dto.mngdeliveryPname }</td>
					</tr>
					<tr>
						<td>${dto.mngdeliveryZipcode }</td>
					</tr>
					<tr>
						<td>${dto.mngdeliveryAddress }</td>
					</tr>
					<tr>
						<td>${dto.mngdeliveryDetail }</td>
					</tr>
					<tr>
						<td>${dto.mngdeliveryDname }</td>
					</tr>
				</table>
				<div class="change" align="center">
					<input type="button" value="수정"
						onclick="location.href='${pageContext.request.contextPath}/delivery/updateform?seq=${dto.mngdeliveryNo }'">
					<input type="button" value="삭제"
						onclick="deleteAction(${dto.mngdeliveryNo})">
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<div class="contents" align="center">
		<div class="message" align="center">배송지를 등록해 주세요</div>
		<br> <input type="button" value="배송지 추가하기+" id="addressPluse"
			onclick="location.href='${pageContext.request.contextPath}/delievery/insertform'">
	</div>

</div>
<script>
	function deleteAction(no){
		var check = confirm("삭제 하시겠습니까?");
		
		if(!check){
			return;
		}
		location.href = '${pageContext.request.contextPath }/delivery/delete?seq=' + no;
	}
</script>
<%@include file = "/WEB-INF/views/layout/footer.jsp" %>