<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<form action="${pageContext.request.contextPath}/uuser/join" name = "join">
	<table>
		<tr>
			<td>ID</td>
			<td>
				<input type="text" name = "uuserId" autocomplete="off" id="uuserId">
				<input type="button" value="중복체크" onclick="checkId(this.form)"><br>
				<span id="check"></span>
			</td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input type="password" name = "uuserPassword"></td>
		</tr>
		<tr>
			<td>rePW</td>
			<td><input type="password" name = "repw"></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name = "uuserName"  autocomplete="off"></td>
		</tr>
		<tr>
			<td>NickName</td>
			<td><input type="text" name = "uuserNickname"  autocomplete="off"></td>
		</tr>
		<tr>
			<td>E-Mail</td>
			<td><input type="text" name = "uuserEmail"></td>
		</tr>
		<tr>
			<td>PHONE</td>
			<td>
				<input name = "uuserPhone">
			</td>
		</tr>
		<tr>
			<td >
				<input type="radio" name="uuserGender" id="male" value="1">
				<label for="male" class="gender_text">남자</label>
				<input type="radio" name="uuserGender" id="female" value="2">
				<label for="female" class="gender_text">여자</label>
			</td>
		</tr>
	
		<tr>
			<td  colspan="2">
				<input type="checkbox" name="uuserEcheck" value="1">E-mail 수신 동의
				&nbsp
				<input type="checkbox" name="uuserScheck" value="1">SMS 수신 동의
			</td>
		</tr>
		<tr>
			<td rowspan="2" colspan="2" align="right">
				<input type="button" id="join" value="Join" disabled="disabled" onclick="javascript:checkJoin()">
				<input type="button" value="Reset" onclick="document.join.reset()">
			</td>
		</tr>
	</table>
</form>
<script>
	
	const idTag = document.getElementById('uuserId');
	//const pwTag = document.getElementById('password');
	const regID = /^[A-Za-z0-9]{8,15}$/;
	//const regPW = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8.20}$/;
	
	
	
	function checkJoin(){
		if(document.join.uuserId.value == ""){
			alert("아이디를 입력하십시오!");
		}else if(!regID.test(idTag.value)){
			alert("8~15사이의 아이디를 입력하십시오");
		}else if(document.join.uuserPassword.value == ""){
			alert("비밀번호를 입력하십시오!");
		}
		/* else if(!regPW.test(pwTag.value)){
			alert("숫자', '문자', '특수문자' 무조건 1개 이상, 비밀번호 '최소 8자이상");
		} */
		else if(document.join.repw.value == ""){
			alert("비밀번호확인을 입력하십시오!");
		}else if(document.join.uuserName.value == ""){
			alert("이름을 입력하십시오!");
		}else if(document.join.uuserNickname.value == ""){
			alert("닉네임을 입력하십시오!");
		}else if(document.join.uuserEmail.value == ""){
			alert("이메일을 입력하십시오!");
		}else if(document.join.uuserPhone.value == ""){
			alert("전화번호를 입력하십시오!");
		}else if(!(document.join.uuserGender.value == 1 || document.join.uuserGender.value == 2)){
			alert("성별을 선택하십시오!");
		}else if(document.join.uuserPassword.value != document.join.repw.value){
			alert("비밀번호가 일치하지 않습니다.");
		}else{
			document.join.submit();
		}
	}
	
	function checkId(f) {
		if(f.uuserId.value == ""){
			alert("아이디를 입력하십시오!");
			return;
		}
		if(!regID.test(idTag.value)){
			alert("8~15사이의 아이디를 입력하십시오");
			return;
		}
		
		
		var url = "${pageContext.request.contextPath}/uuser/checkId";
		var param = "id=" + encodeURIComponent(f.uuserId.value);
		
		sendRequest(url,param,resultFn,"POST");
	}
	
	function resultFn(){
		if(xhr.readyState==4 && xhr.status==200) {
			//도착된 데이터를 읽어오기
			var data = xhr.responseText;
			const join = document.getElementById("join");
			const check = document.getElementById('check');
			const id = document.getElementById('uuserId');
			
			check.innerText = '';
			
			if(data === '사용 가능한 ID입니다'){
				check.style.cssText="color: blue; font-size: 10px;";
				join.disabled=false;
			}else{
				check.style.cssText="color: red; font-size: 10px;";	
				join.disabled=true;
			}
			
			check.innerText = data;
		}
	}

</script>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>



