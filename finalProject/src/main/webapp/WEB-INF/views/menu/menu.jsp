<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<link rel="stylesheet" href="/resources/css/menu/menu.css">
<link rel="stylesheet" href="/resources/css/common/sideMenu.css">
<link rel="stylesheet" href="/resources/css/main-style.css">
</head>
<body>
	<main>
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<section class="main">
			<jsp:include page="/WEB-INF/views/common/sideMenu.jsp"></jsp:include>

			<section class="main-content">
				<div class="content-title">구내식당</div>
				<div class="title-line"></div>

				<section class="content-detail-area">
					<div class="week-meal">
						<p class="meal-title">백반</p>
						<table>
							<thead>
								<tr>
									<td>월</td>
									<td>화</td>
									<td>수</td>
									<td>목</td>
									<td>금</td>
									<td>토</td>
									<td>일</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td rowspan="5">휴관일</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
								</tr>
								<tr>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
								</tr>
								<tr>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
								</tr>
								<tr>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
								</tr>
								<tr>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
									<td>춘천 닭갈비</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="snack">
						<p class="meal-title">분식</p>
					</div>
				</section>
			</section>

		</section>
	</main>


	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>