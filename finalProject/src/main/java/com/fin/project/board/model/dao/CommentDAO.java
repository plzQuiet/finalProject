package com.fin.project.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.board.model.dto.Comment;

@Repository
public class CommentDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 댓글 목록 조회 dao
	 * @param boardNo
	 * @return
	 */
	public List<Comment> select(int boardNo) {
		
		return sqlSession.selectList("boardMapper.selectCommentList", boardNo);
	}

	/** 댓글 작성 dao
	 * @param comment
	 * @return
	 */
	public int insert(Comment comment) {
		
		return sqlSession.insert("boardMapper.insert", comment);
	}

	/** 댓글 수정 dao
	 * @param comment
	 * @return
	 */
	public int update(Comment comment) {
		
		return sqlSession.update("boardMappper.update", comment);
	}

	/** 댓글 삭제 dao
	 * @param commentNo
	 * @return
	 */
	public int update(int commentNo) {
		
		return sqlSession.update("boardMapper.update", commentNo);
	}

}
