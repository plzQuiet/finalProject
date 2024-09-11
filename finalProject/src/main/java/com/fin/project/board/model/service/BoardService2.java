package com.fin.project.board.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fin.project.board.model.dto.Board;

public interface BoardService2 {

	/** 게시글 삽입
	 * @param board
	 * @param images
	 * @param webPath
	 * @param filePath
	 * @return 
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	int boardInsert(Board board, List<MultipartFile> images, String webPath, String filePath) throws IllegalStateException, IOException;

}
