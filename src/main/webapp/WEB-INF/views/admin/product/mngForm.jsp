<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/admin/layout/header.jsp" %>
<form action="/${pageContext.request.contextPath}admin/product/insert" id="insertProductForm" name="insertProductForm" enctype="multipart/form-data" method="post">
	<h2>상품 등록</h2>
	<table>
		<tr>
			<td>상품명</td>
			<td><input type="text" name = "productName" id="productName"></td>
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
			<td><input type="text" name = "productTag1" id="productTag1"></td>
		</tr>
		<tr>
		  	<td>상품 태그2</td>
			<td><input type="text" name = "productTag2" id="productTag2"></td>
		</tr>
		<tr>
			<td>상품 소개</td>
			<td><input type="text" name = "productIntro" id="productIntro"></td>
		</tr>
		<tr>
			<td>할인</td>
			<td><input type="text" name = "productDiscount" id="productDiscount"></td>
		</tr>
		<tr>
			<td>판매가</td>
			<td><input type="text" name = "productPrice" id="productPrice"></td>
		</tr>
		<tr>
			<td>수정 날짜</td>
			<td><input type="text" name = "productUpdate" id="productUpdate"></td>
		</tr>
		<tr>
			<td>카테고리</td>
			<td><input type="text" name = "productCategory" id="productCategory"></td>	
<!-- 				<select name = "categoryProducttype">
					<option value="0">--대분류--</option>
					<option value="1">주류</option>
					<option value="2">비주류</option>
				</select>
				<select name = "catedetailSection ">
					<option value="0_position">--중분류--</option>
					<option value="c_position">술잔</option>
					<option value="b_position">선물세트</option>
					<option value="a_position">술</option>					
				</select>
				<select name = "soolType ">
					<option value="0_position">--소분류--</option>
					<option value="c_position">탁주</option>
					<option value="b_position">증류주</option>
					<option value="a_position">과실주</option>					
				</select> -->
			</td>
			<tr>
				<td>찜</td>
				<td><input type="text" name = "productWish" id="productWish"></td>
			</tr>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" id ="insertBtn" value="insert">
				<input type="button" id ="listBtn" value="list">
				<input type="button" value="Reset" onclick="document.insertProductForm.reset()">
			</td>
		</tr>
	</table>
</form>	


	
	
	<h3>상품 옵션</h3>
	<table>
		<tr>
			<td>상품옵션</td>
			<td><input type="text" name = "sooltype_no "></td>
		</tr>
		<tr>	
			<td>상품옵션 번호</td>
			<td><input type="text" name = "sooltype_no "></td>
		</tr>
		<tr>
			<td>상품 옵션명</td>
			<td><input type="text" name = "sooltype_no "></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" id ="insert" disabled="disabled" value="Insert" onclick="document.insert.submit()">
				<input type="button" value="Reset" onclick="document.insert.reset()">
			</td>
		</tr>
	</table>
	

	<h3>제조사 정보</h3>
	<table>
			<tr>
				<td>제조사 고유번호</td>
				<td><input type="text" name = "mcompany_no"></td>
			</tr>
			<tr>
				<td>제조국가</td>
				<td><input type="text" name = "mcompany_nation"></td>
			</tr>
			<tr>
				<td>제조사 전화번호</td>
				<td><input type="text" name = "mcompany_phone"></td>
			</tr>
			<tr>
				<td>제조사명</td>
				<td><input type="text" name = "mcompany_email"></td>
			</tr>
			<tr>
				<td>담당자 이메일</td>
				<td><input type="text" name = "mcompany_name"></td>
			</tr>
			<tr>
				<td>제조사명</td>
				<td><input type="text" name = "mcompany_mailordernum"></td>
			</tr>
			<tr>
				<td>제조사 주소</td>
				<td><input type="text" name = "mcompany_address"></td>
			</tr>
			<tr>
				<td>사업자 등록번호</td>
				<td><input type="text" name = "mcompany_registrationnum"></td>
			</tr>
			<tr>
				<td>제조사 대표명</td>
				<td><input type="text" name = "mcompany_ceoname"></td>
			</tr>
			<tr>
				<td>양조장 스토리</td>
				<td><input type="text" name = "mcompany_story"></td>
			</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" id ="insert" disabled="disabled" value="Insert" onclick="document.insert.submit()">
				<input type="button" value="Reset" onclick="document.insert.reset()">
			</td>
		</tr>
	</table>
	
	<h3>제조사 브랜드</h3>
	<table>
		<tr>
			<td>브랜드 고유 번호</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td>브랜드 소속 회사</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td>브랜드명</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		
		<tr>
			<td colspan="2" align="right">
				<input type="submit" id ="insert" disabled="disabled" value="Insert" onclick="document.insert.submit()">
				<input type="button" value="Reset" onclick="document.insert.reset()">
			</td>
		</tr>
	</table>
	
	<h3>식품 원재료 정보</h3>
	<table>
		<tr>
			<td>식품 정보 고유 번호</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td>식품 원재료명</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td>상품 번호</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td>식품 용량</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		
		<tr>
			<td>식품 용량 단위</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		
		<tr>
			<td colspan="2" align="right">
				<input type="submit" id ="insert" disabled="disabled" value="Insert" onclick="document.insert.submit()">
				<input type="button" value="Reset" onclick="document.insert.reset()">
			</td>
		</tr>
	</table>
	
	<h3>제품 정보</h3>
	<table>
		<tr>
			<td>제품 정보 번호</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td>상품 번호</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td>재질</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td>구성</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td>유통기한</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td>수입신고</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td>제품 품질 보증 정보</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		
		<tr>
			<td colspan="2" align="right">
				<input type="submit" id ="insert" disabled="disabled" value="Insert" onclick="document.insert.submit()">
				<input type="button" value="Reset" onclick="document.insert.reset()">
			</td>
		</tr>
	</table>
	
	<h3>유통기한</h3>
	<table>
		<tr>
			<td>유통기한 고유 번호</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td>유통기한</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		
		<tr>
			<td colspan="2" align="right">
				<input type="submit" id ="insert" disabled="disabled" value="Insert" onclick="document.insert.submit()">
			</td>
		</tr>
		
	</table>
	
	<h3>재고관리</h3>
	<table>
		<tr>
			<td>재고 관리코드</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td>재고수량</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
	</table>
	
	<h3>용량</h3>
		<table>
		<tr>
			<td>용량 관리코드</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td>용량</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td>단위</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" id ="insert" disabled="disabled" value="Insert" onclick="document.insert.submit()">
				<input type="button" value="Reset" onclick="document.insert.reset()">
			</td>
		</tr>
	</table>
	
	<h3>보관방법</h3>
		<table>
		<tr>
			<td>보관 관리코드</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td>보관방법</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" id ="insert" disabled="disabled" value="Insert" onclick="document.insert.submit()">
				<input type="button" value="Reset" onclick="document.insert.reset()">
			</td>
		</tr>
	</table>
	
	<h3>패키지 구성</h3>
			<table>
		<tr>
			<td>패키지 관리코드</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td>패키지명</td>
			<td><input type="text" name = "mcompany_story"></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" id ="insert" disabled="disabled" value="Insert" onclick="document.insert.submit()">
				<input type="button" value="Reset" onclick="document.insert.reset()">
			</td>
		</tr>
	</table>
	
	<h3>필터</h3>
		<h2>고정필터</h2>
		<table>
			<tr>
				<td>필터번호</td>
				<td><input type="text" name = "mcompany_story"></td>
			</tr>
			<tr>
				<td>필터명</td>
				<td><input type="text" name = "mcompany_story"></td>
			</tr>
			<tr>
				<td>필터 내용</td>
				<td><input type="text" name = "mcompany_story"></td>
			</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" id ="insert" disabled="disabled" value="Insert" onclick="document.insert.submit()">
				<input type="button" value="Reset" onclick="document.insert.reset()">
			</td>
		</tr>
		</table>
		<h2>가변필터</h2>
		<table>
			<tr>
				<td>필터번호</td>
				<td><input type="text" name = "mcompany_story"></td>
			</tr>
			<tr>
				<td>필터명</td>
				<td><input type="text" name = "mcompany_story"></td>
			</tr>
			<tr>
				<td>필터 내용</td>
				<td><input type="text" name = "mcompany_story"></td>
			</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" id ="insertBtn" disabled="disabled" value="Insert" onclick="document.insert.submit()">
				<input type="button" value="list" onclick="document.insert.reset()">
			</td>
		</tr>
		</table>
	
</form>

<h3>카테고리 대/중/소 관리</h3>
	<table id="mainCategory">
		<tr>
			카데고리
		</tr>
		<tr>
			<td>카데고리 고유 번호  </td>
			<td><input type="text" name = "category_no  "></td>
		</tr>
		<tr>
			<td>상품타입</td>
			<td><input type="text" name = "category_producttype  "></td>
		</tr>
		<tr>	
			<td>상품 상세  </td>
			<td><input type="text" name = "catedetail_no "></td>
		</tr>
		<tr>
			<td>주류 타입 번호 </td>
			<td><input type="text" name = "sooltype_no "></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" id ="insert" disabled="disabled" value="Insert">
			</td>
		</tr>
	</table>
	
	<h3>카테고리 상세</h3>
	<table>
		<tr>
			<td>상품 분류 catedetail </td>
		</tr>
		<tr>
			<td>카테 상세 고유 번호</td>
			<td><input type="text" name = "catedetail_no "></td>
		</tr>
		<tr>
			<td>카테 상세</td>
			<td><input type="text" name = "catedetail_section "></td>
		</tr>
		<tr>
			<td>카테 상세명</td>
			<td><input type="text" name = "catedetail_name "></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" id ="insert" value="Insert" onclick="document.insert.submit()">
				<input type="button" value="Reset" onclick="document.insert.reset()">
			</td>
		</tr>
	</table>
	
	<h3>주류 타입</h3>
	<table>
		<tr>
			<td>주류 타입 Sool type</td>
			<td><input type="text" name = "sooltype_no "></td>
		</tr>
			<td>주류 코드</td>
			<td><input type="text" name = "sooltype_no "></td>
		<tr>
			<td>주류 타입</td>
			<td><input type="text" name = "sooltype_name "></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" id ="insert" disabled="disabled" value="Insert" onclick="document.insert.submit()">
				<input type="button" value="Reset" onclick="document.insert.reset()">
			</td>
		</tr>
	</table>
<!--
<script type="text/javascript">
	//상품 등록 유효성 검사
	
	
	
	 $("insertProductForm").click(function(f){
		var productNo = $("productNo").val();
		var productName =$("productName").val();
		var productImg =$("productImg").val();
		var productTag1 =$("productTag1").val();
		var productTag2 =$("productTag2").val();
		var productIntro =$("productIntro").val();
		var productDiscount =$("productDiscount").val();
		var productPrice =$("productPrice").val();
		var productUpdate =$("productUpdate").val();
		var productCategory =$("productCategory").val();

		if(productNo == "") {
			alert("상품 고유 번호를 입력해 주세요.");
			$("productNo").focus();
		}else if(productName == "") {
			alert("상품명을 입력해 주세요.");
			$("productName").focus();
		}else if(productImg == "") {
			alert("상품 이미지를 입력해 주세요.");
			$("productImg").focus();
		}else if(productTag1 == "") {
			alert("상품 태그1을 입력해 주세요.");
			$("productTag1").focus();
		}else if(productTag2 == "") {
			alert("상품 태그2를 입력해 주세요.");
			$("productTag2").focus();
		}else if(productIntro == "") {
			alert("상품 소개를 입력해 주세요.");
			$("productIntro").focus();
		}else if(productDiscount == "") {
			alert("상품 할인가를 입력해 주세요.");
			$("productDiscount").focus();
		}else if(productPrice == "") {
			alert("상품 판매가를 입력해 주세요.");
			$("productPrice").focus();
		}else if(productCategory == "") {
			alert("상품 카테고리를 입력해 주세요.");
			$("productCategory").focus();
		}
		
		document.insertProductForm.action = "${pageContext.request.contextPath}/admin/product/insert";
		document.insertProductForm.submit();
	
		$("#listBtn").click(function(f){
		location.href='${pageContext.request.contextPath}/admin/product/list.jsp';
		});

</script>
  
<script type="text/javascript">

   function readURL(input) {
      var file = input.files[0] 
      console.log(file)
      if (file != '') {
         var reader = new FileReader();
         reader.readAsDataURL(file);
         reader.onload = function (e) { 
	     console.log(e.target)
		console.log(e.target.result)
           $('#preview').attr('src', e.target.result);
          }
      }
  }  
</script>
-->
<%@ include file="/WEB-INF/views/admin/layout/footer.jsp" %>











