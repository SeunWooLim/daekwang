<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>

<jsp:include page="../common/header.jsp"/>
<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>교회사진</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<!-- 변수 setting -->
	<c:set var="tableNum" value="${tableNum}"/>
	<c:set var="pageNum" value="${startPage }"/>
	<%  
		int rowNum = 1; 
		String tableNum = pageContext.getAttribute("tableNum").toString();
		int num = Integer.parseInt(tableNum);
		String cp = pageContext.getAttribute("pageNum").toString();
		int pageNum = Integer.parseInt(cp);
	%>
	
	<div class="photo_wrap photo_wrap_new">
		<c:if test="${sessionScope.loginUser ne null}">
			<div class="insertBtn_wrap">
				<a href="churchPhotoInsert.do" class="newInsertBtn">글쓰기</a>
			</div>
		</c:if>
		
		<ul class="photo_list_new" id="churchPhoto">
			<c:forEach var="churchPhoto" items="${list}">
				<li>
					<c:url var="detail" value="churchPhotoDetail.do">
						<c:param name="BOARD_NO" value="${churchPhoto.BOARD_NO}" />
						<c:param name="BOARD_TITLE" value="${churchPhoto.BOARD_TITLE}" />
						<c:param name="BOARD_CONTENT" value="${churchPhoto.BOARD_CONTENT}" />
						<c:param name="RECENT_UPDATE_DATE" value="${churchPhoto.RECENT_UPDATE_DATE}"/>
						<c:param name="MEMBER_NO" value="${churchPhoto.MEMBER_NO }"/>
						<c:param name="currentPage" value="${currentPage }"/>
					</c:url>
					<a href="${detail }"> 
						<span class="title tddd">${churchPhoto.BOARD_TITLE}</span>
						<!-- 카페24경로 -->
						<%-- <img src="<c:url value="/upload/${churchPhoto.UPLOAD_YYMM}/${churchPhoto.PHOTO_IMAGE1 }"/>"> --%>
						<!-- 로컬서버 경로 -->
						<img src="<c:url value="/resources/uploadChurch/${churchPhoto.PHOTO_IMAGE1 }"/>">
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>
	
	<!-- 페이지 네이션 -->
	<div class=paging_wrap>
		<ul class="board_page">
			<li>
				<c:url var="first" value="churchPhotoNew.do">
					<c:param name="currentPage" value="1" />
				</c:url>
				<a href="${first }">&lt;&lt;</a>
			</li>
			<li>
				<c:url var="prev" value="churchPhotoNew.do">
					<c:param name="currentPage" value="${currentPage}" />
					<c:param name="prev" value="1" />
				</c:url>
				<a href="${prev }">&lt;</a>
			</li>
			<c:forEach var="p" begin="${startPage }" end="${endPage }" step="1">
				<li>
					<c:url var="page" value="churchPhotoNew.do">
						<c:param name="currentPage" value="${p }" />
					</c:url>
					<a href="${page }" id="pageNum<%=pageNum++ %>" class="">${p }</a>
				</li>
			</c:forEach>
			<li>
				<c:url var="next" value="churchPhotoNew.do">
					<c:param name="currentPage" value="${currentPage }" />
					<c:param name="next" value="1" />
				</c:url>
				<a href="${next }">&gt;</a>
			</li>
			<li>
				<c:url var="last" value="churchPhotoNew.do">
					<c:param name="currentPage" value="${maxPage }" />
				</c:url>
				<a href="${last }">&gt;&gt;</a>
			</li>
		</ul>
	</div>
</div>

<jsp:include page="../common/footer.jsp"/>
</body>
<script type="text/javascript">

	/* 현재 페이지 'on' addClass */
	$(document).ready(function(){
		var currentPageNum = '${currentPage}';
		var pageNum = $('#pageNum'+currentPageNum);
		pageNum.addClass('on');
	})
	
</script>
</html>