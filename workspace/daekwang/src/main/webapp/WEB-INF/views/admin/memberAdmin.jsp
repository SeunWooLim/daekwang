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
				<p>회원관리</p>
			</div>

			


			<div class="table_wrap">
				<table>
					<colgroup>
						<col width="5%"/>
						<col width="5%"/>
						<col width="10%"/>
						<col width="10%"/>
						<col width="25%"/>
						<col width="25%"/>
						<col width="10%"/>
						<col width="10%"/>
					</colgroup>
					<thead>
						<tr>
							<th><input type="checkbox" name="" id="check1"/><label for="check1"></label> </th>
							<th>NO</th>
							<th>아이디</th>
							<th>이름</th>
							<th>핸드폰번호</th>
							<th>이메일</th>
							<th>글권한</th>
							<th>회원권한</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox" name="" id="check2"/><label for="check2"></label> </td>
							<td>1</td>
							<td>testID</td>
							<td>testName</td>
							<td>010-1234-5678</td>
							<td>test@naver.com</td>
							<td>
								<select name="">
									<option value="">Y</option>
									<option value="">N</option>
								</select>
							</td>
							<td>
								<select name="">
									<option value="">Y</option>
									<option value="">N</option>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
				
				<jsp:include page="board_page.jsp"/>
			</div>
		</div>
	<!--container s-->
	</div>

 </body>
</html>
