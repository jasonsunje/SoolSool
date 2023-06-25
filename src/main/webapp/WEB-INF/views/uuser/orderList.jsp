<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file = "/WEB-INF/views/layout/header.jsp" %>
<%@include file = "/WEB-INF/views/layout/myHeader.jsp" %>
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
	<c:forEach var="orderMap" items="${list}">
		<tr>
			<td>${orderMap.PORDER_NO }</td>
			<td>${orderMap.UUSER_NO}</td>
			<td>${orderMap.PORDER_DATE}</td>
			<td>${orderMap.PORDER_PDATE}</td>
			<td>${orderMap.PORDER_PTOTAL}</td>
			<td>${orderMap.PORDER_PNO}</td>
			<td>${orderMap.PRODUCT_NO}</td>
			<td>${orderMap.PORDER_CCHECK}</td>
			<td>${orderMap.PORDER_PCHECK}</td>
			<td>${orderMap.PORDER_PUSED}</td>
			<td>${orderMap.COUPON_NO}</td>
			<td>${orderMap.PSTOCK_NO}</td>
			<td>${orderMap.PORDER_PAY}</td>
			<td>${orderMap.PORDER_DTOTAL}</td>
			<td>${orderMap.PORDER_PSTATUS}</td>
			<td>${orderMap.PORDER_GCHECK}</td>
			<td>${orderMap.ODOPTION_NO}</td>
		</tr>
	</c:forEach>
</table>
<%@include file = "/WEB-INF/views/layout/footer.jsp" %>