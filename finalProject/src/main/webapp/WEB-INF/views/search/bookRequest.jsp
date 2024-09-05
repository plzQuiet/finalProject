<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="/resources/css/search/bookRequest-style.css">
<link rel="stylesheet" href="/resources/css/common/sideMenu.css">
<link rel="stylesheet" href="/resources/css/main-style.css">
</head>
<body>
	
		<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
		<section class="main">
			<jsp:include page="/WEB-INF/views/common/sideMenu.jsp"></jsp:include>

			<section class="main-content">
				<div class="main-title">희망 도서 신청</div>
				<hr class="titleLine"/>
				<section class="body-content">
					<div class="body-title">신청 안내</div>
					<!-- 신청 안내 박스 -->
					<div class="apply-box">
						<div class="apply-box-img"></div>
						<div class="apply-box-index"><p>희망 도서 신청 시 다양한 주제의 도서를 선정하기 위해 신청하신 도서가 선정되지 않을 수 있습니다.</p> </div>
					</div>
					
					<hr/>
					<div class="apply-book-detail">
						<div class="line"><hr/></div>
						<div class="apply-book-details">희망 자료 신청 
							<ul>
								<li>신청기간: 상시 / 예산 소진 시 </li>
								<li>신청자격: JAVA LIBRARY 회원</li>
								<li>신청권수: 회원 1인 당 3권</li>
								<li>신청방법: 도서관 홈페이지 (로그인 -> 자료 검색 -> 희망 자료 신청)</li>
							</ul>
						</div>
						
						<div><hr/></div>
						<div>희망 자료 선정 제외 
							<ul>
								<li>품절 / 절판 도서</li>
								<li>전문 도서 및 고가 도서(50,000원 초과)<li>
								<li>과도한 개인 신앙 도서, 과도한 정치 편향 도서</li>
								<li>그 외에 내부 심의를 통해 논란 발생 우려가 있을 경우 제외</li>
							</ul>
						</div>
						
						
						<div><hr/></div>
						<div>희망 자료 선정 처리 
							<ul>
								<li>소요기간: 평균 20일 내외 </li>
								<li>처리절차: 신청 → 검토 → 주문 → 납품 → 등록 작업 → 비치</li>
								<li>처리 상황 안내</li>
								<li>"신청중", "처리중", "소장중" 으로 홈페이지상에 안내되며, 해당 도서 자료실 비치 시 대출 안내 문자메세지를 발송합니다.</li>
							</ul>
						</div>
						
						<hr>
						<div class="apply-area">
							<div>희망 자료 신청 또는 조회를 하려면 버튼을 누르세요 </div>
							<button>조회</button>
							<button>신청</button>
						</div>
						
					</div>
				</section>
			</section>

		</section>
	
</body>
</html>