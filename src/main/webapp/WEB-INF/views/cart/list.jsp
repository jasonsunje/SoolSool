<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function)(){
		$("#btnList").click(function(){
			location.href="${cpath}/product/list";
		});
	});
</script>
<%@include file="/WEB-INF/views/layout/header.jsp" %>
	<h2>장바구니 확인</h2>
	<c:choose>
		<c:when test="${map.count == 0 }">
			장바구니가 비었습니다.
		</c:when>
		<c:otherwise>
		<form name="order" id="order" method="post" action="${cpath }/order/create">
			<table border="1">
				<tr>
					<th>상품명</th>
					<th>판매가</th>
					<th>수량</th>
					<th>취소</th>
				</tr>
				<c:forEach var="cartrow" items="${map.list}" >
				<tr>
					<td>
						${cartrow.PRODUCT_NAME }
					</td>
					<td>
						${cartrow.PRODUCT_PRICE }
						
						<input type="hidden" name="cartNo" value="${cartrow.PRODUCT_NO}">
						<input type="hidden" name="cartPrice" value="${cartrow.PRODUCT_PRICE}">
						<input type="hidden" name="cartCnt" value="${cartrow.CART_CNT}">
					</td>
					<td>
						${cartrow.CART_CNT }
					</td>
					<td>
						<a href="${cpath }/cart/delete/${cartrow.cartNo}">삭제</a>
					</td>
				</tr>
				</c:forEach>
				<tr>
					<td>
						장바구니 금액 합계 : ${map.sumMoney } <br>
						배송료 : ${map.fee } <br>
						전체 주문금액 : ${map.allSum } <br>
					</td>
				</tr>
			</table>
			<input type="hidden" name="count" value="${map.count }">
			<button type="submit" id="btnOrder">주문</button>
		</form>
		</c:otherwise>
	</c:choose>
	<button type="button" id="btnList">상품 목록</button>
</body>
</html>