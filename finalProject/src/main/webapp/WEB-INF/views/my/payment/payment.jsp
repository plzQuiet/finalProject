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
			<h1>결제내역</h1>
			<table id="list-table">
				<thead>
					<tr>
						<th>주문번호</th>
						<th>주문내역</th>
						<th>수량</th>
						<th>결제일</th>
						<th>금액</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(list) == 0}">
							<tr>
								<th style="height: 100px;" colspan="4">결제 내역이 없습니다</th>
							</tr>
						</c:when>
						
						<c:otherwise>
							<c:forEach var="l" items="${list}">
								<tr>
									<td>${b.TYPE_NAME}</td>
									<td>${b.FOOD_QTY}</td>
									<td>${b.PAY_DATE}</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</section>
	</section>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	
	<script src="/resources/js/myPage/book.js"></script>
</body>
</html>