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
			<p class=title>새가족소개</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<div class="photo_wrap">
		<div class="insertBtn_wrap">
			<a href="newFamilyIntroducingInsert.do" class="newInsertBtn">글쓰기</a>
		</div>
		<ul class="photo_list">
			<li>
				<div class="photo_top">
					<ul>
						<li>2019.02.10(우홍섭 성도)</li>
						<li>2019-02-02</li>
					</ul>
				</div>
				<div class="photo_mid">
					<ul>
						<li><img alt="" src="<c:url value="/"/>resources/img/exphoto.png"></li>
					</ul>
				</div>
				<div class="photo_bot">
					내용입니다.
				</div>
			</li>

			<li>
				<div class="photo_top">
					<ul>
						<li>2019.02.10(우홍섭 성도)</li>
						<li>2019-02-02</li>
					</ul>
				</div>
				<div class="photo_mid">
					<ul>
						<li><img alt="" src="<c:url value="/"/>resources/img/exphoto.png"></li>
						<li><img alt="" src="<c:url value="/"/>resources/img/exphoto.png"></li>
						<li><img alt="" src="<c:url value="/"/>resources/img/exphoto.png"></li>
					</ul>
				</div>
				<div class="photo_bot">
					내용입니다.
				</div>
			</li>
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