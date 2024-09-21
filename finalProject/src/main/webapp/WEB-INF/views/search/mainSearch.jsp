<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<script src="https://kit.fontawesome.com/cb5f1fee4d.js" crossorigin="anonymous"></script>

<section class="main-search-area">
   	<article class="searchForm">
		<input type="text" id="query" name="query" placeholder="검색어를 입력하세요.">
		<div class="searchArea">
			<button type="button" id="searchBtn" onclick="searchBooks()"  
			onclick="location.href='searchBook'">  <i class="fa-solid fa-magnifying-glass" style="width: fit-content;"></i></button>
		</div>
	</article>
</section>

