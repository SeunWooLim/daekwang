<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>

<style>
	#filedrag
	{
		display: none;
		font-weight: bold;
		text-align: center;
		padding: 1em 0;
		margin: 1em 0;
		color: #555;
		border: 2px dashed #555;
		border-radius: 7px;
		cursor: default;
	}
	
	#filedrag.hover
	{
		color: #f00;
		border-color: #f00;
		border-style: solid;
		box-shadow: inset 0 3px 4px #888;
	}
</style>

<jsp:include page="../common/header.jsp"/>
<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>교회사진</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<form action="#" method="post" enctype="multipart/form-data" id="uploadForm">
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
								<div>
									<label for="fileselect">이미지 업로드</label>
									<input type="file" id="fileselect" name="fileselect" multiple="multiple" class="upload-hidden"/>
									<input type="hidden" class="upload-name" disabled="disabled" name="src" id="file">
									<div id="filedrag">파일을 이곳에 끌어다 놓으세요</div>
								</div>
						  	</td>
						</tr>
						<tr>
							<td><label>이미지 미리보기</label></td>
							<td class="" id="preview_image" style="height: 120px;">
						  		
						  	</td>
						</tr>
						<tr>
							<td><label for="wPA_context">내용</label></td>
							<td><textarea id="wPA_context" name="BOARD_CONTENT"  placeholder="내용 작성"></textarea></td>
							<!-- <script type="text/javascript">
							CKEDITOR.replace('wPA_context',
									{height: 300});
							</script> -->
						</tr>
					</tbody>
				</table>
				<button type="submit" class="apply_btn" onclick="UploadImage();">등록</button>
			</div>
		</div>
	</form>
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>

<script type="text/javascript">

$(document).ready(function(){
  	var fileTarget = $('.filebox .upload-hidden');

    fileTarget.on('change', function(){
    	
    	if(window.FileReader){
            var filename = $(this)[0].files[0].name;
        } else {
            var filename = $(this).val().split('/').pop().split('\\').pop();
        }
    	$(this).siblings('.upload-name').val(filename);
    });
}); 

// 섬네일 이미지아이디 변수
var imageNum = 0;
// 선택된 이미지 보관 배열
var filesTempArr = new Array();

// getElementById
function $id(id) {
	return document.getElementById(id);
}

// 파일 읽어 init() 호출
if (window.File && window.FileList && window.FileReader) {
	Init();
}

// 초기화함수
function Init() {

	var fileselect = $id("fileselect"),
		filedrag = $id("filedrag");

	// file select
	fileselect.addEventListener("change", FileSelectHandler, false);

	// is XHR2 available?
	var xhr = new XMLHttpRequest();
	if (xhr.upload) {
	
		// file drop
		filedrag.addEventListener("dragover", FileDragHover, false);
		filedrag.addEventListener("dragleave", FileDragHover, false);
		filedrag.addEventListener("drop", FileSelectHandler, false);
		filedrag.style.display = "block";
	}
}

// 파일 drag hover
function FileDragHover(e) {
	e.stopPropagation();
	e.preventDefault();
	e.target.className = (e.type == "dragover" ? "hover" : "");
}


// 파일 선택 핸들러
function FileSelectHandler(e) {
	// 이벤트 취소 및 호버 스타일
	FileDragHover(e);

	// 파일객체 불러오기
	var files = e.target.files || e.dataTransfer.files;

	// 파일 이미지 배열 저장, 섬네일 생성, 유효성 체크
	for (var i = 0, f; f = files[i]; i++) {
		
		// 파일 업로드 확장자 체크
		var ext = f.name.split('.').pop().toLowerCase();
        if($.inArray(ext, ['gif','png','jpg','jpeg','PNG','JPG']) == -1) {
			alert('이미지 파일만 업로드 가능합니다.');
			$(".upload-name").val(""); // input file 파일명을 다시 지워준다.
			return;
    	}
        
     	// 파일 사이즈 체크
        var fileSize = f.size;
        var maxSize = 3 * 1024 * 1024;//3MB
        if(fileSize > maxSize){
           	alert("첨부파일 사이즈는 3MB 이내로 등록 가능합니다.");
            $(".upload-name").val("");
            return;
         }
        
        filesTempArr.push(f);
		ThumnailImage(f, imageNum);
		imageNum++;
	}
} 

//이미지 섬네일 뿌리기
function ThumnailImage(file, i){
	var reader = new FileReader();
	reader.readAsDataURL(file);
	 
	reader.onload = function  () {
	    var tempImage = new Image();
	    tempImage.src = reader.result;
	    tempImage.onload = function () {
	         var canvas = document.createElement('canvas');
	         var canvasContext = canvas.getContext("2d");
	
	         canvas.width = 100; 
	         canvas.height = 100;
	
	         canvasContext.drawImage(this, 0, 0, 100, 100);
	
	         var dataURI = canvas.toDataURL("image/jpeg");
	
	         var imgTag = "<div style='display: inline-block; margin: 2px 2px 2px 2px' id='pre_image"+ i +"'><img src='"+dataURI+"'/><i onclick='DeleteThumnail(" + i + ");' class='xi-close-circle-o' style='vertical-align: top; '></i></div>";
	         $("#preview_image").append(imgTag);
	     };
	 };
}

//섬네일 삭제
function DeleteThumnail(orderParam){
	$('#pre_image'+ orderParam).remove();
	filesTempArr.splice(orderParam, 1);
	filesTempArr.splice(orderParam, 0, 0);
}

//이미지 업로드
function UploadImage(){
	
	// 이미지 담을 폼데이터 세팅
	var formData = new FormData(document.getElementById('uploadForm'));
	
	// 이미지 배열을 폼데이터에 추가
	for(var i=0 ; i < filesTempArr.length; i++) {
	   formData.append("img", filesTempArr[i]);
	}
	
	$.ajax({
	    type : "POST",
	    url : "insertChurchPhoto.do",
	    data : formData,
	    processData: false,
	    contentType : false,
	    success : function(result) {
	    	console.log(result);
	        if(result=="success"){
	        	alert(1);
	        	location.href = "churchPhoto.do";
	        }else{
	            alert("이미지 등록에 실패하였습니다.");
	            location.href = "churchPhoto.do";
	        } 
	    },
	    error : function(err) {
	        alert(err.status);
	        location.href = "churchPhoto.do";
	    }
	});

}


</script>
</html>