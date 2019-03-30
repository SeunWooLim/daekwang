<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>

<jsp:include page="../common/header.jsp"/>
<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>새가족소개</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<div class="photo_wrap">
		<c:if test="${sessionScope.loginUser ne null}">
			<div class="insertBtn_wrap">
				<a href="newFamilyIntroducingInsert.do" class="newInsertBtn">글쓰기</a>
			</div>
		</c:if>
		
		<ul class="photo_list">
			<c:forEach var="newFamily" items="${list }">
				<li>
					<div class="photo_top">
						<ul>
							<li>${newFamily.BOARD_TITLE }</li>
							<li>${newFamily.RECENT_UPDATE_DATE }</li>
						</ul>
					</div>
					<div class="photo_mid">
						<ul>
							<li><img alt="" src="<c:url value="/"/>resources/uploadPhoto/${newFamily.photoVo.PHOTO_RENAME}"></li>
						</ul>
					</div>
					<div class="photo_bot">
						${newFamily.BOARD_CONTENT }
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	
	
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>


</html>