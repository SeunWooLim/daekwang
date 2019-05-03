<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../common/meta.jsp"/>

<jsp:include page="../common/header.jsp"/>
<div id="wrap">
<div class="subvisual_wrap">
	<div class="subvisual_text">
		<p class=title>예배안내</p>
		<p class="text">안양대광교회</p>
	</div>
</div>

<div class="worshipGuide_wrap">
	<div class="time_table">
		<p class="title">예배시간</p>
		<table>
			<colgroup>
				<col width="30%">
				<col width="*">
				<col width="30%">
			</colgroup>
			<tbody>
				<tr>
					<td class="title1">예배</td>
					<td class="title2">시간</td>
					<td class="title2">장소</td>
				</tr>
				<tr>
					<td class="title2">새벽기도회</td>
					<td>매일 새벽 <span>05:30</span></td>
					<td rowspan="6">본당</td>
				</tr>
				<tr>
					<td class="title2">낮예배 1부</td>
					<td>주일 오전 <span>07:30</span></td>
				</tr>
				<tr>
					<td class="title2">낮예배 2부</td>
					<td>주일 오전 <span>10:00</span></td>
				</tr>
				<tr>
					<td class="title2">낮예배 3부</td>
					<td>주일 오전 <span>11:30</span></td>
				</tr>
				<tr>
					<td class="title2">낮예배 4부</td>
					<td>주일 오후 <span>02:00</span></td>
				</tr>
				<tr>
					<td class="title2">수요기도회</td>
					<td>수요일 저녁 <span>08:00</span></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="time_table">
		<p class="title">교회학교</p>
		<table>
			<colgroup>
				<col width="22%">
				<col width="26%">
				<col width="26%">
				<col width="26%">
			</colgroup>
			<tbody>
				<tr>
					<td class="title1">부서</td>
					<td class="title2">대상</td>
					<td class="title2">시간</td>
					<td class="title2">장소</td>
				</tr>
				<tr>
					<td class="title2">유아부</td>
					<td>1~4세</td>
					<td>주일 오전 <span>10:00</span></td>
					<td>본당 유아부실(B1)</td>
				</tr>
				<tr>
					<td class="title2">유치부</td>
					<td>5~7세</td>
					<td>주일 오전 <span>11:30</span></td>
					<td>본당 유치부실(B1)</td>
				</tr>
				<tr>
					<td class="title2">유년부</td>
					<td>초등 1~3학년</td>
					<td>주일 오전 <span>11:30</span></td>
					<td>교육관 부서 예배실</td>
				</tr>
				<tr>
					<td class="title2">소년부</td>
					<td>초등 4~6학년</td>
					<td>주일 오전 <span>11:30</span></td>
					<td>교육관 부서 예배실</td>
				</tr>
				<tr>
					<td class="title2">중등부</td>
					<td>중학생</td>
					<td>주일 오전 <span>09:30</span></td>
					<td>교육관 부서 예배실</td>
				</tr>
				<tr>
					<td class="title2">고등부</td>
					<td>고등학생</td>
					<td>주일 오전 <span>09:30</span></td>
					<td>교육관 부서 예배실</td>
				</tr>
				<tr>
					<td class="title2">제2청년부</td>
					<td>19~25세</td>
					<td>주일 오후 <span>03:00</span></td>
					<td>본당 유아부실(B1)</td>
				</tr>
				<tr>
					<td class="title2">제1청년부</td>
					<td>26세 이상</td>
					<td>주일 오후 <span>03:00</span></td>
					<td>본당 유아실</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="time_table">
		<p class="title">차량운행(3부예배)</p>
		<table>
			<colgroup>
				<col width="30%">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<td class="title2">1호차(5642)</td>
					<td class="p20">
						교회출발 <span>(10:15)</span> <i class="xi-arrow-right"></i>
						석수동 삼성초교앞 <span>(10:35)</span> <i class="xi-arrow-right"></i>
						한전 앞 <span>(10:45)</span> <i class="xi-arrow-right"></i>
						지하도 위 <span>(10:55)</span> <i class="xi-arrow-right"></i>
						파리바게트 <span>(11:10)</span> <i class="xi-arrow-right"></i>
						교회도착
					</td>
				</tr>
				<tr>
					<td class="title2">2호차(8914)</td>
					<td class="p20">
						교회출발 <span>(10:10)</span> <i class="xi-arrow-right"></i>
						미륭APT앞 육교 <span>(10:50)</span> <i class="xi-arrow-right"></i>
						개천(원주APT) <span>(10:55)</span> <i class="xi-arrow-right"></i>
						동편마을4단지정문 <span>(11:05 ~ 11:10)</span> <i class="xi-arrow-right"></i>
						동편마을2단지정문 <span>(11:15)</span> <i class="xi-arrow-right"></i>
						교회도착 <span>(11:20)</span>
					</td>
				</tr>
				<tr>
					<td class="title2">3호차(8915)</td>
					<td class="p20">
						교회출발 <span>(10:10)</span> <i class="xi-arrow-right"></i>
						병목안 <span>(10:30)</span> <i class="xi-arrow-right"></i>
						프라자APT <span>(10:35)</span> <i class="xi-arrow-right"></i>
						안양성당 <span>(10:40)</span> <i class="xi-arrow-right"></i>
						소방서동명APT <span>(10:45)</span> <i class="xi-arrow-right"></i>
						샘병원 <span>(10:45)</span> <i class="xi-arrow-right"></i>
						수촌마을 <span>(10:55)</span> <i class="xi-arrow-right"></i>
						교회도착 <span>(11:05)</span>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</div>

<jsp:include page="../common/footer.jsp"/>

</body>
</html>