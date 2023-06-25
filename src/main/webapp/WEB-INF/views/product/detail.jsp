<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file = "/WEB-INF/views/layout/header.jsp" %>
<div align="center">
	<table id="table">
		<tr>
			<td id="border">상품명</td>
			<td id="productName" name="productName">${vo.productName }</td>
		</tr>
		<tr>
			<td id="border">상품이미지</td>
			<td id="productImg" name="productImg">${vo.productImg }</td>
		</tr>
		<tr>
			<td id="border">상품태그1</td>
			<td id="productTag1" name="productTag1">${vo.productTag1 }</td>
		</tr>
		<tr>
			<td id="border">상품태그2</td>
			<td id="productTag2" name="productTag2">${vo.productTag2 }</td>
		</tr>
		<tr>
			<td id="border">별점</td>
			<td id="productStar" name="productStar">${vo.productStar }</td>
		</tr>
		<tr>
			<td id="border">리뷰개수</td>
			<td id="productRcnt" name="productRcnt">${vo.productRcnt }</td>
		</tr>
		<tr>
			<td id="border">할인가</td>
			<td id="productDiscount" name="productDiscount">${vo.productDiscount }</td>
		</tr>
		<tr>
			<td id="border">소개</td>
			<td id="productIntro" name="productIntro">${vo.productIntro }</td>
		</tr>
		<tr>
			<td id="border">도수</td>
			<td id="productAlcohol" name="productAlcohol">${vo.productAlcohol }</td>
		</tr>
		<tr>
			<td id="border">수정날짜</td>
			<td id="productUpdate" name="productUpdate">${vo.productUpdate}</td>
		</tr>		
		<tr>
			<td id="border">판매가</td>
			<td id="productPrice" name="productPrice">
			<fmt:formatNumber value="${vo.productPrice }" pattern="###,###,###"/></td>
		</tr>	
			<td id="border">찜</td>
			<td id="productWish" name="productWish">${vo.productWish }</td>
		</tr>
		<tr>
			<td id="border">카테고리</td>
			<td id=="categoryNo" name="categoryNo">${vo.categoryNo }</td>
		</tr>	
		<tr>
			<td id="border">패키지</td>
			<td id=="productTag2" name="packageNo">${vo.packageNo }</td>
				<select>
					<ul>--옵션 선택--</ul>
					<ul>단품</ul>
					<ul>선물세트</ul>
				</select>
		</tr>			
		<tr align="center">
			<td colspan="2" align="right"  id="border">
			<form name="cart" method="post" action="${cpath}/cart/insert">
				<input type="hidden" name="productNo" value="${vo.productNo}">
					<td>
						<select name = "cartCnt">
						<c:forEach begin="1" end="10" var="i">
							<option value="${i}">${i}</option>
						</c:forEach>	수량 선택
						</select>&nbsp;개
					</td>
				<input type="submit" value="장바구니에 담기">
			</form>
			</td>
			<td>
			<!-- 주문 form -->
			<form action="/order/detail" method="post" class="order_form">
				<input type="submit" value="주문하기">
			</form>
			</td>
			<a href="#">상품목록</a>
		</tr>
	</table>
</div>
<%@include file = "/WEB-INF/views/layout/footer.jsp" %>