<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" href="/resources/css/my/side.css">

<article class="side-menu">
	<div>내 서재</div>
	<ul>
		<li>
			<a href="/myLibrary/book">나의 도서관</a>
		</li>
		<li>
			<a href="/myPayment">결제내역</a>
		</li>
		<li class="side-category">
			<a href="/myPage/info">회원정보</a>
		</li>
		<li>
			<div class="side-wrap">
				<a href="/myPage/info">내 정보</a>
				<a href="/myPage/writing">내가 쓴 글</a>
				<a href="/myPage/changePw">비밀번호 변경</a>
				<a href="/myPage/secession">회원탈퇴</a>
			</div>
		</li>
	</ul>
</article>