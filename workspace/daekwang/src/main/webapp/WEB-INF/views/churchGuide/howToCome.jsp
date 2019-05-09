<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>

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
						<td colspan="3">(우) 13931  경기도 안양시 동안구 일동로122번길 36</td>						
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
						<td>031-384-7401</td>					
					</tr>
										
				</tbody>
			</table>		
		</div>
	</div>
</div>

<jsp:include page="../common/footer.jsp"/>

</body>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a133c1f242bcc6b7395cedda3c3feffb"></script>
<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new daum.maps.LatLng(37.4068595,126.9595592), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };
	
	var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	// 지도를 클릭한 위치에 표출할 마커입니다
	var marker = new daum.maps.Marker({ 
	    // 지도 중심좌표에 마커를 생성합니다 
	    position: map.getCenter() 
	}); 
	// 지도에 마커를 표시합니다
	marker.setMap(map);
	
	// 지도에 클릭 이벤트를 등록합니다
	// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
	daum.maps.event.addListener(map, 'click', function(mouseEvent) {        
	    
	    // 클릭한 위도, 경도 정보를 가져옵니다 
	    var latlng = mouseEvent.latLng; 
	    
	    // 마커 위치를 클릭한 위치로 옮깁니다
	    marker.setPosition(latlng);
	    
	    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
	    message += '경도는 ' + latlng.getLng() + ' 입니다';
	    
	    var resultDiv = document.getElementById('clickLatlng'); 
	    resultDiv.innerHTML = message;
	    
	});
</script>

</html>