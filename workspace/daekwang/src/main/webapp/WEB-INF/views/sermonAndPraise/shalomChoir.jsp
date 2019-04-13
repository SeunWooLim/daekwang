<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>

<jsp:include page="../common/header.jsp"/>
<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>샬롬 찬양대</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	<div class="worshiptab worshiptab2">
		<ul>
			<li><a href="#" class="on"><i class="xi-bell-o"></i>샬롬 찬양대 소개</a></li>
			<li><a href="#"><i class="xi-bell-o"></i>샬롬 찬양대 영상</a></li>
		</ul>
	</div>
	<div class="nextgene_wrap1">
		<img alt="" src="<c:url value="/"/>resources/img/deptImage/${sapVo1.PRAISE_PHOTO_RENAME }">
		<div class="next_detail">	
			<p class="next_title">샬롬 찬양대 임원조직</p>			
			<div class="next_right">
				<div class="right_left">
					<table>
						<colgroup>
							<col width="16.666%">
							<col width="16.666%">
							<col width="16.666%">
							<col width="16.666%">
							<col width="16.666%">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<td class="title" >대장</td>
								<td colspan="5" class="tech" style="padding: 0 59px;">${sapVo1.PRAISE_BOSS }</td>
							</tr>
							<tr>
								<td class="title">지휘</td>
								<td>${sapVo1.PRAISE_CONDUCTOR }</td>
								<td class="title">총무</td>
								<td>${sapVo1.PRAISE_MANAGER }</td>
								<td class="title">부총무</td>
								<td>${sapVo1.PRAISE_SUBMANAGER }</td>
							</tr>
							<tr>
								<td class="title">서기</td>
								<td>${sapVo1.PRAISE_WRITER }</td>
								<td class="title">회계</td>
								<td>${sapVo1.PRAISE_ACCOUNTANT }</td>
								<td class="title">반주</td>
								<td>${sapVo1.PRAISE_BANJU }</td>
							</tr>
							<tr>
								<td class="title">소프라노</td>
								<td colspan="5" class="tech">${sapVo1.PRAISE_SOPRANO }</td>
							</tr>
							<tr>
								<td class="title">알토</td>
								<td colspan="5" class="tech">${sapVo1.PRAISE_ALTO }</td>
							</tr>
							<tr>
								<td class="title">테너</td>
								<td colspan="5" class="tech">${sapVo1.PRAISE_TENOR }</td>
							</tr>
							<tr>
								<td class="title">베이스</td>
								<td colspan="5" class="tech">${sapVo1.PRAISE_BASS }</td>
							</tr>								
						</tbody>
					</table>
				</div>				
			</div>
		</div>
	</div>
	
	
	<div class="moviewrap">
		<ul id="results" class="movieul"></ul>
	</div>
	
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
<script>
	$(document).ready(function(){
		$(".nextgene_wrap1").show();
		$(".moviewrap").hide();
		
		$(".worshiptab > ul > li:eq(0) > a").click(function(e){
			e.preventDefault();
			$(".nextgene_wrap1").show();
			$(".moviewrap").hide();
			$(this).addClass("on");
			$(this).parent().siblings().find('a').removeClass();
		});
		$(".worshiptab > ul > li:eq(1) > a").click(function(e){
			e.preventDefault();
			$(".nextgene_wrap1").hide();
			$(".moviewrap").show();
			$(this).addClass("on");
			$(this).parent().siblings().find('a').removeClass();
		});
	})
</script>

<script type="text/javascript">
    var playlist = 'PLwcdqPJXVv0a-ggDC9Xr9ycvkOKCmIzLk';
    
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
								'<a href="videoDetail.do?vid=' + vId +'&desc=' + desc + '&menu=7&playlist=' + playlist + '">'+
									'<div class="mwrap">' +
										'<img width="222" height="118" src=\"//img.youtube.com/vi/' + vId + '/mqdefault.jpg\">' +
										'<div class="text">' +
											'<p class="title">' + vTitle + '</p>' +
											'<p class="text">Shalom Choir</p>' +
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
</html>