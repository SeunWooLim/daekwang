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
			<p class=title>임마누엘 찬양대</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	<div class="worshiptab worshiptab1">
		<ul>
			<li><a href="#" class="on"><i class="xi-bell-o"></i>샬롬 찬양대</a></li>
			<li><a href="#"><i class="xi-bell-o"></i>임마누엘 찬양대</a></li>
			<li><a href="#"><i class="xi-bell-o"></i>연합찬양대</a></li>
			<li><a href="#"><i class="xi-bell-o"></i>특송</a></li>
			<li><a href="#"><i class="xi-bell-o"></i>특별행사</a></li>
		</ul>
	</div>
	<div class="moviewrap">
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
</html>