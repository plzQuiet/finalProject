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
	<link rel="stylesheet" href="/resources/css/my/info-style.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />

	<section class="container">
		<jsp:include page="/WEB-INF/views/common/sideMenu.jsp" />

		<section class="myPage">

			<h1 class="myPage-title">내 정보</h1>


			<div class="myPage-wrapper"></div>

			<section class="my-book-info-wrapper">
				<div>
					<span>대출중인도서</span>
					<span>0</span>
				</div>
				<div>
					<span>연체중인도서</span>
					<span>0</span>
				</div>
				<div>
					<span>예약중인도서</span>
					<span>0</span>
				</div>
				<div>
					<span>반납완료도서</span>
					<span>0</span>
				</div>
				<div>
					<span>신청중인도서</span>
					<span>0</span>
				</div>
				<div></div>
			</section>

		</section>
	</section>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>