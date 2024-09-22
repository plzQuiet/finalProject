<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Java Library</title>
<link rel="stylesheet" href="/resources/css/search/bookRequest-style.css">
<link rel="stylesheet" href="/resources/css/common/sideMenu.css">
<link rel="stylesheet" href="/resources/css/main-style.css">
<link rel="stylesheet" href="/resources/css/board/reviewList-style.css">
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<section class="main">
		<jsp:include page="/WEB-INF/views/search/sideMenu.jsp"></jsp:include>

		<section class="main-content">
			<div class="main-title">신청 내역</div>
			<hr class="titleLine" />
			<section class="body-content">
				<section class="board-list">
					<div class="list-wrapper">
						<table class="list-table">
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
							</thead>

							<tbody>
								<!-- 게시글 조회 시 글 목록 존재 X -->
								<c:choose>
									<c:when test="#">
										<tr>
											<th colspan="5">게시글이 존재하지 않습니다.</th>
										</tr>
									</c:when>

									<c:otherwise>
										<c:forEach var="#" items="#">
											<tr>
												<td>1000</td>
												<td>기사단장 죽이기 신청합니다.</td>
												<td>김동준</td>
												<td>2024.09.06</td>
												<td>대기중</td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</div>

					<!-- 관리자에게만 보이는 글쓰기 버튼 -->
					<div class="btn-area">
						<c:if test="#">
							<button id="writeBtn">글쓰기</button>
						</c:if>
					</div>

					<!-- pagination -->
					<div class="pagination-area">

						<ul class="pagination">
							<!-- 첫 페이지로 이동 : << -->
							<li><a href="#">&lt;&lt;</a></li>

							<!-- 이전 목록 마지막 페이지로 이동 : < -->
							<li><a href="#">&lt;</a></li>

							<!-- 특정 페이지로 이동 -->
							<!-- 1페이지 씩 이동 -->
							<li class="currentPage">1</li>
							<li>2</li>
							<li>3</li>
							<li>4</li>
							<li>5</li>

							<!-- 다음 목록 시작 페이지로 이동 : > -->
							<li><a href="#">&gt;</a></li>

							<!-- 마지막 페이지로 이동 : >> -->
							<li><a href="#">&gt;&gt;</a></li>
						</ul>

					</div>

				</section>
			</section>
		</section>
	</section>

	</section>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>
</html>