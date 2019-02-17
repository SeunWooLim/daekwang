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
			<p class=title>섬기는 사람들</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<div class="volunteers_wrap">	
		<ul class="volunteers_btn">
			<li class="on">목사</li><li>전도사</li><li>장로</li>
		</ul>
		
		<div class="list_wrap list1">
			<ul>
				<li>
					<div class="left_box">
						<img alt="" src="<c:url value="/"/>resources/img/king.png">
					</div>
					<div class="right_box">
						<p>이병수 원로목사</p>
					</div>
				</li>
				<li>
					<div class="left_box">
						<img alt="" src="<c:url value="/"/>resources/img/king.png">
					</div>
					<div class="right_box">
						<p>이병수 담임목사</p>
					</div>
				</li>
				<li>
					<div class="left_box">
						<img alt="" src="<c:url value="/"/>resources/img/king.png">
					</div>
					<div class="right_box">
						<p>이병수 부목사</p>
					</div>
				</li>
				<li>
					<div class="left_box">
						<img alt="" src="<c:url value="/"/>resources/img/king.png">
					</div>
					<div class="right_box">
						<p>이병수 부목사</p>
					</div>
				</li>
				<li>
					<div class="left_box">
						<img alt="" src="<c:url value="/"/>resources/img/king.png">
					</div>
					<div class="right_box">
						<p>이병수 부목사</p>
					</div>
				</li>
			</ul>
		</div>
		
		<div class="list_wrap list2">
			<ul>
				<li>
					<div class="left_box">
						<img alt="" src="<c:url value="/"/>resources/img/king.png">
					</div>
					<div class="right_box">
						<p>이병수 전도사</p>
					</div>
				</li>
				<li>
					<div class="left_box">
						<img alt="" src="<c:url value="/"/>resources/img/king.png">
					</div>
					<div class="right_box">
						<p>이병수 전도사</p>
					</div>
				</li>
				<li>
					<div class="left_box">
						<img alt="" src="<c:url value="/"/>resources/img/king.png">
					</div>
					<div class="right_box">
						<p>이병수 전도사</p>
					</div>
				</li>
				<li>
					<div class="left_box">
						<img alt="" src="<c:url value="/"/>resources/img/king.png">
					</div>
					<div class="right_box">
						<p>이병수 전도사</p>
					</div>
				</li>
			</ul>
		</div>
		
		<div class="list_wrap list3">
			<ul>
				<li>
					<div class="left_box">
						<img alt="" src="<c:url value="/"/>resources/img/king.png">
					</div>
					<div class="right_box">
						<p>이병수 장로</p>
					</div>
				</li>
				<li>
					<div class="left_box">
						<img alt="" src="<c:url value="/"/>resources/img/king.png">
					</div>
					<div class="right_box">
						<p>이병수 장로</p>
					</div>
				</li>
				<li>
					<div class="left_box">
						<img alt="" src="<c:url value="/"/>resources/img/king.png">
					</div>
					<div class="right_box">
						<p>이병수 장로</p>
					</div>
				</li>
				<li>
					<div class="left_box">
						<img alt="" src="<c:url value="/"/>resources/img/king.png">
					</div>
					<div class="right_box">
						<p>이병수 장로</p>
					</div>
				</li>
				<li>
					<div class="left_box">
						<img alt="" src="<c:url value="/"/>resources/img/king.png">
					</div>
					<div class="right_box">
						<p>이병수 장로</p>
					</div>
				</li>
			</ul>
		</div>
		
		
	</div>
</div>

<jsp:include page="../common/footer.jsp"/>

</body>

<script>
	$(document).ready(function(){
		$(".volunteers_btn > li").click(function(){
			$(this).addClass("on");
			$(this).siblings("li").removeClass("on");
		});
		
		$(".volunteers_btn > li:eq(0)").click(function(){
			$(".list1").show();
			$(".list2").hide();
			$(".list3").hide();
		});
		
		$(".volunteers_btn > li:eq(1)").click(function(){
			$(".list2").show();
			$(".list1").hide();
			$(".list3").hide();
		});
		
		$(".volunteers_btn > li:eq(2)").click(function(){
			$(".list3").show();
			$(".list2").hide();
			$(".list1").hide();
		});
	})
</script>
</html>