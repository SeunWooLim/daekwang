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
			
			<% int num = 1; %>
			
			<div class="category_wrap">
				<ul class="ul_form1">
					<li><a class="btnform3" onclick="changeDept(1);">영유아부</a></li>
					<li><a class="btnform3" onclick="changeDept(2);">유치부</a></li>
					<li><a class="btnform3" onclick="changeDept(3);">유년부</a></li>
					<li><a class="btnform3" onclick="changeDept(4);">소년부</a></li>
					<li><a class="btnform3" onclick="changeDept(5);">중등부</a></li>
					<li><a class="btnform3" onclick="changeDept(6);">고등부</a></li>
					<li><a class="btnform3" onclick="changeDept(7);">제1청년회</a></li>
					<li><a class="btnform3" onclick="changeDept(8);">제2청년회</a></li>
				</ul>
			</div>
			
			<c:forEach var="schoolList" items="${ schoolList }">
				<div class="management_wrap" id="management_wrap<%= num++ %>" style="text-align:center;">
					<form action="modifyChurchSchoolAdmin.do" method="post" enctype="multipart/form-data">
						<p class="tal f20 mb10 fb">${schoolList.DEPT_NAME}</p>
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
										<img src="<c:url value="/"/>resources/img/deptImage/${schoolList.DEPT_PHOTO_RENAME}">
										<input type="file" name="file" style="padding:0;">
										<p style="color:red;">* 가로 사진으로 업로드 하시기 바랍니다.</p>
										<input type="hidden" name="DEPT_PHOTO_RENAME" value="${schoolList.DEPT_PHOTO_RENAME }">
										<input type="hidden" name="DEPT_PHOTO_ORNAME" value="${schoolList.DEPT_PHOTO_ORNAME }">
										<input type="hidden" name="DEPT_NO" value="${schoolList.DEPT_NO }">
									</td>
								</tr>
								<tr>
									<td>교육표어</td>
									<td><input type="text" name="EDU_TITLE" id="" value="${schoolList.EDU_TITLE}"></td>
									<td>주제말씀</td>
									<td><input type="text" name="MAIN_WORDS" id="" value="${schoolList.MAIN_WORDS }"></td>
								</tr>
								<tr>
									<td>예배대상</td>
									<td><input type="text" name="WORSHIP_OBJECT" id="" value="${schoolList.WORSHIP_OBJECT }"></td>
									<td>예배시간</td>
									<td><input type="text" name="WORSHIP_TIME" id="" value="${schoolList.WORSHIP_TIME }"></td>
								</tr>
								<tr>
									<td>예배장소</td>
									<td colspan="3"><input type="text" name="WORSHIP_AREA" id="" value="${schoolList.WORSHIP_AREA }"></td>
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
									<td><input type="text" name="DEPT_LEADER" id="" value="${schoolList.DEPT_LEADER }"></td>
									<td>부장</td>
									<td><input type="text" name="DEPT_HEADER" id="" value="${schoolList.DEPT_HEADER }"></td>
								</tr>
								<tr>
									<td>부감</td>
									<td><input type="text" name="DEPT_DIRECTOR" id="" value="${schoolList.DEPT_DIRECTOR }"></td>
									<td>총무</td>
									<td><input type="text" name="DEPT_MANAGER" id="" value="${schoolList.DEPT_MANAGER }"></td>
								</tr>
								<tr>
									<td>서기</td>
									<td><input type="text" name="DEPT_WRITER" id="" value="${schoolList.DEPT_WRITER }"></td>
									<td>회계</td>
									<td><input type="text" name="DEPT_ACCOUNTANT" id="" value="${schoolList.DEPT_ACCOUNTANT }"></td>
								</tr>
								<tr>
									<td>선생님</td>
									<td colspan="3"><input type="text" name="DEPT_MEMBER" id="" value="${schoolList.DEPT_MEMBER }"></td>
								</tr>
							</tbody>
						</table>
						
						<button class="btnform1 mt20">수정</button>			
					</form>
				</div>
			</c:forEach>
			
			<c:forEach var="youthList" items="${ youthList }">
				<div class="management_wrap" id="management_wrap<%= num++ %>" style="text-align:center;">
					<form action="modifyChurchSchoolAdmin.do" method="post" enctype="multipart/form-data">
						<p class="tal f20 mb10 fb">${youthList.DEPT_NAME }</p>
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
										<img src="<c:url value="/"/>resources/img/deptImage/${youthList.DEPT_PHOTO_RENAME}">
										<input type="file" name="file" style="padding:0;">
										<p style="color:red;">* 가로 사진으로 업로드 하시기 바랍니다.</p>
										<input type="hidden" name="DEPT_PHOTO_RENAME" value="${youthList.DEPT_PHOTO_RENAME }">
										<input type="hidden" name="DEPT_PHOTO_ORNAME" value="${youthList.DEPT_PHOTO_ORNAME }">
										<input type="hidden" name="DEPT_NO" value="${youthList.DEPT_NO }">
									</td>
								</tr>
								<tr>
									<td>교육표어</td>
									<td><input type="text" name="EDU_TITLE" id="" value="${youthList.EDU_TITLE}"></td>
									<td>주제말씀</td>
									<td><input type="text" name="MAIN_WORDS" id="" value="${youthList.MAIN_WORDS }"></td>
								</tr>
								<tr>
									<td>예배대상</td>
									<td><input type="text" name="WORSHIP_OBJECT" id="" value="${youthList.WORSHIP_OBJECT }"></td>
									<td>예배시간</td>
									<td><input type="text" name="WORSHIP_TIME" id="" value="${youthList.WORSHIP_TIME }"></td>
								</tr>
								<tr>
									<td>예배장소</td>
									<td colspan="3"><input type="text" name="WORSHIP_AREA" id="" value="${youthList.WORSHIP_AREA }"></td>
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
									<td colspan="3"><input type="text" name="DEPT_LEADER" id="" value="${youthList.DEPT_LEADER }"></td>
									
								</tr>
								<tr>
									<td>부장</td>
									<td><input type="text" name="DEPT_HEADER" id="" value="${youthList.DEPT_HEADER }"></td>
									<td>회장</td>
									<td><input type="text" name="DEPT_DIRECTOR" id="" value="${youthList.DEPT_DIRECTOR }"></td>
									
								</tr>
								<tr>
									<td>부회장</td>
									<td><input type="text" name="DEPT_BUDIRECTOR" id="" value="${youthList.DEPT_BUDIRECTOR }"></td>
									<td>총무</td>
									<td><input type="text" name="DEPT_MANAGER" id="" value="${youthList.DEPT_MANAGER }"></td>
									
								</tr>
								<tr>
									<td>서기</td>
									<td><input type="text" name="DEPT_WRITER" id="" value="${youthList.DEPT_WRITER }"></td>
									<td>회계</td>
									<td><input type="text" name="DEPT_ACCOUNTANT" id="" value="${youthList.DEPT_ACCOUNTANT }"></td>
									
								</tr>
							</tbody>
						</table>
						
						<button class="btnform1 mt20">수정</button>			
					</form>
				</div>
			</c:forEach>
		</div>
	<!--container s-->
	</div>

</body>

<script type="text/javascript">

$(document).ready(function(){
	var pageNum = '${dept_no}'; 

	for(var i = 1; i <= 8 ; i++){
		if(i == pageNum){
			$("#management_wrap"+i).show();	
		}else{
			$("#management_wrap"+i).hide();
		}			
	}
})

/* 부서 별 수정 페이지 이동 onclick */
function changeDept(value){
	$(document).ready(function(){
		for(var i = 1; i <= 8 ; i++){
			if(i == value){
				$("#management_wrap"+i).show();	
			}else{
				$("#management_wrap"+i).hide();
			}
		}
	})
}
</script>
</html>
