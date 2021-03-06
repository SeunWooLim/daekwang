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
<style>
				.asdfasdf{overflow: hidden;}
		
			</style>
<div id="wrap">
	<!--header s-->
	<jsp:include page="header.jsp"/>
	<jsp:include page="nav.jsp"/>
	<!--header e-->
	<!--container s-->
		<div id="container">
			<div class="main_title">
				<p>메인슬라이드 관리</p>
			</div>

			<div class="category_wrap">
				<ul class="ul_form2" style="float:left;">
					<li><a class="btnform3" onclick="changeDept(1);">PC용</a></li> 
					<li><a class="btnform3" onclick="changeDept(2);">모바일용</a></li>
				</ul>
				<ul class="ul_form2">
					
					<li><a class="btnform3" onclick="openInsertForm();">등록</a></li>
				</ul>
			</div>
			
			<%  
				int rowNum = 1; 
			%>
			
			<!-- PC용 이미지 -->
			<div class="table_wrap" id="table_wrap">
				<table>
					<colgroup>
						<col width="*"/>
					</colgroup>
					<tbody>
						<c:forEach var="mainSlider" items="${wList }">
							
							<tr>							
								<td style="position: relative; padding:0;">
									<!-- 카페24 경로 -->
									<%-- <img style="width:100%; height:600px"src="<c:url value="/upload/${mainSlider.UPLOAD_YYMM }/${mainSlider.SLIDER_RENAME}"/>"> --%>
									<!-- 로컬서버 경로 -->
									<img style="width:100%; height:600px"src="<c:url value="/resources/img/mainSlideImage/${mainSlider.SLIDER_RENAME}"/>">
									<c:if test="${fn:contains(mainSlider.SLIDER_BG,'Y')}">
										<div style="position:absolute; top:0; left:0; width:100%; height:600px; display:block; background:rgba(0,0,0,0.5)"></div>
									</c:if>
									<div style="position: absolute; top:50%; left:50%; transform:translateX(-50%) translateY(-50%); text-align:center; color:#fff;">
										<p>${mainSlider.SLIDER_TITLE }</p>
										<p>${mainSlider.SLIDER_CONTENT }</p>
									</div>
									<ul class="mt20 mb20">
										<li>
											<a href="#" class="btnform5" onclick="updateForm(<%= rowNum %>)">수정</a>
											<c:url var="delete" value="mainSlideAdmin.do">
												<c:param name="SLIDER_NO" value="${mainSlider.SLIDER_NO }" />
												<c:param name="SLIDER_RENAME" value="${mainSlider.SLIDER_RENAME}"></c:param>
												<c:param name="deleteFlag" value="Y" />
											</c:url>
											<a href="${delete }" class="btnform6">삭제</a>
										</li>
									</ul>
								</td>
							</tr>
							
							<!-- 수정 폼 모달 START-->
							<div class="form_wrap" id="form_wrap<%= rowNum %>">
								<form action="mainSlideAdmin.do" method="post">
									<div class="form">
										<p>메인슬라이드 수정</p>
										<ul>
											<li>
												<label>제목</label>
												<input type="text" id="" name="SLIDER_TITLE" value="${ mainSlider.SLIDER_TITLE}" />
											</li>
											<li>
												<label>내용</label>
												<input type="text" id="" name="SLIDER_CONTENT" value="${mainSlider.SLIDER_CONTENT }" />
											</li>
											<li>
												<label>배경 선택</label>
												<c:if test="${fn:contains(mainSlider.SLIDER_BG,'Y')}">
													<label for="bgY" style="width:30px;">사용</label><input type="radio" name="SLIDER_BG" id="bgY" value="Y" style="width:20px; height:20px; margin-right:15px;" checked>
													<label for="bgN" style="width:50px;">사용안함</label><input type="radio" name="SLIDER_BG" id="bgN" value="N" style="width:20px; height:20px;">
												</c:if>
												<c:if test="${fn:contains(mainSlider.SLIDER_BG,'N')}">
													<label for="bgY" style="width:30px;">사용</label><input type="radio" name="SLIDER_BG" id="bgY" value="Y" style="width:20px; height:20px; margin-right:15px;">
													<label for="bgN" style="width:50px;">사용안함</label><input type="radio" name="SLIDER_BG" id="bgN" value="N" style="width:20px; height:20px;" checked>
												</c:if>
											</li>
										</ul>								
										
										<!-- hidden 변수 -->
										<input type="hidden" name="updateFlag" value="Y">
										<input type="hidden" name="SLIDER_NO" value="${mainSlider.SLIDER_NO }">
										<input type="hidden" name="SLIDER_RENAME" value="${mainSlider.SLIDER_RENAME }">
										
										<ul class="list">
											<li><button type="submit" class="btnform2 update_btn">수정</button></li>
											<li><a class="btnform2 close_btn" onclick="closeUpdateForm(<%= rowNum++ %>)">닫기</a></li>
										</ul>
									</div>
								</form>
							</div>
							<!-- 수정 폼 모달 END -->
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<!-- 모바일용 이미지 -->
			<div class="table_wrap" id="table_wrap2">
			
				<ul class="asdfasdf">
					<c:forEach var="mainSlider" items="${mList }">
					<li style="float:left; width:19%; margin-right:1%;position: relative;">
						<!-- 카페24 경로 -->
						<%-- <img style="width:100%; height:600px"src="<c:url value="/upload/${mainSlider.UPLOAD_YYMM }/${mainSlider.SLIDER_RENAME}"/>"> --%>
						<!-- 로컬서버 경로 -->
						<img style="width:100%; height:600px"src="<c:url value="/resources/img/mainSlideImage/${mainSlider.SLIDER_RENAME}"/>">
						<c:if test="${fn:contains(mainSlider.SLIDER_BG,'Y')}">
							<div style="position:absolute; top:0; left:0; width:100%; height:600px; display:block; background:rgba(0,0,0,0.5)"></div>
						</c:if>
						<div style="position: absolute; top:50%; left:50%; transform:translateX(-50%) translateY(-50%); text-align:center; color:#fff;">
							<p>${mainSlider.SLIDER_TITLE }</p>
							<p>${mainSlider.SLIDER_CONTENT }</p>
						</div>
						<ul class="mt20 mb20" style="text-align:center;">
							<li>
								<a href="#" class="btnform5" onclick="updateForm(<%= rowNum %>)">수정</a>
								<c:url var="delete" value="mainSlideAdmin.do">
									<c:param name="SLIDER_NO" value="${mainSlider.SLIDER_NO }" />
									<c:param name="SLIDER_RENAME" value="${mainSlider.SLIDER_RENAME}"></c:param>
									<c:param name="deleteFlag" value="Y" />
								</c:url>
								<a href="${delete }" class="btnform6">삭제</a>
							</li>
						</ul>
					</li>
					<div class="form_wrap" id="form_wrap<%= rowNum %>">
								<form action="mainSlideAdmin.do" method="post">
									<div class="form">
										<p>메인슬라이드 수정</p>
										<ul>
											<li>
												<label>제목</label>
												<input type="text" id="" name="SLIDER_TITLE" value="${ mainSlider.SLIDER_TITLE}" />
											</li>
											<li>
												<label>내용</label>
												<input type="text" id="" name="SLIDER_CONTENT" value="${mainSlider.SLIDER_CONTENT }" />
											</li>
											<li>
												<label>배경 선택</label>
												<c:if test="${fn:contains(mainSlider.SLIDER_BG,'Y')}">
													<label for="bgY" style="width:30px;">사용</label><input type="radio" name="SLIDER_BG" id="bgY" value="Y" style="width:20px; height:20px; margin-right:15px;" checked>
													<label for="bgN" style="width:50px;">사용안함</label><input type="radio" name="SLIDER_BG" id="bgN" value="N" style="width:20px; height:20px;">
												</c:if>
												<c:if test="${fn:contains(mainSlider.SLIDER_BG,'N')}">
													<label for="bgY" style="width:30px;">사용</label><input type="radio" name="SLIDER_BG" id="bgY" value="Y" style="width:20px; height:20px; margin-right:15px;">
													<label for="bgN" style="width:50px;">사용안함</label><input type="radio" name="SLIDER_BG" id="bgN" value="N" style="width:20px; height:20px;" checked>
												</c:if>
											</li>
										</ul>								
										
										<!-- hidden 변수 -->
										<input type="hidden" name="updateFlag" value="Y">
										<input type="hidden" name="SLIDER_NO" value="${mainSlider.SLIDER_NO }">
										<input type="hidden" name="SLIDER_RENAME" value="${mainSlider.SLIDER_RENAME }">
										
										<ul class="list">
											<li><button type="submit" class="btnform2 update_btn">수정</button></li>
											<li><a class="btnform2 close_btn" onclick="closeUpdateForm(<%= rowNum++ %>)">닫기</a></li>
										</ul>
									</div>
								</form>
							</div>
							<!-- 수정 폼 모달 END -->
					</c:forEach>
				</ul>
				<table>
					<colgroup>
						<col width="*"/>
					</colgroup>
					<tbody>
						<c:forEach var="mainSlider" items="${mList }">
							
							<tr>							
								<td style="position: relative; padding:0;">
									
								</td>
							</tr>
							
							<!-- 수정 폼 모달 START-->
							
						</c:forEach>
					</tbody>
				</table>
			</div>
			
		</div>
	<!--container s-->
	</div>
	
	<!-- 수정, 등록 폼 모달 backGround -->
	<div class="formbg"></div>
	
	<!-- 등록 폼 모달 START -->
	<div class="form_wrap" id="form_wrap_ins" >
		<form action="insertMainSlideAdmin.do" method="post" enctype="multipart/form-data">
			<div class="form">
				<p>메인슬라이더 등록</p>
				<ul>
					<li>
						<label>제목</label>
						<input type="text" id="" name="SLIDER_TITLE" />
					</li>
					<li>
						<label>내용</label>
						<input type="text" id="" name="SLIDER_CONTENT" />
					</li>
					<li>
						<label>분류</label>
						<label for="cateW" style="width:30px;">PC용</label><input type="radio" name="SLIDER_CATE" id="cateW" value="W" style="width:20px; height:20px; margin-right:15px;" checked>
						<label for="cateM" style="width:50px;">모바일용</label><input type="radio" name="SLIDER_CATE" id="cateM" value="M" style="width:20px; height:20px;">
					</li>
					<li>
						<label>이미지</label>
						<input type="file" name="file" style="padding:0; height:100%; width: 50%;    vertical-align: top;">
					</li>
					<li>
						<label>배경선택</label>
						<label for="bgY" style="width:30px;">사용</label><input type="radio" name="SLIDER_BG" id="bgY" value="Y" style="width:20px; height:20px; margin-right:15px;">
						<label for="bgN" style="width:50px;">사용안함</label><input type="radio" name="SLIDER_BG" id="bgN" value="N" style="width:20px; height:20px;" checked>
					</li>
				</ul>								
				
				<input type="hidden" name="insertFlag" value="Y">
				
				<ul class="list">
					<li><button type="submit" class="btnform2 update_btn" id="btn_insert">등록</button></li>
					<li><a class="btnform2 close_btn" id="btn_ins" onclick="closeInsertForm();">닫기</a></li>
				</ul>
			</div>
		</form>
	</div>
	<!-- 등록 폼 모달 END -->

 </body>
 <script type="text/javascript">
	
	/* 수정폼 버튼 onclick */
	function updateForm(modalValue){
		$(document).ready(function(){
			$(".formbg").show();
			$("#form_wrap"+modalValue).show();		
		})
	}
	
	/* 수정폼 닫기 버튼 onclick */
	function closeUpdateForm(modalValue){
		$(document).ready(function(){
			$(".formbg").hide();
			$("#form_wrap"+modalValue).hide();	
		})
	}
	
	/* 등록 버튼 onclick */
	function openInsertForm(){
		$(document).ready(function(){
			$("#form_wrap_ins").show();
			$(".formbg").show();	
		})
	}
	
	/* 등록 닫기 버튼 onclick */
	function closeInsertForm(){
		$(document).ready(function(){
			$("#form_wrap_ins").hide();
			$(".formbg").hide();	
		})
	}
	
	/* ESC key 이벤트 */
	$(document).keyup(function(e) {
	     if (e.keyCode == 27) { 
    	 	$(".formbg").hide();
			$(".form_wrap").hide();
			$("#form_wrap_ins").hide();
	    }
	});
	
	$(document).ready(function(){
		$("#table_wrap").show();	
		$("#table_wrap2").hide();
	})

	/* 부서 별 수정 페이지 이동 onclick */
	function changeDept(value){
		if(value == 1){
			$("#table_wrap").show();	
			$("#table_wrap2").hide();
		}else{
			$("#table_wrap").hide();	
			$("#table_wrap2").show();
		}
	}

</script>
</html>
