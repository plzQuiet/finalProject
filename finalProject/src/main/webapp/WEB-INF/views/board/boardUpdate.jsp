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
    <link rel="stylesheet" href="/resources/css/board/boardUpdate-style.css">
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
            <form action="#" method="" class="board-write" id="boardWriteFrm" enctype="multipart/form-data">

                <!-- 입력된 값 불러오기 -->
                <!-- 제목 -->
                <h1 class="board-title">
                    <input type="text" name="boardTitle" placeholder="제목 입력" value="board-title">
                </h1>

                <!-- board.imageList / imageOrder -->
                <!-- <c:forEach items="${board.imageList}" var="img">
            
                    <c:choose>
                        <c:when test="${img.imageOrder == 0}">
                            <c:set var="img0" value="${img.imagePath}${img.imageReName}"/>
                        </c:when>

                        <c:when test="${img.imageOrder == 1}">
                            <c:set var="img1" value="${img.imagePath}${img.imageReName}"/>
                        </c:when>

                        <c:when test="${img.imageOrder == 2}">
                            <c:set var="img2" value="${img.imagePath}${img.imageReName}"/>
                        </c:when>

                        <c:when test="${img.imageOrder == 3}">
                            <c:set var="img3" value="${img.imagePath}${img.imageReName}"/>
                        </c:when>

                        <c:when test="${img.imageOrder == 4}">
                            <c:set var="img4" value="${img.imagePath}${img.imageReName}"/>
                        </c:when>
                    </c:choose>
        
                </c:forEach> -->

                <!-- 이미지 등록 영역 -->
                <h5>이미지 등록</h5>
                <div class="img-box">
                    <div class="boardImg">
                        <label for="img0">
                            <img src="#" class="preview">
                        </label>
                        <input type="file" name="images" class="inputImage" id="img0" accept="image/*">
                        <span class="delete-image">&times;</span>
                    </div>
    
                    <div class="boardImg">
                        <label for="img1">
                            <img src="#" class="preview">
                        </label>
                        <input type="file" name="images" class="inputImage" id="img1" accept="image/*">
                        <span class="delete-image">&times;</span>
                    </div>
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

                <!-- 기존 이미지 존재하다가 삭제된 이미지 순서 기록 -->
                <input type="hidden" name="deleteList" value="">
                <!-- 수정 성공 시 주소 유지 용도 -->
                <input type="hidden" name="cp" value="#">

            </form>
        </section>


    </section>

    <!-- footer -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    
</body>
</html>