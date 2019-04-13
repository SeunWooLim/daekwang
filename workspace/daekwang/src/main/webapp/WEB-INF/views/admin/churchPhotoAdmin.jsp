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
				<p>교회 사진 관리</p>
			</div>

			<div class="category_wrap">
				<form action="churchPhotoAdmin.do" method="post">
					<ul class="ul_form1">
						<li>
							<c:choose>
								<c:when test="${searchSelect eq 1 or searchSelect eq null }">
									<select name="searchSelect" class="selectform1">
										<option value="1" selected="selected">제목</option>
										<option value="2">내용</option>
										<option value="3">작성자</option>
									</select>
								</c:when>
								<c:when test="${searchSelect eq 2}">
									<select name="searchSelect" class="selectform1">
										<option value="1">제목</option>
										<option value="2" selected="selected">내용</option>
										<option value="3">작성자</option>
									</select>
								</c:when>
								<c:otherwise>
									<select name="searchSelect" class="selectform1">
										<option value="1">제목</option>
										<option value="2">내용</option>
										<option value="3" selected="selected">작성자</option>
									</select>
								</c:otherwise>
							</c:choose>
						</li>
						<li>
							<input type="text" class="inputform150" name="searchContent" value="${searchContent }"/>
						</li>
						<li>
							<button type="submit" class="btnform1">검색</button>
						</li>
						<li>
							<a href="churchPhotoAdmin.do" class="btnform2">전체보기</a>
						</li>
					</ul>
				</form>

				<ul class="ul_form2">
					<li><a href="#" class="btnform4" onclick="deleteAction();">삭제</a></li>
				</ul>
			</div>

			<!-- 변수 setting -->
			<c:set var="tableNum" value="${tableNum}"/>
			<c:set var="pageNum" value="${startPage }"/>
			<%  
				int rowNum = 1; 
				String tableNum = pageContext.getAttribute("tableNum").toString();
				int num = Integer.parseInt(tableNum);
				String cp = pageContext.getAttribute("pageNum").toString();
				int pageNum = Integer.parseInt(cp);
				int ediNum = 1;
			%>

			<div class="table_wrap">
				<table>
					<colgroup>
						<col width="5%"/>
						<col width="5%"/>
						<col width="10%"/>
						<col width="10%"/>
						<col width="25%"/>
						<col width="25%"/>
						<col width="10%"/>
						<col width="10%"/>
					</colgroup>
					<thead>
						<tr>
							<th><input type="checkbox" name="checkAll" id="check1" onclick="checkAll();"/><label for="check1"></label> </th>
							<th>NO</th>
							<th>리스트이미지</th>
							<th>작성자</th>
							<th>제목</th>
							<th>내용</th>
							<th>등록일(수정일)</th>
							<th>편집</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="churchPhoto" items="${list }">
							<tr>
								<td><input type="checkbox" name="checkBox" value="${churchPhoto.BOARD_NO }" id="check2"/><label for="check2"></label> </td>
								<td><%= num-- %></td>
								<td><img src="<c:url value="/"/>resources/uploadChurch/${churchPhoto.PHOTO_IMAGE1}"></td>
								<td>${churchPhoto.MEMBER_NAME }</td>
								<td>${churchPhoto.BOARD_TITLE }</td>
								<td>${churchPhoto.BOARD_CONTENT }</td>
								<td>${churchPhoto.RECENT_UPDATE_DATE }</td>
								<td>
									<a href="#" class="btnform5" onclick="updateForm(<%= rowNum %>);">수정</a>
									<c:url var="delete" value="churchPhotoAdmin.do">
										<c:param name="BOARD_NO" value="${churchPhoto.BOARD_NO }" />
										<c:param name="currentPage" value="${currentPage }" />
										<c:param name="deleteFlag" value="Y" />
									</c:url>
									<a href="${delete }" class="btnform6">삭제</a>
								</td>
							</tr>
							
							<!-- 수정 폼 모달 -->
							<form action="churchPhotoAdmin.do" method="post">
								<div class="form_wrap" id="form_wrap<%= rowNum %>">
									<div class="form">
										<p>꽃꽃이갤러리 수정</p>
										<ul>
											<li>
												<label for="wPA">작성자</label>
												<input type="text" id="wPA" name="wPA" value="${churchPhoto.memberVo.MEMBER_NAME }" readonly/>
												<input type="hidden" name="BOARD_NO" value="${churchPhoto.BOARD_NO }">
											</li>
											<li>
												<label for="wPA_Dep">등록일</label>
												<input type="text" id="wPA_Dep" name="wPA_Dep" value="${churchPhoto.RECENT_UPDATE_DATE }" readonly/>
											</li>
											<li>
												<label>이미지</label>
												<c:forEach var="photo" begin="1" end="${churchPhoto.PHOTO_COUNT }" step="1">
													<img alt="" src="<c:url value="/"/>resources/uploadChurch/${churchPhoto.PHOTO_IMAGE1}">
												</c:forEach>
											</li>
											<li>
												<label>제목</label>
												<input type="text" id="wPA_Dep" name="BOARD_TITLE" value="${churchPhoto.BOARD_TITLE }"/>
											</li>
											<li>
												<label for="wPA_context" style="vertical-align:top;">내용</label>
												<textarea id="wPA_context<%= ediNum %>" name="BOARD_CONTENT">${churchPhoto.BOARD_CONTENT }</textarea>
												<%-- <script type="text/javascript">
												CKEDITOR.replace('wPA_context<%= ediNum++%>',
														{height: 150});
												</script> --%>
											</li>
										</ul>								
										
										<input type="hidden" name="currentPage" value="${currentPage }">
										<input type="hidden" name="searchSelect" value="${searchSelect }">
										<input type="hidden" name="searchContent" value="${searchContent }">
										<input type="hidden" name="updateFlag" value="Y">
										
										<ul class="list">
											<li><button type="submit" class="btnform2 update_btn">수정</button></li>
											<li><a class="btnform2 close_btn" onclick="closeUpdateForm(<%= rowNum++ %>)">닫기</a></li>
										</ul>
									</div>
								</div>
							</form>
						</c:forEach>
					</tbody>
				</table>
				
				<!-- 페이지 네이션 -->
				<ul class="board_page">
					<li>
						<c:url var="first" value="churchPhotoAdmin.do">
							<c:param name="currentPage" value="1" />
							<c:param name="searchSelect" value="${searchSelect }"/>
							<c:param name="searchContent" value="${searchContent }"/>	
						</c:url>
						<a href="${first }">&lt;&lt;</a>
					</li>
					<li>
						<c:url var="prev" value="churchPhotoAdmin.do">
							<c:param name="currentPage" value="${currentPage}" />
							<c:param name="prev" value="1" />
							<c:param name="searchSelect" value="${searchSelect }"/>
							<c:param name="searchContent" value="${searchContent }"/>
						</c:url>
						<a href="${prev }">&lt;</a>
					</li>
					<c:forEach var="p" begin="${startPage }" end="${endPage }" step="1">
						<li>
							<c:url var="page" value="churchPhotoAdmin.do">
								<c:param name="currentPage" value="${p }" />
								<c:param name="searchSelect" value="${searchSelect }"/>
								<c:param name="searchContent" value="${searchContent }"/>
							</c:url>
							<a href="${page }" id="pageNum<%=pageNum++ %>" class="">${p }</a>
						</li>
					</c:forEach>
					<li>
						<c:url var="next" value="churchPhotoAdmin.do">
							<c:param name="currentPage" value="${currentPage }" />
							<c:param name="next" value="1" />
							<c:param name="searchSelect" value="${searchSelect }"/>
							<c:param name="searchContent" value="${searchContent }"/>
						</c:url>
						<a href="${next }">&gt;</a>
					</li>
					<li>
						<c:url var="last" value="churchPhotoAdmin.do">
							<c:param name="currentPage" value="${maxPage }" />
							<c:param name="searchSelect" value="${searchSelect }"/>
							<c:param name="searchContent" value="${searchContent }"/>
						</c:url>
						<a href="${last }">&gt;&gt;</a>
					</li>
				</ul>
			</div>
		</div>
	<!--container s-->
	</div>
	
	<!-- 수정, 등록 폼 모달 backGround -->
	<div class="formbg"></div>

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
	
	/* 현재 페이지 'on' addClass */
	$(document).ready(function(){
		var currentPageNum = '${currentPage}';
		var pageNum = $('#pageNum'+currentPageNum);
		pageNum.addClass('on');
	})
	
	/* 체크박스 전체 선택 */
	function checkAll(){
	    if( $("#check1").is(':checked') ){
	      $("input[name=checkBox]").prop("checked", true);
	    }else{
	      $("input[name=checkBox]").prop("checked", false);
	    }
	}
	
	/* 체크된 게시물 삭제 */
	function deleteAction(){
		var checkBox = "";
		$( "input[name='checkBox']:checked" ).each (function (){
			checkBox = checkBox + $(this).val()+"," ;
		});
			checkBox = checkBox.substring(0,checkBox.lastIndexOf( ",")); //맨끝 콤마 지우기
		
		if(checkBox == ''){
		  	alert("삭제할 대상을 선택하세요.");
	 	 	return false;
		}
		
		if(confirm("정보를 삭제 하시겠습니까?")){
		    
		    //삭제처리 후 다시 불러올 리스트 url      
		    var currentPage = '${currentPage}';
		    var searchSelect1 = '${searchSelect}';
		    var searchContent = '${searchContent}';
		    var deleteYN = 'Y';
		    location.href="churchPhotoAdmin.do?idx="+checkBox+"&currentPage="+currentPage+"&deleteFlag="+deleteYN;      
		}
	}
	
	/* ESC key 이벤트 */
	$(document).keyup(function(e) {
	     if (e.keyCode == 27) { 
    	 	$(".formbg").hide();
			$(".form_wrap").hide();
			$("#form_wrap_ins").hide();
	    }
	});

</script>
</html>