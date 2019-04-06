<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/adminmeta.jsp"/>
</head>
<body>
<div id="wrap">
	<!--header s-->
	<jsp:include page="header.jsp"/>
	<jsp:include page="nav.jsp"/>
	<!--header e-->
	<!--container s-->
		<div id="container">
			<div class="main_title">
				<p>교회학교 관리</p>
			</div>

			<div class="category_wrap">
				<ul class="ul_form1">
					<li><a href="#" class="btnform3">영유아부</a></li>
					<li><a href="#" class="btnform3">유치부</a></li>
					<li><a href="#" class="btnform3">유년부</a></li>
					<li><a href="#" class="btnform3">소년부</a></li>
					<li><a href="#" class="btnform3">중등부</a></li>
					<li><a href="#" class="btnform3">고등부</a></li>
					<li><a href="#" class="btnform3">제1청년회</a></li>
					<li><a href="#" class="btnform3">제2청년회</a></li>
				</ul>
			</div>


			<div class="management_wrap" style="text-align:center;">
				<p class="tal f20 mb10 fb">영유아부</p>
				<table>
					<colgroup>
						<col width="15%">
						<col width="35%">
						<col width="15%">
						<col width="35%">
					</colgroup>
					<tbody>
						<tr>
							<td>이미지</td>
							<td colspan="3" class="tal">
								<img src="<c:url value="/"/>resources/uploadPhoto/1553920806011.jpg">
								<input type="file" style="padding:0;">
							</td>
						</tr>
						<tr>
							<td>교육표어</td>
							<td><input type="text" name="" id="" value=""></td>
							<td>주제말씀</td>
							<td><input type="text" name="" id="" value=""></td>
						</tr>
						<tr>
							<td>예배대상</td>
							<td><input type="text" name="" id="" value=""></td>
							<td>예배시간</td>
							<td><input type="text" name="" id="" value=""></td>
						</tr>
						<tr>
							<td>예배장소</td>
							<td colspan="3"><input type="text" name="" id="" value=""></td>
						</tr>
					</tbody>
				</table>	
				
				<table class="mt20">
					<colgroup>
						<col width="15%">
						<col width="35%">
						<col width="15%">
						<col width="35%">
					</colgroup>
					<tbody>
						<tr>
							<td>지도</td>
							<td><input type="text" name="" id="" value=""></td>
							<td>부장</td>
							<td><input type="text" name="" id="" value=""></td>
						</tr>
						<tr>
							<td>부감</td>
							<td><input type="text" name="" id="" value=""></td>
							<td>총무</td>
							<td><input type="text" name="" id="" value=""></td>
						</tr>
						<tr>
							<td>서기</td>
							<td><input type="text" name="" id="" value=""></td>
							<td>회계</td>
							<td><input type="text" name="" id="" value=""></td>
						</tr>
						<tr>
							<td>선생님</td>
							<td colspan="3"><input type="text" name="" id="" value=""></td>
						</tr>
					</tbody>
				</table>
				
				<button class="btnform1 mt20">수정</button>			
			</div>
			
			<div class="management_wrap" style="text-align:center;">
				<p class="tal f20 mb10 fb">제1청년회</p>
				<table>
					<colgroup>
						<col width="15%">
						<col width="35%">
						<col width="15%">
						<col width="35%">
					</colgroup>
					<tbody>
						<tr>
							<td>이미지</td>
							<td colspan="3" class="tal">
								<img src="<c:url value="/"/>resources/uploadPhoto/1553920806011.jpg">
								<input type="file" style="padding:0;">
							</td>
						</tr>
						<tr>
							<td>교육표어</td>
							<td><input type="text" name="" id="" value=""></td>
							<td>주제말씀</td>
							<td><input type="text" name="" id="" value=""></td>
						</tr>
						<tr>
							<td>예배대상</td>
							<td><input type="text" name="" id="" value=""></td>
							<td>예배시간</td>
							<td><input type="text" name="" id="" value=""></td>
						</tr>
						<tr>
							<td>예배장소</td>
							<td colspan="3"><input type="text" name="" id="" value=""></td>
						</tr>
					</tbody>
				</table>	
				
				<table class="mt20">
					<colgroup>
						<col width="15%">
						<col width="35%">
						<col width="15%">
						<col width="35%">
					</colgroup>
					<tbody>
						<tr>
							<td>지도</td>
							<td colspan="3"><input type="text" name="" id="" value=""></td>
							
						</tr>
						<tr>
							<td>부장</td>
							<td><input type="text" name="" id="" value=""></td>
							<td>회장</td>
							<td><input type="text" name="" id="" value=""></td>
							
						</tr>
						<tr>
							<td>부회장</td>
							<td><input type="text" name="" id="" value=""></td>
							<td>총무</td>
							<td><input type="text" name="" id="" value=""></td>
							
						</tr>
						<tr>
							<td>서기</td>
							<td><input type="text" name="" id="" value=""></td>
							<td>회계</td>
							<td><input type="text" name="" id="" value=""></td>
							
						</tr>
					</tbody>
				</table>
				
				<button class="btnform1 mt20">수정</button>			
			</div>
		</div>
	<!--container s-->
	</div>

 </body>
</html>
