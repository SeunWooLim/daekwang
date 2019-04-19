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
			<p class=title>교회사진</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<div class="photo_wrap photo_wrap_new">
		<c:if test="${sessionScope.loginUser ne null}">
			<div class="insertBtn_wrap">
				<a href="churchPhotoInsert.do" class="newInsertBtn">글쓰기</a>
			</div>
		</c:if>
		
		<ul class="photo_list_new" id="churchPhoto">
			<li>
				<a href="churchPhotoDetail.do"> 
					<span class="title tddd">제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목</span>
					<img src="<c:url value="/resources/img/main_section1.jpg"/>">
				</a>
			</li>
			<li>
				<a href="#">
					<span class="title tddd">제목</span>
					<img src="<c:url value="/resources/img/main_section1.jpg"/>">
				</a>
			</li>
			<li>
				<a href="#">
					<span class="title tddd">제목</span>
					<img src="<c:url value="/resources/img/main_section1.jpg"/>">
				</a>
			</li>
			
			<li>
				<a href="#">
					<span class="title tddd">제목</span>
					<img src="<c:url value="/resources/img/main_section1.jpg"/>">
				</a>
			</li>
			
			<li>
				<a href="#">
					<span class="title tddd">제목</span>
					<img src="<c:url value="/resources/img/main_section1.jpg"/>">
				</a>
			</li>
			<li>
				<a href="#">
					<span class="title tddd">제목</span>
					<img src="<c:url value="/resources/img/main_section1.jpg"/>">
				</a>
			</li>
			<li>
				<a href="#">
					<span class="title tddd">제목</span>
					<img src="<c:url value="/resources/img/main_section1.jpg"/>">
				</a>
			</li>
			<li>
				<a href="#">
					<span class="title tddd">제목</span>
					<img src="<c:url value="/resources/img/main_section1.jpg"/>">
				</a>
			</li>
			<li>
				<a href="#">
					<span class="title tddd">제목</span>
					<img src="<c:url value="/resources/img/main_section1.jpg"/>">
				</a>
			</li>
		</ul>
	</div>
	<jsp:include page="../common/paging.jsp"/>
</div>

<jsp:include page="../common/footer.jsp"/>
</body>
</html>