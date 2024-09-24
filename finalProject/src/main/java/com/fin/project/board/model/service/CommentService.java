package com.fin.project.board.model.service;

import java.util.List;
import java.util.Map;

import com.fin.project.board.model.dto.Comment;

public interface CommentService {
	
	/** 댓글 목록 조회
	 * @param boardNo
	 * @return
	 */
	List<Comment> select(int boardNo);
	
	/** 전체 댓글 목록 조회
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectCommentList(int cp);

 	/** 댓글 작성
	 * @param comment
	 * @return
	 */
	int insert(Comment comment);

	/** 댓글 수정
	 * @param comment
	 * @return
	 */
	int update(Comment comment);

	/** 댓글 삭제
	 * @param commentNo
	 * @return
	 */
	int delete(int commentNo);
	
}
