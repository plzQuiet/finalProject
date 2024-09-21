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
    <link rel="stylesheet" href="/resources/css/my/list-style.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
	<section class="container">
		<jsp:include page="/WEB-INF/views/my/sideMenu.jsp"/>
		
		<section class="list-area">
			<h1>예약 및 신청</h1>
			<div class="nav-area">
				<a href="reserv?m=1">좌석 예약현황</a>
                <a href="reserv?m=2">공간 예약현황</a>
                <a href="reserv?m=3">클래스 신청현황</a>
			</div>
			<table id="list-table">
				<thead>
					<tr>
						<th>번호</th>
						<th>구분</th>
						<th>예약일</th>
						<th>예약시간</th>
						<th>취소</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(list) == 0}">
							<tr>
								<th style="height: 100px;" colspan="5">예약 내역이 없습니다</th>
							</tr>
						</c:when>
						
						<c:otherwise>
							<c:forEach var="l" items="${list}">
								<tr>
									<td>${l.SEAT_NO}</td>
									<td>디지털열람실</td>
									<td>${l.RESERVATION_DT}</td>
									<td>${l.START_TIME} ~ ${l.END_TIME}</td>
									<td><button onclick="reservCancle(${l.RESERVATION_NO})">취소</button></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</section>
	</section>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	<script src="/resources/js/my/library.js"></script>
</body>
</html>