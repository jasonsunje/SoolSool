<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<form action="${pageContext.request.contextPath}/uuser/joinform" name="check" id="check" method="post">
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
</form>
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