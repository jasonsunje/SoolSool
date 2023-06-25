<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file = "/WEB-INF/views/admin/layout/header.jsp" %>

<form action="${pageContext.request.contextPath}admin/product/update" id="updateProductForm" name="updateProductForm" enctype="multipart/form-data" method="post">
	<h2>상품 수정</h2>
	<table>
		<tr>
			<td>상품 고유 번호</td>
			<td><input type="text" name = "productName" id="productName" disable="true" value="${vo.productNo}"></td>
		</tr>
		<tr>
			<td>상품명</td>
			<td><input type="text" name = "productName" id="productName" value="${vo.productName}"></td>
		</tr>
		<tr>
			<td>상품이미지</td>
			<!-- 파일업로드를 위해서는 반드시 POST타입으로 전송해야 하며, enctype이 필요하다 -->
<!-- 					<input type="file" name="photo"><br>
					<input type="button" value="전송" onclick="send(this.form);"> -->
			<td><input type="file" name = "file" id="productImg"></td>
		</tr>
		<tr>
		  	<td>상품 태그1</td>
			<td><input type="text" name = "productTag1" id="productTag1" value="${vo.productTag1}"></td>
		</tr>
		<tr>
		  	<td>상품 태그2</td>
			<td><input type="text" name = "productTag2" id="productTag2" value="${vo.productTag2}"> </td>
		</tr>
		<tr>
			<td>상품 소개</td>
			<td><input type="text" name = "productIntro" id="productIntro" value="${vo.productIntro}"></td>
		</tr>
		<tr>
			<td>할인</td>
			<td><input type="text" name = "productDiscount" id="productDiscount" value="${vo.productDiscount}"></td>
		</tr>
		<tr>
			<td>판매가</td>
			<td><input type="text" name = "productPrice" id="productPrice" value="${vo.productPrice}"></td>
		</tr>
		<tr>
			<td>수정 날짜</td>
		</tr>
		<tr>
			<td>카테고리</td>
			<td><input type="text" name = "categoryno" id="categoryno" value="${vo.categoryNo}"></td>	

				
		</tr>	
			<td colspan="2" align="right">
					<input type="submit" id ="update" value="update">
					<input type="button" value="Reset" onclick="document.insert.reset()">
			 		<input type="button" value="delete" onclick="deleteProduct(${vo.productNo})">
			 		<input type="button" value = "돌아가기" onclick="location.href='${ pageContext.request.contextPath }/admin/product/list'">
				</td>
		</table>
</form>	
<script>
  function deleteProduct(productNo) {
    if (confirm("정말로 상품을 삭제하시겠습니까?")) {
      location.href = "${pageContext.request.contextPath}/admin/product/delete/" + productNo;
    }
  }
</script>


<%@include file = "/WEB-INF/views/admin/layout/footer.jsp" %>