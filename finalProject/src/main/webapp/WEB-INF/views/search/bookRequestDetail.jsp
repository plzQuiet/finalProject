<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
								<td>${bookReq.requestTitle}"</td>
							</tr>
							<tr>
								<th>신청일자</th>
								<td>${bookReq.requestDate}"</td>
							</tr>
							<tr>
								<th>신청자</th>
								<td>${bookReq.memberName}</td>
							</tr>
							<tr>
								<th>희망 도서명</th>
								<td>${bookReq.bookTitle}</td>
							</tr>
							<tr>
								<th>저자</th>
								<td>${bookReq.bookAuthor}</td>
							</tr>
							<tr>
								<th>출판사</th>
								<td>${bookReq.bookPub}</td>
							</tr>
							<tr>
								<th>출판연도</th>
								<td>${bookReq.bookPubDate}</td>
							</tr>
							<tr>
								<th class="opinion">추천의견</th>
								<td><textarea id="opinion" cols="20">${bookReq.requestOpinion}</textarea></td>
							</tr>

						</tbody>
					</table>
				</div>
				<div class="btn-area">
					<c:if test="${loginMember.memberNo == bookReq.memberNo}">
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
		const requestNo = "${bookReq.requestNo}";
	</script>
	<script src="/resources/js/search/bookRequestDetail.js"></script>
</body>
</html>