<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../common/meta.jsp"/>

<jsp:include page="../common/header.jsp"/>
<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>교회사진</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<div class="ch_detail_wrap">
		<div class="head">
			<span class="left">${boardVo.BOARD_TITLE }</span>
			<span class="right">${boardVo.RECENT_UPDATE_DATE }</span>
		</div>
		<div class="mid">
			<c:forEach var="photoDetail" items="${list }">
				<!-- 카페24경로 -->
				<%-- <img src="<c:url value="/upload/${photoDetail.UPLOAD_YYMM}/${photoDetail.PHOTO_RENAME }"/>"> --%>
				<!-- 로컬서버 경로 -->
				<img src="<c:url value="/resources/uploadChurch/${photoDetail.PHOTO_RENAME }"/>">
			</c:forEach>
		</div>
		<!-- <div class="bot">
			<ul>
				<li><a href="#"><i class="xi-angle-up"></i><span class="t1">이전글</span><span class="t2">이전글제목</span></a></li>
				<li><a href="#"><i class="xi-angle-down"></i><span class="t1">다음글</span><span class="t2">다음글제목</span></a></li>
			</ul> 
		</div> -->
		
		<!-- 삭제버튼 -->
		<!-- div class="tac" 로 무조건 버튼들 감싸주고 써주시면 됩니다. -->
		<div class="tac">
			<c:url var="list" value="churchPhotoNew.do">
				<c:param name="currentPage" value="${currentPage }"/>
			</c:url>
			<a href="${list }" class="btn11">목록</a>
			<c:if test="${sessionScope.loginUser.MEMBER_NO eq boardVo.MEMBER_NO}">
				<a class="btn11" onclick="delete_event()">삭제</a>
			</c:if>
		</div>
	</div>
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
<script type="text/javascript">
	function delete_event(){
		var currentPage = '${currentPage}';
		var BOARD_NO = '${boardVo.BOARD_NO}';
		var deleteYN = 'Y';
		
		if(confirm("정말 삭제하시겠습니까?") == true){
			location.href="churchPhotoNew.do?deleteFlag="+deleteYN+"&currentPage="+currentPage+"&BOARD_NO="+BOARD_NO; 
		}else{
			return;
		}
	}
</script>
</html>