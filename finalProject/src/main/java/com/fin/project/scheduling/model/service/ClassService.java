package com.fin.project.scheduling.model.service;

import java.util.Map;

public interface ClassService {

	/**클래스 게시판 게시글 목록 조회
	 * @param cateCode
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectClassBoard(int cateCode, int cp);

}
