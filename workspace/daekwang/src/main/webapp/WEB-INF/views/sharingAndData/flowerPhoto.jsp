<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>

<jsp:include page="../common/header.jsp"/>
<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>꽃꽃이갤러리</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<div class="photo_wrap">
		<c:if test="${sessionScope.loginUser ne null}">
			<div class="insertBtn_wrap">
				<a href="flowerPhotoInsert.do" class="newInsertBtn">글쓰기</a>
			</div>
		</c:if>
		
		<ul class="photo_list masonry2" id="flowerPhoto">
			<li class="sizer w25"></li>
		</ul>
	</div>
	
	
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>


<script>

	var container1 = document.querySelector( '.masonry2' );
	var msnry1 = $('.masonry2').masonry( {	  
		  	itemSelector	: ".item",
			columnWidth	: '.sizer',
			gutter : 20,
			percentPosition : true,
			
			
		});
	
	 msnry1.imagesLoaded().progress(function(){
				msnry1.masonry('layout');
	});
	
	 	
</script>

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
	
			console.log("documentHeight:" + documentHeight + " | scrollTop:" +
			scrollTop + " | windowHeight: " + windowHeight);
			
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
	      	url: "addFlowerPhoto.do",
	      	data: {"pageNum" : pageNum},
	      	type: "post",
	      	dataType: "JSON",
	      	success: function(result){
	      		$('#flowerPhoto').html("");
	      		var jsonStr = JSON.stringify(result);
	      		var json = JSON.parse(jsonStr);
	      		var tag = "";
	      			
	      		for(var i = 0; i<json.flowerPhoto.length; i++){
	      			tag += 
		      				'<li class="item w25">' +
								'<div class="photo_top">' +
									'<ul>' +
										'<li>' + json.flowerPhoto[i].board_title + '</li>' +
										'<li>' + json.flowerPhoto[i].recent_update_date + '</li>' +
									'</ul>' +
								'</div>' +
								'<div class="photo_mid">' +
									'<ul>' +
										'<li><img src="<c:url value="/"/>resources/uploadPhoto/' + json.flowerPhoto[i].photo_rename + '"></li>' +
									'</ul>' +
								'</div>' +
								'<div class="photo_bot">' +
									json.flowerPhoto[i].board_content +
								'</div>' +
							'</li>'
							;
	      		}
	      		$('#flowerPhoto').html(tag);
	      	},
	      	error: function(request, status, errorData){
	      		alert("error code : " + request.status + "\n" + "message : " + request.responseText + "\n" + "error : " + errorData);
	      	}
    	});
	}

</script>

</html>