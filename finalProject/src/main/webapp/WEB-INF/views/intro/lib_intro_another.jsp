<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaLibrary - 주변 도서관</title>

<link rel="stylesheet" href="/resources/css/main-style.css">
<link rel="stylesheet" href="/resources/css/common/sideMenu.css">
<link rel="stylesheet" href="/resources/css/intro/popup.css">
<link rel="stylesheet" href="/resources/css/intro/intro_another.css">
<link rel="stylesheet" href="/resources/css/intro/edit_popup.css">

</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
	<section class="main-content-suround-section">
		<jsp:include page="/WEB-INF/views/common/sideMenu.jsp"></jsp:include>
		
		<section class="content-suround-section">
			<div class="content-title">주변 도서관</div>
            <div class="title-line"></div>

            <section class="content-detail-section">
                <nav class="library-another-btn-area">
                   <div class="libraryAnother current"> <a href="" class="current">서울 도서관</a> </div>
				   <div class="libraryAnother"> <a href="">다른 도서관</a> </div>
                </nav>
                
                <article class="map-content-suround">
					<div>

					</div>
                    <div class="introduce-another-library-area">
						<table class="introduce-another-content">
							<tr>
								<th>주소</th>
								<td id="anLibraryAddress">서울 중구 세종대로 110 서울도서관</td>
							</tr>
							<tr>
								<th>소개</th>
								<td id="anLibraryIntro">다른 도서관 소개글</td>
							</tr>
						</table>

                    </div>
                    <div id="map"></div>
                </article>
                
                <article class="library-another-images-area">
					<div class="boardImg">
						<img src="/resources/images/intro/library_map_1F.png" alt="">
						<img src="/resources/images/intro/library_map_1B.png" alt="">
						<img src="/resources/images/intro/library_map_2F.png" alt="">
						<img src="/resources/images/intro/library_map_3F.png" alt="">
					</div>
                </article>

				<!-- 검색한 지도의 위도, 경도 저장 -->
				<input type="hidden" name="libraryLat" value="">
				<input type="hidden" name="libraryLng" value="">

				<div class="manager-btn-area">
					<button onclick="openEditModal(this)" id="insertLibrary">추가</button>
					<button onclick="openUpdateModal(this)" id="updateLibrary">수정</button>
					<button onclick="openModal(this)" id="deleteLibrary">삭제</button>
				</div>
                
            </section>
		</section>		
	</section>
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	
	<!-- 모달 영역 -->
	
	<!-- 편집 모달 -->
    <div id="edit-popup_layer">
	  <div class="edit-popup_box">
	  	  <div class="edit-popup_header">
	  	  	<p>주변 도서관 편집</p>
			<span id="edit-popup-close">&times;</span>
	  	  </div>
	  	  
	      <!--팝업 컨텐츠 영역-->
	      <div class="edit-popup_content">
			<form action="" method="post" name="editIntroFrm">
			<div>
	          <div class="popupTitle"><span>도서관명</span> <input type="text" name="libraryName"> </div>
	          <div class="popupAddress"> <span>주소</span> <input type="text" name="libraryAddress" id="libraryAddress"> <button type="button" id="searchMap">검색</button> </div>
			  <div class="popup-map-suround">
				  <div id="map2"></div>
			  </div>
			  <div class="popupIntroSuround">
				<div>소개</div>
				<textarea name="popupIntro"></textarea>
			  </div>
			  <div class="pop-image-suround">
				<div class="boardImage">
                    <label for="img1">
                        <img class="preview" src="">
                    </label>

                    <input type="file" class="inputImage" id="img1" accept="image/*" name="1">
                    <span class="delete-image">&times;</span>
                </div>

                <div class="boardImage">
                    <label for="img2">
                        <img class="preview" src="">
                    </label>

                    <input type="file" class="inputImage" id="img2" accept="image/*" name="2">
                    <span class="delete-image">&times;</span>
                </div>

                <div class="boardImage">
                    <label for="img3">
                        <img class="preview" src="">
                    </label>

                    <input type="file" class="inputImage" id="img3" accept="image/*" name="3">
                    <span class="delete-image">&times;</span>
                </div>

                <div class="boardImage">
                    <label for="img4">
                        <img class="preview" src="">
                    </label>

                    <input type="file" class="inputImage" id="img4" accept="image/*" name="4">
                    <span class="delete-image">&times;</span>
                </div>
			  </div>
			</div>
	      </div>
	      <!--팝업 버튼 영역-->
	      <div class="edit-popup_btn">
	      	<button id="edit-confirm_btn">등록</button>
	      </div>

		  <!-- 기존 이미지가 있다가 삭제된 이미지의 순서를 기록 -->
		  <input type="hidden" name="deleteList" value="">

		  <!-- 검색한 지도의 위도, 경도 저장 -->
		  <input type="hidden" name="searchLat" value="">
		  <input type="hidden" name="searchLng" value="">
		</form>
	  </div>
	</div>
	
	<!-- 알림창 모달-->
	<div id="popup_layer">
		<div class="popup_box">
			  <div class="popup_header">
				  <p>주변 도서관 삭제</p>
			  </div>
			  
			<!--팝업 컨텐츠 영역-->
			<div class="popup_content">
				<p> 정말 삭제 하시겠습니까?
				</p>
			</div>
			<!--팝업 버튼 영역-->
			<div class="popup_btn">
				<button id="confirm_btn">확인</button>
				<button id="cancel_btn">취소</button>
			</div>
		</div>
	  </div>
	  
	  <!-- 사진 모달 -->
	<div class="modal">
        <span id="modal-close">&times;</span>
        <img src="" id="modal-image">
    </div>
    
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=607938550ca3e7059ff2ce14439ad035&libraries=services"></script>
    <script src="/resources/js/intro/lib_intro_another.js"></script>
	
</body>
</html>