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
    <link rel="stylesheet" href="/resources/css/member/login.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
	<form action="/member/login" method="post" name="loginFrm" id="loginFrm">
		<div class="login-logo">
			<img src="/resources/images/logo.png">
		</div>
		
			<div class="login-input-area">
				<input type="text" name="memberEmail" id="memberEmail" placeholder="">
				<input type="password" name="memberPw" id="memberPw" placeholder="">
			</div>
		
		<div class="btn-area">
			<button>로그인</button>
		</div>
	</form>

	<ul class="login-nav">
		<li><a href="/member/findId">아이디 찾기</a></li>
		<li>|</li>
		<li><a href="/member/resetPw">비밀번호 초기화</a></li>
		<li>|</li>
		<li><a href="/member/signUp">회원가입</a></li>
	</ul>
		
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>