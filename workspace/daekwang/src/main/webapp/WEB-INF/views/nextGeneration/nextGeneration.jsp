<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>


<!-- 밑에 두가지 방법 중 하나 이용 -->
<jsp:include page="../common/header.jsp"/>
<div id="wrap">
	<div class="next_list_btn">
		<ul>
			<li class="title">교회학교</li>
			<li><a href="#tab1">영유아부</a></li>
			<li><a href="#tab2">유치부</a></li>
			<li><a href="#tab3">유년부</a></li>
			<li><a href="#tab4">소년부</a></li>
			<li><a href="#tab5">중등부</a></li>
			<li><a href="#tab6">고등부</a></li>
			<li class="title">청년회</li>
			<li><a href="#tab7">제1청년회</a></li>
			<li><a href="#tab8">제2청년회</a></li>
		</ul>
	</div>
	
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>다음세대</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<% int num = 1; %>
	
	<c:forEach var="schoolList" items="${ schoolList }">
		<div class="nextgene_wrap">	
			<div id="tab<%= num++ %>"  class="nextgene_cate">
				
				<p class="title">${schoolList.DEPT_NAME} </p>
				<div class="next_detail_all_wrap">
					<div class="next_detail next_detail_wrapppp">
						<div class="next_left">
							<p>교육표어</p>
						</div>
						<div class="next_right">
							<div class="right_left">
								<p class="title">
									교육표어<span class="text">${schoolList.EDU_TITLE}</span>
								</p>
								<p class="title">주제말씀<span class="text">${schoolList.MAIN_WORDS }</span></p>
								<p class="title">예배대상<span class="text">${schoolList.WORSHIP_OBJECT }</span></p>
								<p class="title">예배시간<span class="text">${schoolList.WORSHIP_TIME }</span></p>
								<p class="title">예배장소<span class="text">${schoolList.WORSHIP_AREA }</span></p>
							</div>				
						</div>
					</div>
					<!-- 이미지 추가부분 s -->
					<div class="nextjpg_wrap nextjpg_wrap1111">
						<img alt="" src="<c:url value="/"/>resources/img/exnext.jpg">
						<span class="bg"></span>
						<span class="lt"></span>
						<span class="rt"></span>
						<span class="lb"></span>
						<span class="rb"></span>
					</div>
					<!-- 이미지 추가부분 e -->	
				</div>
				<div class="next_detail">
					<div class="next_left">
						<p>비전</p>
					</div>
					<div class="next_right">
						<div class="right_left">
							<p class="title">a.<span class="text">${schoolList.DEPT_VISION }</span></p>
						</div>				
					</div>
				</div>
				
				<div class="next_detail">
					<div class="next_left">
						<p>핵심사역</p>
					</div>
					<div class="next_right">
						<div class="right_left">
							<p class="title">예배<span class="text">${schoolList.DEPT_MISSION }</span></p>
							<p class="title">교육<span class="text">${schoolList.DEPT_MISSION }</span></p>
							<p class="title">전도<span class="text">${schoolList.DEPT_MISSION }</span></p>
							<p class="title">교제<span class="text">${schoolList.DEPT_MISSION }</span></p>
							<p class="title">친교<span class="text">${schoolList.DEPT_MISSION }</span></p>
						</div>				
					</div>
				</div>																	
				<div class="next_detail">
					<div class="next_left">
						<p>섬기는분들</p>
					</div>
					<div class="next_right">
						<div class="right_left">
							<table>
								<colgroup>
									<col width="16.666%">
									<col width="16.666%">
									<col width="16.666%">
									<col width="16.666%">
									<col width="16.666%">
									<col width="*">
								</colgroup>
								<tbody>
									<tr>
										<td class="title">지도</td>
										<td>${schoolList.DEPT_LEADER }</td>
										<td class="title">부장</td>
										<td>${schoolList.DEPT_HEADER }</td>
										<td class="title">부감</td>
										<td>${schoolList.DEPT_DIRECTOR }</td>
									</tr>
									<tr>
										<td class="title">총무</td>
										<td>${schoolList.DEPT_MANAGER }</td>
										<td class="title">서기</td>
										<td>${schoolList.DEPT_WRITER }</td>
										<td class="title">회계</td>
										<td>${schoolList.DEPT_ACCOUNTANT }</td>
									</tr>
									<tr>
										<td class="title">선생님</td>
										<td colspan="5" class="tech">${schoolList.DEPT_MEMBER }</td>
									</tr>
								</tbody>
							</table>
						</div>				
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
		

	<c:forEach var="youthList" items="${ youthList }">	
		<div class="nextgene_wrap">
			<div id="tab<%= num++ %>" class="nextgene_cate">
				
				<p class="title">${youthList.DEPT_NAME }</p>
				<div class="next_detail_all_wrap">
					<div class="next_detail next_detail_wrapppp">
						<div class="next_left ">
							<p>교육표어</p>
						</div>
						<div class="next_right">
							<div class="right_left">
								<p class="title">교육표어<span class="text">${youthList.EDU_TITLE}</span></p>
								<p class="title">주제말씀<span class="text">${youthList.MAIN_WORDS }</span></p>
								<p class="title">예배대상<span class="text">${youthList.WORSHIP_OBJECT }</span></p>
								<p class="title">예배시간<span class="text">${youthList.WORSHIP_TIME }</span></p>
								<p class="title">예배장소<span class="text">${youthList.WORSHIP_AREA }</span></p>
							</div>				
						</div>						
					</div>
					<!-- 이미지 추가부분 s -->
					<div class="nextjpg_wrap nextjpg_wrap1111">
						<img alt="" src="<c:url value="/"/>resources/img/exnext.jpg">
						<span class="bg"></span>
						<span class="bg"></span>
						<span class="lt"></span>
						<span class="rt"></span>
						<span class="lb"></span>
						<span class="rb"></span>
					</div>
					<!-- 이미지 추가부분 e -->
				</div>
				
				
				
				<div class="next_detail">
					<div class="next_left">
						<p>비전</p>
					</div>
					<div class="next_right">
						<div class="right_left">
							<p class="title">a.<span class="text">${youthList.DEPT_VISION }</span></p>
						</div>				
					</div>
				</div>
				
				<div class="next_detail">
					<div class="next_left">
						<p>핵심사역</p>
					</div>
					<div class="next_right">
						<div class="right_left">
							<p class="title">예배<span class="text">${youthList.DEPT_MISSION }</span></p>
							<p class="title">교육<span class="text">${youthList.DEPT_MISSION }</span></p>
							<p class="title">전도<span class="text">${youthList.DEPT_MISSION }</span></p>
							<p class="title">교제<span class="text">${youthList.DEPT_MISSION }</span></p>
							<p class="title">친교<span class="text">${youthList.DEPT_MISSION }</span></p>
						</div>				
					</div>
				</div>
				<div class="next_detail">
					<div class="next_left">
						<p>섬기는분들</p>
					</div>
					<div class="next_right">
						<div class="right_left">
							<table>
								<colgroup>
									<col width="16.666%">
									<col width="16.666%">
									<col width="16.666%">
									<col width="16.666%">
									<col width="16.666%">
									<col width="*">
								</colgroup>
								<tbody>
									<tr>
										<td class="title">지도</td>
										<td colspan="5">${youthList.DEPT_LEADER }</td>
									</tr>
									<tr>
										<td class="title">부장</td>
										<td>${youthList.DEPT_HEADER }</td>
										<td class="title">회장</td>
										<td>${youthList.DEPT_DIRECTOR }</td>
										<td class="title">부회장</td>
										<td>${youthList.DEPT_BUDIRECTOR }</td>
									</tr>
									<tr>
										<td class="title">총무</td>
										<td>${youthList.DEPT_MANAGER }</td>
										<td class="title">서기</td>
										<td>${youthList.DEPT_WRITER }</td>
										<td class="title">회계</td>
										<td>${youthList.DEPT_ACCOUNTANT }</td>
									</tr>
								</tbody>
							</table>
						</div>				
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
		
</div>


<jsp:include page="../common/footer.jsp"/>

</body>
</html>

