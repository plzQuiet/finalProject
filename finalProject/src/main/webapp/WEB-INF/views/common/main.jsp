<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Java Library</title>
    <link rel="stylesheet" href="/resources/css/main-style.css">
    <link rel="stylesheet" href="/resources/css/intro/main_cal_hour.css">
    <link rel="stylesheet" href="/resources/css/board/main-notice.css">
    <link rel="stylesheet" href="/resources/css/food/mainFood.css">
    <link rel="stylesheet" href="/resources/css/member/mainLogin.css">
    <link rel="stylesheet" href="/resources/css/scheduling/slideClass.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
	<section class="main-page-suround-area-section">

        <article class="main-class-login-area">
            <jsp:include page="/WEB-INF/views/scheduling/slideClass.jsp"/>
            <div></div>
            <jsp:include page="/WEB-INF/views/member/mainLogin.jsp"/>
        </article>
        <%-- 이용시간 및 달력 --%>
        <jsp:include page="/WEB-INF/views/intro/main_cal_hours.jsp"/>
        
        <article class="main-food-notice-area">
	        <%-- 오늘의 메뉴 --%>
	        <jsp:include page="/WEB-INF/views/food/mainFood.jsp"/>
	        
	        <!-- 공지사항 -->
	        <jsp:include page="/WEB-INF/views/board/main-notice.jsp" />  
        
        </article>
        
	</section>


    <%-- 달력 일정 모달 --%>
    <jsp:include page="/WEB-INF/views/intro/main_cal_modal.jsp"/>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>