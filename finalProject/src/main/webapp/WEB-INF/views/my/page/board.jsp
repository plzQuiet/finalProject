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
	<jsp:include page="/WEB-INF/views/common/header.jsp" />

	<section class="container">
		<jsp:include page="/WEB-INF/views/my/page/sideMenu.jsp"/>

		<section class="list-area">
			<h1>내가 쓴 글</h1>
			<div class="nav-area">
				<a href="writing?m=1">게시글</a>
				<a href="writing?m=2">댓글</a>
			</div>
			<p>총 ${fn:length(list)}건</p>
			<table id="list-table">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(list) == 0}">
							<tr>
								<th style="height: 100px;" colspan="3">작성한 게시글이 없습니다</th>
							</tr>
						</c:when>
					
						<c:otherwise>
							<c:forEach var="l" items="${list}">
								<tr>
									<td>${l.BOARD_NO}</td>
									<c:if test="${l.CAT_CODE == 12}">
										<c:set var="board" value="scheduling"/>
									</c:if>
									<c:if test="${l.CAT_CODE != 12}">
										<c:set var="board" value="board"/>
									</c:if>
									<td><a href="/${board}/${l.CAT_CODE}/${l.BOARD_NO}">${l.BOARD_TITLE}</a></td>
									<td>${l.B_CREATE_DT}</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			
			<c:if test="${empty param.m}">
				<c:set var="m" value="1"/>
			</c:if>
			
			<c:if test="${!empty param.m}">
				<c:set var="m" value="${param.m}"/>
			</c:if>
			
			<c:if test="${pagination.listCount > 0}">
				<div class="pagination-area">
					<ul class="pagination">
						<li><a href="writing?m=${m}&cp=1">&lt;&lt;</a></li>
						<li><a href="writing?m=${m}&cp=${pagination.prevPage}">&lt;</a></li>
						<c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}">
							<c:choose>
								<c:when test="${i == pagination.currentPage}">
								<li><a class="current">${i}</a></li>
								</c:when>
								
								<c:otherwise>
								<li><a href="writing?m=${m}&cp=${i}">${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<li><a href="writing?m=${m}&cp=${pagination.nextPage}">&gt;</a></li>
						<li><a href="writing?m=${m}&cp=${pagination.maxPage}">&gt;&gt;</a></li>
					</ul>
				</div>
			</c:if>
		</section>
	</section>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<script src="/resources/js/my/library.js"></script>
</body>
</html>