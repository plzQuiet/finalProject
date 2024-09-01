<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/resources/css/menu/menu.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
	<section class="main">
		<jsp:include page="/WEB-INF/views/common/sideMenu.jsp"></jsp:include>
		
		 <section class="main-content">
            <div class="content-title">구내식당</div>
            <div class="title-line"></div>

            <section class="content-detail-section">
                내용
            </section>
        </section>
		
	</section>	
	
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>