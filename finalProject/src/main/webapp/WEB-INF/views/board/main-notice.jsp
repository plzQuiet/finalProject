<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>main-notice</title>
    <link rel="stylesheet" href="/resources/css/board/main-notice.css">
</head>
<body>

    <section class="main-notice-section">

        <div class="main-notice-area">

            <div class="notice-title">
                <span>공지사항</span>
                <div id="gotoNotice"><a href="/board/15">더보기 +</a></div>
            </div>

            <div class="notice-content">
                <li><a href="/board/15/${boardNo}?${cp}">게시글</a></li>
            </div>

        </div>

    </section>
    
</body>
</html>