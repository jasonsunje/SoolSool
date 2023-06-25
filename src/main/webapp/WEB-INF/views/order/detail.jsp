<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp" %>
	<h2>주문목록</h2>
		<form name="order" id="order" method="post" action="${cpath }/order/canceled">
			<table border="1">
				<tr>
		            <th>주문 고유 번호</th>
		            <th>회원 고유 번호</th>
		            <th>주문일자</th>
		            <th>결제일자</th>
		            <th>총 결제 금액</th>
		            <th>상품 갯수</th>
		            <th>상품 가격</th>
		            <th>결제 번호</th>
		            <th>상품번호</th>
		            <th>쿠폰 사용 여부</th>
		            <th>포인트 사용 여부</th>
		            <th>포인트 사용 금액</th>
		            <th>쿠폰 시리얼 번호</th>
		            <th>상품 재고 현황</th>
		            <th>결제 방식</th>
		            <th>총 할인 금액</th>
		            <th>결제 상태</th>
		            <th>직접 받기/선물하기</th>
		            <th>옵션 번호</th>
				</tr>
				<c:forEach items="${map.list}" >
				<tr>
					<td>
						${map.pOrder_No }
					</td>
					<td>
						<td>${map.uuser_No}</td>
			            <td>${map.porder_Date}</td>
			            <td>${map.porder_Pdate}</td>
			            <td>${map.porder_Ptotal}</td>
			            <td>${map.porder_Nproduce}</td>
			            <td>${map.porder_Price}</td>
			            <td>${map.podrder_Pno}</td>
			            <td>${map.product_Mo}</td>
			            <td>${map.porder_Ccheck}</td>
			            <td>${map.porder_Pcheck}</td>
			            <td>${map.porder_Pused}</td>
			            <td>${map.coupon_No}</td>
			            <td>${map.product_Status}</td>
			            <td>${map.porder_Pay}</td>
			            <td>${map.porder_Dtotal}</td>
			            <td>${map.porder_Pstatus}</td>
			            <td>${map.porder_Gcheck}</td>
			            <td>${map.doption_No}</td>
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
			<button type="submit" id="btnOrderCanceled">취소</button>
		</form>
	<button type="button" id="btnList">상품 목록</button>
</body>
</html>