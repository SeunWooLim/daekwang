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
	
	<div class="ch_detail_wrap">
		<div class="head">
			<span class="left">${boardVo.BOARD_TITLE }</span>
			<span class="right">${boardVo.RECENT_UPDATE_DATE }</span>
		</div>
		<div class="mid">
			${boardVo.BOARD_CONTENT }
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
			<a href="churchNews.do" class="btn11">목록</a>
			<c:if test="${sessionScope.loginUser.MEMBER_NO eq boardVo.MEMBER_NO}">
				<a href="#" class="btn11" onclick="delete_event(${boardVo.BOARD_NO})">삭제</a>
			</c:if>
		</div>
	</div>
	
	
	
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>

<script type="text/javascript">
	//게시물 삭제 Event
	function delete_event(BOARD_NO){
		var currentPage = '${currentPage}';
		var deleteYN = 'Y';
		
		if(confirm("정말 삭제하시겠습니까?") == true){
			location.href="churchNews.do?deleteFlag="+deleteYN+"&BOARD_NO="+BOARD_NO; 
		}else{
			return;
		}
	}
</script>

</html>