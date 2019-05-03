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
				<p>주보광고신청</p>
			</div>

			<div class="category_wrap">
				<form action="weekPageApplyAdmin.do" method="post">
					<ul class="ul_form1">
						<li>
							<c:choose>
								<c:when test="${searchSelect2 eq '주보원고' or searchSelect2 eq null }">
									<select name="searchSelect2" class="selectform2">
										<option value="주보원고" selected="selected">주보원고</option>
										<option value="광고요청">광고요청</option>
									</select>
								</c:when>
								<c:when test="${searchSelect2 eq '광고요청'}">
									<select name="searchSelect2" class="selectform2">
										<option value="주보원고">주보원고</option>
										<option value="광고요청" selected="selected">광고요청</option>
									</select>
								</c:when>
								<c:otherwise>
									<select name="searchSelect2" class="selectform2">
										<option value="주보원고" selected="selected">주보원고</option>
										<option value="광고요청">광고요청</option>
									</select>
								</c:otherwise>
							</c:choose>
						</li>
						<li>
							<c:choose>
								<c:when test="${searchSelect1 eq 1 or searchSelect1 eq null }">
									<select name="searchSelect1" class="selectform1">
										<option value="1" selected="selected">신청자</option>
										<option value="2">내용</option>
									</select>
								</c:when>
								<c:when test="${searchSelect1 eq 2}">
									<select name="searchSelect1" class="selectform1">
										<option value="1">신청자</option>
										<option value="2" selected="selected">내용</option>
									</select>
								</c:when>
								<c:otherwise>
									<select name="searchSelect1" class="selectform1">
										<option value="1" selected="selected">신청자</option>
										<option value="2">내용</option>
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
							<a href="weekPageApplyAdmin.do" class="btnform2">전체보기</a>
						</li>
					</ul>
				</form>

				<ul class="ul_form2">
					<!-- <li><a href="#" class="btnform3">등록</a></li> -->
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
						<col width="3%"/>
						<col width="3%"/>
						<col width="5%"/>
						<col width="6%"/>
						<col width="5%"/>
						<col width="*"/>
						<col width="10%"/>
						<col width="10%"/>
					</colgroup>
					<thead>
						<tr>
							<th><input type="checkbox" name="checkAll" id="check1" onclick="checkAll();"/><label for="check1"></label> </th>
							<th>NO</th>
							<th>신청자</th>
							<th>부서명</th>
							<th>분류</th>
							<th>내용</th>
							<th>등록일(수정일)</th>
							<th>편집</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="weekPage" items="${list }">
							<tr>
								<td><input type="checkbox" name="checkBox" value="${weekPage.APPLY_NO }" id="check2"/><label for="check2"></label> </td>
								<td><%= num-- %></td>
								<td>${weekPage.memberVo.MEMBER_NAME }</td>
								<td>${weekPage.DEPT_NAME }</td>
								<td>${weekPage.APPLY_CATE }</td>
								<c:set var="text" value="${weekPage.APPLY_CONTENT }"/>		
								<%
									String text = pageContext.getAttribute("text").toString();
									String replacetext = text.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
								%>
								<td style="text-align:center"><p style="width:800px; text-align:center; margin:0 auto;"><%=replacetext %></p></td>
								<td>${weekPage.APPLY_DATE }</td>
								<td>
									<a class="btnform5 update_btn" onclick="updateForm(<%= rowNum %>);">보기</a>
									<%-- 
									<c:url var="delete" value="weekPageApplyAdmin.do">
										<c:param name="APPLY_NO" value="${weekPage.APPLY_NO }" />
										<c:param name="currentPage" value="${currentPage }" />
										<c:param name="deleteFlag" value="Y" />
									</c:url>
									--%>
									<a class="btnform6" onclick="deleteOne(${weekPage.APPLY_NO });">삭제</a>
								</td>	
							</tr>
							
							<!-- 수정 폼 모달 Start -->
							<div class="form_wrap" id="form_wrap<%= rowNum %>">
								<form action="" method="">
									<div class="form">
										<p>주보광고신청 수정</p>
										<ul>
											<li>
												<label for="wPA">신청자</label>
												<input type="text" id="wPA" name="wPA" value="${weekPage.memberVo.MEMBER_NAME }"/>
											</li>
											<li>
												<label for="wPA_Dep">부서명</label>
												<input type="text" id="wPA_Dep" name="wPA_Dep" value="${weekPage.DEPT_NAME }"/>
											</li>
											<li>
												<label>분류</label>
												<c:if test="${weekPage.APPLY_CATE eq '주보원고' }">
													<select name="category">
														<option value="1" selected>주보원고</option>
														<option value="2">광고요청</option>
													</select>
												</c:if>
												<c:if test="${weekPage.APPLY_CATE eq '광고요청' }">
													<select name="category">
														<option value="1">주보원고</option>
														<option value="2" selected>광고요청</option>
													</select>
												</c:if>
											</li>
											<li>
												<label for="wPA_context" style="vertical-align:top;">내용</label>
												<div id="wPA_context<%= ediNum %>" name="wPA_context" value="내용 작성">${weekPage.APPLY_CONTENT }</div>
												
												<script type="text/javascript">
												CKEDITOR.replace('wPA_context<%= ediNum++%>',
														{height: 350});
												</script>
												
											</li>
										</ul>								
										
										<ul class="list">
											<li><a class="btnform2 close_btn" onclick="closeUpdateForm(<%= rowNum %>)">닫기</a></li>
										</ul>
									</div>
								</form>
							</div>
							<% 
								rowNum++;
							%>
							<!-- 수정 폼 모달 End -->
						</c:forEach>
					</tbody>
				</table>
				
				<!-- 수정 폼 모달 backGround -->
				<div class="formbg"></div>
				
				<!-- 페이지 네이션 -->
				<ul class="board_page">
					<li>
						<c:url var="first" value="weekPageApplyAdmin.do">
							<c:param name="currentPage" value="1" />
							<c:param name="searchSelect2" value="${searchSelect2 }"/>
							<c:param name="searchSelect1" value="${searchSelect1 }"/>
							<c:param name="searchContent" value="${searchContent }"/>	
						</c:url>
						<a href="${first }">&lt;&lt;</a>
					</li>
					<li>
						<c:url var="prev" value="weekPageApplyAdmin.do">
							<c:param name="currentPage" value="${currentPage}" />
							<c:param name="prev" value="1" />
							<c:param name="searchSelect2" value="${searchSelect2 }"/>
							<c:param name="searchSelect1" value="${searchSelect1 }"/>
							<c:param name="searchContent" value="${searchContent }"/>
						</c:url>
						<a href="${prev }">&lt;</a>
					</li>
					<c:forEach var="p" begin="${startPage }" end="${endPage }" step="1">
						<li>
							<c:url var="page" value="weekPageApplyAdmin.do">
								<c:param name="currentPage" value="${p }" />
								<c:param name="searchSelect2" value="${searchSelect2 }"/>
								<c:param name="searchSelect1" value="${searchSelect1 }"/>
								<c:param name="searchContent" value="${searchContent }"/>
							</c:url>
							<a href="${page }" id="pageNum<%=pageNum++ %>" class="">${p }</a>
						</li>
					</c:forEach>
					<li>
						<c:url var="next" value="weekPageApplyAdmin.do">
							<c:param name="currentPage" value="${currentPage }" />
							<c:param name="next" value="1" />
							<c:param name="searchSelect2" value="${searchSelect2 }"/>
							<c:param name="searchSelect1" value="${searchSelect1 }"/>
							<c:param name="searchContent" value="${searchContent }"/>
						</c:url>
						<a href="${next }">&gt;</a>
					</li>
					<li>
						<c:url var="last" value="weekPageApplyAdmin.do">
							<c:param name="currentPage" value="${maxPage }" />
							<c:param name="searchSelect2" value="${searchSelect2 }"/>
							<c:param name="searchSelect1" value="${searchSelect1 }"/>
							<c:param name="searchContent" value="${searchContent }"/>
						</c:url>
						<a href="${last }">&gt;&gt;</a>
					</li>
				</ul>

			</div>
		</div>
	<!--container s-->
	</div>	
 </body>

<script type="text/javascript">
	
	/* 수정 버튼 onclick */
	function updateForm(modalValue){
		$(document).ready(function(){
			$(".formbg").show();
			$("#form_wrap"+modalValue).show();		
		})
	}
	
	/* 닫기 버튼 onclick */
	function closeUpdateForm(modalValue){
		$(document).ready(function(){
			$(".formbg").hide();
			$("#form_wrap"+modalValue).hide();	
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
	
	/* 게시물 단일 삭제 */
	function deleteOne(APPLY_NO){
		var currentPage = '${currentPage}';
		var deleteYN = 'Y';
		
		if(confirm("정말 삭제 하시겠습니까?")){
			location.href="weekPageApplyAdmin.do?APPLY_NO="+APPLY_NO+"&currentPage="+currentPage+"&deleteFlag="+deleteYN;   
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
		
		if(confirm("정말 삭제 하시겠습니까?")){
		    
		    //삭제처리 후 다시 불러올 리스트 url      
		    var currentPage = '${currentPage}';
		    var searchSelect2 = '${searchSelect2}';
		    var searchSelect1 = '${searchSelect1}';
		    var searchContent = '${searchContent}';
		    var deleteYN = 'Y';
		    location.href="weekPageApplyAdmin.do?idx="+checkBox+"&currentPage="+currentPage+"&deleteFlag="+deleteYN;      
		}
	}
	
	/* ESC key 이벤트 */
	$(document).keyup(function(e) {
	     if (e.keyCode == 27) { 
    	 	$(".formbg").hide();
			$(".form_wrap").hide();	
	    }
	});
</script>

</html>