package com.fin.project.board.model.service;

import java.util.Map;

public interface BoardService {

	/** 게시글 목록 조회(공지사항/문의사항/책후기나눠요)
	 * @param cateCode
	 * @param cp
	 * @return map
	 */
	Map<String, Object> selectBoardList(int cateCode, int cp);
	

	/** 게시글 목록 조회(검색)
	 * @param paramMap
	 * @param cp
	 * @return boardList
	 */
	Map<String, Object> selectBoardList(Map<String, Object> paramMap, int cp);



}
