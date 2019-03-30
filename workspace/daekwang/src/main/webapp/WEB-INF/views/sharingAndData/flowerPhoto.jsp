<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>

<jsp:include page="../common/header.jsp"/>
<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>꽃꽃이갤러리</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<div class="photo_wrap">
		<c:if test="${sessionScope.loginUser ne null}">
			<div class="insertBtn_wrap">
				<a href="flowerPhotoInsert.do" class="newInsertBtn">글쓰기</a>
			</div>
		</c:if>
		
		<ul class="photo_list">
			<c:forEach var="flowerPhoto" items="${list }">
				<li>
					<div class="photo_top">
						<ul>
							<li>${flowerPhoto.BOARD_TITLE }</li>
							<li>${flowerPhoto.RECENT_UPDATE_DATE }</li>
						</ul>
					</div>
					<div class="photo_mid">
						<ul>
							<li><img alt="" src="<c:url value="/"/>resources/uploadPhoto/${flowerPhoto.photoVo.PHOTO_RENAME}"></li>
						</ul>
					</div>
					<div class="photo_bot">
						${flowerPhoto.BOARD_CONTENT }
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	
	
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>

<script>
	$(document).ready(function(){
		$(".photo_mid > ul").bxSlider({
			mode: "horizontal",    
			slideMargin: 0,
			minSlides: 1,
			maxSlides: 5,
			moveSlides: 1,
			startSlide: 0,         
			infiniteLoop: true,    
			//captions: true,       
			pager: true,         
			adaptiveHeight: true,   
			auto: false,            
			pause: 3000,           
			speed: 500,           
			easing: "",	
			touchEnabled:true,   	
			controls: true,
			//video: true,
			useCSS: false,
		});
	})
</script>

</html>