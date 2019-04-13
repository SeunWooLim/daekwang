<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/adminmeta.jsp"/>
</head>
<body>
<div id="wrap">
	<!--header s-->
	<jsp:include page="header.jsp"/>
	<jsp:include page="nav.jsp"/>
	<!--header e-->
	<!--container s-->
		<div id="container">
			<div class="main_title">
				<p>대광교회 관리자 홈</p>
			</div>

			<div class="category_wrap">
				<ul class="menuuuuuu">
					
				<li><a href="memberAdmin.do"><i class="xi-user"></i>회원 관리 </a></li>			
				<li><a href="newFamilyAdmin.do"><i class="xi-home"></i>새가족소개 관리 </a></li>
				<li><a href="churchNoticeAdmin.do"><i class="xi-paper-o"></i>교회소식 관리 </a></li>
				<li><a href="personNewsAdmin.do"><i class="xi-paper-o"></i>교우소식 관리</a></li>
				<li><a href="churchPhotoAdmin.do"><i class="xi-camera-o"></i>교회사진 관리</a></li>
				<li><a href="flowerPhotoAdmin.do"><i class="xi-image-o"></i>꽃꽃이 갤러리 관리</a></li>
				<li><a href="weekPageApplyAdmin.do"><i class="xi-plus-square-o"></i>주보 광고신청 관리</a></li>
				<li><a href="worshipDataApplyAdmin.do"><i class="xi-plus-square-o"></i>예배 자료신청 관리</a></li>			
				<li><a href="mainSlideAdmin.do"><i class="xi-layout-aside-o"></i>메인슬라이드 관리 </a></li>
				<li><a href="churchSchoolAdmin.do"><i class="xi-home"></i>교회학교 관리 </a></li>
				<li><a href="shalomChoirAdmin.do"><i class="xi-emoticon-happy-o"></i>샬롬 찬양대</a></li>
				<li><a href="immanuelChoirAdmin.do"><i class="xi-emoticon-smiley-o"></i>임마누엘 찬양대</a></li>
				
				</ul>
			</div>		
		</div>
	<!--container s-->
	</div>

 </body>
</html>
<style>
	.menuuuuuu{text-align:center;}
	.menuuuuuu li{margin-bottom:20px; display: inline-block; width:24%; margin-right:1%; height:100px; }
	.menuuuuuu li a{width:100%; height:100px; padding-top:20px; box-sizing:border-box; border:1px solid #ccc; }
	.menuuuuuu li i{display: block; font-size:30px; margin-bottom:5px;}
	.menuuuuuu li:nth-child(4n){margin-right:0;}
	.menuuuuuu li p{font-size:20px;}
	.menuuuuuu li p span{font-size:20px;}
</style>