<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Java Library</title>
    <link rel="stylesheet" href="/resources/css/main-style.css">
    <link rel="stylesheet" href="/resources/css/member/findId.css">
</head>
<body>
	<main>
		<jsp:include page="/WEB-INF/views/common/header.jsp"/>
		
		<form action="/member/findId" method="post" name="findIdFrm" id="findIdFrm">
			<div class="findId-logo">
				<img src="/resources/images/logo.png">
				아이디 찾기
			</div>
			
			
			<div class="findId-input-area">
				<span>이름</span>
				<input type="text" name="memberName" id="memberName">
			</div>
			
			<span class="findPw-message" id="nameMessage"></span>
			
			
			<div class="findId-input-area">
				<span>전화번호</span>
				<input type="text" name="memberTel" id="memberTel">
			</div>
			
			<span class="findPw-message" id="telMessage"></span>
			
			
			<div class="btn-area">
				<button>확인</button>
			</div>
		</form>
		
	</main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	<script src="/resources/js/member/findId.js"></script>
</body>
</html>