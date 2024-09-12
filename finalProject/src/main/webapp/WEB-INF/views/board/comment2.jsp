<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="commentArea">
        <div class="comment-list-area">
            <ul id="commentList">
                <c:forEach items="${board.commentList}" var="comment">
                    <li class="comment-row">
                        <p class="comment-writer">
                            <span>${comment.memberName}</span>
                            <span class="comment-date">${comment.commentCreateDate}</span>
                        </p>

                        <p class="comment-content">${comment.commentContent}</p>
                        <div class="comment-btn-area">
                            <c:if test="${loginMember.memberNo == comment.memberNo}">
                                <button onclick="showUpdateComment(${comment.commentNo}, this)">수정</button>
                                <button onclick="deleteComment(${comment.commentNo})">삭제</button>
                            </c:if>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <div class="comment-write-area">
            <textarea id="commentContent"></textarea>
            <button id="addComment">
                등록
            </button>
        </div>
    </div>