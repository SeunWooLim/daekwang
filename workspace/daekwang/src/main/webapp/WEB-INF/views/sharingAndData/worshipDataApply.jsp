<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../common/meta.jsp"/>


<!-- 밑에 두가지 방법 중 하나 이용 -->
<jsp:include page="../common/header.jsp"/>
<div id="wrap">
	<div class="subvisual_wrap">
		<div class="subvisual_text">
			<p class=title>예배 자료신청</p>
			<p class="text">안양대광교회</p>
		</div>
	</div>
	
	<form action="#" method="post">
		<div class="apply_wrap">
			<div class="apply">
				<table>
					<colgroup>
						<col width="15%">
						<col width="*">
					</colgroup>	
					<tbody>
						<tr>
							<td><label for="wPA">신청자</label></td>
							<td><input type="text" id="wPA" name="wPA" placeholder="신청자 작성"/></td>
						</tr>
						<tr>
							<td><label>예배명</label></td>
							<td>
								<select name=category>
									<option value="1">샬롬찬양대</option>
									<option value="2">임마누엘찬양대</option>
									<option value="3">연합찬양대</option>
									<option value="4">주일 1부예배</option>
									<option value="5">주일 2부예배</option>
									<option value="6">주일 3부예배</option>
									<option value="7">올젠워십</option>
									<option value="8">수요기도회</option>
									<option value="9">기타행사</option>
								</select>
							</td>
						</tr>
						<tr>
							<td><label for="wPA_context">내용</label></td>
							<td><textarea id="wPA_context" name="wPA_context"  placeholder="내용 작성"></textarea></td>
						</tr>
						<tr>
							<td><label>첨부파일</label></td>
							<td class="filebox">
								<input class="upload-name" value="파일선택" disabled="disabled">
								<label for="filename">업로드</label> 
						  		<input type="file" id="filename" class="upload-hidden">
						  	</td>
						</tr>
					</tbody>
				</table>
				<button class="apply_btn">신청하기</button>
			</div>
		</div>
	</form>
	
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>
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
	    });
	}); 
</script>