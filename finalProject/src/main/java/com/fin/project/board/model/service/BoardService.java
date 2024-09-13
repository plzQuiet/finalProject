package com.fin.project.board.model.service;

import java.util.List;
import java.util.Map;

import com.fin.project.board.model.dto.Board;

public interface BoardService {

	/** 게시글 목록 조회(공지사항/문의사항/책후기나눠요)
	 * @param cateCode
	 * @param cp
	 * @param keyword 
	 * @param query 
	 * @return map
	 */
	Map<String, Object> selectBoardList(int cateCode, int cp, String query, String keyword);
	
	/** 게시글 상세 조회
	 * @param map
	 * @return board
	 */
	Board selectBoard(Map<String, Object> map);

	/** 조회수 증가
	 * @param boardNo
	 * @return
	 */
	int increaseReadCount(int boardNo);

	/** 게시글 목록 조회(검색)
	 * @param paramMap
	 * @param cp
	 * @return boardList
	 */
	Map<String, Object> selectBoardList(Map<String, Object> paramMap, int cp);








}
