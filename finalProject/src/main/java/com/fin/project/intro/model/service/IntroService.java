package com.fin.project.intro.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.fin.project.board.model.dto.Board;
import com.fin.project.board.model.dto.BoardImage;
import com.fin.project.intro.model.dto.LibAnother;

public interface IntroService {
	
	/** 카테고리 리스트 얻어오는 Service
	 * @return category
	 */
	List<Map<String, Object>> selectCategoryList();

	/** 주변도서관 도서관명 얻어오는 Service
	 * @param catLevel2
	 * @return map
	 */
	Map<String, Object> selectAnotherLib(int catLevel3);

	/** 주변 도서관 insert Service
	 * @param board
	 * @param images
	 * @param lib
	 * @param webPath
	 * @param filePath
	 * @return result
	 */
	int insertAnLib(Board board, List<MultipartFile> images, LibAnother lib, String webPath, String filePath) throws Exception;

	/** 주변 도서관 상세 정보 Service
	 * @param catLevel3
	 * @param boardNo
	 * @return libAn
	 */
	Map<String, Object> selectLibAn(int catLevel3, int boardNo);

	/** 주변 도서관 수정 Service
	 * @param board
	 * @param webPath
	 * @param filePath
	 * @param lib
	 * @param deleteList
	 * @param images
	 * @return rowCount
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	int libAnUpdate(Board board, String webPath, String filePath, LibAnother lib, String deleteList,
			List<MultipartFile> images) throws IllegalStateException, IOException;

	/** 주변 도서관 삭제 Service
	 * @param boardNo
	 * @return result
	 */
	int deleteLibAn(int boardNo);

	/** 주변 도서관 imageList 가져오기 Service
	 * @param boardNo
	 * @return imageList
	 */
	List<BoardImage> getImageList(int boardNo);

}
