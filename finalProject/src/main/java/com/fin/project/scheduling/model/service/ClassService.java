package com.fin.project.scheduling.model.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

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

	/** 클래스 작성(내용, 일정, 사진)
	 * @param classSchedule
	 * @param image
	 * @param webPath
	 * @param filePath
	 * @return
	 */
	int classInsert(ClassSchedule classSchedule, MultipartFile image, String webPath, String filePath) throws IllegalStateException, IOException;

	/** 클래스 삭제
	 * @param map
	 * @return
	 */
	int classDelete(Map<String, Object> map);

	/** 클래스 신청
	 * @param map
	 * @return
	 */
	int applyClass(Map<String, Object> map);

	
}
