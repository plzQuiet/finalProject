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
    <link rel="stylesheet" href="/resources/css/my/my-style.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
	<section class="container">
		<jsp:include page="/WEB-INF/views/common/sideMenu.jsp"/>
		
		<section class="my-area">
			<h1>즐겨찾기</h1>
			<p>도서 상세</p>
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
					<tr>
						<td>1Q84</td>
						<td>무라카미 하루키</td>
						<td>신초샤 문학동네</td>
						<td>2010년 4월 16일</td>
						<td>9788954608640</td>
						<td>★</td>
					</tr>
					<tr>
						<td>1Q84</td>
						<td>무라카미 하루키</td>
						<td>신초샤 문학동네</td>
						<td>2010년 4월 16일</td>
						<td>9788954608640</td>
						<td>☆</td>
					</tr>
					<tr>
						<td>1Q84</td>
						<td>무라카미 하루키</td>
						<td>신초샤 문학동네</td>
						<td>2010년 4월 16일</td>
						<td>9788954608640</td>
						<td>☆</td>
					</tr>
					<tr>
						<td>1Q84</td>
						<td>무라카미 하루키</td>
						<td>신초샤 문학동네</td>
						<td>2010년 4월 16일</td>
						<td>9788954608640</td>
						<td>☆</td>
					</tr>
				</tbody>
			</table>
		</section>
	</section>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	
	<script src="/resources/js/myPage/book.js"></script>
</body>
</html>