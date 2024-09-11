<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>도서관 예약 시스템</title>

    <link rel="stylesheet" href="/resources/css/reservation/study-reservation.css">
    <link rel="stylesheet" href="/resources/css/reservation/reservModal.css">

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

                <li><a href="1"><span>열람실</span></a><a>&nbsp;|&nbsp;</a><a href="2"><span>세미나실</span></a></li>
            </ul>
        </nav>
    </header>

    <section class="main-content-suround-section">
        <form action="#">


            <section class="content-suround-section">
                <div><span>열람실</span></div>
                <div>
                    <span>1. 예약 일자</span>
                    <span><input type="date"></span>
                </div>
                <div>
                    <span>2. 예약 시간</span>
                    <span><input type="time"> ~ <input type="time"></span>
                    <span><button>조회</button></span>
                </div>
                <div>
                    <span>3. 예약 좌석 </span>
                    <span id="ment">예약할 좌석을 선택해 주세요.</span>
                    <span>seat(--)</span>
                    <span><button onclick="reservSeatModal()">예약</button></span>
                </div>
            </section>

            <section class="seat-status-section">

                <table>
                    <tr>
                        <th>열람실</th>
                        <th>전제좌석</th>
                        <th>사용좌석</th>
                        <th>잔여좌석</th>
                    </tr>
                    <tr>
                        <td>4층</td>
                        <td>32</td>
                        <td>12</td>
                        <td>20</td>
                    </tr>
                </table>


                <table>
                    <tr>
                        <th id="selected-no">좌석번호</th>
                        <th>좌석번호</th>
                    </tr>
                    <tr>
                        <td id="selected-seat">사용중</td>
                        <td>사용가능</td>
                    </tr>
                </table>



            </section>

            <section class="seat-select-section">

                <div class="seat-group">
                    <table class="private">
                        <tr>
                            <th>1</th>
                        </tr>

                        <tr>
                            <td>사용중</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>2</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>3</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>4</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <th>5</th>
                        </tr>

                        <tr>
                            <td>사용중</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>6</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>7</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>8</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>
                </div>

                <div class="seat-group">
                    <table>
                        <tr>
                            <th>9</th>
                        </tr>

                        <tr>
                            <td>사용중</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>10</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>11</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>12</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <th>13</th>
                        </tr>

                        <tr>
                            <td>사용중</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>14</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>15</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>16</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>
                </div>

                <div class="seat-group">
                    <table>
                        <tr>
                            <th>17</th>
                        </tr>

                        <tr>
                            <td>사용중</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>18</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>19</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>20</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <th>21</th>
                        </tr>

                        <tr>
                            <td>사용중</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>22</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>23</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>24</th>
                        </tr>

                        <tr>
                            <td>공 석</td>
                        </tr>
                    </table>
                </div>


                <div class="empty-space"></div> <!-- 오른쪽 상단 빈 공간 -->

            </section>
        </form>

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

    <!-- 알림창 모달-->
    <div id="popup_layer">
        <div class="popup_box">
            <div class="popup_header">
                <p>다음과 같이 좌석이 선택되었습니다.</p>
            </div>

            <!--팝업 컨텐츠 영역-->
            <div class="popup_content">
                <p>해당 00좌석을 예약 하시겠습니까?</p>
            </div>
            <!--팝업 버튼 영역-->
            <div class="popup_btn">
                <button id="reserv_confirm_btn" onclick="seatImporModal()">확인</button>
                <button id="cancel_btn">취소</button>
            </div>
        </div>
    </div>

    <!-- 예약정보 확인 모달-->
    <div id="popup_layer">
        <div class="popup_box">
            <div class="popup_header">
                <p>다음과 같이 예약되었습니다.</p>
            </div>

            <!--팝업 컨텐츠 영역-->
            <div class="popup_content">
                <p>예약 좌석 : 00번</p>
                <p>예약 일자 : 2024-09-09</p>
                <p>예약 요일 : 0요일</p>
                <p>예약 시간 : 09:00 ~ 12:00</p>
            </div>
            <!--팝업 버튼 영역-->
            <div class="popup_btn">
                <button id="reserv-history">예약이력</button>
            </div>
        </div>
    </div>

    <script src="/resources/js/reservation/class-board.js"></script>


</body>

</html>