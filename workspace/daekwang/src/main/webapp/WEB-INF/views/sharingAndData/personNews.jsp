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
			<p class=title>교우소식</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<div class="pw_board_wrap">
		<ul>
			<c:forEach var="personNews" items="${list }">
				<li>
					<div class="head">
						<div>${listCount }</div>
						<p class="title">${personNews.BOARD_TITLE }</p>
						<p class="text"><span>${personNews.RECENT_UPDATE_DATE }</span><span>${personNews.memberVo.MEMBER_NAME }</span></p>
						<i class="xi-angle-down"></i>
					</div>
					<div class="body">
						<p class="title">${personNews.BOARD_CONTENT }</p>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
<script>
	$(document).ready(function(){
		$(".head").click(function(e){
			e.preventDefault();
			$(this).siblings(".body").slideToggle();
			$(this).parent().toggleClass("on");
			/* $(this).parent().siblings().find(".body").slideUp();
			$(this).parent().siblings().removeClass("on"); */
		})
	})
</script>

</html>