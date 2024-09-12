<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" href="/resources/css/my/side.css">

<article class="side-menu">
	<div>내 서재</div>
	<ul>
		<li>
			<a href="/myLibrary/book" class="side-category">나의 도서관</a>
		</li>
		<li>
			<div class="side-wrap">
				<a href="/myLibrary/book">도서현황</a>
				<a href="/myLibrary/reserv">예약 및 신청</a>
				<a href="/myLibrary/bookmark">즐겨찾기</a>
			</div>
		</li>
		<li>
			<a href="/myPayment">결제내역</a>
		<li>
			<a href="/myPage/info">회원정보</a>
		</li>
	</ul>
</article>