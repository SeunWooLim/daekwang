<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="meta.jsp"/>
</head>
<body>

<!-- 밑에 두가지 방법 중 하나 이용 -->
<jsp:include page="header.jsp"/>

	<div id="wrap">
		<div class="main_slider">
			<ul>
				<li>
					<img alt="" src="<c:url value="/"/>resources/img/main1.jpg">
				</li>
				<li>
					<img alt="" src="<c:url value="/"/>resources/img/main2.jpg">
				</li>
				<li>
					<img alt="" src="<c:url value="/"/>resources/img/main3.jpg">
				</li>
				<li>
					<img alt="" src="<c:url value="/"/>resources/img/main4.jpg">
				</li>
			</ul>
		</div>
		<div class="main_content_wrap">
			<div class="main_content1 cursor" onclick="location.href='newFamilyIntroducing.do'">
				<img src="<c:url value="/"/>resources/img/main_section1.jpg">
				<div class="text">
					<p>새가족등록안내</p>
					<span>새가족 등록절차</span>
				</div>
				<span><i class="xi-plus-circle-o"></i></span>
			</div>
			<div class="main_content1 cursor" onclick="location.href='worshipGuide.do'">
				<img src="<c:url value="/"/>resources/img/main_section2.jpg">
				<div class="text">
					<p>예배시간안내</p>
					<span>대광교회 예배시간</span>
				</div>
				<span><i class="xi-plus-circle-o"></i></span>
			</div>
			<div class="main_content1">
				<img src="<c:url value="/"/>resources/img/main_section3.jpg">
				<div class="text">
					<p>예배영상</p>
					<a href="sundayWorship.do">주일 낮 설교</a>
					<a href="wednesdayWorship.do">수요기도회 설교</a>
					<a href="allgenWorship.do">올젠워십 설교</a>
				</div>
				<span><i class="xi-plus-circle-o"></i></span>
			</div>
			<div class="main_content1 main_content2 cursor" onclick="location.href='sundayWorship.do'">
				<img src="<c:url value="/"/>resources/img/main_section4.jpg">
			</div>
			<div class="main_content1 cursor" onclick="location.href='newFamilyIntroducing.do'">
				<img src="<c:url value="/"/>resources/img/img_recent1.jpg">
				<div class="text">
					<p>새가족등록안내</p>
					<span>새가족 등록절차</span>
				</div>
				<span><i class="xi-plus-circle-o"></i></span>
			</div>
			<div class="main_content1 cursor" onclick="location.href='newFamilyIntroducing.do'">
				<img src="<c:url value="/"/>resources/img/img_recent1.jpg">
				<div class="text">
					<p>새가족등록안내</p>
					<span>새가족 등록절차</span>
				</div>
				<span><i class="xi-plus-circle-o"></i></span>
			</div>
			<div class="main_content1 cursor" onclick="location.href='newFamilyIntroducing.do'">
				<img src="<c:url value="/"/>resources/img/main_section6.jpg">
				<div class="text">
					<p>새가족등록안내</p>
					<span>새가족 등록절차</span>
				</div>
				<span><i class="xi-plus-circle-o"></i></span>
			</div>
		</div>
	</div>

<jsp:include page="footer.jsp"/>
 
</body>
<script>
	$(document).ready(function(){
		$(".main_slider > ul").bxSlider({
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
			auto: true,            
			pause: 3000,           
			speed: 500,           
			easing: "",	
			touchEnabled:true,   	
			controls: false,
			//video: true,
			useCSS: false,
		})
	})
</script>
</html>