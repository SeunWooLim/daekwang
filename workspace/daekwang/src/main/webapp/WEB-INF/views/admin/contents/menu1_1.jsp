<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/daekwang/resources/css/basic.css">
<link rel="stylesheet" type="text/css" href="/daekwang/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="/daekwang/resources/css/jquery.jqplot.css"/>
<link rel="stylesheet" type="text/css" href="/daekwang/resources/css/simple.min.css"/>
<link rel="stylesheet" href="//cdn.jsdelivr.net/gh/xpressengine/xeicon@2.3.1/xeicon.min.css">
<script src="/daekwang/resources/js/jquery-1.11.1.min.js"></script>
<script src="/daekwang/resources/js/jquery-ui.min.js"></script>
<script src="/daekwang/resources/js/script.js"></script>

<script src="/daekwang/resources/js/jquery.jqplot.js"></script>
<script src="/daekwang/resources/js/excanvas.js"></script>
<script type="text/javascript" src="/daekwang/resources/plugins/dist/jqplot.categoryAxisRenderer.min.js"></script>
<script type="text/javascript" src="/daekwang/resources/plugins/dist/jqplot.barRenderer.min.js"></script>
<script type="text/javascript" src="/daeknwang/resources/plugins/dist/jqplot.pointLabels.min.js"></script>
</head>
<body>
<div id="wrap">
	<!--header s-->
		<jsp:include page="../header.jsp"/>
		<jsp:include page="../nav.jsp"/>
	<!--header e-->
	<!--container s-->
		<div id="container">
			<div class="main_title">
				<p>메뉴1_1</p>
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
					<li><a href="#" class="btnform3">등록</a></li>
					<li><a href="#" class="btnform4">삭제</a></li>
				</ul>
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
							<th>리스트이미지</th>
							<th>카테고리</th>
							<th>제목</th>
							<th>내용</th>
							<th>등록일</th>
							<th>편집</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox" name="" id="check2"/><label for="check2"></label> </td>
							<td>1</td>
							<td><img src="/common/img/eximg1.jpg" alt=""/></td>
							<td>카테고리1</td>
							<td>제목입니다.</td>
							<td>내용입니다.</td>
							<td>2018-04-23</td>
							<td>
								<a href="#" class="btnform5">수정</a>
								<a href="#" class="btnform6">삭제</a>
							</td>
						</tr>
					</tbody>
				</table>
				
				<jsp:include page="../board_page.jsp"/>
			</div>
		</div>
	<!--container s-->
	</div>
</body>
</html>