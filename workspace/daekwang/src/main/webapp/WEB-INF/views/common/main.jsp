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
			<div class="main_content1 cursor" onclick="location.href='pastorGreeting.do'">
				<img src="<c:url value="/"/>resources/img/main_section1.jpg">
				<div class="text">
					<p>환영합니다</p>
					<span>담임목사 인사</span>
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
			<div class="main_content1 cursor" onclick="location.href='newFamilyIntroducing.do'"> 
				<img src="<c:url value="/"/>resources/img/main_section1.jpg">
				<div class="text">
					<p>금주의 새가족</p>
					<span>대광교회 예배시간</span>
				</div>
				<span><i class="xi-plus-circle-o"></i></span>
			</div>
			<div class="main_content1 main_content2 cursor" onclick="location.href='sundayWorship.do'">
				<img src="<c:url value="/"/>resources/img/main_section4.jpg">
			</div>
			<div class="main_content1 main_content3">
				<img src="<c:url value="/"/>resources/img/main_section2.jpg">
				<div class="text">
					<p>교회소식</p>
					<ul>
						<li>
							<a href="#">
								<span class="left">제목입니다.</span>
								<span class="right">2019-02-20</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="left">제목입니다.</span>
								<span class="right">2019-02-20</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="left">제목입니다.</span>
								<span class="right">2019-02-20</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="left">제목입니다.</span>
								<span class="right">2019-02-20</span>
							</a>
						</li>
					</ul>
				</div>
				<span><a href="churchNews.do"><i class="xi-plus-circle-o"></i></a></span>
			</div>
			
			<div class="main_content1">
				<img src="<c:url value="/"/>resources/img/main_section1.jpg">
				<div class="text">
					<p>찬양대</p>
					<a href="shalomChoir.do">샬롬 찬양대</a>
					<a href="immanuelChoir.do">임마누엘 찬양대</a>
				</div>
				<span><i class="xi-plus-circle-o"></i></span>
			</div>
			<div class="main_content1 cursor" onclick="window.open('https://www.youtube.com/feed/subscriptions/UCUelWlMoTG9gH2J7DP_VYLg')">
				<img src="<c:url value="/"/>resources/img/main_section2.jpg">
				<div class="text">
					<p>대광교회 유튜브</p>
				</div>
				<span><i class="xi-plus-circle-o"></i></span>
			</div>
			<div class="main_content1 cursor" onclick="location.href='churchPhoto.do'">
				<img src="<c:url value="/"/>resources/img/main_section1.jpg">
				<div class="text">
					<p>교회사진</p>
				</div>
				<span><i class="xi-plus-circle-o"></i></span>
			</div>
			<div class="main_content1 cursor" onclick="location.href='flowerPhoto.do'">
				<img src="<c:url value="/"/>resources/img/main_section2.jpg">
				<div class="text">
					<p>꽃꽃이갤러리</p>
				</div>
				<span><i class="xi-plus-circle-o"></i></span>
			</div>
			<div class="main_content1 cursor"  onclick="location.href='weekPageApply.do'">
				<img src="<c:url value="/"/>resources/img/main_section1.jpg">
				<div class="text">
					<p>주보요청</p>
				</div>
				<span><i class="xi-plus-circle-o"></i></span>
			</div>
			<div class="main_content1 cursor"  onclick="location.href='worshipDataApply.do'">
				<img src="<c:url value="/"/>resources/img/main_section2.jpg">
				<div class="text">
					<p>예배자료신청</p>
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