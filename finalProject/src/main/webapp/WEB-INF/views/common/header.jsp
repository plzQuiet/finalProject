<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script>
	(()=>{
      var link = document.createElement('link');
      link.rel ="shortcut icon";
      link.href ="/resources/images/logo.png";
      document.head.appendChild(link);
	})();
</script>

<header>
	<nav>
	    <ul>
	        <li><a href="/"><img id="homeLogo" src="/resources/images/logo.png">자바 라이브러리</a></li>
	        <li>
				<a href="#">도서관 안내</a>
				<ul>
					<li><a href="#">도서관 소개</a></li>
					<li><a href="#">이용안내</a></li>
					<li><a href="#">시설안내</a></li>
				</ul>
			</li>
	        <li>
				<a href="/2">자료 검색</a>
				<ul>
					<li><a href="#">통합 자료 검색</a></li>
					<li><a href="#">희망 도서 신청</a></li>
				</ul>
			</li>
	        <li>
				<a href="#">참여마당</a>
				<ul>
					<li><a href="#">교육/문화 프로그램</a></li>
					<li><a href="#">열람실</a></li>
					<li><a href="#">세미나실</a></li>
				</ul>
			</li>
	        <li>
				<a href="#">이용자 마당</a>
				<ul>
					<li><a href="/notice">공지사항</a></li>
					<li><a href="/qna">문의사항</a></li>
					<li><a href="/faq">자주 묻는 질문</a></li>
					<li><a href="/review">책후기 나눠요</a></li>
				</ul>
			</li>
	        <li>
				<a href="/menu">맛있는 도서관</a>
				<ul>
					<li><a href="/menu">구내식당</a></li>
					<li><a href="/cafe">카페</a></li>
				</ul>
			</li>
	        <li>
				<a href="/myLibrary/book">내 서재</a>
				<ul>
					<li><a href="/myLibrary/book">나의 도서관</a></li>
					<li><a href="/myPayment">결제내역</a></li>
					<li><a href="#">회원정보</a></li>
				</ul>
			</li>
	    </ul>
	    
	    <div class="header-top-menu">
			<c:choose>
				<c:when test="${empty loginMember}">
					<!-- 로그인 X -->
					<a href="/">메인 페이지</a> | <a href="/member/login">로그인</a>
				</c:when>
		
				<c:otherwise>
					<!-- 로그인 O -->
					<label for="headerMenuToggle"> ${loginMember.memberNickname}
						<i class="fa-solid fa-caret-down"></i>
					</label>
		
					<input type="checkbox" id="headerMenuToggle">
		
					<div class="header-menu">
						<a href="/myPage/info">내정보</a> <a href="/member/logout">로그아웃</a>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	<div></div>
</header>

<c:set var="requestAddr" value="${requestScope['javax.servlet.forward.servlet_path']}"/>

<c:if test="${requestAddr != '/'}">
    <div class="library-book">
    	<img src="/resources/images/library_book.png">
    </div>
</c:if>