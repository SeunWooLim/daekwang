<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>

<jsp:include page="../common/header.jsp"/>
<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<c:choose>
				<c:when test="${menu eq 1 }">
					<p class="title">주일 낮 설교</p>
				</c:when>
				<c:when test="${menu eq 2 }">
					<p class="title">수요기도회 설교</p>
				</c:when>
				<c:when test="${menu eq 3 }">
					<p class="title">올젠워십 설교</p>
				</c:when>
				<c:when test="${menu eq 4 }">
					<p class="title">연합 찬양대</p>
				</c:when>
				<c:when test="${menu eq 5 }">
					<p class="title">특송</p>
				</c:when>
				<c:when test="${menu eq 6 }">
					<p class="title">특별예배</p>
				</c:when>
				<c:when test="${menu eq 7 }">
					<p class="title">샬롬 찬양대</p>
				</c:when>
				<c:when test="${menu eq 8 }">
					<p class="title">임마누엘 찬양대</p>
				</c:when>
				<c:when test="${menu eq 9 }">
					<p class="title">특별행사</p>
				</c:when>
			</c:choose>
			
			<p class="text">안양대광교회</p>
		</div>
	</div>
	<!-- 
	메뉴 파라미터(menu)
	1 : 주일낮 설교
	2 : 수요기도회 설교
	3 : 올젠워십 설교
	4 : 연합찬양대
	5 : 특송
	6 : 특별예배
	7 : 샬롬 찬양대
	8 : 임마누엘 찬양대
	9 : 특별행사
	 -->
	<c:choose>
		<c:when test="${menu eq 1 }">
			<div class="worshiptab">
				<ul>
					<li><a href="sundayWorship.do" class="on"><i class="xi-bell-o"></i>주일 낮 설교</a></li>
					<li><a href="wednesdayWorship.do"><i class="xi-bell-o"></i>수요기도회 설교</a></li>
					<li><a href="allgenWorship.do"><i class="xi-bell-o"></i>올젠워십 설교</a></li>
				</ul>
			</div>
		</c:when>
		<c:when test="${menu eq 2 }">
			<div class="worshiptab">
				<ul>
					<li><a href="sundayWorship.do"><i class="xi-bell-o"></i>주일 낮 설교</a></li>
					<li><a href="wednesdayWorship.do" class="on"><i class="xi-bell-o"></i>수요기도회 설교</a></li>
					<li><a href="allgenWorship.do"><i class="xi-bell-o"></i>올젠워십 설교</a></li>
				</ul>
			</div>		
		</c:when>
		<c:when test="${menu eq 3 }">
			<div class="worshiptab">
				<ul>
					<li><a href="sundayWorship.do"><i class="xi-bell-o"></i>주일 낮 설교</a></li>
					<li><a href="wednesdayWorship.do"><i class="xi-bell-o"></i>수요기도회 설교</a></li>
					<li><a href="allgenWorship.do" class="on"><i class="xi-bell-o"></i>올젠워십 설교</a></li>
				</ul>
			</div>
		</c:when>
		<c:when test="${menu eq 4 }">
			<div class="worshiptab worshiptab1">
				<ul>
					<li><a href="unionChoir.do" class="on"><i class="xi-bell-o"></i>연합찬양대</a></li>
					<li><a href="specialSong.do"><i class="xi-bell-o"></i>특송</a></li>
					<li><a href="specialEvent.do"><i class="xi-bell-o"></i>특별예배</a></li>
				</ul>
			</div>
		</c:when>
		<c:when test="${menu eq 5 }">
			<div class="worshiptab worshiptab1">
				<ul>
					<li><a href="unionChoir.do"><i class="xi-bell-o"></i>연합찬양대</a></li>
					<li><a href="specialSong.do" class="on"><i class="xi-bell-o"></i>특송</a></li>
					<li><a href="specialEvent.do"><i class="xi-bell-o"></i>특별예배</a></li>
				</ul>
			</div>
		</c:when>
		<c:when test="${menu eq 6 }">
			<div class="worshiptab worshiptab1">
				<ul>
					<li><a href="unionChoir.do"><i class="xi-bell-o"></i>연합찬양대</a></li>
					<li><a href="specialSong.do"><i class="xi-bell-o"></i>특송</a></li>
					<li><a href="specialEvent.do" class="on"><i class="xi-bell-o"></i>특별예배</a></li>
				</ul>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	
	<div class="iframe_wrapp">
		<div class="iframe_wrap">
			<iframe class="iframe11" width="840" height="500" src="https://www.youtube.com/embed/${vid}" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
		</div>
		
		<div class="visual">
			<div class="list">
				<div class="oh" id="choisBox">
		        	<div class="wrap slick-initialized slick-slider slick-vertical">
		            	<div class="slick-list draggable" tabindex="0" style="height: 485px;">
		            		<div class="slick-track" id="result" style="opacity: 1; height: 485px; transform: translate3d(0px, 0px, 0px); overflow-y:auto; overflow-x: hidden;">
		            			
							</div>
						</div>	
		       		</div>
				</div>
			</div>
		</div>
	
	</div>
	
	
	<p class="iframe_text">${desc }</p>
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
<script type="text/javascript">
    var playlist = '${playlist}';
    var menu = '${menu}';
    
    $(document).ready(function(){
       $.get(
           "https://www.googleapis.com/youtube/v3/playlistItems", {
               part: 'snippet',
               maxResults: 50,
               playlistId: playlist,
               key: 'AIzaSyAYH3AjbJxhiYngE1l5obNvwBPNo5_lnyg'},
               function(data){
                   var output;
                   $.each(data.items, function(i, item){
                       console.log(item);
                       vTitle = item.snippet.title;
                       vId = item.snippet.resourceId.videoId;
                       var temp = item.snippet.publishedAt;
                       var time = temp.substring(0,10);
                       var desc = item.snippet.description;
                       var num = 1;
                       //output = '<li>'+vTitle + '<br>--videoid: ' + vId+'<br>--time: ' + time + '<br>--desc: '+ desc + '</li>';
                       //output= '<li>'+vTitle+'<iframe src="//www.youtube.com/embed/'+vId+'\"></iframe></li>';
                       output=                    	   	 
								'<div class="slide slide01Box slick-slide slick-active" name="slide" index="0" style="width: 350px;">'+
									'<div class="box">' +
										'<a class="img" href="videoDetail.do?vid=' + vId +'&desc=' + desc + '&menu=' + menu + '&playlist=' + playlist + '">'+
											'<div class="on"><i class="xi-play-circle"></i></div>' +
											'<img src=\"//img.youtube.com/vi/' + vId + '/mqdefault.jpg\">' +
										'</a>' +
										'<div class="contents">' +
											'<a class="tit" href="videoDetail.do?vid=' + vId +'&desc=' + desc + '&menu=' + menu + '">' + vTitle + '</a>' +										
										'</div>' +
									'</div>' +
								'</div>'
                       		 ;
                       $("#result").append(output);
                   })
               }
               );
    });

</script>
</html>