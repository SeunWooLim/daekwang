<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>

<jsp:include page="../common/header.jsp"/>
<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>특송</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	<div class="worshiptab worshiptab1">
		<ul>
			
			<li><a href="unionChoir.do"><i class="xi-bell-o"></i>연합찬양대</a></li>
			<li><a href="specialSong.do" class="on"><i class="xi-bell-o"></i>특송</a></li>
			<li><a href="specialEvent.do"><i class="xi-bell-o"></i>특별행사</a></li>
		</ul>
	</div>
	<div class="moviewrap">
		<ul id="results" class="movieul">
			<li>	
				<a href="https://www.youtube.com/playlist?list=PLwcdqPJXVv0aBMn89M0WaPVdqYyVXzG_j" target="_blank">
					<div class="mwrap">
						<img width="222" height="118" src="<c:url value="/resources/img/youtube.jpg"/>">
						<div class="text">
							<p class="title">배너클릭시 특송 유튜브채널로 이동합니다.</p>
							<p class="text">Sunday Worship</p>
						</div>
					</div>
				</a>
			</li>
		</ul>
		
	</div>
	
	
</div>
<jsp:include page="../common/footer.jsp"/>

<script type="text/javascript">
    var playlist = 'PLwcdqPJXVv0aBMn89M0WaPVdqYyVXzG_j';
    
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
                       output=                    	   	 
							'<li>'+
								'<a href="videoDetail.do?vid=' + vId +'&desc=' + desc + '&menu=5&playlist=' + playlist + '">'+
									'<div class="mwrap">' +
										'<img width="222" height="118" src=\"//img.youtube.com/vi/' + vId + '/mqdefault.jpg\">' +
										'<div class="text">' +
											'<p class="title">' + vTitle + '</p>' +
											'<p class="text">Special Song</p>' +
										'</div>' +
									'</div>' +
								 '</a>' +
							'</li>'
                 		 ;
                 $("#results").append(output);
             })
         }
         );
	});

</script>

</body>
</html>