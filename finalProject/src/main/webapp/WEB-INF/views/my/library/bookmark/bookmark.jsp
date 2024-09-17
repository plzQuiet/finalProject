<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<h1>즐겨찾기</h1>
			<table id="list-table">
				<thead>
					<tr>
						<th>도서명</th>
						<th>저자</th>
						<th>발행처</th>
						<th>발행년도</th>
						<th>ISBN</th>
						<th>즐겨찾기</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(list) == 0}">
							<tr>
								<th style="height: 100px;" colspan="6">즐겨찾기 내역이 없습니다</th>
							</tr>
						</c:when>
					
						<c:otherwise>
							<c:forEach var="b" items="${list}">
								<tr>
									<td><a href="">${b.BOOK_TITLE}</a></td>
									<td>${b.BOOK_AUTHOR}</td>
									<td>${b.BOOK_PUB}</td>
									<td>${b.BOOK_PUB_DT}</td>
									<td>${b.BOOK_ISBN}</td>
									<td><span onclick="bookmarkCancle(${b.BOOK_NO})">★</span></td>
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