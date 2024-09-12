package com.fin.project.board.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.fin.project.board.model.dto.Board;

public interface BoardService2 {

	/** 게시글 작성
	 * @param board
	 * @param images
	 * @param webPath
	 * @param filePath
	 * @return 
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	int boardInsert(Board board, List<MultipartFile> images, String webPath, String filePath) throws IllegalStateException, IOException;

	/** 게시글 수정
	 * @param board
	 * @param images
	 * @param webPath
	 * @param filePath
	 * @param deleteList
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	int boardUpdate(Board board, List<MultipartFile> images, String webPath, String filePath, String deleteList) throws IllegalStateException, IOException;

	/** 게시글 삭제
	 * @param map
	 * @return
	 */
	int boardDelete(Map<String, Object> map);


}
