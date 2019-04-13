<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>

<jsp:include page="../common/header.jsp"/>
<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>행사 동영상</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<div class="moviewrap">
		<ul id="results" class="movieul"></ul>
		<div class="youtube_Btn">
			<a href="https://www.youtube.com/playlist?list=PLwcdqPJXVv0b0pUV1530909VFaApVt6mf" target="_blank">
				<i class="xi-youtube-play"></i>
				<span>대광교회 YouTube</span>
			</a>
		</div>
	</div>
	
</div>
<jsp:include page="../common/footer.jsp"/>

<script type="text/javascript">
    var playlist = 'PLwcdqPJXVv0b0pUV1530909VFaApVt6mf';
    
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
								'<a href="videoDetail.do?vid=' + vId +'&desc=' + desc + '&menu=9&playlist=' + playlist + '">'+
									'<div class="mwrap">' +
										'<img width="222" height="118" src=\"//img.youtube.com/vi/' + vId + '/mqdefault.jpg\">' +
										'<div class="text">' +
											'<p class="title">' + vTitle + '</p>' +
											'<p class="text">Sunday Worship</p>' +
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