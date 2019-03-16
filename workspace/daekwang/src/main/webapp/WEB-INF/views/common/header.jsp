<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	<div id="header">
		<div class="head_top_wrap">
			<div class="head_top">
				<div class="head_top_left">
				<a href="forwardMain.do">
					<img alt="안양대광교회" src="<c:url value="/resources/img/logo1.png"/>">
				</a>
			</div>
			<div class="head_top_right">
				<ul>
					<!-- 로그인X -->
					<c:if test="${sessionScope.loginUser eq null}">
						<li><a href="#" class="login_btn">로그인</a></li>
						<li>|</li>
						<li><a href="join.do" class="login_btn">회원가입</a></li>
					</c:if>
					<!-- 로그인O -->
					<c:if test="${sessionScope.loginUser ne null}">
						<!-- 관리자 -->
						<c:if test="${sessionScope.loginUser.MEMBER_FG eq 1 }">
							<li><a href="admin.do" class="login_btn">${sessionScope.loginUser.MEMBER_NAME }님</a></li>
						</c:if>
						<!-- 일반사용자 -->
						<c:if test="${sessionScope.loginUser.MEMBER_FG eq 2 }">
							<li><a href="#" class="">${sessionScope.loginUser.MEMBER_NAME }님</a></li>
						</c:if>
						<li>|</li>
						<li><a href="logout.do" class="login_btn">로그아웃</a></li>
					</c:if>
					<li>|</li>
					<li><a href="myPage.do">사이트맵</a></li>
				</ul>
			</div>
			</div>
		</div>
		<div class="head_mid_wrap">
			<ul>
				<li><a href="pastorGreeting.do">교회안내</a></li>
				<li><a href="sundayWorship.do">말씀과 찬양</a></li>
				<li><a href="newFamilyIntroducing.do">나눔과 자료</a></li>
				<li><a href="nextGeneration.do">다음세대</a></li>
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
									<li><a href="shalomChoir.do">샬롬 찬양대</a></li>	
									<li><a href="immanuelChoir.do">임마누엘 찬양대</a></li>
									<li><a href="unionChoir.do">연합찬양대</a></li>
									<li><a href="specialSong.do">특송</a></li>
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
									<li><a href="nextGeneration.do#tab7">제1청년회</a></li>
									<li><a href="nextGeneration.do#tab8">제2청년회</a></li>
									<li><span class="subtitle">교회학교</span></li>
									<li><a href="nextGeneration.do#tab1">영유아부</a></li>
									<li><a href="nextGeneration.do#tab2">유치부</a></li>
									<li><a href="nextGeneration.do#tab3">유년부</a></li>
									<li><a href="nextGeneration.do#tab4">소년부</a></li>
									<li><a href="nextGeneration.do#tab5">중등부</a></li>
									<li><a href="nextGeneration.do#tab6">고등부</a></li>
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
	
<!-- 로그인  s-->
<div class="h_login">
	<div class="box">
        <div class="head">
        	<p><i class="xi-profile-o"></i>로그인</p>
    		<i class="xi-close"></i>
        </div>
        <div class="body">
	        <form method="post" action="login.do">
	            <div class="input"><i class="xi-mail-o"></i><input type="text" placeholder="아이디" id="loginEmail" name="MEMBER_ID" value=""></div>
	            <div class="input"><i class="xi-key"></i><input type="password" class="password" placeholder="비밀번호" id="loginPasswd" name="MEMBER_PWD"></div>
	            <label class="id_save"><input name="loginChk01" id="loginChk01" type="checkbox" value="">로그인 기억</label>
	            <ul class="menu">
	                <li><a class="find_id_btn">아이디찾기</a></li>
	                <li><span></span></li>
	                <li><a class="find_pw_btn">비밀번호찾기</a></li>
	            </ul>
	            <div class="cb"></div>
	            <button type="submit" class="button">로그인</button>
	            <div class="line"></div>		
	        </form>
       
            <div class="join_btn">아직 계정이 없으신가요? <a href="join.do">회원가입 바로가기</a></div>		            
        </div>
    </div>
	<div class="cb"></div>
</div>
<!-- 로그인 e -->
<div class="scroll_top">
    <img class="on" src="<c:url value="/resources/img/scroll_top_on.png"/>"/>
    <img src="<c:url value="/resources/img/scroll_top.png"/>"/>
    
</div>
<script>
	$(document).ready(function(){
		$(".login_btn").click(function(){
			$(".h_login").stop().fadeIn(200);
		});
		
		$(".h_login .box .head .xi-close").click(function(){
			$(".h_login").stop().fadeOut(200);
		});
		
		$(".head_mid_wrap").mouseover(function(){
			$(".head_mid_detail_wrap").show();
			
		});
		
		$(".head_top_wrap").mouseover(function(){
			$(".head_mid_detail_wrap").hide();
		});
		
		
		$(".head_mid_detail_wrap").mouseleave(function(){
			$(".head_mid_detail_wrap").hide();
		});
		
		// header:s
		var scroll_header = 0
		$(window).scroll(function(){
			
			if($(window).scrollTop() > 50){
				if(scroll_header == 1) return;
				scroll_header=1
				$(".scroll_top").fadeIn(500)
				$(".head_top_wrap").addClass("on");
				$(".head_mid_wrap").addClass("on");

			}else{
				scroll_header=0
				$(".scroll_top").fadeOut(500)
				$(".head_top_wrap").removeClass("on");
				$(".head_mid_wrap").removeClass("on");
			}
		})
		
		$(".scroll_top").mouseenter(function(){
			$(".on",this).stop().fadeIn(200)
			$(this).mouseleave(function(){
				$(".on",this).stop().fadeOut(200)
			})
		})
		
		$(".scroll_top").click(function(){
			$("html, body").animate({scrollTop:0},1000)
			return false;
		})
	})
</script>

