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
	<div id="header">
		<div class="head_top_wrap">
			<div class="head_top">
				<div class="head_top_left">
				<a href="forwardMain.do">
					<img alt="안양대광교회" src="<c:url value="/"/>resources/img/index_logo.gif">
				</a>
			</div>
			<div class="head_top_right">
				<a href="#">사이트맵</a>
			</div>
			</div>
		</div>
		<div class="head_mid_wrap">
			<ul>
				<li><a href="pastorGreeting.do">교회안내</a></li>
				<li><a href="sundayWorship.do">말씀과 찬양</a></li>
				<li><a href="newFamilyIntroducing.do">나눔과 자료</a></li>
				<li><a href="firstYouth.do">다음세대</a></li>
				<li><a href="mediatorPrayer.do">선교</a></li>
			</ul>
		</div>
		<div class="head_mid_detail_wrap">
			<div class="head_mid_detail">
				<table>
					<colgroup>
						<col width="20%">
						<col width="20%">
						<col width="20%">
						<col width="20%">
						<col width="20%">
					</colgroup>
					<tbody>
						<tr>
							<td>
								<ul>
									<li><a href="pastorGreeting.do">담임목사 인사</a></li>
									<li><a href="churchIntroducing.do">대광교회 소개</a></li>
									<li><a href="churchHistory.do">교회연혁</a></li>
									<li><a href="newFamilyGuide.do">새가족을 위한 안내</a></li>
									<li><a href="volunteers.do">섬기는 사람들</a></li>
									<li><a href="worshipGuide.do">예배안내</a></li>
									<li><a href="howToCome.do">찾아오시는 길</a></li>
								</ul>
							</td>
							<td>
								<ul>
									<li><span class="subtitle">예배 설교</span></li>
									<li><a href="sundayWorship.do">주일 낮 설교</a></li>
									<li><a href="wednesdayWorship.do">수요기도회 설교</a></li>
									<li><a href="allgenWorship.do">올젠워십 설교</a></li>
									<li><span class="subtitle">예배 찬양</span></li>
									<li><a href="chalomChoir.do">샬롬 찬양대</a></li>	
									<li><a href="immanuelChoir.do">임마누엘 찬양대</a></li>
									<li><a href="unionChoir.do">연합찬양대</a></li>
									<li><a href="speicalSong.do">특송</a></li>
									<li><a href="specialEvent.do">특별행사</a></li>
								</ul>
							</td>
							<td>
								<ul>
									<li><a href="newFamilyIntroducing.do">새가족소개</a></li>
									<li><a href="churchNews.do">교회소식</a></li>
									<li><a href="personNews.do">교우소식</a></li>
									<li><a href="churchPhoto.do">교회사진</a></li>
									<li><a href="eventVideo.do">행사 동영상</a></li>
									<li><a href="flowerPhoto.do">꽃꽃이 갤러리</a></li>
									<li><a href="weekPageApply.do">주보 광고신청</a></li>
									<li><a href="worshipDataApply.do">예배 자료신청</a></li>
								</ul>
							</td>
							<td>
								<ul>
									<li><span class="subtitle">청년회</span></li>
									<li><a href="firstYouth.do">제1청년회</a></li>
									<li><a href="secondYouth.do">제2청년회</a></li>
									<li><span class="subtitle">교회학교</span></li>
									<li><a href="infants.do">영유아부</a></li>
									<li><a href="kindergarten.do">유치부</a></li>
									<li><a href="lowChild.do">유년부</a></li>
									<li><a href="highChild.do">소년부</a></li>
									<li><a href="middleSchool.do">중등부</a></li>
									<li><a href="highSchool.do">고등부</a></li>
								</ul>
							</td>
							<td>
								<ul>
									<li><a href="mediatorPrayer.do">중보기도회</a></li>
									<li><a href="christianityCulture.do">경기기독문화원</a></li>
								</ul>
							</td>						
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<script>
	$(document).ready(function(){
		$(".head_mid_wrap").mouseover(function(){
			$(".head_mid_detail_wrap").show();
		});
		
		$(".head_top_wrap").mouseover(function(){
			$(".head_mid_detail_wrap").hide();
		});
		
		
		$(".head_mid_detail_wrap").mouseleave(function(){
			$(".head_mid_detail_wrap").hide();
		});
	});
		
</script>
</html>