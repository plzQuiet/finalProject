<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글쓰기</title>

    <link rel="stylesheet" href="/resources/css/main-style.css">
    <link rel="stylesheet" href="/resources/css/board/boardWrite-style.css">
</head>
<body>

    <!-- 공지사항 / 책 후기 나눠요 공통 화면 -->

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
            <div class="content-title">공지사항/책 후기 나눠요</div>
            <div class="title-line"></div>

            <!-- 게시글 작성 화면 -->
            <!-- notice / bookreview 공통 -->
            <form action="/board2/${cateCode}/insert" method="POST" class="board-write" id="boardWriteFrm" enctype="multipart/form-data">
                <!-- 제목 -->
                <h1 class="board-title">
                    <input type="text" name="boardTitle" placeholder="제목 입력">
                </h1>

                <!-- 이미지 등록 영역 -->
                <h5>이미지 등록</h5>
                <div class="img-box">
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
                </div>

                
                <!-- 내용 -->
                <div class="board-content">
                    <textarea name="boardContent"></textarea>
                </div>

                <!-- 버튼 영역 -->
                <div class="btn-area">
                    <button>취소</button>
                    <button type="submit" id="writeBtn">등록</button>
                </div>

            </form>
        </section>


    </section>

    <!-- footer -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script src="/resources/js/board/boardWrite.js"></script>

</body>
</html>