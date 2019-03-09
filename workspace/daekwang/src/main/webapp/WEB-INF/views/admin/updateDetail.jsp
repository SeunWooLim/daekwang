<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../common/adminmeta.jsp"/>
</head>
<body>
<div class="form_wrap">
	<form action="" method="">
		<div class="form">
			<p>주보광고신청 수정</p>
			<table>
				<colgroup>
					<col width="10%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<td><label for="wPA">신청자</label></td>
						<td><input type="text" id="wPA" name="wPA" value="신청자명"/></td>
					</tr>
					<tr>
						<td><label for="wPA_Dep">부서명</label></td>
						<td><input type="text" id="wPA_Dep" name="wPA_Dep" value="부서명"/></td>
					</tr>
					<tr>
						<td><label>분류</label></td>
						<td>
							<select name="category">
								<option value="1" selected>주보원고</option>
								<option value="2">광고요청</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="wPA_context">내용</label></td>
						<td><textarea id="wPA_context" name="wPA_context" value="내용 작성"></textarea></td>
					</tr>
				</tbody>
			</table>
			<ul>
				<li><a class="btnform1">수정</a></li>
				<li><a class="btnform2 close_btn">닫기</a></li>
			</ul>
		</div>
	</form>
</div>
 </body>
</html>