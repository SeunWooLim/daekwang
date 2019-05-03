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
				<p>샬롬 찬양대 관리</p>
			</div>
			
			<form action="modifyChoirAdmin.do" method="post" enctype="multipart/form-data">
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
									<!-- 카페24 경로 -->
									<%-- <img src="<c:url value="/upload/${sapVo1.PRAISE_UPLOAD_YYMM }/${sapVo1.PRAISE_PHOTO_RENAME}"/>"> --%>
									<!-- 로컬서버 경로 -->
									<img src="<c:url value="/resources/img/deptImage/${sapVo1.PRAISE_PHOTO_RENAME}"/>">
									<input type="file" name="file" style="padding:0;" value="${sapVo1.PRAISE_PHOTO_ORNAME}">
									<p style="color:red;">* 가로 사진으로 업로드 하시기 바랍니다.</p>
									<input type="hidden" name="PRAISE_PHOTO_RENAME" value="${sapVo1.PRAISE_PHOTO_RENAME}">
									<input type="hidden" name="PRAISE_PHOTO_ORNAME" value="${sapVo1.PRAISE_PHOTO_ORNAME}">
									<input type="hidden" name="PRAISE_UPLOAD_YYMM" value="${sapVo1.PRAISE_UPLOAD_YYMM }">
									<input type="hidden" name="PRAISE_FG" value="1">
								</td>
							</tr>
							<tr>
								<td>대장</td>
								<td colspan="3"><input type="text" name="PRAISE_BOSS" id="" value="${sapVo1.PRAISE_BOSS}"></td>							
							</tr>
							<tr>
								<td>지휘</td>
								<td><input type="text" name="PRAISE_CONDUCTOR" id="" value="${sapVo1.PRAISE_CONDUCTOR}"></td>
								<td>총무</td>
								<td><input type="text" name="PRAISE_MANAGER" id="" value="${sapVo1.PRAISE_MANAGER}"></td>							
							</tr>
							<tr>
								<td>부총무</td>
								<td><input type="text" name="PRAISE_SUBMANAGER" id="" value="${sapVo1.PRAISE_SUBMANAGER}"></td>
								<td>서기</td>
								<td colspan="3"><input type="text" name="PRAISE_WRITER" id="" value="${sapVo1.PRAISE_WRITER}"></td>
							</tr>
							<tr>
								<td>회계</td>
								<td><input type="text" name="PRAISE_ACCOUNTANT" id="" value="${sapVo1.PRAISE_ACCOUNTANT}"></td>
								<td>반주</td>
								<td><input type="text" name="PRAISE_BANJU" id="" value="${sapVo1.PRAISE_BANJU}"></td>
							</tr>
							<tr>
								<td>소프라노</td>
								<td colspan="3"><input type="text" name="PRAISE_SOPRANO" id="" value="${sapVo1.PRAISE_SOPRANO}"></td>
							</tr>
							<tr>
								<td>알토</td>
								<td colspan="3"><input type="text" name="PRAISE_ALTO" id="" value="${sapVo1.PRAISE_ALTO}"></td>
							</tr>
							<tr>
								<td>테너</td>
								<td colspan="3"><input type="text" name="PRAISE_TENOR" id="" value="${sapVo1.PRAISE_TENOR}"></td>
							</tr>
							<tr>
								<td>베이스</td>
								<td colspan="3"><input type="text" name="PRAISE_BASS" id="" value="${sapVo1.PRAISE_BASS}"></td>
							</tr>
						</tbody>
					</table>	
					
					<button class="btnform1 mt20">수정</button>			
				</div>
			</form>
		
		</div>
	<!--container s-->
	</div>

</body>
</html>
