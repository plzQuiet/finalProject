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
						<th>내용</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(list) == 0}">
							<tr>
								<th style="height: 100px;" colspan="3">작성한 댓글이 없습니다</th>
							</tr>
						</c:when>
					
						<c:otherwise>
							<c:forEach var="l" items="${list}">
								<tr>
									<td>${l.COMMENT_NO}</td>
									<td>${l.COMMENT_CONTENT}</td>
									<td>${l.C_CREATE_DT}</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</section>
	</section>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<script src="/resources/js/my/library.js"></script>
</body>
</html>