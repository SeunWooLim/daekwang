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
			<p class=title>교회사진</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<div class="photo_wrap">
		<div class="photo_top">
			<p>190124 교사강습회(평촌교회)
		</div>
		<div class="photo_mid">
			<ul>
				<li><img alt="" src="<c:url value="/"/>resources/img/exphoto.png"></li>
			</ul>
		</div>
		<div class="photo_bot">
			
		</div>
	</div>
	
	
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>


</html>