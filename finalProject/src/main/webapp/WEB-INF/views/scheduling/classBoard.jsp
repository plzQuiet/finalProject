<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="pagination" value="${map.pagination}" />
<c:set var="boardList" value="${map.boardList}" />

<c:forEach items="${category}" var="catelist">
    <c:if test="${catelist.CAT_CODE == cateCode}">
        <c:set var="cateName" value="${catelist.CAT_NAME}"/>
    </c:if>
</c:forEach>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JavaLibrary - 교육문화 프로그램</title>

    <link rel="stylesheet" href="/resources/css/main-style.css">
    <link rel="stylesheet" href="/resources/css/common/sideMenu.css">
    <link rel="stylesheet" href="/resources/css/common/sideMenu.css">
    <link rel="stylesheet" href="/resources/css/scheduling/class-board.css">
    <link rel="stylesheet" href="/resources/css/scheduling/modal.css">
    <script src="https://kit.fontawesome.com/f4e088b372.js" crossorigin="anonymous"></script>

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

            <!-- 검색창 -->
            <form action="#">
                <div class="search-area">
                    <select name="key" id="searchKey">
                        <option value="t">제목</option>
                        <option value="c">내용</option>
                        <option value="tc">제목+내용</tion>
                    </select>

                    <input type="text" name="query" id="query" placeholder="검색어 입력">

                    <button id="searchBtn"><i class="fa-solid fa-magnifying-glass"></i></button>
                </div>
            </form>

            <!-- 게시글 목록 -->
            <section class="board-list">
                <div class="list-wrapper">
                    <table class="list-table">
                        <thead>
                            <tr>
                                <th>상태</th>
                                <th>제목</th>
                                <th>모집기간</th>
                            </tr>
                        </thead>

                        <tbody>
                            <!-- 게시글 조회 시 글 목록 존재 X -->
                            <c:choose>
                                <c:when test="#">
                                    <tr>
                                        <th colspan="5">게시글이 존재하지 않습니다.</th>
                                    </tr>
                                </c:when>

                                <c:otherwise>
                                    <c:forEach var="#" items="#">
                                        <td>기간마감</td>
                                        <td>000 프로그램</td>
                                        <td>2024-08-09 ~ 2024-08-10</td>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                        <tbody>
                            <td>신청가능</td>
                            <td>000 프로그램</td>
                            <td>2024-08-09 ~ 2024-08-10</td>
                        </tbody>
                    </table>
                </div>

                <!-- 관리자에게만 보이는 글쓰기 버튼 -->
                <div class="btn-area">
                    <c:if test="#">
                        <button id="writeBtn">글쓰기</button>
                    </c:if>
                </div>

                <!-- pagination -->
                <div class="pagination-area">

                    <ul class="pagination">
                        <!-- 첫 페이지로 이동 -->
                        <li><a href="/board/${cateCode}?cp=1${qs}">&lt;&lt;</a></li>

                        <!-- 이전 목록 마지막 페이지로 이동 -->
                        <li><a href="/board/${cateCode}?cp=${pagination.prevPage}${qs}">&lt;</a></li>

                        <!-- 특정 페이지로 이동 -->
                        <!-- 1페이지 씩 이동 -->
                        <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}">
                            <c:choose>

                                <c:when test="${i == pagination.currentPage}">
                                    <li><a class="current">${i}</a></li>
                                </c:when>

                                <c:otherwise>
                                    <li><a href="/board/${cateCode}?cp=${i}${qs}">${i}</a></li>
                                </c:otherwise>

                            </c:choose>
                        </c:forEach>

                        <!-- 다음 목록 시작 페이지로 이동 : > -->
                        <li><a href="/board/${cateCode}?cp=${pagination.nextPage}${qs}">&gt;</a></li>

                        <!-- 마지막 페이지로 이동 : >> -->
                        <li><a href="/board/${cateCode}?cp=${pagination.maxPage}${qs}">&gt;&gt;</a></li>
                    </ul>

                </div>

            </section>
        </section>


    </section>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>

</html>