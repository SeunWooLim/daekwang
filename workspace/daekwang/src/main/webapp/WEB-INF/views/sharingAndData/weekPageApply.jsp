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
			<p class=title>주보 광고신청</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<form action="insertWeekPage.do" method="post">
		<div class="apply_wrap">
			<div class="apply">
				<table>
					<colgroup>
						<col width="15%">
						<col width="*">
					</colgroup>	
					<tbody>
						<tr>
							<td><label for="wPA">신청자</label></td>
							<td>${sessionScope.loginUser.MEMBER_NAME }<input type="hidden" name="MEMBER_NO" value="${sessionScope.loginUser.MEMBER_NO}"></td>
						</tr>
						<tr>
							<td><label for="wPA_Dep">부서명</label></td>
							<td><input type="text" id="wPA_Dep" name="DEPT_NAME"  placeholder="부서명 작성"/></td>
						</tr>
						<tr>
							<td><label>분류</label></td>
							<td>
								<select name="APPLY_CATE">
									<option value="주보원고">주보원고</option>
									<option value="광고요청">광고요청</option>
								</select>
							</td>
						</tr>
						<tr>
							<td><label for="wPA_context">내용</label></td>
							<td><textarea id="wPA_context" name="APPLY_CONTENT"  placeholder="내용 작성"></textarea></td>
						</tr>
						<tr>
							<td colspan="2" class="point">주보광고신청은 매주 금요일 오후 12시 까지입니다.</td>
						</tr>
					</tbody>
				</table>
				<button type="submit" class="apply_btn">신청하기</button>
			</div>
		</div>
	</form>
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>