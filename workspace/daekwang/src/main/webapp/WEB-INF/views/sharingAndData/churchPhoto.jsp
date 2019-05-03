<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>

<jsp:include page="../common/header.jsp"/>
<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>교회사진</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<div class="photo_wrap">
		<c:if test="${sessionScope.loginUser.MEMBER_AUTH eq 'W'}">
			<div class="insertBtn_wrap">
				<a href="churchPhotoInsert.do" class="newInsertBtn">글쓰기</a>
			</div>
		</c:if>
		
		<ul class="photo_list masonry2" id="churchPhoto">
			<li class="sizer w25"></li>
		</ul>
	</div>
</div>

<jsp:include page="../common/footer.jsp"/>
</body>

<!-- 무한 스크롤 처리 -->
<script type="text/javascript">
	let isEnd = false;
	let pageNum = 1;

	$(function() {
		$(window).scroll(function() {
			let $window = $(this);
			let scrollTop = $window.scrollTop();
			let windowHeight = $window.height();
			let documentHeight = $(document).height();
	
			// scrollbar의 thumb가 바닥 전 50px까지 도달 하면 리스트를 가져온다.
			if (scrollTop + windowHeight + 50 > documentHeight) {
				fetchList(pageNum);
				pageNum++;
			}
		})
		fetchList(pageNum);
	})

	let fetchList = function(pageNum) {
		if (isEnd == true) {
			return;
		}

		$.ajax({
	      	url: "addChurchPhoto.do",
	      	data: {"pageNum" : pageNum},
	      	type: "post",
	      	dataType: "JSON",
	      	success: function(result){
	      		$('#churchPhoto').html("");
	      		var jsonStr = JSON.stringify(result);
	      		var json = JSON.parse(jsonStr);
	      		var tag = "";
	      			
	      		for(var i = 0; i<json.churchPhoto.length; i++){
	      			var endNum = json.churchPhoto[i].photo_count;
	      			var imageName = json.churchPhoto[i].photo_image;
	      			tag += 
			      			'<li class="item w25">' +
								'<div class="photo_top">' +
									'<ul>' +
										'<li>' + json.churchPhoto[i].board_title + '</li>' +
										'<li>' + json.churchPhoto[i].recent_update_date + '</li>' +
									'</ul>' +
								'</div>' +
								'<div class="photo_mid">' +
									'<ul>';
										var tempA = 4;
										var tempB = 21;
										for(var j = 1; j <= json.churchPhoto[i].photo_count; j++  ){
											//카페24 경로
											//tag +=	'<li><img src="<c:url value="/upload/' + json.churchPhoto[i].upload_yymm + '/' + imageName.substring(tempA, tempB) + '"/>"></li>' ;
											//로컬서버 경로
											tag +=	'<li><img src="<c:url value="/resources/uploadChurch/' + imageName.substring(tempA, tempB) + '"/>"></li>' ;
											tempA += 17;
											tempB += 17;
										} 
					tag +=			'</ul>' +
								'</div>' +
								'<div class="photo_bot">' +
									json.churchPhoto[i].board_content +
								'</div>' +
							'</li>'
							;
	      		}
	      		$('#churchPhoto').html(tag);
      			
	      		$(".photo_mid > ul").bxSlider({
	  				mode: "fade",    
	  				slideMargin: 0,
	  				moveSlides: 1,
	  				startSlide: 0,         
	  				infiniteLoop: true,    
	  				//captions: true,       
	  				pager: true,         
	  				adaptiveHeight: true,   
	  				auto: false,            
	  				pause: 3000,           
	  				speed: 500,           
	  				easing: "",	
	  				touchEnabled:true,   	
	  				controls: true,
	  				//video: true,
	  				useCSS: false,
	  			});
	      	},
	      	error: function(request, status, errorData){
	      		alert("error code : " + request.status + "\n" + "message : " + request.responseText + "\n" + "error : " + errorData);
	      	}
    	});
	}

</script>


</html>