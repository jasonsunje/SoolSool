<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function checkWrite() {
		if(document.update.reviewContent.value == ""){
			alert("내용을 입력하십시오!");
		}else if(document.update.reviewStar.value == ""){
			alert("별점을 입력하십시오!")
		}else{
			document.update.submit();
		}
	}
</script>
<%@include file = "/WEB-INF/views/layout/header.jsp" %>
  
<div align="center">
	<form action="${ pageContext.request.contextPath }/uuser/rUpdate" method="post" name = "update" >
		<input type="hidden" name="reviewNo" value="${vo.reviewNo }">
		<table class = "reviewTable">
			<tr>
				<input type="file" name="photo" value="${vo.reviewPhoto }"></input>
			</tr>
				<textarea id="summernote" rows="15" cols="65" name="reviewContent" value="${vo.reviewContent }"></textarea>
	
			<tr>
				<th>별점</th>
				 <td class="star-rating space-x-4 mx-auto" >
                    <input type="radio" id="5-stars" name="reviewStar" value="5" v-model="ratings" />
                    <label for="5-stars" class="star pr-4">★</label>
                    <input type="radio" id="4-stars" name="reviewStar" value="4" v-model="ratings" />
                    <label for="4-stars" class="star">★</label>
                    <input type="radio" id="3-stars" name="reviewStar" value="3" v-model="ratings" />
                    <label for="3-stars" class="star">★</label>
                    <input type="radio" id="2-stars" name="reviewStar" value="2" v-model="ratings" />
                    <label for="2-stars" class="star">★</label>
                    <input type="radio" id="1-star" name="reviewStar" value="1" v-model="ratings" />
                    <label for="1-star" class="star">★</label>
                </td>
			</tr>
		</table>
		<div class = "btnBox">
			<input type="button" value="수정" onclick="javascript:checkWrite()">
		</div>
	</form>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		  $('#summernote').summernote();
		});
</script>
<%@include file = "/WEB-INF/views/layout/footer.jsp" %>