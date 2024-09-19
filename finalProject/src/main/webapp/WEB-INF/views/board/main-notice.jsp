<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="boardList" value="${map.boardList}" />

    <section class="main-notice-section">

        <div class="main-notice-area">

            <div class="notice-title">
                <span>공지사항</span>
                <div id="gotoNotice"><a href="/board/15"><i class="fa-solid fa-plus"></i></a></div>
            </div>

             <div class="list-wrapper">
                    <table class="list-table">
                        <tbody>
                            <c:choose>
                                <c:when test="${empty boardList}">
                                    <tr>
                                        <th colspan="5">게시글이 존재하지 않습니다.</th>
                                    </tr>
                                </c:when>

                                <c:otherwise>
                                    <c:forEach var="board" items="${boardList}">
                                        <tr>
                                            <!-- 게시글] 조회 시 글 목록 존재 O -->
                                            <td>${board.boardNo}</td>
                                            <td>
                                                <a href="/board/15/${board.boardNo}">${board.boardTitle}</a>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${board.boardUpdateDate != null}">
                                                        ${board.boardUpdateDate}
                                                    </c:when>
                                                    <c:otherwise>
                                                        ${board.boardCreateDate}
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>

        </div>

    </section>
    
</body>
</html>