<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>

<jsp:include page="../common/header.jsp"/>

<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>교우소식</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<c:if test="${sessionScope.loginUser.MEMBER_AUTH eq 'W'}">
		<div class="insertBtn_wrap mt20">
	       <a href="personNewsInsert.do" class="newInsertBtn">글쓰기</a>
	    </div>
	</c:if>
	
	<div class="pw_board_wrap">
 		<ul id="personNews">
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
	      	url: "addPersonNews.do",
	      	data: {"pageNum" : pageNum},
	      	type: "post",
	      	dataType: "JSON",
	      	success: function(result){
	      		$('#personNews').html("");
	      		var jsonStr = JSON.stringify(result);
	      		var json = JSON.parse(jsonStr);
	      		var tag = "";
	      		var listCount = json.listCount;
	      		var member_no = '${sessionScope.loginUser.MEMBER_NO}';
	      			
	      		for(var i = 0; i<json.personNewsList.length; i++){
	      			tag += 
		      				'<li>' +
								'<div class="head" id="head'+listCount+'" onclick=slideBtn('+listCount+')>' +
									'<div>' + listCount + '</div>' +
									'<p class="title">'+ json.personNewsList[i].board_title +'</p>' +
									'<p class="text"><span>' + json.personNewsList[i].recent_update_date + '</span><span>' + json.personNewsList[i].member_name + '</span></p>' +
									'<i class="xi-angle-down"></i>' +
								'</div>' +
								'<div class="body" id="body'+listCount+'">' +
									'<p class="title">' + json.personNewsList[i].board_content + '</p>' +
								'</div>';
								//삭제버튼 처리
								if(member_no == json.personNewsList[i].member_no){
									tag += 	'<i class="xi-close" onclick="delete_event(' + json.personNewsList[i].board_no + ');"></i>' ;
								}
								tag += 	'</li>'	;						
							;
					listCount--;
	      		}
	      		$('#personNews').html(tag);
	      	},
	      	error: function(request, status, errorData){
	      		alert("error code : " + request.status + "\n" + "message : " + request.responseText + "\n" + "error : " + errorData);
	      	}
    	});
	}
</script>

<script>
	function slideBtn(listCount){
		var body = document.getElementById("body");
		$("#body"+listCount).slideToggle();
		$("#head"+listCount).parent().toggleClass("on");
	}
	
	//게시물 삭제 Event
	function delete_event(BOARD_NO){
		var currentPage = '${currentPage}';
		var deleteYN = 'Y';
		
		if(confirm("정말 삭제하시겠습니까?") == true){
			location.href="personNews.do?deleteFlag="+deleteYN+"&BOARD_NO="+BOARD_NO; 
		}else{
			return;
		}
	}
</script>

</html>