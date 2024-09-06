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
		<jsp:include page="/WEB-INF/views/common/sideMenu.jsp"/>
		
		<section class="list-area">
			<h1>예약 및 신청</h1>
			<div class="btn-area">
				<button class="selected">좌석 예약현황</button>
				<button>공간 예약현황</button>
				<button>클래스 신청현황</button>
			</div>
			<p>총 1건</p>
			<table id="list-table">
				<thead>
					<tr>
						<th>번호</th>
						<th>구 분</th>
						<th>예약일</th>
						<th>예약시간</th>
						<th>취소</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>186</td>
						<td>디지털열람석</td>
						<td>2024-08-26</td>
						<td>09:00 ~ 12:00</td>
						<td><button class="cancel">취소</button></td>
					</tr>
					<tr>
						<td>186</td>
						<td>디지털열람석</td>
						<td>2024-08-26</td>
						<td>09:00 ~ 12:00</td>
						<td><button class="cancel">취소</button></td>
					</tr>
					<tr>
						<td>186</td>
						<td>디지털열람석</td>
						<td>2024-08-26</td>
						<td>09:00 ~ 12:00</td>
						<td><button class="cancel">취소</button></td>
					</tr>
					<tr>
						<td>186</td>
						<td>디지털열람석</td>
						<td>2024-08-26</td>
						<td>09:00 ~ 12:00</td>
						<td><button class="cancel">취소</button></td>
					</tr>
				</tbody>
			</table>
		</section>
	</section>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	
	<script src="/resources/js/myPage/book.js"></script>
</body>
</html>