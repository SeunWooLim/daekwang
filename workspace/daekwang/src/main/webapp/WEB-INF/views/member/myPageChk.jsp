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
	
	<div class="join_form join_chk_form">
			<p>회원정보 수정을 위해 비밀번호를 입력해주세요.</p>
			<form method="post" action="">
				<table>
					<colgroup>
						<col width="20%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<td><label for="user_pw">현재 비밀번호</label></td>
							<td><input type="password" id="currentpwd" name="MEMBER_PWD"><p id="enrollpwdtxt" style="display: inline-block; margin-left:10px;" ></p></td>
						</tr>
						
					</tbody>
				</table>
				<button type="submit" id="signupbtn" class="button" disabled="disabled">확인</button>
			</form>
		</div>	
	</div>

<jsp:include page="../common/footer.jsp"/>
 

</body>

</html>