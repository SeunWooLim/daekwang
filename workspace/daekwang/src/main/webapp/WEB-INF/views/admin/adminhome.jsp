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
				<p>홈</p>
			</div>

			<div class="category_wrap">
				<ul class="menuuuuuu">
					<!-- <li><a href="#">교회학교 관리페이지 // churchSchoolAdmin.do</a></li>
					<li><a href="#">교회소식 관리페이지 // churchNoticeAdmin.do</a></li>
					<li><a href="#">교우소식 관리페이지 // personNewsAdmin.do</a></li>
					<li><a href="#">교회사진 관리페이지 // churchPhotoAdmin.do</a></li>
					<li><a href="#">꽃꽃이 갤러리 관리페이지 // flowerPhotoAdmin.do</a></li>
					<li><a href="#">주보 광고신청 관리페이지 // weekPageApplyAdmin.do</a></li>
					<li><a href="#">예배 자료신청 관리페이지 // worshipDataApplyAdmin.do</a></li> -->
					<!-- <li><p>메뉴1_1 (<span style="color:blue">리스트이미지</span>, <span style="color:red">카테고리</span>, 제목, 내용, 등록일)</p></li>
					<li><p>메뉴1_2 (<span style="color:red">카테고리</span>, 제목, 내용, 등록일)</p></li>
					<li><p>메뉴1_3 (<span style="color:blue">리스트이미지</span>, 제목, 내용, 등록일)</p></li>
					<li><p>-----------------작성자 있는 테이블 S---------------------</p></li>
					<li><p>메뉴1_4 (<span style="color:blue">리스트이미지</span>, <span style="color:red">카테고리</span>, 제목, 내용, 작성자, 등록일)</p></li>
					<li><p>메뉴1_5 (<span style="color:red">카테고리</span>, 제목, 내용, 작성자, 등록일)</p></li>
					<li><p>메뉴1_6 (<span style="color:blue">리스트이미지</span>, 제목, 내용, 작성자, 등록일)</p></li>
					<li><p>-----------------작성자 있는 테이블 E---------------------</p></li>
					<li><p>메뉴1_7 (제목, 내용, 작성자, 등록일)</p></li>
					<li><p>메뉴1_8 (<span style="color:blue">리스트이미지</span>, 제목, 등록일)</p></li>
					<li><p>메뉴1_9 (작성자, 메일, 제목, 확인여부, 등록일) &lt;&lt;&lt; Q&A용</p></li>
					<li><p>메뉴1_10 (아이디, 이름, 전화번호, 사용여부) &lt;&lt;&lt; 어드민계정관리용</p></li>
					<li><p>메뉴1_11 (이름, 이메일, 전화번호, 가입경로, 가입일) &lt;&lt;&lt; 일반회원관리용</p></li>
					<li><p>메뉴1_12 (<span style="color:blue">리스트이미지</span>, 제목, 이벤트기간, 등록일) &lt;&lt;&lt; 이벤트용</p></li> -->
				</ul>
			</div>		
		</div>
	<!--container s-->
	</div>

 </body>
</html>
<style>
	.menuuuuuu{}
	.menuuuuuu li{margin-bottom:20px; }
	.menuuuuuu li p{font-size:20px;}
	.menuuuuuu li p span{font-size:20px;}
</style>