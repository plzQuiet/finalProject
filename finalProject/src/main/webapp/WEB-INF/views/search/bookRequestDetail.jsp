<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Java Library</title>
<link rel="stylesheet" href="/resources/css/main-style.css">
<link rel="stylesheet" href="/resources/css/common/sideMenu.css">
<link rel="stylesheet" href="/resources/css/common/modal.css">
<link rel="stylesheet" href="/resources/css/search/bookRequest-style.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<section class="main">
		<jsp:include page="/WEB-INF/views/search/sideMenu.jsp"></jsp:include>

		<section class="main-content">
			<div class="main-title">신청 양식</div>
			<hr class="titleLine" />
			<section class="body-content">
				<div class="request-form">
					<table>
						<tbody>
							<tr class="request-tr">
								<th>제목</th>
								<td>${request.requestTitle}</td>
							</tr>
							<tr>
								<th>신청일자</th>
								<td>${request.requestDate}</td>
							</tr>
							<tr>
								<th>신청자</th>
								<td>${fn:substring(request.memberName, 0,1)}*<c:if test="${fn:length(request.memberName) > 2}">${fn:substring(request.memberName, 2, fn:length(request.memberName))}</c:if></td>
							</tr>
							<tr>
								<th>희망 도서명</th>
								<td>${request.bookTitle}</td>
							</tr>
							<tr>
								<th>저자</th>
								<td>${request.bookAuthor}</td>
							</tr>
							<tr>
								<th>출판사</th>
								<td>${request.bookPub}</td>
							</tr>
							<tr>
								<th>출판 연도</th>
								<td>${request.bookPubDate}</td>
							</tr>
							<tr>
								<th class="opinion">추천의견</th>
								<td><textarea id="opinion" cols="20">${request.requestOpinion}</textarea></td>
							</tr>

						</tbody>
					</table>
				</div>
				<div class="btn-area">
					<c:if test="${loginMember.memberNo == request.memberNo}">
						<button id="updateBtn">수정</button>
						<button id="deleteBtn">삭제</button>
					</c:if>

					<button id="goToListBtn">목록으로</button>
				</div>
			</section>
		</section>
		
	</section>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<script>
		const loginMemberNo = "${loginMember.memberNo}";
		const requestNo = "${request.requestNo}";
	</script>
	<script src="/resources/js/search/bookRequestDetail.js"></script>
</body>
</html>