<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>cafe</title>
	
	<link rel="stylesheet" href="/resources/css/menu/cafe.css">
	<link rel="stylesheet" href="/resources/css/common/sideMenu.css">
	<link rel="stylesheet" href="/resources/css/main-style.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<section class="main">
		<jsp:include page="/WEB-INF/views/common/sideMenu.jsp"></jsp:include>

		<section class="main-content">
			<div class="content-title">카페</div>
			<div class="title-line"></div>

			<section class="content-detail-area">
				<div class="cafe-btn-area">
					<button id="pay-btn">음료 구매</button>
				</div>

				<article class="cafe-menu">
					<div class="cafe-menu-area">
						<a href="#">
							<img src="/resources/images/menu/americano.png">
							<p>아이스 아메리카노</p>
							<p>3500원</p>
						</a>
					</div>
					
					<div class="cafe-menu-area">
						<a href="#">
							<img src="/resources/images/menu/americano.png">
							<p>아이스 아메리카노</p>
							<p>3500원</p>
						</a>
					</div>
					
					<div class="cafe-menu-area">
						<a href="#">
							<img src="/resources/images/menu/americano.png">
							<p>아이스 아메리카노</p>
							<p>3500원</p>
						</a>
					</div>
					
					<div class="cafe-menu-area">
						<a href="#">
							<img src="/resources/images/menu/americano.png">
							<p>아이스 아메리카노</p>
							<p>3500원</p>
						</a>
					</div>
					
					<div class="cafe-menu-area">
						<a href="#">
							<img src="/resources/images/menu/jamonghoneyblended.jpg">
							<p>자몽 허니 블렌디드</p>
							<p>3500원</p>
						</a>
					</div>
				</article>
			</section>
		</section>
	</section>
</body>
</html>