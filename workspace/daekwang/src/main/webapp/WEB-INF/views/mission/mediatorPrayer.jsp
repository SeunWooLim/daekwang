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
			<p class=title>중보기도회</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<div class="cc_wrap">
		<div id="infantsTab"  class="nextgene_cate">
			<div class="next_detail">
				<img alt="" src="<c:url value="/resources/img/pray.png"/>">
				<div class="next_left">
					<p>중보기도</p>
				</div>
				<div class="next_right">
					<div class="right_left">
						
						<table>
							<colgroup>
								
								<col width="*">
							</colgroup>
							<tbody>
								<tr>
									<td class="title fb">화요 중보 기도모임</td>
								</tr>
								<tr>
									<td>일시 : 매주 화요일 오전 10시, 장소 : 본당 지하 유치부실</td>									
								</tr>
								
								<tr>
									<td class="title fb">어머니 기도회</td>
								</tr>
								<tr>
									<td>일시 : 매주 목요일 오후 3시, 장소 : 교육관</td>
									
								</tr>
								
								
								<tr>
									<td class="title fb">주일 중보 기도모임</td>
								</tr>
								<tr>
									<td>일시 : 매주 주일, 장소 : 중보기도실</td>
									
								</tr>
								
								
								
								<tr>
									<td class="title fb">금요 기도모임</td>
								</tr>
								<tr>
									<td>일시 : 매월 첫째주 금요일 저녁 8시, 장소 : 본당</td>
									
								</tr>
							
							</tbody>
						</table>
					</div>				
				</div>
			</div>
			
		
		</div>
		
	</div>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>