<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>


<!-- 밑에 두가지 방법 중 하나 이용 -->
<jsp:include page="../common/header.jsp"/>
<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>교회소식</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<form action="#" method="#">
		<div class="search_wrap">
			<ul>
				<li>
					<select name="">
						<option value="1">제목+내용</option>
						<option value="2">제목</option>
						<option value="3">내용</option>
						<option value="4">작성자</option>
					</select>
				</li>
				<li>
					<input type="text" name="search_value"/>
				</li>
				<li>
					<a href="#">검색</a>
				</li> 
			</ul>
		</div>
	</form>
	
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
				<tr>
					<td>1</td>
					<td class="tal"><a href="churchNewsDetail.do">제목</a></td>		
					<td>2019-02-24</td>
					<td>오민식</td>
					<td>3</td>
				</tr>
			</tbody>
		</table>	
	</div>
	
	<jsp:include page="../common/paging.jsp"/>
	
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>