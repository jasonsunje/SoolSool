<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp" %>
	<h2>주문목록</h2>
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
				<c:forEach var="orderrow" items="${map.list}" vartStatus="i">
				<tr>
					<td>
						${orderrow.pOrderNo }
					</td>
					<td>
						<td>${orderrow.uuserNo}</td>
			            <td>${orderrow.porderDate}</td>
			            <td>${orderrow.porderPdate}</td>
			            <td>${orderrow.porderPtotal}</td>
			            <td>${orderrow.porderNproduce}</td>
			            <td>${orderrow.porderPrice}</td>
			            <td>${orderrow.podrderPno}</td>
			            <td>${orderrow.productMo}</td>
			            <td>${orderrow.porderCcheck}</td>
			            <td>${orderrow.porderPcheck}</td>
			            <td>${orderrow.porderPused}</td>
			            <td>${orderrow.couponNo}</td>
			            <td>${orderrow.productStatus}</td>
			            <td>${orderrow.porderPay}</td>
			            <td>${orderrow.porderDtotal}</td>
			            <td>${orderrow.porderPstatus}</td>
			            <td>${orderrow.porderGcheck}</td>
			            <td>${orderrow.doptionNo}</td>
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
		    <form action="/order/cancel" method="post">
		        <label for="orderId">주문 ID:</label>
		        <input type="text" id="orderId" name="orderId" required><br>
		        <button type="submit">주문 취소</button>
		    </form>
	<button type="button" id="btnList">상품 목록</button>
</body>
</html>