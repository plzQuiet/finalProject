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
<body>
	<main>
		<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
		<section class="main">
			<jsp:include page="/WEB-INF/views/common/sideMenu.jsp"></jsp:include>

			<section class="main-content">
				<div class="main-title">상세 검색</div>
				<section class="body-content">
					<div class="searchFormDetail">
						<div class="detailItem">
							<div class="details">검색 항목</div>
							<div class="detailsYear">발행 연도</div>
							<div class="detailsAlign">정렬 조건</div>
							<div class="detailsCount">출력 건수</div>

						</div>
						<div class="detailInput">

							<div class="searchDetail">
								<div class="searchTitle">
									<div class="bookTitle">서명</div>
									<div class="input">
										<input type="text" id="inputDetail" placeholder="책 제목을 입력해주세요."></input>
									</div>
								</div>

								<div class="searchAuthor">
									<div class="author">저자</div>
									<div class="input">
										<input type="text" id="inputDetail" placeholder="저자 이름을 입력해주세요."></input>
									</div>
								</div>

								<div class="searchPublisher">
									<div class="publisher">출판사</div>
									<div class="input">
										<input type="text" id="inputDetail" placeholder="출판사명을 입력해주세요."></input>
									</div>
								</div>

								<div class="searchYear">
									<div class="inputYear">
										<input type="text" id="inputYear"></input> 부터 <input type="text" id="inputYear"></input>
									</div>
								</div>

								<div class="searchAlign">
									<select id="searchAlign" name="searchAlign" title="정렬조건">
										<option value="accuracy">정확도순</option>
										<option value="recent">최근순</option>
										<option value="none">선택 안함</option>
									</select>
								</div>

								<div class="searchPrint">
									<select id="searchPrint" name="searchPrint" title="출력건수">
										<option value="10">10건</option>
										<option value="20">20건</option>
										<option value="30">30건</option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="btn-area">
						<div class="index-btn">
							<button id="index-btn">검색</button>
						</div>

						<div class="refresh-btn">
							<button id="refresh-btn">초기화</button>
						</div>
					</div>
				</section>
			</section>

		</section>
	</main>
</body>
</html>