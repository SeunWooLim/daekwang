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
			<span class="left">제목</span>
			<span class="right">작성일 : 2019-02-02</span>
		</div>
		<div class="mid">
			내용
		</div>
		<div class="bot">
			<ul>
				<li><a href="#"><i class="xi-angle-up"></i><span class="t1">이전글</span><span class="t2">이전글제목</span></a></li>
				<li><a href="#"><i class="xi-angle-down"></i><span class="t1">다음글</span><span class="t2">다음글제목</span></a></li>
			</ul> 
		</div>
		<a href="churchNews.do" class="btn11">목록</a>
	</div>
	
	
	
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>