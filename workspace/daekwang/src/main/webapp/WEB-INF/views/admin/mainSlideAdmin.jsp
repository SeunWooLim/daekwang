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
				<p>메인슬라이드 관리</p>
			</div>

			<div class="category_wrap">
				<ul class="ul_form2">
					<li><a class="btnform3" onclick="openInsertForm();">등록</a></li>
					<li><a href="#" class="btnform4" onclick="deleteAction();">삭제</a></li>
				</ul>
			</div>


			<div class="table_wrap">
				<table>
					<colgroup>
						<col width="*"/>
					</colgroup>
					<tbody>
						<tr>							
							<td style="position: relative; padding:0;">
								<img style="width:100%; height:600px"src="<c:url value="/"/>resources/uploadPhoto/1553920806011.jpg">
								<div style="position:absolute; top:0; left:0; width:100%; height:600px; display:block; background:rgba(0,0,0,0.5)"></div>
								<div style="position: absolute; top:50%; left:50%; transform:translateX(-50%) translateY(-50%); text-align:center; color:#fff;">
									<p>제목입니다</p>
									<p>내용입니다</p>
								</div>
								<ul class="mt20 mb20">
									<li>
										<a href="#" class="btnform5" onclick="updateForm()">수정</a>
										<a href="#" class="btnform6">삭제</a>
									</li>
								</ul>
							</td>
						</tr>
						<!-- 수정 폼 모달 -->
						<form action="personNewsAdmin.do" method="post">
							<div class="form_wrap" id="form_wrap">
								<div class="form">
									<p>메인슬라이드 수정</p>
									<ul>
										<li>
											<label>제목</label>
											<input type="text" id="" name="" />
										</li>
										<li>
											<label>내용</label>
											<input type="text" id="" name="" />
										</li>
										<li>
											<label>이미지</label>
											<img style="width:300px; height:200px; "src="<c:url value="/"/>resources/uploadPhoto/1553920806011.jpg">
											<input type="file" style="padding:0; height:100%; width: 50%;    vertical-align: top;">
										</li>
									</ul>								
									
									
									<input type="hidden" name="updateFlag" value="Y">
									
									<ul class="list">
										<li><button type="submit" class="btnform2 update_btn">수정</button></li>
										<li><a class="btnform2 close_btn" onclick="closeUpdateForm()">닫기</a></li>
									</ul>
								</div>
							</div>
						</form>
					</tbody>
				</table>
				
				<jsp:include page="board_page.jsp"/>
			</div>
			
			
		</div>
	<!--container s-->
	</div>
	
	<!-- 수정, 등록 폼 모달 backGround -->
	<div class="formbg"></div>
	
	<!-- 등록 폼 모달 -->
	<div class="form_wrap" id="form_wrap_ins">
		<form action="" method="post">
			<div class="form">
				<p>메인슬라이더 등록</p>
				<ul>
					<li>
						<label>제목</label>
						<input type="text" id="" name="" />
					</li>
					<li>
						<label>내용</label>
						<input type="text" id="" name="" />
					</li>
					<li>
						<label>이미지</label>
						<img style="width:300px; height:200px; "src="<c:url value="/"/>resources/uploadPhoto/1553920806011.jpg">
						<input type="file" style="padding:0; height:100%; width: 50%;    vertical-align: top;">
					</li>
				</ul>								
				
				<input type="hidden" name="insertFlag" value="Y">
				
				<ul class="list">
					<li><button type="submit" class="btnform2 update_btn" id="btn_insert">등록</button></li>
					<li><a class="btnform2 close_btn" id="btn_ins" onclick="closeInsertForm();">닫기</a></li>
				</ul>
				
			</div>
		</form>
	</div>

 </body>
 <script type="text/javascript">
	
	/* 수정폼 버튼 onclick */
	function updateForm(modalValue){
		$(document).ready(function(){
			$(".formbg").show();
			$("#form_wrap"+modalValue).show();		
		})
	}
	
	/* 수정폼 닫기 버튼 onclick */
	function closeUpdateForm(modalValue){
		$(document).ready(function(){
			$(".formbg").hide();
			$("#form_wrap"+modalValue).hide();	
		})
	}
	
	/* 등록 버튼 onclick */
	function openInsertForm(){
		$(document).ready(function(){
			$("#form_wrap_ins").show();
			$(".formbg").show();	
		})
	}
	
	/* 등록 닫기 버튼 onclick */
	function closeInsertForm(){
		$(document).ready(function(){
			$("#form_wrap_ins").hide();
			$(".formbg").hide();	
		})
	}
	
	/* 현재 페이지 'on' addClass */
	$(document).ready(function(){
		var currentPageNum = '${currentPage}';
		var pageNum = $('#pageNum'+currentPageNum);
		pageNum.addClass('on');
	})
	
	/* 체크박스 전체 선택 */
	function checkAll(){
	    if( $("#check1").is(':checked') ){
	      $("input[name=checkBox]").prop("checked", true);
	    }else{
	      $("input[name=checkBox]").prop("checked", false);
	    }
	}
	
	/* 체크된 게시물 삭제 */
	function deleteAction(){
		var checkBox = "";
		$( "input[name='checkBox']:checked" ).each (function (){
			checkBox = checkBox + $(this).val()+"," ;
		});
			checkBox = checkBox.substring(0,checkBox.lastIndexOf( ",")); //맨끝 콤마 지우기
		
		if(checkBox == ''){
		  	alert("삭제할 대상을 선택하세요.");
	 	 	return false;
		}
		
		if(confirm("정보를 삭제 하시겠습니까?")){
		    
		    //삭제처리 후 다시 불러올 리스트 url      
		    var currentPage = '${currentPage}';
		    var searchSelect1 = '${searchSelect}';
		    var searchContent = '${searchContent}';
		    var deleteYN = 'Y';
		    location.href="personNewsAdmin.do?idx="+checkBox+"&currentPage="+currentPage+"&deleteFlag="+deleteYN;      
		}
	}
	
	/* ESC key 이벤트 */
	$(document).keyup(function(e) {
	     if (e.keyCode == 27) { 
    	 	$(".formbg").hide();
			$(".form_wrap").hide();
			$("#form_wrap_ins").hide();
	    }
	});

</script>
</html>
