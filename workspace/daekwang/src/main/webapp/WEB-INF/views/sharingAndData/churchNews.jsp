<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>

<jsp:include page="../common/header.jsp"/>
<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>교회소식</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<form action="churchNews.do" method="post">
		<div class="search_wrap">
			<ul>
				<li>
					<c:choose>
						<c:when test="${searchSelect eq 2}">
							<select name="searchSelect">
								<option value="1">제목+내용</option>
								<option value="2" selected="selected">제목</option>
								<option value="3">내용</option>
								<option value="4">작성자</option>
							</select>
						</c:when>
						<c:when test="${searchSelect eq 2}">
							<select name="searchSelect">
								<option value="1">제목+내용</option>
								<option value="2">제목</option>
								<option value="3" selected="selected">내용</option>
								<option value="4">작성자</option>
							</select>
						</c:when>
						<c:when test="${searchSelect eq 2}">
							<select name="searchSelect">
								<option value="1">제목+내용</option>
								<option value="2">제목</option>
								<option value="3">내용</option>
								<option value="4" selected="selected">작성자</option>
							</select>
						</c:when>
						<c:otherwise>
							<select name="searchSelect">
								<option value="1" selected="selected">제목+내용</option>
								<option value="2">제목</option>
								<option value="3">내용</option>
								<option value="4">작성자</option>
							</select>
						</c:otherwise>
					</c:choose>
				</li>
				<li>
					<input type="text" name="searchContent" value="${searchContent }"/>
				</li>
				<li>
					<!-- <a href="#">검색</a> -->
					<button type="submit">검색</button>
				</li> 
			</ul>
		</div>
	</form>
	
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
	
	<div class="cw_board_wrap">
		<table>
			<colgroup>
				<col width="8%">
				<col width="*">
				<col width="13%">
				<col width="10%">
				<col width="8%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>등록일</th>
					<th>작성자</th>
					<th>조회</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="churchNews" items="${list }" varStatus="status">
					<tr>
						<td><%= num-- %></td>
						<c:url var="churchNewsDetail" value="churchNewsDetail.do">
							<c:param name="BOARD_NO" value="${churchNews.BOARD_NO }"/>
						</c:url>
						<td class="tal"><a href="${churchNewsDetail }">${churchNews.BOARD_TITLE }</a></td>		
						<td>${churchNews.RECENT_UPDATE_DATE }</td>
						<td>${churchNews.memberVo.MEMBER_NAME }</td>
						<td>${churchNews.BOARD_READCNT }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${sessionScope.loginUser ne null}">
			<div class="insertBtn_wrap mt20">
				<a href="churchNewsInsertPage.do" class="newInsertBtn">글쓰기</a>
			</div>
		</c:if>
	</div>
	
	<!-- 페이지 네이션 -->
	<div class=paging_wrap>
	<ul class="board_page">
		<li>
			<c:url var="first" value="churchNews.do">
				<c:param name="currentPage" value="1" />
				<c:param name="searchSelect" value="${searchSelect }"/>
				<c:param name="searchContent" value="${searchContent }"/>	
			</c:url>
			<a href="${first }">&lt;&lt;</a>
		</li>
		<li>
			<c:url var="prev" value="churchNews.do">
				<c:param name="currentPage" value="${currentPage}" />
				<c:param name="prev" value="1" />
				<c:param name="searchSelect" value="${searchSelect }"/>
				<c:param name="searchContent" value="${searchContent }"/>
			</c:url>
			<a href="${prev }">&lt;</a>
		</li>
		<c:forEach var="p" begin="${startPage }" end="${endPage }" step="1">
			<li>
				<c:url var="page" value="churchNews.do">
					<c:param name="currentPage" value="${p }" />
					<c:param name="searchSelect" value="${searchSelect }"/>
					<c:param name="searchContent" value="${searchContent }"/>
				</c:url>
				<a href="${page }" id="pageNum<%=pageNum++ %>" class="">${p }</a>
			</li>
		</c:forEach>
		<li>
			<c:url var="next" value="churchNews.do">
				<c:param name="currentPage" value="${currentPage }" />
				<c:param name="next" value="1" />
				<c:param name="searchSelect" value="${searchSelect }"/>
				<c:param name="searchContent" value="${searchContent }"/>
			</c:url>
			<a href="${next }">&gt;</a>
		</li>
		<li>
			<c:url var="last" value="churchNews.do">
				<c:param name="currentPage" value="${maxPage }" />
				<c:param name="searchSelect" value="${searchSelect }"/>
				<c:param name="searchContent" value="${searchContent }"/>
			</c:url>
			<a href="${last }">&gt;&gt;</a>
		</li>
	</ul>
	</div>
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
<script type="text/javascript">

	/* 현재 페이지 'on' addClass */
	$(document).ready(function(){
		var currentPageNum = '${currentPage}';
		var pageNum = $('#pageNum'+currentPageNum);
		pageNum.addClass('on');
	})
	
</script>
</html>