<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/meta.jsp"/>
</head>
<body>

<!-- 밑에 두가지 방법 중 하나 이용 -->
<jsp:include page="../common/header.jsp"/>

	<div id="wrap">
		<div class="subvisual_wrap">
			<div class="subvisual_text">
				<p class=title>회원가입</p>
				<p class="text">안양대광교회</p>
			</div>
		</div>
		<div class="join_form">
			<form action="">
				<table>
					<colgroup>
						<col width="20%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<td><label for="user_id">아이디</label></td>
							<td><input type="text" id="user_id" name="user_id"><a href="#">중복확인</a></td>
						</tr>
						<tr>
							<td><label for="user_pw">비밀번호</label></td>
							<td><input type="text" id="user_pw" name="user_pw"></td>
						</tr>
						<tr>
							<td><label for="user_pwc">비밀번호확인</label></td>
							<td><input type="text" id="user_pwc" name="user_pwc"></td>
						</tr>
						<tr>
							<td><label for="user_name">이름</label></td>
							<td><input type="text" id="user_name" name="user_name"></td>
						</tr>
						<tr>
							<td><label for="address">주소</label></td>
							<td class="add">
								<input type="text" id="address" name="address"><a href="#">주소찾기</a>
							</td>
						</tr>
						<tr>
							<td><label for="email">이메일</label></td>
							<td>
								<input type="text" id="email" name="email">
								@
								<input type="text" id="email2" name="email2">
								<select name="phone1">
									<option value="1">직접입력</option>								
									<option value="2">naver.com</option>								
									<option value="3">daum.net</option>								
									<option value="4">nate.com</option>								
									<option value="5">gmail.com</option>								
								</select>
							</td>
						</tr>
						<tr>
							<td><label for="phone2">전화번호</label></td>
							<td>
								<select name="phone1">
									<option value="010">010</option>								
									<option value="011">011</option>								
									<option value="016">016</option>								
									<option value="017">017</option>								
									<option value="018">018</option>								
									<option value="019">019</option>								
								</select>
								-
								<input type="text" id="phone2" name="phone2">
								-
								<input type="text" id="phone3" name="phone3">
							</td>
						</tr>
					</tbody>
				</table>
				<button class="button">가입신청</button>
			</form>
		</div>	
	</div>

<jsp:include page="../common/footer.jsp"/>
 
</body>

</html>