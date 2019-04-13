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
				<p>회원관리</p>
			</div>
			
			<div class="category_wrap">
				<form action="memberAdmin.do" method="post">
					<ul class="ul_form1">
						<li>
							<c:choose>
								<c:when test="${searchSelect eq 1 or searchSelect eq null }">
									<select name="searchSelect" class="selectform1">
										<option value="1" selected="selected">이름</option>
										<option value="2">아이디</option>
										<option value="3">핸드폰번호</option>
									</select>
								</c:when>
								<c:when test="${searchSelect eq 2}">
									<select name="searchSelect" class="selectform1">
										<option value="1">이름</option>
										<option value="2" selected="selected">아이디</option>
										<option value="3">핸드폰번호</option>
									</select>
								</c:when>
								<c:otherwise>
									<select name="searchSelect" class="selectform1">
										<option value="1">이름</option>
										<option value="2">아이디</option>
										<option value="3" selected="selected">핸드폰번호</option>
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
							<a href="memberAdmin.do" class="btnform2">전체보기</a>
						</li>
					</ul>
				</form>
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
				int authNum = 1;
			%>

			<div class="table_wrap">
				<table>
					<colgroup>
						<%-- <col width="5%"/> --%>
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
							<!-- <th><input type="checkbox" name="" id="check1"/><label for="check1"></label> </th> -->
							<th>NO</th>
							<th>아이디</th>
							<th>이름</th>
							<th>핸드폰 번호</th>
							<th>이메일</th>
							<th>글 쓰기 권한</th>
							<th>사용 여부</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="member" items="${list }">
							<tr>
								<!-- <td><input type="checkbox" name="" id="check2"/><label for="check2"></label> </td> -->
								<td><%= num-- %></td>
								<td>${member.MEMBER_ID }</td>
								<td>${member.MEMBER_NAME }</td>
								<td>${member.MEMBER_PHONE }</td>
								<td>${member.MEMBER_EMAIL }</td>
								<td>
									<c:if test="${member.MEMBER_AUTH eq 'W' }">
										<select name="MEMBER_AUTH" id="MEMBER_AUTH<%= authNum %>" onchange="authChange(<%= authNum %>, ${member.MEMBER_NO });">
											<option value="W" selected="selected">W</option>
											<option value="R">R</option>
										</select>
									</c:if>
									<c:if test="${member.MEMBER_AUTH eq 'R' }">
										<select name="MEMBER_AUTH" id="MEMBER_AUTH<%= authNum %>" onchange="authChange(<%= authNum %>, ${member.MEMBER_NO });">
											<option value="W">W</option>
											<option value="R" selected="selected">R</option>
										</select>
									</c:if>
								</td>
								<td>
									<c:if test="${member.MEMBER_USEYN eq 'Y' }">
										<select name="MEMBER_USEYN" id="MEMBER_USEYN<%= authNum %>" onchange="authChange(<%= authNum %>, ${member.MEMBER_NO });">
											<option value="Y" selected="selected">Y</option>
											<option value="N">N</option>
										</select>
									</c:if>
									<c:if test="${member.MEMBER_USEYN eq 'N' }">
										<select name="MEMBER_USEYN" id="MEMBER_USEYN<%= authNum %>" onchange="authChange(<%= authNum %>, ${member.MEMBER_NO });">
											<option value="Y">Y</option>
											<option value="N" selected="selected">N</option>
										</select>
									</c:if>
								</td>
								<% authNum++; %>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<!-- 페이지 네이션 -->
				<ul class="board_page">
					<li>
						<c:url var="first" value="memberAdmin.do">
							<c:param name="currentPage" value="1" />
							<c:param name="searchSelect" value="${searchSelect }"/>
							<c:param name="searchContent" value="${searchContent }"/>	
						</c:url>
						<a href="${first }">&lt;&lt;</a>
					</li>
					<li>
						<c:url var="prev" value="memberAdmin.do">
							<c:param name="currentPage" value="${currentPage}" />
							<c:param name="prev" value="1" />
							<c:param name="searchSelect" value="${searchSelect }"/>
							<c:param name="searchContent" value="${searchContent }"/>
						</c:url>
						<a href="${prev }">&lt;</a>
					</li>
					<c:forEach var="p" begin="${startPage }" end="${endPage }" step="1">
						<li>
							<c:url var="page" value="memberAdmin.do">
								<c:param name="currentPage" value="${p }" />
								<c:param name="searchSelect" value="${searchSelect }"/>
								<c:param name="searchContent" value="${searchContent }"/>
							</c:url>
							<a href="${page }" id="pageNum<%=pageNum++ %>" class="">${p }</a>
						</li>
					</c:forEach>
					<li>
						<c:url var="next" value="memberAdmin.do">
							<c:param name="currentPage" value="${currentPage }" />
							<c:param name="next" value="1" />
							<c:param name="searchSelect" value="${searchSelect }"/>
							<c:param name="searchContent" value="${searchContent }"/>
						</c:url>
						<a href="${next }">&gt;</a>
					</li>
					<li>
						<c:url var="last" value="memberAdmin.do">
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

</body>

<script type="text/javascript">

	/* 현재 페이지 'on' addClass */
	$(document).ready(function(){
		var currentPageNum = '${currentPage}';
		var pageNum = $('#pageNum'+currentPageNum);
		pageNum.addClass('on');
	})
	
	function authChange(number, memberNo){
	var member_auth = $("#MEMBER_AUTH" + number).val();
	var member_useyn = $("#MEMBER_USEYN" + number).val();
	var member_no = memberNo;
	
	$.ajax({
	      	url: "updateMemberAuthChange.do",
	      	data: {"member_auth" : member_auth ,
	      		   "member_useyn" : member_useyn ,
	      		   "member_no" : member_no },
	      	type: "post",
	      	dataType: "text",
	      	success: function(result){
	      		
	      	},
	      	error: function(request, status, errorData){
	      		alert("error code : " + request.status + "\n" + "message : " + request.responseText + "\n" + "error : " + errorData);
	      	}
    	});
	}
</script>
</html>
