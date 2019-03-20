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
			<p class=title>교회소식</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<form action="insertChurchNews.do" method="post">
		<div class="apply_wrap">
			<div class="apply">
				<table>
					<colgroup>
						<col width="15%">
						<col width="*">
					</colgroup>	
					<tbody>
						<tr>
							<td><label for="wPA">작성자</label></td>
							<td>${sessionScope.loginUser.MEMBER_NAME }<input type="hidden" name="MEMBER_NO" value="${sessionScope.loginUser.MEMBER_NO}"></td>
						</tr>
						<tr>
							<td><label for="wPA_Dep">제목</label></td>
							<td><input type="text" id="wPA_title" name="BOARD_TITLE" class="title" placeholder="제목 작성"/></td>
						</tr>
						<tr>
							<td><label for="wPA_context">내용</label></td>
							<td><textarea id="wPA_context" name="BOARD_CONTENT"  placeholder="내용 작성"></textarea></td>
							<script type="text/javascript">
							CKEDITOR.replace('wPA_context',
									{height: 300});
							</script>
						</tr>
					</tbody>
				</table>
				<button type="submit" class="apply_btn">등록</button>
			</div>
		</div>
	</form>
	
	
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>