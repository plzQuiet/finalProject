package com.fin.project.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.project.board.model.dao.CommentDAO;
import com.fin.project.board.model.dto.Board;
import com.fin.project.board.model.dto.Comment;
import com.fin.project.board.model.dto.Pagination;
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
	
	// 전체 댓글 목록 조회
	@Override
	public Map<String, Object> selectCommentList(int cp) {
		
		int listCount = dao.getListCount();
		
		Pagination pagination = new Pagination(cp, listCount);
		
		List<Comment> commentList = dao.select(-1);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("commentList", commentList);
		
		return map;
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
		return dao.update(comment);
	}

	// 댓글 삭제
	@Override
	public int delete(int commentNo) {
		
		return dao.delete(commentNo);
	}

}
