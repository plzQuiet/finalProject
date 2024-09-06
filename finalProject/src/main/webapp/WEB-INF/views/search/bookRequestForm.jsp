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
			<div class="main-title">신청 양식</div>
			<hr class="titleLine" />
			<section class="body-content">
				<div class="request-form">
					<table>
						<tbody>
							<tr class="request-tr">
								<th>제목</th>
								<td>책 신청합니다 !! !! ! !</td>
							</tr>
							<tr>
								<th>신청일자</th>
								<td>aaaa</td>
							</tr>
							<tr>
								<th>신청자</th>
								<td>aaaa</td>
							</tr>
							<tr>
								<th>희망 도서명</th>
								<td>aaaa</td>
							</tr>
							<tr>
								<th>저자</th>
								<td>aaaa</td>
							</tr>
							<tr>
								<th>출판사</th>
								<td>aaaa</td>
							</tr>
							<tr>
								<th>출판일자</th>
								<td>aaaa</td>
							</tr>
							<tr>
								<th class="opinion">추천의견</th>
								<td>이 책을 보고 한 눈에 반했어 그래서 이 책을 사야만 했는데 수중에 돈이 없었어 돈을 모으려고 해봤지만 돈이 모이지 않았어 그래서 결국 이렇게 도서관에 와서 도서를 신청하고 있는 내가 존재하게 된거야 나는 이 책을 봐야만 해 찾아야만 해 그렇지 않으면 죽고 말거야</td>
							</tr>

						</tbody>
					</table>
				</div>
				<div class="btn-area">
					<button id="request-btn">신청하기</button>
				</div>
			</section>
		</section>

	</section>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>
</html>