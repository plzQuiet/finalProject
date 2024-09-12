package com.fin.project.scheduling.model.service;

import java.util.Map;

import com.fin.project.scheduling.model.dto.ClassSchedule;

public interface ClassService {

	/**클래스 게시판 게시글 목록 조회
	 * @param cateCode
	 * @param cp
	 * @return map
	 */
	Map<String, Object> selectClassBoard(int cateCode, int cp);

	/**클래스 게시판 게시글 목록 조회 - 검색
	 * @param paramMap
	 * @param cp
	 * @return map
	 */
	Map<String, Object> selectClassBoard(Map<String, Object> paramMap, int cp);

	/** 클래스 상세 조회
	 * @param map
	 * @return
	 */
	ClassSchedule selectClass(Map<String, Object> map);

}
