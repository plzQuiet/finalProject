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
    <link rel="stylesheet" href="/resources/css/myLibrary/info-style.css">
</head>
<body>
	<main>
		<jsp:include page="/WEB-INF/views/common/header.jsp"/>
		
		<section class="container">
			<jsp:include page="/WEB-INF/views/common/sideMenu.jsp"/>
			
			<section class="myInfo">

                <h1 class="myInfo-title">비밀번호 변경</h1>
                <span class="myInfo-subject">현재 비밀번호가 일치하는 경우 새 비밀번호로 변경할 수 있습니다.</span>

                <form action="changePw" method="POST" name="myInfoFrm" id="changePwFrm">

                    <div class="myInfo-row">
                        <label>현재 비밀번호</label>
                        <input type="password" name="currentPw" id="currentPw" maxlength="30" >              
                    </div>

                    <div class="myInfo-row">
                        <label>새 비밀번호</label>
                        <input type="password" name="newPw" id="newPw" maxlength="30">              
                    </div>

                    <div class="myInfo-row">
                        <label>새 비밀번호 확인</label>
                        <input type="password" name="newPwConfirm" id="newPwConfirm" maxlength="30">              
                    </div>

                    <button class="myInfo-submit">변경하기</button>

                </form>

            </section>
		</section>
		
	</main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>