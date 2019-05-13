<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="meta.jsp" />


<jsp:include page="header.jsp" />

	<div id="wrap">
		<div class="main_slider w_main_slider">
			<ul>
				<c:forEach var="mainSlider" items="${wList }">
					<li>
						<div class="main_slider_div">
							<p class="title">${mainSlider.SLIDER_TITLE }</p>
							<p class="text">${mainSlider.SLIDER_CONTENT }</p>
						</div>
						<!-- 메인슬라이더 배경 -->
						<c:if test="${fn:contains(mainSlider.SLIDER_BG,'Y')}">
							<div class="main_slider_bg"></div>
						</c:if>
						
						<!-- 로컬서버 경로 -->
						<img alt="" src="<c:url value="/resources/img/mainSlideImage/${mainSlider.SLIDER_RENAME }"/>">
						<!-- 카페24 경로 -->
						<%-- <img alt="" src="<c:url value="/upload/${mainSlider.UPLOAD_YYMM }/${mainSlider.SLIDER_RENAME}"/>"> --%>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="main_slider m_main_slider">
			<ul>
				<c:forEach var="mainSlider" items="${mList }">
					<li>
						<div class="main_slider_div">
							<p class="title">${mainSlider.SLIDER_TITLE }</p>
							<p class="text">${mainSlider.SLIDER_CONTENT }</p>
						</div>
						<!-- 메인슬라이더 배경 -->
						<c:if test="${fn:contains(mainSlider.SLIDER_BG,'Y')}">
							<div class="main_slider_bg"></div>
						</c:if>
						<!-- 로컬서버 경로 -->
						<img alt="" src="<c:url value="/resources/img/mainSlideImage/${mainSlider.SLIDER_RENAME }"/>">
						<!-- 카페24 경로 -->
						<%-- <img alt="" src="<c:url value="/upload/${mainSlider.UPLOAD_YYMM }/${mainSlider.SLIDER_RENAME}"/>"> --%>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="main_background_wrap" id="sliderwrapp">
			<span class="bg"></span>
			<div class="main_content_wrap">
				<div class="main_content1 cursor"
					onclick="location.href='pastorGreeting.do'">
					<img src="<c:url value="/resources/img/mainmenu1.jpg"/>">
					<span class="bg1"></span>
					<div class="text">
						<p>환영합니다</p>
						<span>담임목사 인사</span>
					</div>
					<span><i class="xi-plus-circle-o"></i></span>
				</div>
				<div class="main_content1 cursor"
					onclick="location.href='worshipGuide.do'">
					<img src="<c:url value="/resources/img/mainmenu2.jpg"/>">
					<span class="bg1"></span>
					<div class="text">
						<p>예배시간안내</p>
						<span>대광교회 예배시간</span>
					</div>
					<span><i class="xi-plus-circle-o"></i></span>
				</div>
				<div class="main_content1 cursor"
					onclick="location.href='newFamilyIntroducing.do'">
					<img src="<c:url value="/resources/img/mainmenu3.png"/>">
					<span class="bg2"></span>
					<div class="text" >
						<p style="color:#333">금주의 새가족</p>
						<span  style="color:#333; border-color:#333">대광교회 예배시간</span>
					</div>
					<span><i class="xi-plus-circle-o"  style="color:#333"></i></span>
				</div>
				<div class="main_content1 main_content2 cursor"
					onclick="location.href='sundayWorship.do'">
					<img src="<c:url value="/resources/img/main_section4.jpg"/>" style="height:100%;">
					
				</div>
				<div class="main_content1 main_content3">
					<img src="<c:url value="/resources/img/mainmenu4.png"/>">
					<span class="bg2"></span>
					<div class="text">
						<p>교회소식</p>
						<!-- <ul>
							<li><a href="#"> <span class="left">제목입니다.</span> <span
									class="right">2019-02-20</span>
							</a></li>
							<li><a href="#"> <span class="left">제목입니다.</span> <span
									class="right">2019-02-20</span>
							</a></li>
							<li><a href="#"> <span class="left">제목입니다.</span> <span
									class="right">2019-02-20</span>
							</a></li>
							<li><a href="#"> <span class="left">제목입니다.</span> <span
									class="right">2019-02-20</span>
							</a></li>
						</ul> -->
					</div>
					<span><a href="churchNews.do"><i
							class="xi-plus-circle-o"></i></a></span>
				</div>

				
				<div class="main_content1 cursor"
					onclick="location.href='churchPhoto.do'">
					<img src="<c:url value="/resources/img/mainmenu5.jpg"/>">
					<span class="bg1"></span>
					<div class="text">
						<p>교회사진</p>
					</div>
					<span><i class="xi-plus-circle-o"></i></span>
				</div>
				<div class="main_content1 cursor"
					onclick="location.href='flowerPhoto.do'">
					<img src="<c:url value="/resources/img/mainmenu6.jpg"/>">
					<span class="bg1"></span>
					<div class="text">
						<p>꽃꽃이갤러리</p>
					</div>
					<span><i class="xi-plus-circle-o"></i></span>
				</div>
			</div>
		</div>
		<div class="main_background_wrap1" id="sliderwrapp">
			<span class="bg"></span>
			<div class="main_content_wrap">
				<div class="left">
					<div class="main_content_title">
						<p>대광교회 클립보드</p>
						<p>대광교회의 자료,영상 등을 <br> 만나실 수 있습니다.</p>
						<i class=""></i>
					</div>
				</div>
				<div class="right">
					<div class="main_content1">
						<img src="<c:url value="/resources/img/mainmenu7.jpg"/>">
						<span class="bg1"></span>
						<div class="text">
							<p>찬양대</p>
							<a href="shalomChoir.do">샬롬 찬양대</a> <a href="immanuelChoir.do">임마누엘
								찬양대</a>
						</div>
						<span><i class="xi-plus-circle-o"></i></span>
					</div>
					<div class="main_content1 cursor"
						onclick="window.open('https://www.youtube.com/feed/subscriptions/UCUelWlMoTG9gH2J7DP_VYLg')">
						<img src="<c:url value="/resources/img/mainmenu8.jpg"/>">
						<span class="bg1"></span>
						<div class="text">
							<p>대광교회 유튜브</p>
						</div>
						<span><i class="xi-plus-circle-o"></i></span>
					</div>
					<div class="main_content1 cursor"
						onclick="location.href='weekPageApply.do'">
						<img src="<c:url value="/resources/img/mainmenu9.jpg"/>">
						<span class="bg1"></span>
						<div class="text">
							<p>주보요청</p>
						</div>
						<span><i class="xi-plus-circle-o"></i></span>
					</div>
					<div class="main_content1 cursor"
						onclick="location.href='worshipDataApply.do'">
						<img src="<c:url value="/resources/img/mainmenu10.jpg"/>">
						<span class="bg1"></span>
						<div class="text">
							<p>예배자료신청</p>
						</div>
						<span><i class="xi-plus-circle-o"></i></span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />

</body>
<script>
	$(document).ready(function() {
		
		/*메인슬라이더 px*/
		$(".main_slider ul li img").css({
			height : $(window).height() + "px"
		})
		$(window).resize(function() {
			$(".main_slider ul li img").css({
				height : $(window).height() + "px"
			})
		})
		/*메인슬라이더 px*/
		
		$(".main_slider > ul").bxSlider({
			mode : "horizontal",
			slideMargin : 0,
			minSlides : 1,
			maxSlides : 5,
			moveSlides : 1,
			startSlide : 0,
			infiniteLoop : true,
			//captions: true,       
			pager : true,
			adaptiveHeight : true,
			auto : true,
			pause : 3000,
			speed : 500,
			easing : "",
			touchEnabled : true,
			controls : false,
			//video: true,
			useCSS : false,
		})
	})
</script>
<script>
var isVisible = false;

	$(window).on('scroll',function() {
		if (checkVisible($('#sliderwrapp'))&&!isVisible) {
			TweenMax.staggerFrom(".main_content1:eq(0)", 1, {opacity:0, y:50}, 1);
			TweenMax.staggerFrom(".main_content1:eq(1)", 1.3, {opacity:0, y:100}, 1);
			TweenMax.staggerFrom(".main_content1:eq(2)", 1.5, {opacity:0, y:150}, 1);
			TweenMax.staggerFrom(".main_content1:eq(3)", 1.8, {opacity:0, y:200}, 1);
			TweenMax.staggerFrom(".main_content1:eq(4)", 2, {opacity:0, y:100}, 1.5);
			TweenMax.staggerFrom(".main_content1:eq(5)", 2.4, {opacity:0, y:150}, 1.5);
			TweenMax.staggerFrom(".main_content1:eq(6)", 2.8, {opacity:0, y:200}, 1.5);
			TweenMax.staggerFrom(".main_content1:eq(7)", 3, {opacity:0, y:100}, 1);
			TweenMax.staggerFrom(".main_content1:eq(8)", 3, {opacity:0, y:150}, 1);
			TweenMax.staggerFrom(".main_content1:eq(9)", 3, {opacity:0, y:200}, 1);
			TweenMax.staggerFrom(".main_content1:eq(10)", 3, {opacity:0, y:200}, 1);
			
			isVisible=true;
		}
	});
	 
	function checkVisible( elm, eval ) {
		eval = eval || "object visible";
		var viewportHeight = $(window).height(), // Viewport Height
			scrolltop = $(window).scrollTop(), // Scroll Top
			y = $(elm).offset().top,
			elementHeight = $(elm).height();   
		
		if (eval == "object visible") return ((y < (viewportHeight + scrolltop)) && (y > (scrolltop - elementHeight)));
		if (eval == "above") return ((y < (viewportHeight + scrolltop)));
	}
</script>
</html>