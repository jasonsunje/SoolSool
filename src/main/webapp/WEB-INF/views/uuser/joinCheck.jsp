<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<!-- Coding By CodingNepal - www.codingnepalweb.com -->
<html lang="ko">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>술술🍶</title>
    <link rel="icon" href="images/fav.png" type="image/png" sizes="16x16"> 
    <style>
      body {
        font-family: Arial, sans-serif;
        padding: 20px;
        background: #f0f2f5;
      }
      .container {
        max-width: 700px;
        margin: 0 auto;
        background: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
      }
      h1 {
        font-size: 1.5rem;
        color: #333;
        margin-bottom: 20px;
        text-align: center;
      }
      .terms-box {
        max-height: 200px;
        overflow: auto;
        margin-bottom: 20px;
        background-color: rgb(244, 244, 244);
      }

      dt{
        margin-inline-start: 40px;
      }

      dd{
        margin-inline-end: 40px;         
      }

      label {
        display: block;
        margin-bottom: 10px;
      }
      .checkbox-label {
        display: flex;
        justify-content: flex-start; 
        align-items: center;
        padding: 0 10px; 
        border: 1px solid #ddd; 
        border-radius: 6px; 
        margin-bottom: 10px; 
      }
      #allAgree {
        margin-top: 10px;
      }
      #join {
        display: block;
        width: 100%;
        height: 48px;
        padding: 0; 
        background: #ffcc23;
        border: none;
        border-radius: 6px;
        color: #fff;
        font-size: 1.063rem;
        font-weight: 600;
        cursor: pointer;
        transition: 0.2s ease;
        text-align: center;
        line-height: 48px;
     }

  #join:hover {
    background: #d4ac26;
  }
      </style>
  </head>
  <body>
    <div class="container">
    <h1>이용약관 동의</h1>
    <!-- <form id="termsForm"> -->
    <form action="${pageContext.request.contextPath}/uuser/joinform" name="check" id="check" method="post">
      <label id="allAgree">
        <input type="checkbox" id="checkAll" name="selectAll"> 모든 항목 동의
      </label>
      <h4>[필수] 이용약관</h4>
      <div class="terms-box">
        <dl>
          <dt>
              시행일자: 
          </dt>
          <br>
          <dd>
               여러분을 환영합니다. Soolsool 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한
				Soolsool 서비스의 이용과 관련하여 Soolsool 서비스를 제공하는 네이버 주식회사(이하 ‘Soolsool’)와 이를 이용하는 Soolsool 서비스
				회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 Soolsool 서비스 이용에 도움이 될 수 있는 유익한
				정보를 포함하고 있습니다. Soolsool 서비스를 이용하시거나 네이버 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련
				운영 정책을 확인하거나 동의하게 되므로, 잠시 시간을 내시어 주의 깊게 살펴봐 주시기 바랍니다.<br /><br />

              본 개인정보취급방침은 다음과 같은 내용을 담고 있습니다.<br /><br />
          </dd>
        </dl>
      </div>
      <label>
        <input type="checkbox" id="termService" name="es" class="checkVal"> 이용 약관에 동의합니다.
      </label>

      <h4>[필수] 개인정보 수집 및 이용</h4>
      <div class="terms-box">
        <dl>
          <dt>
              시행일자: 
          </dt>
          <br>
          <dd>
             실명 인증된 아이디로 가입, 위치기반서비스 이용약관(선택), 이벤트・혜택 정보 수신(선택) 동의를
				포함합니다.<br /><br />
          </dd>
        </dl>
      </div>
      <label>
        <input type="checkbox" id="termPrivacy" name="es" class="checkVal"> 이용 약관에 동의합니다.
      </label>

      <h4>[선택] 실명 인증된 아이디로 가입</h4>
      <div class="terms-box">
        <dl>
          <dt>
              시행일자: 
          </dt>
          <br>
          <dd>
             실명 인증된 아이디로 가입하시면 본인인증이 필요한 서비스(Soolsool 페이, 쇼핑, 멤버십 등)를 가입 후 바로
				이용하실 수 있어요.<br /><br />
          </dd>
        </dl>
      </div>
      <label>
        <input type="checkbox" id="checkName" name="checkVal" class="checkVal"> 이용 약관에 동의합니다.
      </label>

      <h4>[선택] 위치기반서비스 이용약관</h4>
      <div class="terms-box">
        <dl>
          <dt>
              시행일자: 
          </dt>
          <br>
          <dd>
             위치기반서비스 이용약관에 동의하시면, 위치를 활용한 광고 정보 수신 등을 포함하는 Soolsool 위치기반 서비스를
				이용할 수 있습니다.<br /><br />
          </dd>
        </dl>
      </div>
      <label>
        <input type="checkbox" id="termLocation" name="checkVal" class="checkVal"> 이용 약관에 동의합니다.
      </label>

      <h4>[선택] 이벤트 혜택 정보 수신</h4>
      <div class="terms-box">
        <dl>
          <dt>
              시행일자: 
          </dt>
          <br>
          <dd>
              Soolsool 서비스 및 제휴 이벤트・혜택 등의 정보를 휴대전화(Soolsool앱 알림 또는 문자), 이메일로 받을 수
				있습니다. 일부 서비스(별개의 회원 체계 운영, Soolsool 가입 후 추가 가입하는 서비스 등)의 경우, 수신에 대해 별도로
				안내드리며 동의를 구합니다.<br /><br />
          </dd>
        </dl>
      </div>
      <label>
        <input type="checkbox" id="termEvent" name="checkVal" class="checkVal"> 이용 약관에 동의합니다.
      </label>
      <br>
      <input type="button"
				id="join" value="가입하기" disabled="disabled"
				onclick="javascript:checkJoin()">
    </form>
  </body>
</html>






<%-- <form action="${pageContext.request.contextPath}/uuser/joinform" name="check" id="check" method="post">
	<table>
		<tr>
			<td><input type="checkbox" id="checkAll" name="selectAll"><span>전체
					동의하기</span></td>

		</tr>
		<tr>
			<td>실명 인증된 아이디로 가입, 위치기반서비스 이용약관(선택), 이벤트・혜택 정보 수신(선택) 동의를
				포함합니다.</td>
		</tr>
		<tr>
			<td><input type="checkbox" id="termService" name="es"
				class="checkVal"><span>[필수] 이용약관</span></td>

		</tr>
		<tr>
			<td>여러분을 환영합니다. 네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한
				네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 이를 이용하는 네이버 서비스
				회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한
				정보를 포함하고 있습니다. 네이버 서비스를 이용하시거나 네이버 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련
				운영 정책을 확인하거나 동의하게 되므로, 잠시 시간을 내시어 주의 깊게 살펴봐 주시기 바랍니다.</td>
		</tr>
		<tr>
			<td><input type="checkbox" id="termPrivacy" name="es"
				class="checkVal"><span>[필수] 개인정보 수집 및 이용</span></td>

		</tr>
		<tr>
			<td>실명 인증된 아이디로 가입, 위치기반서비스 이용약관(선택), 이벤트・혜택 정보 수신(선택) 동의를
				포함합니다.</td>
		</tr>
		<tr>
			<td><input type="checkbox" id="checkName" name="checkVal"
				class="checkVal"><span>[선택] 실명 인증된 아이디로 가입</span></td>

		</tr>
		<tr>
			<td>실명 인증된 아이디로 가입하시면 본인인증이 필요한 서비스(네이버 페이, 쇼핑, 멤버십 등)를 가입 후 바로
				이용하실 수 있어요.</td>
		</tr>
		<tr>
			<td><input type="checkbox" id="termLocation" name="checkVal"
				class="checkVal"><span>[선택] 위치기반서비스 이용약관</span></td>

		</tr>
		<tr>
			<td>위치기반서비스 이용약관에 동의하시면, 위치를 활용한 광고 정보 수신 등을 포함하는 네이버 위치기반 서비스를
				이용할 수 있습니다.</td>
		</tr>
		<tr>
			<td><input type="checkbox" id="termEvent" name="checkVal"
				class="checkVal"><span>[선택] 이벤트 혜택 정보 수신</span></td>

		</tr>
		<tr>
			<td>네이버 서비스 및 제휴 이벤트・혜택 등의 정보를 휴대전화(네이버앱 알림 또는 문자), 이메일로 받을 수
				있습니다. 일부 서비스(별개의 회원 체계 운영, 네이버 가입 후 추가 가입하는 서비스 등)의 경우, 수신에 대해 별도로
				안내드리며 동의를 구합니다.</td>
		</tr>
		<tr>
			<td rowspan="2" colspan="2" align="center"><input type="button"
				id="join" value="Join" disabled="disabled"
				onclick="javascript:checkJoin()">
			</td>
		</tr>
	</table>
</form> --%>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script>
	const checkAll = document.getElementById('checkAll');
	const es = document.getElementsByName('es');
	const join = document.getElementById('join');
	
	checkAll.addEventListener('click', function(){
		const isChecked = checkAll.checked;
		
		if(isChecked){
			const checkboxes = document.querySelectorAll('.checkVal');
			
			for(const checkbox of checkboxes){
				checkbox.checked = true;
				checkReq();
			}
		}else{
			const checkboxes = document.querySelectorAll('.checkVal');
			
			for(const checkbox of checkboxes){
				checkbox.checked = false;
				checkReq();
			}
		}
	});
	
	const checkboxes = document.querySelectorAll('.checkVal');
	for(const checkbox of checkboxes){
		checkbox.addEventListener('click', function(){	
			const totalCnt = checkboxes.length;
			const checkedCnt = document.querySelectorAll('.checkVal:checked').length;
			checkReq();
			if(totalCnt == checkedCnt){
				document.querySelector('#checkAll').checked = true;
			}else{
				document.querySelector('#checkAll').checked = false;
			}
		});
	}

	function checkReq(){
		let count = 0;
		es.forEach((obj) => {
			const esLength = es.length;
			if(obj.checked == true){
				count++;
			}
			if(esLength == count){
				join.disabled = false;
			}else{
				join.disabled = true;
			}
			});
		}

	
	function checkJoin(){
		document.check.submit();
	}
	
	
	
	
	
	
</script>