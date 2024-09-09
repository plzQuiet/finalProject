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
			<h1>도서현황</h1>
			<div class="btn-area">
				<button class="selected">대출중인 도서</button>
				<button>이전 대출내역</button>
				<button>예약내역</button>
				<button>신청내역</button>
			</div>
			<p>대출중인 도서 : 4권</p>
			<table id="list-table">
				<thead>
					<tr>
						<th>등록번호</th>
						<th>도서명</th>
						<th>대출일/반납예정일</th>
						<th>대출상태</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>JU0000041821</td>
						<td>셜록 홈즈 - 주홍색 연구</td>
						<td>2008-02-21<br>2008-03-06</td>
						<td>연체중</td>
					</tr>
					<tr>
						<td>JU0000041821</td>
						<td>셜록 홈즈 - 주홍색 연구</td>
						<td>2008-02-21<br>2008-03-06</td>
						<td>연체중</td>
					</tr>
					<tr>
						<td>JU0000041821</td>
						<td>셜록 홈즈 - 주홍색 연구</td>
						<td>2008-02-21<br>2008-03-06</td>
						<td>연체중</td>
					</tr>
					<tr>
						<td>JU0000041821</td>
						<td>셜록 홈즈 - 주홍색 연구</td>
						<td>2008-02-21<br>2008-03-06</td>
						<td>연체중</td>
					</tr>
				</tbody>
			</table>
		</section>
	</section>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	<script>
		const loginMemberNo = "${loginMember.memberNo}";
	</script>
	<script src="/resources/js/myPage/book.js"></script>
</body>
</html>