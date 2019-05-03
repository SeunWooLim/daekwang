<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>

<jsp:include page="../common/header.jsp"/>
    
<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>새가족을 위한 안내</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	<div class="newfamilybg">
		<div class="newfamilytxt">
			새가족<br>등록안내
		</div>
		<img alt="" src="<c:url value="/resources/img/new1.png"/>" style="width:100%">
		
		<img alt="" src="<c:url value="/resources/img/new3.jpg"/>">
	</div>
</div>

<jsp:include page="../common/footer.jsp"/>

</body>
</html>