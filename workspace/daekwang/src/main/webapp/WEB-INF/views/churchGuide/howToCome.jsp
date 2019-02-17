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
			<p class=title>찾아오시는 길</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<div class="howtocome_wrap">
		<div class=map_wrap>
			<div id="map" style="width:100%;height:100%;"></div>
		</div>
		
		<div class="map_text">
			<table>
				<colgroup>
					<col width="25%">
					<col width="25%">
					<col width="25%">
					<col width="25%">
				</colgroup>
				<tbody>
					<tr>
						<td class="title1">주소</td>
						<td colspan="3">431-806 경기도 안양시 동안구 일동로 122번길 36</td>						
					</tr>
					<tr>
						<td class="title1">대표전화</td>
						<td>031-384-7408</td>					
						<td class="title1">팩스</td>					
						<td>031-388-3090</td>					
					</tr>
					<tr>
						<td class="title1">2층 사무실</td>
						<td>031-383-7408</td>					
						<td class="title1">교육관</td>					
						<td>031-384-7401, 031-384-7403</td>					
					</tr>
										
				</tbody>
			</table>		
		</div>
	</div>
</div>

<jsp:include page="../common/footer.jsp"/>

</body>
<script type="text/javascript">
var map = new naver.maps.Map('map', {
    center: new naver.maps.LatLng(37.4068595,126.9595592),
    zoom: 13
});

// 1. 정보 창 + 마커
var marker1 = new naver.maps.Marker({
        position: new naver.maps.LatLng(37.4068595,126.9595592),
        icon: {
            url: 'https://ssl.pstatic.net/static/maps/img/icons/pin_s_1.png',
            size: new naver.maps.Size(22, 30),
            anchor: new naver.maps.Point(11, 30)
        },
        title: '1번 마커',
        map: map
    }),
    iwContent1 = [
        '<div>',
            '<div style="margin:0;padding:0;">',
                '<a href="#" class="spmc btn_clear">핀 삭제</a>',
                '<div class="p5">안양대광교회</div>',
            '</div>',
        '</div>'
    ].join(''),
    
    infowindow1 = new naver.maps.InfoWindow({
        content: iwContent1
    });

$(infowindow1.getWrapElement()).find('.btn_clear').on('click', function(e) {
    infowindow1.close();
});

naver.maps.Event.addListener(marker1, 'click', function(e) {
    infowindow1.open(map, marker1);
});






</script>
</html>