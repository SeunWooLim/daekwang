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
				<p>샬롬찬양대 관리</p>
			</div>
			
			<div class="management_wrap" style="text-align:center;">
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
							<td>대장</td>
							<td colspan="3"><input type="text" name="" id="" value=""></td>							
						</tr>
						<tr>
							<td>지휘</td>
							<td><input type="text" name="" id="" value=""></td>
							<td>총무</td>
							<td><input type="text" name="" id="" value=""></td>							
						</tr>
						<tr>
							<td>부총무</td>
							<td><input type="text" name="" id="" value=""></td>
							<td>서기</td>
							<td colspan="3"><input type="text" name="" id="" value=""></td>
						</tr>
						<tr>
							<td>회계</td>
							<td><input type="text" name="" id="" value=""></td>
							<td>반주</td>
							<td><input type="text" name="" id="" value=""></td>
						</tr>
						<tr>
							<td>소프라노</td>
							<td colspan="3"><input type="text" name="" id="" value=""></td>
						</tr>
						<tr>
							<td>알토</td>
							<td colspan="3"><input type="text" name="" id="" value=""></td>
						</tr>
						<tr>
							<td>테너</td>
							<td colspan="3"><input type="text" name="" id="" value=""></td>
						</tr>
						<tr>
							<td>베이스</td>
							<td colspan="3"><input type="text" name="" id="" value=""></td>
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
