<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QnA Detail</title>

    <link rel="stylesheet" href="/resources/css/main-style.css">
    <link rel="stylesheet" href="/resources/css/board/qnaDetail-style.css">
    <link rel="stylesheet" href="/resources/css/board/comment-style.css">
    <script src="https://kit.fontawesome.com/f4e088b372.js" crossorigin="anonymous"></script>
</head>

<body>

    <!-- header -->
    <jsp:include page="/WEB-INF/views/common/header.jsp" />

    <section class="main-content-suround-section">
        <article class="side-menu-article">
            <!-- 사이드 메뉴 -->
            <div class="category">이용자 마당</div>
            <ul class="side-menu">
                <li class="side-current"> <a href="#" class="current">공지사항</a></li>
                <li class="side1"><a href="#">문의사항</a></li>
                <li class="side2"><a href="#">자주 묻는 질문</a></li>
                <li class="last-menu"><a href="#">책 후기 나눠요</a></li>
            </ul>

        </article>

        <!-- 공지사항 목록 -->
        <section class="content-suround-section">
            <div class="content-title">QnA</div>
            <div class="title-line"></div>

            <!-- 게시글 상세 화면 -->
            <section class="board-detail">
                <!-- 제목 -->
                <h1 class="board-title">
                    작성한 제목 나올 부분
                    <!-- 비공개면 자물쇠 표시 되도록 -->
                    <i class="fa-solid fa-lock"></i>
                </h1>

                <!-- 작성자 / 작성일 / 조회수 -->
                <div class="board-nav">
                    <div class="member-name">
                        <span>홍**(이름은 성빼고 문자처리)</span>
                    </div>

                    <div class="board-info">
                        <!-- 최초 작성일 -->
                        <p><span>작성일</span>&nbsp;2024-09-25</p>
                        <!-- 게시글 수정 시 마지작 수정일로 변경되어 반영됨 -->
                        <!-- <p><span>마지막 수정일</span>&nbsp;2024-09-26</p> -->

                        <p><span>조회수</span>&nbsp;104</p>
                    </div>

                </div>

                <!-- 게시글 내용 -->
                <div class="board-content">자바라이브러리 소개합니다</div>

                <!-- 버튼 영역 -->
                <div class="btn-area">
                    <!-- 수정(로그인 한 멤버번호== 작성한 멤버번호) -->
                    <button id="updateBtn">수정</button>
                    <!-- 삭제(로그인 한 멤버번호== 작성한 멤버번호) -->
                    <button id="deleteBtn">삭제</button>

                    <!-- 목록으로 -->
                    <button id="listBtn">목록으로</button>
                </div>

            </section>

            <!-- 게시글 작성 화면 -->
            <!-- notice / bookreview 공통 -->
            <!-- <form action="#" method="" class="board-write" id="boardWriteFrm" enctype="multipart/form-data"> -->
            <!-- 제목 -->
            <!-- <h1 class="board-title">
                    <input type="text" name="boardTitle" placeholder="제목">
                </h1> -->

            <!-- 이미지 등록 영역 -->
            <!-- <h5>이미지 등록</h5> -->
            <!-- <div class="img-box">
                    <div class="boardImg">
                        <label for="img0">
                            <img src="" class="preview">
                        </label>
                        <input type="file" name="images" class="inputImage" id="img0" accept="image/*">
                        <span class="delete-image">&times;</span>
                    </div>
    
                    <div class="boardImg">
                        <label for="img1">
                            <img src="" class="preview">
                        </label>
                        <input type="file" name="images" class="inputImage" id="img1" accept="image/*">
                        <span class="delete-image">&times;</span>
                    </div>
                </div> -->


            <!-- 내용 -->
            <!-- <div class="board-content">
                    <textarea name="boardContent"></textarea>
                </div> -->

            <!-- 버튼 영역 -->
            <!-- <div class="btn-area">
                    <button>취소</button>
                    <button type="submit" id="writeBtn">등록</button>
                </div> -->

            <!-- </form> -->
          

            <jsp:include page="/WEB-INF/views/board/comment.jsp"/>
        </section>


    </section>

    <!-- footer -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <!-- comment.js 연결 -->
    <script src="/resources/js/board/comment.js"></script>

</body>

</html>