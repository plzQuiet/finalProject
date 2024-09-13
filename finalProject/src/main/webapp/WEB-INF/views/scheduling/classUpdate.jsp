<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JavaLibrary - 교육문화 프로그램</title>

    <link rel="stylesheet" href="/resources/css/main-style.css">
    <link rel="stylesheet" href="/resources/css/common/sideMenu.css">
    <link rel="stylesheet" href="/resources/css/scheduling/class-write.css">
    <link rel="stylesheet" href="/resources/css/scheduling/modal.css">
</head>

<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp" />

    <section class="main-content-suround-section">
        <article class="side-menu-article">
            <!-- 사이드 메뉴 -->
            <div class="category">참여 마당</div>
            <ul class="side-menu">
                <li class="side-current"> <a href="#" class="current">교육문화 프로그램</a></li>
                <li class="side1"><a href="#">열람실</a></li>
                <li class="side2"><a href="#">세미나실</a></li>
            </ul>

        </article>

        <!-- 공지사항 목록 -->
        <section class="content-suround-section">
            <div class="content-title">교육문화 프로그램</div>
            <div class="title-line"></div>

            <!-- 게시글 작성 화면 -->
            <section class="board-detail">
                <form action="#" method="" class="board-write" id="boardWriteFrm" enctype="multipart/form-data">
                    <h1 class="board-title">
                        <input type="text" name="boardTitle" placeholder="제목">
                    </h1>

                    <!-- 교육기간 / 신청기간 / 최대인원 -->
                    <div class="board-nav">
                        <span>신청기간 : <input type="date"> ~ <input type="date"></span>&nbsp;|&nbsp;
                        <span>교육기간 : <input type="date"> ~ <input type="date"></span>&nbsp;|&nbsp;
                        <span>최대인원 : <input type="number" style="width: 50px;" min="0"></span>
                    </div>

                    <!-- 이미지 등록 영역 -->
                    <div class="img-box">
                        <div class="boardImg">
                            <label for="img0">
                                <img src="" class="preview">
                                이미지 파일을 선택해 주세요.
                            </label>
                            <input type="file" name="images" class="inputImage" id="img0" accept="image/*">
                            <span class="delete-image">&times;</span>
                        </div>
                    </div>


                    <!--  내용 -->
                    <div class="board-content">
                        <textarea name="boardContent" placeholder="내용을 입력해 주세요."></textarea>
                    </div>

                    <!-- 버튼 영역 -->
                    <div class="btn-area">
                        <button onclick="cancelModal()">취소</button>
                        <button type="submit" id="writeBtn" onclick="registModal()">등록</button>
                    </div>

                </form>

            </section>


        </section>

    </section>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />


    <!-- 알림창 모달-->
    <div id="popup_layer">
        <div class="popup_box">
            <div class="popup_header">
                <p>교육문화 프로그램</p>
            </div>

            <!--팝업 컨텐츠 영역-->
            <div class="popup_content">
                <p> 게시글 등록을 취소 하시겠습니까?</p>
                <p> 해당 게시글을 등록 하시겠습니까?</p>
            </div>
            <!--팝업 버튼 영역-->
            <div class="popup_btn">
                <button id="confirm_btn">확인</button>
                <button id="cancel_btn">취소</button>
            </div>
        </div>
    </div>

    <script src="/resources/js/scheduling/class-board.js"></script>

</body>

</html>