<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<script src="https://kit.fontawesome.com/cb5f1fee4d.js" crossorigin="anonymous"></script>

<section class="main-login-area">
    <article class="main-login-title">회원 로그인</article>
    <article class="main-login-form">

        <input type="text" name="id" placeholder="아이디 입력"/>
        <input type="password" name="pw" placeholder="비밀번호 입력"/>
        <div class="main-saveId">
            <input type="checkbox" name="saveId"/>
            <label for="saveId">아이디 저장</label>
        </div>
        <div class="main-login-btn-area">
            <button id="main-login-btn">로그인</button>
        </div>
        <div class="main-my-area">
            <a href="#"><span>ID 찾기</span></a>
            <span>|</span>
            <a href="#"><span>비밀번호 초기화</span></a>
            <span>|</span>
            <a href="#"><span>회원가입</span></a>
        </div>
    </article>
    
</section>

<script src="/resources/js/member/mainLogin.js" defer></script>