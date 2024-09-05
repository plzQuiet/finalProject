<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>수정</title>

    <link rel="stylesheet" href="/resources/css/main-style.css">
    <link rel="stylesheet" href="/resources/css/board/qnaUpdate-style.css">
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

            <!-- 게시글 작성 화면 -->
            <form action="#" method="" class="board-write" id="boardWriteFrm">
                <!-- 제목 -->
                <h1 class="board-title">
                    <input type="text" name="boardTitle" placeholder="제목 입력" value="board-title">
                </h1>

                <!-- 작성자 이름 영역 -->
                <!-- db에서 memberName 불러올 것 -->
                <div class="member-name"><h3>홍길동</h3></div>

                <!-- 공개/비공개 -->
                <div class="board-type">
                    <span>공개 여부</span> 
                    <input type="radio" name="option" id="public">
                    <label for="public">공개</label>

                    <input type="radio" name="option" id="private">
                    <label for="private">비공개</label>
                </div>

                
                <!-- 내용 -->
                <div class="board-content">
                    <textarea name="boardContent">작성한 글 내용 불러오기</textarea>
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

    
</body>
</html>