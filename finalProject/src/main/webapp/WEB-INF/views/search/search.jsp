<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="/resources/css/search/search-style.css">
<link rel="stylesheet" href="/resources/css/common/sideMenu.css">
<link rel="stylesheet" href="/resources/css/main-style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
</head>

<body>
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <!-- <script>
        // 검색 버튼 클릭 이벤트
        $(document).ready(function () {
            $('#searchBtn').on('click', function () {
                // 입력된 검색어 가져오기
                var query = $('input[type="text"]').val();
                
                // Kakao API 호출
                $.ajax({
                    method: "GET",
                    url: "https://dapi.kakao.com/v3/search/book?target=title",
                    data: { query: query },
                    headers: { Authorization: "KakaoAK ae9b73b7e0b950cf9da13887e83fa9e1" }
                })
                .done(function (msg) {
                    // 검색 결과가 있을 경우 처리
                    if (msg.documents.length > 0) {
                        // 기존 내용 지우기
                        $("p").html(""); 

                        // 모든 검색 결과를 출력
                        msg.documents.forEach(function(book) {
                            // 책 제목과 이미지 출력
                            $("p").append("<div><strong>" + book.title + "</strong></div>");
                            $("p").append("<div><img src='" + book.thumbnail + "' alt='Book Thumbnail' style='width: 100px; height: 150px;'/></div>");
                            $("p").append("<hr>");  // 구분선 추가
                        });
                    } else {
                        // 검색 결과가 없을 때
                        $("p").html("검색 결과가 없습니다.");
                    }
                })
                .fail(function () {
                    // API 요청 실패 시 처리
                    $("p").html("검색 중 오류가 발생했습니다.");
                });
            });
        });
    </script> -->
    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
        <section class="main">
            <jsp:include page="/WEB-INF/views/search/sideMenu.jsp"></jsp:include>

            <section class="main-content">
                <div class="main-title">간략 검색</div>
                <hr class="titleLine"/>
                <section class="body-content">
                    <div class="searchForm">
                        <div class="searchInput">
                            <div class="searchBar">
                                <div class="searchSelect">
                                    <select id="key" name="key" title="검색 선택">
                                        <option value="ta">전체</option>
                                        <option value="t">서명</option>
                                        <option value="a">저자</option>
                                    </select>
                                </div>

                                <div>
                                    <input type="text" id="query" name="query" placeholder="도서를 검색해 주세요">
                                </div>

                                <div class="searchArea">
                                    <button type="button" id="searchBtn" onclick="searchBooks()" onclick="location.href='searchBook'">  <i class="fa-solid fa-magnifying-glass" style="width: fit-content;"></i>검색</button>
                                </div>

                            </div>

                        </div>
                        <div>
                            <button id="searchDetailBtn">상세 검색</button>
                        </div>
                    </div>
                

                    <div class="body-content-mid">원하시는 도서를 검색해 보세요
                    </div>
                    <div id="result"></div>

                    <div class="body-content-bot">
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
    </main>
    <script src="/resources/js/search/search.js"></script>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    
</body>
</html>
