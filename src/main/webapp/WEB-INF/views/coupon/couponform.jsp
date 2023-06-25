<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="title">쿠폰</div>
<div class="style_coupon">
	<div class="style_coupon_wrapper" align="center">
		<div class="style_coupon_tab">
		잔여쿠폰: <a href="">${count }</a> 개
		</div>
		<div class="style_coupon_used">사용/만료된 쿠폰</div>
	</div>
	<div class="couponRegisterWrapper">
		<div class="couponform">
			<input aria-invalid="false"placeholder="쿠폰 코드를 입력해 주세요" type="text" >
			<fieldset aria-hidden="true" class="couponform_true">
				<legend class="css-coupon">
					<span class="notranslate"></span>
				</legend>
			</fieldset>
		</div>
		<button class="buttoncoupon">등록</button>
	</div>
	<c:choose>
			<c:when test="${fn:length(list) == 0 }">
				<span> 등록된 쿠폰이 없습니다.</span>
			</c:when>
			<c:otherwise>
				<c:forEach var="do" items="${list }">
					<table style="border: 1px solid;">
						<c:if test="${do.couponNo == 2}">
							<tr>
								<td>쿠폰</td>
							</tr>
						</c:if>
						<tr>
							<td>쿠폰 이름</td>
							<td>${do.couponName }</td>
						</tr>
						<tr>
							<td>쿠폰 유효기간 시작</td>
							<td>${do.cserialStart }</td>
						</tr>
						<tr>
							<td>쿠폰 유효기간 종료</td>
							<td>${do.cserialEnd }</td>
						</tr>
						<tr>
							<td>쿠폰 상태</td>
							<td>${do.cserialStatus }</td>
						</tr>
					</table>
					<div class="change" align="center">
						<input type="button" value="삭제"
							onclick="deleteAction(${do.couponNo})">
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
</div>
</body>
	<script type="text/javascript">
	function deleteAction(no){
		var check = confirm("삭제 하시겠습니까?");
		
		if(!check){
			return;
		}
		location.href = '${pageContext.request.contextPath }/coupon/delete?seq=' + no;
	}
	</script>
</html>