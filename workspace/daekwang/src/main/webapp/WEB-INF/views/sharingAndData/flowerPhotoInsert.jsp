<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>

<jsp:include page="../common/header.jsp"/>
<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>꽃꽃이갤러리</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<form action="insertFlowerPhoto.do" method="post" enctype="multipart/form-data">
		<div class="apply_wrap">
			<div class="apply">
				<table>
					<colgroup>
						<col width="15%">
						<col width="*">
					</colgroup>	
					<tbody>
						<tr>
							<td><label for="wPA">작성자</label></td>
							<td>${sessionScope.loginUser.MEMBER_NAME }<input type="hidden" name="MEMBER_NO" value="${sessionScope.loginUser.MEMBER_NO}"></td>
						</tr>
						<tr>
							<td><label for="wPA_Dep">제목</label></td>
							<td><input type="text" id="wPA_title" name="BOARD_TITLE" class="title" placeholder="제목 작성"/></td>
						</tr>
						<tr>
							<td><label>이미지</label></td>
							<td class="filebox">
								<input class="upload-name" placeholder="파일선택" disabled="disabled" name="src" id="file">
								<label for="filename">업로드</label> 
						  		<input type="file" id="filename" name="file" class="upload-hidden">
						  	</td>
						</tr>
						<tr>
							<td><label for="wPA_context">내용</label></td>
							<td><textarea id="wPA_context" name="BOARD_CONTENT"  placeholder="내용 작성"></textarea></td>
							<!-- <script type="text/javascript">
							CKEDITOR.replace('wPA_context',
									{height: 200});
							</script> -->
						</tr>
						
					</tbody>
				</table>
				<button type="submit" class="apply_btn">등록</button>
			</div>
		</div>
	</form>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>

<script>
	$(document).ready(function(){
	  	var fileTarget = $('.filebox .upload-hidden');

	    fileTarget.on('change', function(){
	    	
	    	if(window.FileReader){
	            var filename = $(this)[0].files[0].name;
	        } else {
	            var filename = $(this).val().split('/').pop().split('\\').pop();
	        }
	    	$(this).siblings('.upload-name').val(filename);
	     	
	    	// 파일 업로드 확장자 체크
			var ext = $('.upload-name').val().split('.').pop().toLowerCase();
	        if($.inArray(ext, ['gif','png','jpg','jpeg','PNG','JPG']) == -1) {
				alert('이미지 파일만 업로드 가능합니다.');
				$(".upload-name").val(""); // input file 파일명을 다시 지워준다.
				return;
	    	}
	        
	     	// 파일 사이즈 체크
	        var fileSize = document.getElementById("filename").files[0].size;
	        var maxSize = 3 * 1024 * 1024;//3MB
	        if(fileSize > maxSize){
	           	alert("이미지 파일은 3MB 이내로 업로드 가능합니다.");
	            $(".upload-name").val("");
	            return;
	         }
	    });
	}); 
</script>

</html>