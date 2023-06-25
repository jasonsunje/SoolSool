<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file = "/WEB-INF/views/layout/header.jsp" %>
<%@include file = "/WEB-INF/views/layout/myHeader.jsp" %>
<script type="text/javascript">
	function checkReview(){
		if(document.review.content.value == ""){
			alert("내용을 입력해주세요!");
		}else{
			document.review.submit();
		}	
	}
</script>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        
        .product_img {
            width: 80px;
            height: 100px;
        }

        .product {
            margin: 0 auto;
            background-color: aqua;
            width: 1000px;
            height: 120px;
        }

        .review {
            margin: 0 auto;

        }

        .how {
            background-color: blueviolet;
        }

        .star-rating {
            display: flex;
            flex-direction: row-reverse;
            font-size: 2.25rem;
            line-height: 2.5rem;
            justify-content: space-around;
            padding: 0 0.2em;
            text-align: center;
            width: 5em;
        }

        .star-rating input {
            display: none;
        }

        .star-rating label {
            -webkit-text-fill-color: transparent;
            /* Will override color (regardless of order) */
            -webkit-text-stroke-width: 2.3px;
            -webkit-text-stroke-color: #2b2a29;
            cursor: pointer;
        }

        .star-rating :checked~label {
            -webkit-text-fill-color: gold;
        }

        .star-rating label:hover,
        .star-rating label:hover~label {
            -webkit-text-fill-color: #fff58c;
        }

        .content {
            width: 800px;
            height: 200px;
            resize:none;
        }
    </style>
</head>

    <div>
        <div class="review">
            <form action="${pageContext.request.contextPath }/uuser/review" method="post" name ="review">
                <c:if test="${reviewNo != null}">
                	<input type="hidden" name="no" value="${reviewNo}">
                </c:if>
                <div class="product">
                    <table>
                        <tr>
                            <th>제조사</th>
                            <td></td><!-- -->
                        </tr>
                        <tr>
                            <th>제품이름</th>
                            <td></td>
                        </tr>
                        <tr>
                            <th>선택옵션</th>
                            <td></td>
                        </tr>
                    </table>
                </div>
                <div class="star-rating space-x-4 mx-auto">
                    <input type="radio" id="5-stars" name="rating" value="5" v-model="ratings" />
                    <label for="5-stars" class="star pr-4">★</label>
                    <input type="radio" id="4-stars" name="rating" value="4" v-model="ratings" />
                    <label for="4-stars" class="star">★</label>
                    <input type="radio" id="3-stars" name="rating" value="3" v-model="ratings" />
                    <label for="3-stars" class="star">★</label>
                    <input type="radio" id="2-stars" name="rating" value="2" v-model="ratings" />
                    <label for="2-stars" class="star">★</label>
                    <input type="radio" id="1-star" name="rating" value="1" v-model="ratings" />
                    <label for="1-star" class="star">★</label>
                </div>
                <textarea class="content" name="content">

                </textarea>
                <br>
                <input type="file" title="사진첨부">
                <br>
                <button onclick="javascript:checkReview()">리뷰작성</button>
            </form>
        </div>
    </div>
</body>

<%@include file = "/WEB-INF/views/layout/footer.jsp" %>
