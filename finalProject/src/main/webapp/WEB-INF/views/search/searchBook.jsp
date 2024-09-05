<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>자료 검색</title>
<link rel="stylesheet" href="/resources/css/search/search-style.css">
<link rel="stylesheet" href="/resources/css/common/sideMenu.css">
<link rel="stylesheet" href="/resources/css/main-style.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<section class="main">
		<jsp:include page="/WEB-INF/views/common/sideMenu.jsp"></jsp:include>
		<section class="main-content">
			<div class="main-title">자료 검색</div>
			<section class="body-content">
				<div class="searchForm">
					<div class="searchInput">
						<!-- select box + 검색창 + 검색 버튼 -->
						<div class="searchBar">
							<div class="searchSelect">
								<select id="searchKey" name="searchKey" title="검색 선택">
									<option value="All">전체</option>
									<option value="Title">서명</option>
									<option value="Author">저자</option>
								</select>
							</div>
							<!-- 검색창 -->
							<div>
								<input type="text" placeholder="원하시는 도서를 검색해 주세요"></input>
							</div>
							<!-- 검색 버튼 -->
							<div class="btnArea_a">
								<button id="searchBtn">
									<img src="" />검색
								</button>
							</div>
						</div>
						<!-- 상세 검색 버튼 -->
						<div class="btnArea_b">
							<button id="searchDetailBtn">상세 검색</button>
						</div>
					</div>
				</div>

				<!-- 검색 결과 text -->
				<div>검색어 : '전체 : 잘린 머리처럼 불길한 것' 에 대한 검색 결과이며, 총 n 건이 검색되었습니다.</div>
				<hr>
				<!-- 밑줄 아래 부터 검색 결과 -->

				<div class="searchBody">
					<!-- 순번 -->
					<div class="index">1</div>
					<!-- 책 이미지 -->
					<div class="bookThumbnail">
						<img src="/resources/images/bookThumbnail" />
					</div>
					<!-- 책 상세 -->
					<div class="bookDetail">
						<div class="bookDetailTitle">잘린 머리처럼 불길한 것</div>
						<div class="bookDetailAuthor">저자 : 미쓰다 신조 지음, 권영조 옮김</div>
						<div class="bookDetailEnroll">등록 번호 : BOOK20240904</div>
						<div class="bookDetailState">
							<div>책 상태 :</div>
							<div class="bookDetailStateTextY">대출 가능</div>
							<div class="informBtn">
								<button id="informBtn">
									예약 / 소장 정보<img src="" />
								</button>
							</div>
						</div>
					</div>
					<!-- 즐겨찾기 -->
					<div class="favorite">
						<div>
							<button class="favoriteStar"></button>
						</div>
					</div>
				</div>
				<hr>

				<div class="searchBody">
					<!-- 순번 -->
					<div class="index">2</div>
					<!-- 책 이미지 -->
					<div class="bookThumbnail">
						<img src="/resources/images/bookThumbnail">
					</div>
					<!-- 책 상세 -->
					<div class="bookDetail">
						<div class="bookDetailTitle">잘린 머리처럼 불길한 것</div>
						<div class="bookDetailAuthor">저자 : 미쓰다 신조 지음, 권영조 옮김</div>
						<div class="bookDetailEnroll">등록 번호 : BOOK20240904</div>
						<div class="bookDetailState">
							<div>책 상태 :</div>
							<div class="bookDetailStateTextN">대출 불가능</div>
							<div class="informBtn">
								<button id="informBtn">예약 / 소장 정보</button>
							</div>
						</div>
					</div>
					<!-- 즐겨찾기 -->
					<div class="favorite">
						<div>
							<button class="favoriteStar"></button>
						</div>
					</div>
				</div>

				<!-- 예약 / 소장 정보 버튼 클릭 시 -->
				<div class="searchBodyDetail">
					<table class="detailTable">
						<thead>
							<tr>
								<th>도서관</th>
								<th>대출상태</th>
								<th>반납 예정일</th>
								<th>도서 등록 번호</th>
								<th>예약</th>
								<th>부록</th>
								<th>비고</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>JAVA LIBRARY</td>
								<td>대출 상태<br> (예약 가능)<br> (예약: 0명)
								</td>
								<td>2024.09.07</td>
								<td>EM0000063421</td>
								<td><button id="reservationBtn">예약하기</button></td>
								<td>없음</td>
								<td>없음</td>
							</tr>
						</tbody>
					</table>
				</div>
				<hr>
				

			</section>

		</section>
	</section>
</body>
</html>