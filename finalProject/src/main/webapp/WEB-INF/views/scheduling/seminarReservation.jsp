<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>도서관 예약 시스템</title>
    <link rel="stylesheet" href="/resources/css/scheduling/seminar-reservation.css">
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js'></script>
</head>

<body>
    <header>
        <nav>
            <ul>
                <li>
                    <a href="#">
                        <img src="/resources/images/logo.png" alt="로고" id="homeLogo">
                        <span>도서관 예약 시스템</span>
                    </a>
                </li>
                <li><a href="#"><span>열람실</span></a><a>&nbsp;|&nbsp;</a><a href="#"><span>세미나실</span></a></li>
            </ul>
        </nav>
    </header>

    <section class="main-content-suround-section">
        <section class="content-suround-section">
            <div><span>세미나실</span></div>

            <form action="">
                <div>
                    <span>예약일 :</span><span id="date-div"></span>
                </div>

                <div class="surround-calendar-area">
                    <div class="calendar-btn-area">
                        <div id="prev-btn">&lt;</div>
                        <div id="today-btn">오늘</div>
                        <div id="next-btn">&gt;</div>
                    </div>
                    <div id='calendar'></div>
                </div>

                <div class="reservation-time">
                    <span>예약시간</span>
                </div>
                <div id="time-slot-table" class="time-slot-table">
                    <!-- 예약 가능한 시간표가 여기에 표시됩니다 -->
                </div>

                <div class="button-area">
                    <button type="button" id="reserve-btn">예약</button>
                </div>
            </form>
        </section>
    </section>

    <footer>
        <article>
            <a href="#">개인정보처리방침</a>
            <span>|</span>
            <a href="#"> 영상정보처리기 운영·관리방침 </a>
        </article>
        <div>
            <img src="/resources/images/logo.png">
            <div>
                <p>서울특별시 강남구 테헤란로 14길 6 (남도빌딩) </p>
                <p> 전화번호 : 1544-9970 </p>
                <p> 이용시간 : 화~금 07:00 ~ 23:00 / 토,일 07:00~21:00 / 월요일, 공휴일 휴관</p>
            </div>
            <img src="/resources/images/wa_logo.png">
        </div>
    </footer>


    <script src="/resources/js/scheduling/seminar-reservation.js"></script>
</body>

</html>