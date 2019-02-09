<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/meta.jsp"/>
</head>
<body>

<!-- 밑에 두가지 방법 중 하나 이용 -->
<jsp:include page="../common/header.jsp"/>
<div class="subvisual_wrap">
	<div class="subvisual_text">
		<p class=title>담임목사 인사</p>
		<p class="text">안양대광교회</p>
	</div>
</div>

<div class="greet_wrap">	
	<div class="greet_detail">
		<div class="greet_left">
			<p>환영인사</p>
		</div>
		<div class="greet_right">
			<div class="right_left">
				<p>우리가 사는 세상은 하루가 다르게 변화하고 있습니다.<br>
          		수많은 정보의 물결로 넘쳐 나고 있습니다. 이렇게 변화하는 세상 속에 있는 교회도
          		 이 세상을 포용하고 현대를 사는 사람들에게 복음 선교의 사명을 제대로 감당하기 위해서는 새로운
          		  패러다임을 수용하지 않고는 안 될 것입니다. 물론 아무리 세상이 변하고 사람들의 생활양식이 
          		  달라진다고 해도 변해서는 안 될 절대적 진리가 있습니다. 그것이 복음이요 성경말씀일 것입니다. 
          		 그러나 그것을 현대인들이 쉽게 받아들일 수 있도록 전달하는 방법과 매체는 변할 수밖에 없고 또한 
          		 변해야 할 것입니다.</p>
          
	          	<p><br>
	        	현대는 모든 것들이 온라인화 되어 있습니다. <br>이제는 사이버공간과 현실공간과의 거리가 없어졌습니다.
	        	<br> 
	        	회사들의 모든 업무도 사이버공간 속에서 이루어집니다.<br>
	        	사람들의 만남도 사이버공간 속에서 더 많은 만남과 교제가 이루어지는 것을 볼 수 있습니다.<br>
	        	 또한 수많은 사이버카페도 생겨나고 사이버공간에서 수많은 동호회가 결성되어 활동하고 있습니다. <br><br> <br> 
	         	이 사이버 공간이 말씀과 찬양 그리고 성도들의 아름다운 간증과 이야기들을 통해서 충만한 은혜를 
	         	누리는 곳이 되길 바랍니다. 더불어 이 곳에서 틈틈이 만나서 성도의 아름다운 교제를 이루실 수 있기를 바랍니다.
	         	 그리고 여러분의 따뜻하고 은혜로운 이야기로 함께 이 공간을 꾸며 주시기 바랍니다.<br>
	       		</p>
			</div>
			<div class="right_right">
				<img src="<c:url value="/"/>resources/img/king.png">
				<p class="title">담임목사 <span>이병수</span></p>
				<ul>
					<li>- 현 대광교회 담임목사</li>
					<li>- 연세대학교 신학과 졸업</li>
					<li>- 장로회 신학 대학교 신대원(M.Div)</li>
					<li>- 장로회 신학 대학교 대학원(Th.M.)</li>
					<li>- 연세대학교 대학원 박사(Ph.D.)</li>
					<li>- 은광교회, 동막교회, 장석교회 등에서 사역</li>
				</ul>
			</div>
		</div>
	</div>
</div>

<jsp:include page="../common/footer.jsp"/>

</body>
</html>

