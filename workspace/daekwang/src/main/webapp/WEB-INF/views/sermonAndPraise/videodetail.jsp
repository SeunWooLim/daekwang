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
			<p class=title>수요기도회 설교</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	<div class="worshiptab">
		<ul>
			<li><a href="sundayWorship.do"><i class="xi-bell-o"></i>주일 낮 설교</a></li>
			<li><a href="wednesdayWorship.do" class="on"><i class="xi-bell-o"></i>수요기도회 설교</a></li>
			<li><a href="allgenWorship.do"><i class="xi-bell-o"></i>올젠워십 설교</a></li>
		</ul>
	</div>
	
	비디오 디테일페이지
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>