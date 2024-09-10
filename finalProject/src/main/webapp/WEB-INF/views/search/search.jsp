<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="/resources/css/search/search-style.css">
<link rel="stylesheet" href="/resources/css/common/sideMenu.css">
<link rel="stylesheet" href="/resources/css/main-style.css">
</head>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<body>
	<main>
		<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
		<section class="main">
			<jsp:include page="/WEB-INF/views/common/sideMenu.jsp"></jsp:include>

			<section class="main-content">
				<div class="main-title">간략 검색</div>
				<section class="body-content">
					<div class="searchForm">
						<div class="searchInput">
							<div class="searchBar">
								<div class="searchSelect">
									<select id="searchKey" name="searchKey" title="검색 선택">
										<option value="All">전체</option>
										<option value="Title">서명</option>
										<option value="Author">저자</option>
									</select>
								</div>

								<div>
									<input type="text" placeholder="원하시는 도서를 검색해주세요">
								</div>

								<div>
									<button id="searchBtn">검색</button>
								</div>

							</div>

							<label class="searchDetailBtn">
								<div>
									<button id="searchDetailBtn">상세 검색</button>
								</div>
							</label>
						</div>
					</div>
					<div>검색어 '전체 : 잘린 머리처럼 불길한 것'에 대한 자료 검색 결과이며, 총 n건이 검색되었습니다.</div>
					<hr>

					<div class="body-content-mid">원하시는 도서를 검색해 보세요</div>

					<div class="body-content-bot">스와이프 들어갈 곳</div>
				</section>
			</section>
	</main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	
</body>
</html>