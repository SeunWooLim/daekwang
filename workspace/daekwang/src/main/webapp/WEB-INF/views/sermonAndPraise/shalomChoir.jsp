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
		<img alt="" src="<c:url value="/"/>resources/img/ex111.jpg">
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
	
	
	<div class="moviewrap" style="display:none;">
		<p class="asdfasdf">샬롬 찬양대 영상</p>
		<ul>
			<li>
				<a href="#">
					<table>
						<colgroup>
							<col width="3%">
							<col width="25%">
							<col width="*">				
						</colgroup>
						<tbody>
							<tr>
								<td>10</td>
								<td>
									<img alt="" src="<c:url value="/"/>resources/img/movieex1.png">
								</td>
								<td>
									<p class="title">마커스워십 - 주의길</p>
									<p class="text">MARKERS WORSHIP</p>
								</td>
							</tr>
						</tbody>
					</table>	
				</a>
			</li>
			<li>
				<a href="#">
					<table>
						<colgroup>
							<col width="3%">
							<col width="25%">
							<col width="*">				
						</colgroup>
						<tbody>
							<tr>
								<td>10</td>
								<td>
									<img alt="" src="<c:url value="/"/>resources/img/movieex1.png">
								</td>
								<td>
									<p class="title">마커스워십 - 주의길</p>
									<p class="text">MARKERS WORSHIP</p>
								</td>
							</tr>
						</tbody>
					</table>	
				</a>
			</li>
		</ul>		
	</div>
	
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
<script>
	$(document).ready(function(){
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
</html>