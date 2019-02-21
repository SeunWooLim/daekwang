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
				<p>주보광고신청</p>
			</div>

			<div class="category_wrap">
				<ul class="ul_form1">
					<li>
						<select name="" title="" class="selectform2">
							<option value="" selected="selected">카테고리</option>
							<option value="">카테고리1</option>
						</select>
					</li>
					<li>
						<select name="" title="" class="selectform1">
							<option value="" selected="selected">제목</option>
							<option value="">내용</option>
						</select>
					</li>
					<li>
						<input type="text" class="inputform150" title="" value="" name=""/>
					</li>
					<li>
						<a href="#" class="btnform1">검색</a>
					</li>
					<li>
						<a href="#" class="btnform2">전체보기</a>
					</li>
				</ul>

				<ul class="ul_form2">
					<!-- <li><a href="#" class="btnform3">등록</a></li> -->
					<li><a href="#" class="btnform4">삭제</a></li>
				</ul>
			</div>


			<div class="table_wrap">
				<table>
					<colgroup>
						<col width="3%"/>
						<col width="3%"/>
						<col width="5%"/>
						<col width="5%"/>
						<col width="5%"/>
						<col width="*"/>
						<col width="10%"/>
						<col width="10%"/>
					</colgroup>
					<thead>
						<tr>
							<th><input type="checkbox" name="" id="check1"/><label for="check1"></label> </th>
							<th>NO</th>
							<th>신청자</th>
							<th>부서명</th>
							<th>분류</th>
							<th>내용</th>
							<th>등록일</th>
							<th>편집</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox" name="" id="check2"/><label for="check2"></label> </td>
							<td>1</td>
							<td>오민식</td>
							<td>찬양대</td>
							<td>주보신청</td>
							<td>내용입니다.</td>
							<td>2018-04-23</td>
							<td>
								<a href="#" class="btnform5 update_btn">수정</a>
								<a href="#" class="btnform6">삭제</a>
							</td>
						</tr>
					</tbody>
				</table>
				
				<jsp:include page="board_page.jsp"/>
			</div>
		</div>
	<!--container s-->
	</div>
	<div class="formbg"></div>
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
							<td><textarea id="wPA_context" name="wPA_context"  value="내용 작성"></textarea></td>
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
<script>
	$(document).ready(function(){
		$(".update_btn").click(function(){
			$(".formbg").show();
			$(".form_wrap").show();
		});
		
		$(".close_btn").click(function(){
			$(".formbg").hide();
			$(".form_wrap").hide();
		});
	})
</script>
</html>

<style>
	.menuuuuuu{}
	.menuuuuuu li{margin-bottom:20px; }
	.menuuuuuu li p{font-size:20px;}
	.menuuuuuu li p span{font-size:20px;}
</style>