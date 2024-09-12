<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<c:set var="pagination" value="${map.pagination}" />
<c:set var="boardList" value="${map.boardList}" />

<c:forEach items="${category}" var="catelist">
    <c:if test="${catelist.CAT_CODE == cateCode}">
        <c:set var="cateName" value="${catelist.CAT_NAME}"/>
    </c:if>
</c:forEach>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>이용자 마당</title>

    <link rel="stylesheet" href="/resources/css/main-style.css">
    <link rel="stylesheet" href="/resources/css/board/noticeDetail-style.css">
    <link rel="stylesheet" href="/resources/css/board/comment2.css">
</head>
<body>

   <!-- header -->
   <jsp:include page="/WEB-INF/views/common/header.jsp" />

    <section class="main-content-suround-section">
        <article class="side-menu-article">
             <!-- 사이드 메뉴 -->
            <div class="category">이용자 마당</div>
            <ul class="side-menu">
                <li><a href="/board/15">공지사항</a></li>
                <li class="side1"><a href="/board/16">문의사항</a></li>
                <li class="side2"><a href="/board/17">자주 묻는 질문</a></li>
                <li class="last-menu"><a href="/board/18">책 후기 나눠요</a></li>
            </ul>

        </article>

        <!-- 공지사항 목록 -->
        <section class="content-suround-section">
            <div class="content-title">${cateName}</div>
            <div class="title-line"></div>

            <!-- 게시글 상세 화면 -->
            <section class="board-detail">
                <!-- 제목 -->
                <h1 class="board-title">${board.boardTitle}</h1>

                <!-- 작성자 / 작성일 / 조회수 -->
                <div class="board-nav">
                    <div class="member-name">
                        <span>${board.memberName}</span>
                    </div>
    
                    <div class="board-info">
                        <!-- 최초 작성일 -->
                        <p><span>작성일</span>&nbsp;${board.boardCreateDate}</p>
                        <!-- 게시글 수정 시 마지작 수정일로 변경되어 반영됨 -->
                        <c:if test="${!empty board.boardUpdateDate}">
                            <p><xspan>마지막 수정일</xspan>&nbsp;2024-09-26</p>
                        </c:if>
    
                        <p><span>조회수</span>&nbsp;${board.readCount}</p>
                    </div>

                </div>

                <!-- 이미지 보여지는 영역 -->
                <!-- 썸네일 X -->
                <c:if test="${fn:length(board.imageList) > 0}">
                    <div class="img-box">

                        <c:forEach var="i" begin="0" end="${fn:length(board.imageList) - 1}">
                            <div class="boardImg">
                                <c:set var="path" value="${board.imageList[i].imagePath}${board.imageList[i].imageReName}" />
                                <img src="${path}"/>
                                <a href="${path}" download="${board.imageList[i].imageOriginal}">다운로드</a>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
                <!-- 게시글 내용 -->
                <div class="board-content">${board.boardContent}</div> 
                
                <!-- 버튼 영역 -->
                <div class="btn-area">
                    <c:if test="${loginMember.memberNo == board.memberNo}">
                        <button id="updateBtn"><a href="/board2/${cateCode}/${boardNo}/update?cp=${cp}">수정</a></button>
                        <button id="deleteBtn"><a href="/board2/${cateCode}/${boardNo}/delete?cp=${cp}">삭제</a></button>
                    </c:if>
                    <!-- 목록으로 -->
                    <button id="listBtn">목록으로</button>
                </div>

            </section>

            <!-- 게시글 작성 화면 -->
            <!-- notice / bookreview 공통 -->
            <%-- <form action="#" method="" class="board-write" id="boardWriteFrm" enctype="multipart/form-data">
                <!-- 제목 -->
                 <h1 class="board-title">
                    <input type="text" name="boardTitle" placeholder="제목">
                </h1>  --%>

                <!-- 이미지 등록 영역 -->
                <%-- <h5>이미지 등록</h5>
                <div class="img-box">
                    <div class="boardImg">
                        <label for="img0">
                            <img src="${img0}" class="preview">
                        </label>
                        <input type="file" name="images" class="inputImage" id="img0" accept="image/*">
                        <span class="delete-image">&times;</span>
                    </div>
    
                    <div class="boardImg">
                        <label for="img1">
                            <img src="${img1}" class="preview">
                        </label>
                        <input type="file" name="images" class="inputImage" id="img1" accept="image/*">
                        <span class="delete-image">&times;</span>
                    </div>
                </div> --%>

                
                <!-- 내용 -->
                <!-- <div class="board-content">
                    <textarea name="boardContent"></textarea>
                </div> -->

                <!-- 버튼 영역 -->
                <%-- <div class="btn-area">
                    <button>취소</button>
                    <button type="submit" id="writeBtn">등록</button>
                </div>

            </form>  --%>

            <!-- comment.jsp 연결 -->
            <c:if test="${cateCode == 16 || cateCode == 18}">
                <jsp:include page="/WEB-INF/views/board/comment2.jsp"/>
            </c:if>

        </section>
        
    </section>
    

    <!-- footer -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script>
        const cateCode = "${cateCode}";

        console.log(cateCode);

        const li = document.querySelectorAll(".side-menu > li");

        switch(cateCode){
            case "15" : li[0].classList.add("side-current"); break;
            case "16" : li[1].classList.add("side-current"); break;
            case "17" : li[2].classList.add("side-current"); break;
            case "18" : li[3].classList.add("side-current"); break;
        } 

    </script>
    
    <script>
        const boardNo = "${board.boardNo}";
        console.log(boardNo);
            
        // 로그인한 회원 번호 변수로 선언
        const loginMemberNo = "${loginMember.memberNo}";
        console.log(loginMemberNo);
            
        const cateCode = "${cateCode}";
    </script>
            

    <!-- comment.js 연결 -->
    <script src="/resources/js/board/comment.js"></script>

    <%-- boardDetail.js 연결 --%>
    <script src="/resources/js/board/boardDetail.js"></script>


    
</body>
</html>