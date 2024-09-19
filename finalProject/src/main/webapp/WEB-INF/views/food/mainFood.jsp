<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.Calendar" %>

<%
    // 오늘 날짜에서 요일 가져오기 (0: 일요일, 1: 월요일, ..., 6: 토요일)
    Calendar calendar = Calendar.getInstance();
    int dayOfWeek = (calendar.get(Calendar.DAY_OF_WEEK) - 1) % 7;

    // dayOfWeek 값을 request에 저장
    request.setAttribute("dayOfWeek", dayOfWeek);
%>

<script src="https://kit.fontawesome.com/cb5f1fee4d.js" crossorigin="anonymous"></script>

<section class="main-food-area">
    <article>
    	<div class="today-menu-title">
	    	<i class="fa-solid fa-utensils"></i>오늘의 메뉴
    	</div>
    	<div id="goToFood"><a href="/food"><i class="fa-solid fa-plus"></i></a></div>
    </article>
    <article class="main-food-info-area">
        <div class="main-today-menu">
            <c:forEach var="food" items="${foodList}" varStatus="status">
                <c:if test="${food.typeNo == 0}">
                    <c:if test="${food.foodNo % 6 == dayOfWeek}">
                        <div>${food.foodName}</div>
                    </c:if>
                </c:if>
            </c:forEach>
        </div>
        <div class="main-time-info">
            <div class="main-restaurant-time">
                <p><strong>식당+매점 운영시간</strong></p>
                <p>09:00 ~ 20:00</p>
            </div>
            <div class="main-cafe-time">
                <p><strong>카페 운영시간</strong></p>
                <p>09:00 ~ 20:00</p>
            </div>
        </div>
    </article>
    
</section>

