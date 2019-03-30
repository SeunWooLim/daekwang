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
	
<%-- 	<c:set var="listCount" value="${listCount }"/>
	<% 
		String listNum = pageContext.getAttribute("listCount").toString();
		int listCount = Integer.parseInt(listNum);
	%> --%>
	
	<div class="pw_board_wrap">
		<div class="insertBtn_wrap">
	       <a href="#" class="newInsertBtn">글쓰기</a>
	    </div>
<%-- 		
		<ul>
			<c:forEach var="personNews" items="${list }">
				<li>
					<div class="head">
						<div><%= listCount %></div>
						<p class="title">${personNews.BOARD_TITLE }</p>
						<p class="text"><span>${personNews.RECENT_UPDATE_DATE }</span><span>${personNews.memberVo.MEMBER_NAME }</span></p>
						<i class="xi-angle-down"></i>
					</div>
					<div class="body">
						<p class="title">${personNews.BOARD_CONTENT }</p>
					</div>
				</li>
				<% 
					listCount--;
				%>
			</c:forEach>
		</ul>
 --%>		
 		<ul id="personNews">
		</ul>
	</div>
	
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
<script>
	$(document).ready(function(){
		$(".head").click(function(e){
			e.preventDefault();
			$(this).siblings(".body").slideToggle();
			$(this).parent().toggleClass("on");
			/* $(this).parent().siblings().find(".body").slideUp();
			$(this).parent().siblings().removeClass("on"); */
		})
	})
</script>
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
	      			
	      		for(var i = 0; i<json.personNewsList.length; i++){
	      			tag += 
		      				'<li>' +
								'<div class="head">' +
									'<div>' + listCount + '</div>' +
									'<p class="title">'+ json.personNewsList[i].board_title +'</p>' +
									'<p class="text"><span>' + json.personNewsList[i].recent_update_date + '</span><span>' + json.personNewsList[i].member_name + '</span></p>' +
									'<i class="xi-angle-down"></i>' +
								'</div>' +
								'<div class="body">' +
									'<p class="title">' + json.personNewsList[i].board_content + '</p>' +
								'</div>' +
							'</li>'
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

</html>