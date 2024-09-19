<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 댓글 작성된 영역 -->
<div id="commentArea">
	<div class="comment-list-area">

		<div class="comment-detail">
			<c:forEach items="${board.commentList}" var="comment">
				<div>
					<p class="comment-info">
						<!-- 이름 -->
						<span class="comment-writer">${comment.memberName}</span>
	
						<!-- 작성일 -->
						<!-- 수정하면 수정일 == 작성일 -->
						<span class="comment-date">${comment.commentCreateDate}</span>
					</p>
	
					<!-- 댓글 내용 -->
					<p class="comment-content">${comment.commentContent}</p>
				</div>
				<!-- 버튼 영역 -->
				<!-- 로그인 후 댓글 작성자만 작성 가능 -->
				<div class="comment-btn-area">
					<!-- js 필요 -->
					<c:if test="${loginMember.memberNo == comment.memberNo}">
						<button onclick="showUpdateComment(${comment.commentNo}, this)">수정</button>     
						<button onclick="deleteComment(${comment.commentNo})">삭제</button>
					</c:if>
				</div>
			</c:forEach>
		</div>
	</div>

	<!-- 댓글 작성하는 영역 -->
	<c:choose>
		<%-- 문의사항 : 관리자만 보임 --%>
		<c:when test="${cateCode == 16}">
			<c:if test="${loginMember.authority == 2}">
				<div class="comment-write-area">
					<textarea id="commentContent"></textarea>
					<button id="commentAdd">등록</button>
				</div>
			</c:if>
		</c:when>
		<c:otherwise>
			<div class="comment-write-area">
				<textarea id="commentContent"></textarea>
				<button id="commentAdd">등록</button>
			</div>
		</c:otherwise>
	</c:choose>


</div>