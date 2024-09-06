<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 댓글 작성된 영역 -->
<div id="commentArea">
	<div class="comment-list-area">

		<div class="comment-detail">
			<div>
				<p class="comment-info">
					<!-- 이름 -->
					<span class="comment-writer">김길동</span>

					<!-- 작성일 -->
					<!-- 수정하면 수정일 == 작성일 -->
					<span class="comment-date">2024-09-25</span>
				</p>

				<!-- 댓글 내용 -->
				<p class="comment-content">저랑 취향이 같네용</p>
			</div>
			<!-- 버튼 영역 -->
			<!-- 로그인 후 댓글 작성자만 작성 가능 -->
			<div class="comment-btn-area">
				<!-- js 필요 -->
				<button>수정</button>
				<button>삭제</button>
			</div>
		</div>
	</div>

	<!-- 댓글 작성하는 영역 -->
	<!-- 관리자만 보이는 영역 -->
	<div class="comment-write-area">
		<textarea id="commentContent"></textarea>
		<button id="commentAdd">등록</button>
	</div>
</div>