<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Java Library</title>
<link rel="stylesheet" href="/resources/css/main-style.css">
<link rel="stylesheet" href="/resources/css/common/sideMenu.css">
<link rel="stylesheet" href="/resources/css/search/search-style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
</head>

<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <section class="container">
        <jsp:include page="/WEB-INF/views/search/sideMenu.jsp"></jsp:include>

        <section class="main-content">
            <div class="main-title">간략 검색</div>
            <hr class="titleLine"/>
            <div class="searchBar">
                <select id="key">
                    <option value="ta">전체</option>
                    <option value="t">도서명</option>
                    <option value="a">저자</option>
                </select>

                <input type="text" id="query" name="query" placeholder="도서를 검색해 주세요">

                <button id="searchBtn">
                    <i class="fa-solid fa-magnifying-glass"></i>검색
                </button>

            </div>

            
            <div id="queryResult"></div>

            <div class="body-content-bot" style="display: none;">
                <p>인기도서</p>
                <div class="swiper sample">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide"><img src="../../../resources/images/bookThumbnail.jpg" alt="Image1"></div>
                        <div class="swiper-slide"><img src="../../../resources/images/bookThumbnail.jpg" alt="Image2"></div>
                        <div class="swiper-slide"><img src="../../../resources/images/bookThumbnail.jpg" alt="Image3"></div>
                        <div class="swiper-slide"><img src="../../../resources/images/bookThumbnail.jpg" alt="Image4"></div>
                        <div class="swiper-slide"><img src="../../../resources/images/bookThumbnail.jpg" alt="Image5"></div>
                        <div class="swiper-slide"><img src="../../../resources/images/bookThumbnail.jpg" alt="Image6"></div>
                        <div class="swiper-slide"><img src="../../../resources/images/bookThumbnail.jpg" alt="Image7"></div>

                    </div>
                    <div class="swiper-button-prev"></div>
                    <div class="swiper-button-next"></div>
                </div>


            </div>
        </section>
    </section>
    <jsp:include page="/WEB-INF/views/search/searchModal.jsp"></jsp:include>
    <script>
        const loginMemberNo = "${loginMember.memberNo}";
    </script>
    <script src="/resources/js/search/search.js"></script>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>
