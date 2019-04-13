<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>


<!-- 밑에 두가지 방법 중 하나 이용 -->
<jsp:include page="../common/header.jsp"/>
<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>My Page</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<div class="join_form">
			<form method="post" action="enroll.do">
				<table>
					<colgroup>
						<col width="20%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<td><label for="user_id">아이디</label></td>
							<td>${member.MEMBER_ID }</td>
						</tr>						
						<tr>
							<td><label for="user_pw">현재 비밀번호</label></td>
							<td><input type="password" id="currentpwd" name="MEMBER_PWD"><p id="enrollpwdtxt" style="display: inline-block; margin-left:10px;" ></p></td>
						</tr>
						<tr>
							<td><label for="user_pw">새 비밀번호</label></td>
							<td><input type="password" id="ernollpwd" name="MEMBER_NEWPWD" oninput="checkPwd()" placeholder="영문, 숫자 8~14자리 조합"><p id="enrollpwdtxt" style="display: inline-block; margin-left:10px;" ></p></td>
						</tr>
						<tr>
							<td><label for="user_pwc">새 비밀번호확인</label></td>
							<td><input type="password" id="confirmpwd" name="MEMBER_NEWPWD2" oninput="checkPwd()" placeholder="영문, 숫자 8~14자리 조합"><p id="confirmpwdtxt" style="display: inline-block; margin-left:10px;" ></p></td>
						</tr>
						<tr>
							<td><label for="user_name">이름</label></td>
							<td>${member.MEMBER_NAME }</td>
						</tr>
						<tr>
							<td><label for="address">주소</label></td>
							<td class="add">
								<input type="text" id="postcode" name="MEMBER_POSTCODE" placeholder="우편번호" value="${member.MEMBER_POSTCODE }" readonly>
								<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
								<input type="text" id="address" name="MEMBER_ADDR" placeholder="주소" value="${member.MEMBER_ADDR }" readonly><br>
								<input type="text" id="detailAddress" name="MEMBER_ADDR_DETAIL" placeholder="상세주소" value="${member.MEMBER_ADDR_DETAIL }" oninput="checkAddr()">
								<input type="text" style="width:89%" id="extraAddress" name="MEMBER_ADDR_EXTRA" placeholder="참고항목" value="${member.MEMBER_ADDR_EXTRA }" readonly>
								<p id="addrtxt" style="display: inline-block; margin-left:10px;" ></p>
							</td>
						</tr>
						<tr>
							<td><label for="email">이메일</label></td>
							<td>
								<input type="text" id="email1" name="email1" value="${map.email1 }">
								@
								<input type="text" id="email2" name="email2" value="${map.email2 }">
								<select id="email3" name="email3">
									<option value="">직접입력</option>								
									<option value="naver.com">naver.com</option>								
									<option value="gmail.com">gmail.com</option>								
									<option value="daum.net">daum.net</option>								
									<option value="nate.com">nate.com</option>
									<option value="hanmail.net">hanmail.net</option>	
									<option value="hotmail.com">hotmail.com</option>	
									<option value=korea.com>korea.com</option>									
								</select>
							</td>
						</tr>
						<tr>
							<td><label for="phone2">전화번호</label></td>
							<td class="call">
								<select id="phone1" name="phone1">
									<c:choose>
										<c:when test="${map.phone1 eq '011' }">
											<option value="010">010</option>								
											<option value="011" selected="selected">011</option>								
											<option value="016">016</option>								
											<option value="017">017</option>								
											<option value="018">018</option>								
											<option value="019">019</option>								
										</c:when>
										<c:when test="${map.phone1 eq '016' }">
											<option value="010">010</option>								
											<option value="011">011</option>								
											<option value="016" selected="selected">016</option>								
											<option value="017">017</option>								
											<option value="018">018</option>								
											<option value="019">019</option>								
										</c:when>
										<c:when test="${map.phone1 eq '017' }">
											<option value="010">010</option>								
											<option value="011">011</option>								
											<option value="016">016</option>								
											<option value="017" selected="selected">017</option>								
											<option value="018">018</option>								
											<option value="019">019</option>								
										</c:when>
										<c:when test="${map.phone1 eq '018' }">
											<option value="010">010</option>								
											<option value="011">011</option>								
											<option value="016">016</option>								
											<option value="017">017</option>								
											<option value="018" selected="selected">018</option>								
											<option value="019">019</option>								
										</c:when>
										<c:when test="${map.phone1 eq '019' }">
											<option value="010">010</option>								
											<option value="011">011</option>								
											<option value="016">016</option>								
											<option value="017">017</option>								
											<option value="018">018</option>								
											<option value="019" selected="selected">019</option>								
										</c:when>
										<c:otherwise>
											<option value="010" selected="selected">010</option>								
											<option value="011">011</option>								
											<option value="016">016</option>								
											<option value="017">017</option>								
											<option value="018">018</option>								
											<option value="019">019</option>
										</c:otherwise>
									</c:choose>
								</select>
								-
								<input type="text"  style="width:27%"  id="phone2" name="phone2"  oninput="checkPhone()" value="${map.phone2 }">
								-
								<input type="text"  style="width:27%"  id="phone3" name="phone3"  oninput="checkPhone()" value="${map.phone3 }">
								<p id="phonetxt" style="display: inline-block; margin-left:10px;" ></p>
							</td>
						</tr>
					</tbody>
				</table>
				<button type="submit" id="signupbtn" class="button" disabled="disabled">수정</button>
			</form>
		</div>	
	</div>

<jsp:include page="../common/footer.jsp"/>
 
<script type="text/javascript">
	var mail2 = document.getElementById('email2');
	var mail3 = document.getElementById('email3');
	mail3.onchange = function(event){
	        var _val = this.value.trim();
	        mail2.value = _val ;
	}
</script>
 
<script type="text/javascript">
var pwdInputCheck = 0;
var pwdConfirmCheck = 0;
var addrCheck = 0;
var emailCheck = 0;
var phoneCheck = 0;


//재입력 비밀번호 체크하여 가입버튼 비활성화 또는 맞지않음을 알림.
function checkPwd() {
	var regexp1 = /^(?=.*[a-z])(?=.*[0-9]).{8,14}$/;
	var ernollpwd = $('#ernollpwd').val();
	var confirmpwd = $('#confirmpwd').val();
	if (ernollpwd == "") {
		$("#ernollpwd").css("background-color", "#FFCECE");
	} else{	
		if(!regexp1.test(ernollpwd)){
			$("#ernollpwd").css("background-color", "#FFCECE");
			pwdCheck = 0;
			$("#enrollpwdtxt").html("규칙확인").css("color","red");
		}
		else{
			$("#ernollpwd").css("background-color", "#B0F6AC");
			pwdCheck = 1;
			$("#enrollpwdtxt").html("사용가능").css("color","green");
		}
	}	
	
	if (confirmpwd == "") {
		$("#confirmpwd").css("background-color", "white");
	} else {
		$("#confirmpwd").css("background-color", "#B0F6AC");
	}
	
	if (ernollpwd == "" && confirmpwd == "" && ernollpwd.length < 8) {
		$("#confirmpwd").css("background-color", "white");
		$("#ernollpwd").css("background-color", "white");
	} else {
		if (ernollpwd == confirmpwd) {
			$("#confirmpwd").css("background-color", "#B0F6AC");
			pwdConfirmCheck = 1;
			$("#confirmpwdtxt").html("같음").css("color","green");
		} else if (ernollpwd != confirmpwd) {
			$("#confirmpwd").css("background-color", "#FFCECE");
			pwdConfirmCheck = 0;
			$("#confirmpwdtxt").html("다름").css("color","red");
		}
	}
	toggleBtn();
}

//주소 유효성검사
function checkAddr() {
	var postcode = $("#postcode").val();
	var address = $("#address").val();
	var detailAddress = $("#detailAddress").val();

	if (detailAddress == "") {
		addrCheck = 0;
	} else if(postcode !== "" && detailAddress.length > 3){
		addrCheck = 1;
		$("#addrtxt").html("입력완료").css("color","green");
	}
	toggleBtn();
}

//이메일 유효성검사
function checkEmail(){
	var email1 = $('#email1').val();
	var email2 = $('#email2').val();
	var email = email1 + '@' + email2;
	
	if(email1 == "" && email2 == ""){
		$("#email1").css("background-color", "white");
		$("#email2").css("background-color", "white");
	}else{
		var pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		
		if(pattern.test(email)){
			$("#email1").css("background-color", "#B0F6AC");
			$("#email2").css("background-color", "#B0F6AC");
			emailCheck = 1;
			$("#emailtxt").html("사용가능").css("color","green");
		}else{
			$("#email1").css("background-color", "#FFCECE");
			$("#email2").css("background-color", "#FFCECE");
			emailCheck = -1;
			$("#emailtxt").html("사용불가").css("color","red");
		}
	}
	toggleBtn();
}

//휴대폰번호 유효성검사
function checkPhone() {
	var phone1 = $("#phone1").val();
	var phone2 = $("#phone2").val();
	var phone3 = $("#phone3").val();
	var phone = phone1 + phone2 + phone3;
	
	if (phone2 == "" && phone3 == "") {
		$("#phone2").css("background-color", "white");
		$("#phone3").css("background-color", "white");
		phoneCheck = 0;
	} else {
		
		var pattern =  /(01[016789])([1-9]{1}[0-9]{2,3})([0-9]{4})$/;

		if(pattern.test(phone)){
			$("#phone2").css("background-color", "#B0F6AC");
			$("#phone3").css("background-color", "#B0F6AC");
			phoneCheck = 1;
			$("#phonetxt").html("사용가능").css("color","green");
		}else{
			$("#phone2").css("background-color", "#FFCECE");
			$("#phone3").css("background-color", "#FFCECE");
			phoneCheck = -1;
			$("#phonetxt").html("사용불가").css("color","red");
		}
	}
	toggleBtn();
}

//모든 입력값 유효성 검사 확인후 회원가입 버튼 disabled 해체
function toggleBtn() {
	var activeBtn = pwdCheck + pwdConfirmCheck + addrCheck + emailCheck + phoneCheck;
	console.log(activeBtn);
	if (activeBtn == 5) {
		$("#signupbtn").prop("disabled", false);
		$("#signupbtn").css("background-color", "#004157");
	} else {
		$("#signupbtn").prop("disabled", true);
		$("#signupbtn").css("background-color", "#aaaaaa");
	}
}
</script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
        
    }
</script>
</body>

</html>