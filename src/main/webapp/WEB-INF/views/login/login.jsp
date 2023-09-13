<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function check(f) {
		if(f.uuserId.value == ""){
			alert("ID를 입력하십시오!");
			f.id.focus();
			return false;
		}else if(f.uuserPassword.value == ""){
			alert("PW를 입력하십시오!");
			f.password.focus();
			return false;
		}
		
		return true;
	}
	
	
	
	
	
	
	
</script>
<%-- <%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<div align="center">
		<form action="${ pageContext.request.contextPath }/login/check" method="post" onsubmit="return check(this)">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="uuserId" value="${id }"></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" name="uuserPassword"></td>
				</tr>
				<tr>
					<th colspan="2" align="right">
						<span class="ckid">
							<c:choose>
								<c:when test="${check }">
									<input type="checkbox" name="ckid" value="true" checked="checked">
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="ckid" value="true">
								</c:otherwise>
							</c:choose>
							<font class="ckid_text">아이디 기억하기</font>
						</span>
						<input type="submit" value="Login">
					</th>
				</tr>
			</table>
		</form>
	</div>
	<a href="${ pageContext.request.contextPath }/login/findform?mode=id">ID찾기</a> | 
	<a href="${ pageContext.request.contextPath }/login/findform?mode=pw">PW재설정</a> 

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
 --%>
 
 <!DOCTYPE html>
<!-- Coding By CodingNepal - www.codingnepalweb.com -->
<html lang="ko">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>술술🍶</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/login.css">
  </head>
  <body>
    <div class="container flex">
      <div class="sool-page flex">
        <div class="text">
          <h1>Soolsool</h1>
          <p>기분이 술술 풀리다, 술술 </p>
        </div>
        <form action="${ pageContext.request.contextPath }/login/check" method="post" onsubmit="return check(this)">
          <input type="text" name="uuserId" value="${id }" placeholder="id를 입력해 주세요" >
          <input type="password" name="uuserPassword" placeholder="Password를 입력해 주세요." >

          <div class="remember-id">
            <span class="ckid">
                <input type="checkbox" id="ckidCheckbox">
                <label for="ckidCheckbox">아이디 기억하기</label>
            </span>
          </div>
          &nbsp;
          <div class="link">
            <button type="submit" class="login">로그인</button>
          </div>
 
          <hr>
          <div class="button">
            <a href="${pageContext.request.contextPath }/uuser/joincheck">회원가입</a>
          </div>
          <div class="linforgot">
            <a href="${ pageContext.request.contextPath }/login/findform?mode=id" class="forgot" id="forgot">아이디 찾기</a>
            <a href="${ pageContext.request.contextPath }/login/findform?mode=pw" class="forgot" id="forgot">비밀번호 찾기</a>
          </div>
        </form>
      </div>
    </div>
  </body>
</html>
<script>
// 테스트
	 window.onload = function () {

	        var ckidCheckbox = document.getElementById("ckidCheckbox");

	        var rememberedValue = localStorage.getItem("rememberedValue");
	        if (rememberedValue === "true") {
	            ckidCheckbox.checked = true;
	        } else {
	            ckidCheckbox.checked = false;
	        }

	        ckidCheckbox.addEventListener("change", function () {
	            if (ckidCheckbox.checked) {
	                localStorage.setItem("rememberedValue", "true");
	            } else {
	                localStorage.setItem("rememberedValue", "false");
	            }
	        });
	    };
	    
</script>