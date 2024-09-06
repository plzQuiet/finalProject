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
	<jsp:include page="/WEB-INF/views/common/header.jsp" />

	<section class="container">
		<jsp:include page="/WEB-INF/views/common/sideMenu.jsp" />

		<section class="list-area">
			<h1>내 글 관리</h1>
			<div class="btn-area">
				<button class="selected">게시글</button>
				<button>댓글</button>
			</div>
			<p>총 1건</p>
			<table id="list-table">
				<thead>
					<tr>
						<th>번호</th>
						<th>내용</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>186</td>
						<td>ㅓㅁㄴ아ㅣㄹ;ㅓㅁㄴ일[ㅓㅁㄴㅇ럼ㄴ이렁ㅁ니]</td>
						<td>유저일</td>
						<td>2024-08-26</td>
					</tr>
				</tbody>
			</table>
		</section>
	</section>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>