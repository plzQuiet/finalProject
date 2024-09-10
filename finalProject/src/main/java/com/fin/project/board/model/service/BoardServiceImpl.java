package com.fin.project.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.project.board.model.dao.BoardDAO;
import com.fin.project.board.model.dto.Board;
import com.fin.project.board.model.dto.Pagination;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO dao;

	// 게시글 목록 조회
	@Override
	public Map<String, Object> selectBoardList(int cateCode, int cp) {
		
		// 특정 게시판의 삭제되지 않은 게시글 수 조회
		int listCount = dao.getListCount(cateCode);
		
		Pagination pagination = new Pagination(cp, listCount); 
		
		List<Board> boardList = dao.selectBoardList(cateCode, pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		return map;
	}

	// 게시글 목록 조회(검색)
	@Override
	public Map<String, Object> selectBoardList(Map<String, Object> paramMap, int cp) {
		return null ;
	}

}
