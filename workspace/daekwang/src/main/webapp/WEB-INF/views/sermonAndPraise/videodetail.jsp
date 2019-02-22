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
	
	<!-- 주일 낮 설교에서 넘어올 때 -->
	<c:if test="${menu eq 1 }">
		<div class="worshiptab">
			<ul>
				<li><a href="sundayWorship.do" class="on"><i class="xi-bell-o"></i>주일 낮 설교</a></li>
				<li><a href="wednesdayWorship.do"><i class="xi-bell-o"></i>수요기도회 설교</a></li>
				<li><a href="allgenWorship.do"><i class="xi-bell-o"></i>올젠워십 설교</a></li>
			</ul>
		</div>
	</c:if>
	
	<!-- 수요기도회에서 넘어올 때 -->
	<c:if test="${menu eq 2 }">
		<div class="worshiptab">
			<ul>
				<li><a href="sundayWorship.do"><i class="xi-bell-o"></i>주일 낮 설교</a></li>
				<li><a href="wednesdayWorship.do" class="on"><i class="xi-bell-o"></i>수요기도회 설교</a></li>
				<li><a href="allgenWorship.do"><i class="xi-bell-o"></i>올젠워십 설교</a></li>
			</ul>
		</div>
	</c:if>
	
	<!-- 올젠워쉽에서 넘어올 때 -->
	<c:if test="${menu eq 3 }">
		<div class="worshiptab">
			<ul>
				<li><a href="sundayWorship.do"><i class="xi-bell-o"></i>주일 낮 설교</a></li>
				<li><a href="wednesdayWorship.do"><i class="xi-bell-o"></i>수요기도회 설교</a></li>
				<li><a href="allgenWorship.do" class="on"><i class="xi-bell-o"></i>올젠워십 설교</a></li>
			</ul>
		</div>
	</c:if>
	
	<div class="iframe_wrap">
		<iframe class="iframe11" width="900" height="500" src="https://www.youtube.com/embed/${vid}" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
	</div>
	
	<p class="iframe_text">${desc }</p>
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>