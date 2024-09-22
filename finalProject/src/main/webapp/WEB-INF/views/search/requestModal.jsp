<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modal</title>
	<link rel="stylesheet" href="/resources/css/common/modal.css">
</head>
<body>
	<div id="popup_layer">
	  <div class="popup_box_res">
	  	  <div class="popup_header">
	  	  <!-- 안에 p 태그로 함 -->
			<p><b>희망 도서 신청</b></p>
	  	  </div>
	  	  
	      <!--팝업 컨텐츠 영역-->
	      <div class="popup_content">
	      <!-- 안에 p태그로 함 -->
				<div class="popup_content_mid">
					<p><b>도서 신청이 완료되었습니다!</b></p>
				</div>	
	      	<!--팝업 버튼 영역-->
			<div class="popup_btn">
		    	<button id="confirm_btn" onclick="location.href='/book/2'">확인</button>
		    </div>

	      </div>
	     
	  </div>
	</div>
</body>
</html>