<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<form action="${pageContext.request.contextPath}/uuser/join" name="join" id="form">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="uuserId" autocomplete="off"
				id="uuserId" tabindex="1"> <input type="button" value="중복체크"
				onclick="checkId(this.form)"><br> <span id="check"></span>
			</td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input type="password" name="uuserPassword" id="uuserPassword" tabindex="2">
				<br><span id="pwError"></span>
			</td>
		</tr>
		
		<tr>
			<td>rePW</td>
			<td><input type="password" name="repw" id="repw" tabindex="3">
				<br><span id="repwError"></span>
			</td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name="uuserName" autocomplete="off" tabindex="4"></td>
		</tr>
		<tr>
			<td>NickName</td>
			<td><input type="text" name="uuserNickname" id="uuserNickname" autocomplete="off" tabindex="5">
				<br><span id="nickError"></span>
			</td>
		</tr>
		<tr>
			<td>E-Mail</td>
			<td><input type="text" name="uuserEmail" id="uuserEmail" tabindex="6">
				<select class="emailControl" name="uuserEmail2" id="uuserEmail2">					
					<option>직접입력</option>
					<option>@naver.com</option>
					<option>@daum.net</option>
					<option>@gmail.com</option>
					<option>@hanmail.com</option>
					<option>@yahoo.co.kr</option>
				</select>
				<button type="button" class="btnPrimary" id="mailCheckBtn">본인인증</button>
			</td>
		</tr>
		<tr>
			<td>이메일 인증</td>
			<td >
				<input id="mailCheckInput" placeholder="인증번호 6자리를 입력해주세요!" disabled="disabled" maxlength="6" size="30">
				<button type="button" id="mailCheck">인증확인</button>
				<br><span id="mailCheckError"></span>
			</td>
		</tr>
		<tr>
			<td>PHONE</td>
			<td><input name="uuserPhone" tabindex="7"></td>
		</tr>
		<tr>
			<td>
				<input type="radio" name="uuserGender" id="male" value="1" tabindex="8">
				<label for="male" class="gender_text">남자</label>
				<input type="radio" name="uuserGender" id="female" value="2" tabindex="9">
				<label for="female" class="gender_text">여자</label>
			</td>
		</tr>

		<tr>
			<td colspan="2">
				<input type="checkbox" name="uuserEcheck" value="1" tabindex="10">E-mail 수신 동의 &nbsp 
				<input type="checkbox" name="uuserScheck" value="1" tabindex="11">SMS 수신 동의
			</td>
		</tr>
		<tr>
			<td rowspan="2" colspan="2" align="right"><input type="button"
				id="join" value="Join" disabled="disabled"
				onclick="javascript:checkJoin()"> <input type="button"
				value="Reset" onclick="document.join.reset()" tabindex="12"></td>
		</tr>
	</table>
</form>
<script>

	const idTag = document.getElementById('uuserId');
	const pwTag = document.getElementById('uuserPassword');
	const repwTag = document.getElementById('repw');
	//const nickTag = document.getElementById('uuserNickname');
	const emailTag = document.getElementById('uuserEmail');
	const regID = /^[A-Za-z0-9]{8,15}$/;
	const regPW = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;
	//const regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	const form = document.getElementById('form');
	const pwError = document.getElementById('pwError');
    const repwError = document.getElementById('repwError');
	//const nickError = document.getElementByid('nickError');
	const emailError = document.getElementById('emailError');
	const mailCheckBtn = document.getElementById('mailCheckBtn');
	const mailCheckInput = document.getElementById('mailCheckInput');
	const emailTag2 = document.getElementById("uuserEmail2");
	const resultMsg = document.getElementById('mailCheckError');
	const mailCheck = document.getElementById('mailCheck');
	let code;
	
	
	function checkJoin() {
		if (document.join.uuserId.value == "") {
			alert("아이디를 입력하십시오!");
		} else if (!regID.test(idTag.value)) {
			alert("8~15사이의 아이디를 입력하십시오");
		} else if (document.join.uuserPassword.value == "") {
			alert("비밀번호를 입력하십시오!");
		} else if (document.join.repw.value == "") {
			alert("비밀번호확인을 입력하십시오!");
		} else if (document.join.uuserName.value == "") {
			alert("이름을 입력하십시오!");
		} else if (document.join.uuserNickname.value == "") {
			alert("닉네임을 입력하십시오!");
		} else if (document.join.uuserEmail.value == "") {
			alert("이메일을 입력하십시오!");
		} else if (document.join.uuserPhone.value == "") {
			alert("전화번호를 입력하십시오!");
		} else if (!(document.join.uuserGender.value == 1 || document.join.uuserGender.value == 2)) {
			alert("성별을 선택하십시오!");
		} else if (document.join.uuserPassword.value != document.join.repw.value) {
			alert("비밀번호가 일치하지 않습니다.");
		} else {
			document.join.submit();
		}
	}
	

	// 아이디
    
	function checkId(f) {
		if (f.uuserId.value == "") {
			alert("아이디를 입력하십시오!");
			return;
		}
		if (!regID.test(idTag.value)) {
			alert("8~15사이의 아이디를 입력하십시오");
			return;
		}
    
		var url = "${pageContext.request.contextPath}/uuser/checkId";
		var param = "id=" + encodeURIComponent(f.uuserId.value);
    
		sendRequest(url, param, resultFn, "POST");
	}
    
	
	function resultFn() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			//도착된 데이터를 읽어오기
			var data = xhr.responseText;
			const join = document.getElementById("join");
			const check = document.getElementById('check');
			const id = document.getElementById('uuserId');
    
			check.innerText = '';
    
			if (data === '사용 가능한 ID입니다') {
				check.style.cssText = "color: blue; font-size: 10px;";
				join.disabled = false;
			} else {
				check.style.cssText = "color: red; font-size: 10px;";
				join.disabled = true;
			}
			
			check.innerText = data;
		}
	}
	
	// 비밀번호
	
	pwTag.addEventListener("focus",() =>{
		pwError.innerHTML = "'숫자', '문자', '특수문자' 무조건 1개 이상, 비밀번호 '최소 8자이상 작성해주세요";
		pwError.style.cssText = "color: red; font-size: 10px;";
	}); 
		
	pwTag.addEventListener("blur",() => {
		if(pwTag.value == ""){
			pwError.innerHTML = "";
		}else if(!regPW.test(pwTag.value)){
			pwError.innerHTML = "'숫자', '문자', '특수문자' 무조건 1개 이상, 비밀번호 '최소 8자이상 작성해주세요";
			pwError.style.cssText = "color: red; font-size: 10px;";
			//pwTag.focus();
		}else {
			pwError.innerHTML = "";
		}
	});
	
	// 비밀번호 확인
	
	repwTag.addEventListener("blur",() =>{
		if(pwTag.value == ""){
			repwError.innerHTML = "";
		}
		else if(pwTag.value != repwTag.value){
			repwError.innerHTML = "비밀번호가 일치하지 않습니다";
			repwError.style.cssText = "color: red; font-size: 10px;";
			
		}else{
			repwError.innerHTML = "비밀번호가 일치 합니다";
			repwError.style.cssText = "color: blue; font-size: 10px;";
		}
	});
	
	// 이메일 
	

	
	mailCheckBtn.addEventListener("click", ()=>{
		const email = $('#uuserEmail').val() + $('#uuserEmail2').val(); // 이메일 주소값 가져오기
		console.log("완성된 이메일" + email); // 이메일 확인
		
		
		$.ajax({
			type : 'post',
			url : '<c:url value="/uuser/mailCheck?email="/>' + email,
			success : function(data){
				console.log("data : " + data);
				code = data;
				alert("인증번호가 전송되었습니다.");
				mailCheckInput.disabled = false;
			}
		});
	});
	
	mailCheck.addEventListener("click", ()=>{
	
		if(mailCheckInput.value === code){
			resultMsg.innerHTML = "인증번호가 일치합니다";
			resultMsg.style.cssText = "color: blue; font-size: 10px;";
		}else{
			resultMsg.innerHTML = "인증번호가 불일치 합니다. 다시 확인해주세요";
			resultMsg.style.cssText = "color: red; font-size: 10px;";
		}
	});
	
	
	
	
	
	
	
</script>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>



