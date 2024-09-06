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

			<h1 class="myPage-title">정보수정</h1>
			<span class="myPage-subject">원하는 회원 정보를 수정할 수 있습니다.</span>

			<form action="update" method="POST" name="myPageFrm" id="updateFrm">

				<div class="myPage-row">
					<label>이름</label>
					<input type="text" name="memberName" id="memberName">
				</div>

				<div class="myPage-row">
					<label>전화번호</label>
					<input type="password" name="memberPno" id="memberPno">
				</div>

				<div class="myPage-row info-title">
					<span>주소</span>
				</div>

				<c:set var="addr" value="${fn:split(loginMember.memberAddress,'^^^')}" />

				<div class="myPage-row info-address">
					<input type="text" name="memberAddress" id="sample6_postcode" placeholder="우편번호" value="${addr[0]}">
					<button type="button" onclick="sample6_execDaumPostcode()">검색</button>
				</div>

				<div class="myPage-row info-address">
					<input type="text" name="memberAddress" id="sample6_address" placeholder="도로명/지번 주소" value="${addr[1]}">
				</div>

				<div class="myPage-row info-address">
					<input type="text" name="memberAddress" id="sample6_detailAddress" placeholder="상세 주소" value="${addr[2]}">
				</div>

				<button class="myPage-submit">수정하기</button>

			</form>

		</section>
	</section>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>