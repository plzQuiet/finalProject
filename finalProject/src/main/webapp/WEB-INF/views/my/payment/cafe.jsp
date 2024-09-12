readingReserv<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="pagination" value="${map.pagination}"/>
<c:set var="list" value="${map.list}"/>

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
		<jsp:include page="/WEB-INF/views/my/library/sideMenu.jsp"/>
		
		<section class="list-area">
			<h1>예약 및 신청</h1>
			<div class="nav-area">
				<a href="cafe?m=1">구내식당</a>
                <a href="cafe?m=2">카페</a>
			</div>
			<p>카페</p>
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
								<th style="height: 100px;" colspan="4">신청 내역이 없습니다</th>
							</tr>
						</c:when>
						
						<c:otherwise>
							<c:forEach var="b" items="${list}">
								<tr>
									<td>${b.REQ_BOOK_NO}</td>
									<td>${b.BOOK_TITLE}</td>
									<td>${b.BOOK_AUTHOR}</td>
									<td>${b.BOOK_PUB}</td>
									<td>
										<c:if test="${b.REQ_APPROVE == 'W'}">대기</c:if>
										<c:if test="${b.REQ_APPROVE == 'Y'}">승인</c:if>
										<c:if test="${b.REQ_APPROVE == 'N'}">거절</c:if>
									</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			
			<c:if test="${fn:length(list) > 0}">
				<div class="pagination-area">
		            <ul class="pagination">
		                <li><a href="/myLibrary/reserv?m=3&cp=1">&lt;&lt;</a></li>
		                <li><a href="/myLibrary/reserv?m=3&cp=${pagination.prevPage}">&lt;</a></li>
		                <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}">
		                    <c:choose>
		                        <c:when test="${i == pagination.currentPage}">
		                            <li><a class="current">${i}</a></li>
		                        </c:when>
		
		                        <c:otherwise>
		                            <li><a href="/myLibrary/reserv?m=3&cp=${i}">${i}</a></li>
		                        </c:otherwise>
		                    </c:choose>
		                </c:forEach>
		                <li><a href="/myLibrary/reserv?m=3&cp=${pagination.nextPage}">&gt;</a></li>
		                <li><a href="/myLibrary/reserv?m=3&cp=${pagination.maxPage}">&gt;&gt;</a></li>
		            </ul>
		        </div>
	        </c:if>
		</section>
	</section>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	<script src="/resources/js/my/library.js"></script>
</body>
</html>