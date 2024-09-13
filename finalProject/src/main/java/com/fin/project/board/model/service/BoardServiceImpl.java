package com.fin.project.board.model.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fin.project.board.model.dao.BoardDAO;
import com.fin.project.board.model.dto.Board;
import com.fin.project.board.model.dto.Pagination;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO dao;

	// 게시글 목록 조회
	@Override
	public Map<String, Object> selectBoardList(int cateCode, int cp, String query, String keyword) {
		
		Map<String, Object> search = new HashMap<>();
		search.put("query", query);
		search.put("keyword", keyword);
		search.put("cateCode", cateCode);
		
		
		int listCount = dao. searchListCount(search);
		
		Pagination pagination = new Pagination(cp, listCount); 
		
		List<Board> boardList = dao.searchBoardList(search, pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		return map;
	}

	// 게시글 상세 조회
	@Override
	public Board selectBoard(Map<String, Object> map) {
		
		// 게시글, 이미지, 댓글
		return dao.selectBoard(map);
	}

	// 조회수 증가
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int increaseReadCount(int boardNo) {
		
		return dao.increaseReadCount(boardNo);
	}
	
	// 게시글 목록 조회(검색)
	@Override
	public Map<String, Object> selectBoardList(Map<String, Object> paramMap, int cp) {
		
		int listCount = dao.getListCount(paramMap);
		
		Pagination pagination = new Pagination(cp, listCount);
		
		List<Board> boardList = dao.selectBoardList(paramMap, pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		return map;
	}


}
