package com.fin.project.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.project.board.model.dao.CommentDAO;
import com.fin.project.board.model.dto.Comment;
import com.fin.project.common.utility.Util;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentDAO dao;

	// 댓글 목록 조회
	@Override
	public List<Comment> select(int boardNo) {
		
		return dao.select(boardNo);
	}

	// 댓글 작성
	@Override
	public int insert(Comment comment) {
		
		comment.setCommentContent(Util.XSSHandling(comment.getCommentContent()));
		return dao.insert(comment);
	}

	// 댓글 수정
	@Override
	public int update(Comment comment) {
		
		comment.setCommentContent(Util.XSSHandling(comment.getCommentContent()));
		System.out.println(comment);
		return dao.update(comment);
	}

	// 댓글 삭제
	@Override
	public int delete(int commentNo) {
		
		return dao.delete(commentNo);
	}
	

}
