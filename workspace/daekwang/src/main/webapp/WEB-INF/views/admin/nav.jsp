<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav id="sidenav" class="sidenav">
	<a class="logo" href="forwardMain.do">LOGO</a>
	<ul class="">
		<li><a href="admin.do" style="background:none;"><i class="xi-home"></i>Home</a></li>
	</ul>
	<ul class="menulist">
		<li><a href="#"><i class="xi-layout-column"></i>게시판 관리</a>
			<ul class="nav_detail">
				<li><a href="churchNoticeAdmin.do">교회소식 관리 </a></li>
				<li><a href="personNewsAdmin.do">교우소식 관리</a></li>
				<li><a href="churchPhotoAdmin.do">교회사진 관리</a></li>
				<li><a href="flowerPhotoAdmin.do">꽃꽃이 갤러리 관리</a></li>
				<li><a href="weekPageApplyAdmin.do">주보 광고신청 관리</a></li>
				<li><a href="worshipDataApplyAdmin.do">예배 자료신청 관리</a></li>
			</ul>
		</li>
		<li><a href="#"><i class="xi-layout-column"></i>정보관리</a>
			<ul class="nav_detail">
				<li><a href="churchSchoolAdmin.do">교회학교 관리 </a></li>
				<li><a href="#">샬롬 찬양대</a></li>
				<li><a href="#">임마누엘 찬양대</a></li>
				
			</ul>
		</li>
		<!-- <li><a href="#"><i class="xi-market"></i>메뉴2</a>
			<ul class="nav_detail">
				<li><a href="/contents/menu2_1.html">메뉴2-1</a></li>
				<li><a href="/contents/menu2_2.html">메뉴2-2</a></li>
				<li><a href="/contents/menu2_3.html">메뉴2-3</a></li>
			</ul>
		</li>
		<li><a href="#"><i class="xi-pen"></i>메뉴3</a>
			<ul class="nav_detail">
				<li><a href="/contents/menu3_1.html">메뉴3-1</a></li>
				<li><a href="/contents/menu3_2.html">메뉴3-2</a></li>
				<li><a href="/contents/menu3_3.html">메뉴3-3</a></li>
				<li><a href="/contents/menu3_4.html">메뉴3-4</a></li>
				<li><a href="/contents/menu3_5.html">메뉴3-5</a></li>
				<li><a href="/contents/menu3_6.html">메뉴3-6</a></li>
				<li><a href="/contents/menu3_7.html">메뉴3-7</a></li>
			</ul>
		</li> -->
	</ul>	
</nav>
</body>
</html>