<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Review</title>

    <link rel="stylesheet" href="/resources/css/main-style.css">
    <link rel="stylesheet" href="/resources/css/board/reviewList-style.css">
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
                <li class="side-current"> <a href="/notice" class="current">공지사항</a></li>
                <li class="side1"><a href="/qna">문의사항</a></li>
                <li class="side2"><a href="/faq">자주 묻는 질문</a></li>
                <li class="last-menu"><a href="/review">책 후기 나눠요</a></li>
            </ul>

        </article>

        <!-- 공지사항 목록 -->
        <section class="content-suround-section">
            <div class="content-title">책 후기 나눠요</div>
            <div class="title-line"></div>

             <!-- 검색창 --> 
             <form action="notice" method="get" id="boardSearch">
                <div class="search-area">
                    <select name="key" id="searchKey">
                        <option value="t">제목</option>
                        <option value="c">내용</option>
                    </select>

                    <input type="text" name="query" id="searchQuery" placeholder="검색어 입력">

                    <button id="searchBtn"><i class="fa-solid fa-magnifying-glass"></i></button>
                </div>
            </form>

            <!-- 게시글 목록 -->
            <section class="board-list">
                <div class="list-wrapper">
                    <table class="list-table">
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>작성일</th>
                                <th>조회수</th>
                            </tr>
                        </thead>

                        <tbody>
                            <!-- 게시글 조회 시 글 목록 존재 X -->
                            <c:choose>
                                <c:when test="${empty boardList}">
                                    <tr>
                                        <th colspan="5">게시글이 존재하지 않습니다.</th>
                                    </tr>
                                </c:when>

                                <c:otherwise>
                                    <c:forEach var="board" items="${boardList}">
                                        <%-- 게시글 조회 시 글 목록 존재 O --%>
                                        <td>${board.boardNo}</td>
                                        <td>
                                            <a href="/notice/${board.boardNo}?cp=${pagination.currentPage}${qs}">${board.boardTitle}</a>
                                            [${board.commentCount}]
                                        </td> 
                                        <td>${board.memberNo}</td>
                                        <td>${board.boardCreateDate}</td>
                                        <td>${board.readCount}</td>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>

                <!-- 로그인하면 보이는 글쓰기 버튼 -->
                <div class="btn-area">
                    <c:if test="${!empty loginMember}">
                        <button id="writeBtn">글쓰기</button>
                    </c:if>
                </div>

                <!-- pagination -->
                <div class="pagination-area">

                    <ul class="pagination">
                        <!-- 첫 페이지로 이동 : << -->
                        <li><a href="/notice?cp=1${qs}">&lt;&lt;</a></li>

                        <!-- 이전 목록 마지막 페이지로 이동 : < -->
                        <li><a href="/notice?cp=${pagination.prevPage}${qs}">&lt;</a></li>

                        <!-- 특정 페이지로 이동 -->
                        <!-- 1페이지 씩 이동 -->
                        <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}">
                            <c:choose>
                                <c:when test="${i == pagination.currentPage}">
                                    <!-- 현재 페이지 -->
                                    <li><a class="current">${i}</a></li>
                                </c:when>

                                <c:otherwise>
                                    <%-- 현재 페이지 제외한 나머지 --%>
                                    <li><a href="/notice?cp=${i}${qs}">${i}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <%-- <li>2</li>
                        <li>3</li>
                        <li>4</li>
                        <li>5</li> --%>

                        <!-- 다음 목록 시작 페이지로 이동 : > -->
                        <li><a href="/notice?cp=${pagination.nextPage}${qs}">&gt;</a></li>

                        <!-- 마지막 페이지로 이동 : >> -->
                        <li><a href="/notice?cp=${pagination.maxPage}${qs}">&gt;&gt;</a></li>
                    </ul>

                </div>
               
            </section>
        </section>


    </section>

    <!-- footer -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>

</html>