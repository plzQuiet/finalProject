<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JavaLibrary - 교육문화 프로그램</title>

    <link rel="stylesheet" href="/resources/css/common/sideMenu.css">
    <link rel="stylesheet" href="/resources/css/reservation/class-detail.css">
    <link rel="stylesheet" href="/resources/css/reservation/modal.css">

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

            <!-- 게시글 상세 화면 -->
            <section class="board-detail">
                <!-- 제목 -->
                <h1 class="board-title">React 클래스</h1>

                <!-- 작성자 / 작성일 / 조회수 -->
                <div class="board-nav">
                    <span>교육기간 : 2024-09-25 ~ 2024-09-27</span>&nbsp;|&nbsp;
                    <span>신청기간 : 2024-0819 ~ 2024-09-08 </span>
                </div>

                <!-- 이미지 보여지는 영역 -->
                <!-- 썸네일 X -->
                <div class="img-box">
                    <!-- 등록한 이미지가 있으면 보여줘야하는 영역 -->
                    <div class="boardImg">
                        <img src="../../images/bookThumbnail.jpg">
                    </div>
                </div>

                <!-- 게시글 내용 -->
                <div class="board-content">
                    클래스 내용을 소개합니다.
                </div>

                <!-- 버튼 영역(회원) -->
                <div class="btn-area">
                    <!-- 신청(로그인 한 멤버번호== 작성한 멤버번호) -->
                    <button id="applyBtn" onclick="applyModal(this)">신청</button>

                    <button id="listBtn">목록으로</button>
                </div>

                <!-- 버튼 영역(관리자) -->
                <div class="btn-area">
                    <button id="updateBtn" onclick="updateModal()">수정</button>
                    <button id="updateBtn" onclick="deleteModal()">삭제</button>

                    <button id="listBtn">목록으로</button>
                </div>

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
            <div class="popup_content"> <!-- 조건 설정해서 1개만 띄우기 -->
                <p> 해당 클래스를 신청하시겠습니까?</p>
                <p> 해당 게시글을 수정하시겠습니까?</p>
                <p> 해당 게시글을 삭제하시겠습니까?</p>
            </div>
            <!--팝업 버튼 영역-->
            <div class="popup_btn">
                <button id="confirm_btn">확인</button><!-- 경우에 따라 다른 화면으로 보냄 -->
                <button id="cancel_btn">취소</button>
            </div>
        </div>
    </div>

    <script src="/resources/js/reservation/class-board.js"></script>
</body>

</html>