package com.fin.project.intro.model.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.fin.project.board.model.dto.Board;
import com.fin.project.board.model.dto.BoardImage;
import com.fin.project.board.model.exception.FileUploadException;
import com.fin.project.common.ImageDeleteException;
import com.fin.project.common.utility.Util;
import com.fin.project.intro.model.dao.IntroDAO;
import com.fin.project.intro.model.dto.LibAnother;




@Service
public class IntroServiceImpl implements IntroService {
	
	@Autowired
	private IntroDAO dao;

	// 카테고리 목록을 가져오는 서비스
	@Override
	public List<Map<String, Object>> selectCategoryList() {
		return dao.selectCategoryList();
	}

	// 주변 도서관 도서관 명 얻어오는 서비스
	@Override
	public Map<String, Object> selectAnotherLib(int catLevel3) {
		
		List<Map<String,Object>> libTitle = dao.getAnLibTitle(catLevel3);
		
		if(libTitle.isEmpty()) {
			return null;
		}
		
		Map<String, Object> another = new HashMap<String, Object>();
		another.put("libTitle", libTitle);
		
		return another;
	}

	// 주변 도서관 삽입 서비스
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertAnLib(Board board, List<MultipartFile> images, LibAnother lib, String webPath, String filePath) throws Exception  {
		
		board.setBoardTitle( Util.XSSHandling(board.getBoardTitle()));
		board.setBoardContent( Util.XSSHandling(board.getBoardContent()));
		
		int boardNo = dao.anLibInsert(board);
		
		if(boardNo > 0) {
			List<BoardImage> uploadList = new ArrayList<>();
			
			for(int i = 0; i < images.size(); i++) {
				
				if(images.get(i).getSize() > 0) {
					
					BoardImage img = new BoardImage();
					
					img.setBoardNo(boardNo);
					img.setImageOrder(i);
					img.setImagePath(webPath);
					
					String fileName = images.get(i).getOriginalFilename();
					img.setImageOriginal(fileName);
					img.setImageReName( Util.fileRename(fileName));
					
					uploadList.add(img);
				}
			}
			
			if(!uploadList.isEmpty()) {
				
				int result = dao.insertImageList(uploadList);
				
				if(result == uploadList.size()) {
					for(int i = 0; i < uploadList.size(); i++) {
						
						String rename = uploadList.get(i).getImageReName();
						
						int index = uploadList.get(i).getImageOrder();
						
						images.get(index).transferTo( new File(filePath + rename));
					}
					
					// 이미지가 성공적으로 넣어지면 도서관 주소, 경도, 위도 삽입
					lib.setBoardNo(boardNo);
					
					result = dao.insertLibAn(lib);
					
					if(result == 0) {
						throw new FileUploadException();
					}
				}else {
					throw new FileUploadException();
				}
			}
			
			
		}
		
		return boardNo;
	}

	// 주변 도서관 상세 정보 서비스
	@Override
	public Map<String, Object> selectLibAn(int catLevel3, int boardNo) {
		
		List<Map<String,Object>> libTitle = dao.getAnLibTitle(catLevel3);
		
		if(libTitle.isEmpty()) {
			return null;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("catLevel3", catLevel3);
		map.put("boardNo", boardNo);
		
		Board board = dao.getAnLibBoard(map);
		
		LibAnother libAdd = dao.getAnAdd(map);
		
		Map<String, Object> libAn = new HashMap<String, Object>();
		libAn.put("libTitle", libTitle);
		libAn.put("board", board);
		libAn.put("libAdd", libAdd);
		
		return libAn;
	}

	// 주변 도서관 수정(update) 서비스
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int libAnUpdate(Board board, String webPath, String filePath, LibAnother lib, String deleteList,
			List<MultipartFile> images) throws IllegalStateException, IOException {
		
		board.setBoardContent( Util.XSSHandling(board.getBoardContent()));
		board.setBoardTitle( Util.XSSHandling( board.getBoardTitle()));
		
		int rowCount = dao.boardUpdate(board);
		
		if(rowCount > 0) {
			
			if(!deleteList.equals("")) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("boardNo", board.getBoardNo());
				map.put("deleteList", deleteList);
				
				rowCount = dao.deleteImageList(map);
				
				if(rowCount == 0) {
					throw new ImageDeleteException();
				}
				
			}
			
			List<BoardImage> update = new ArrayList<BoardImage>();
			
			for(int i =0; i < images.size(); i++) {
				
				if(images.get(i).getSize() > 0) {
					BoardImage b = new BoardImage();
					b.setImagePath(webPath);
					b.setBoardNo(board.getBoardNo());
					b.setImageOrder(i);
					
					b.setImageOriginal(images.get(i).getOriginalFilename());
					b.setImageReName( Util.fileRename(images.get(i).getOriginalFilename()));
					
					update.add(b);
					
					rowCount = dao.imageUpdate(b);
					
					if(rowCount == 0) {
						rowCount = dao.insertImage(b);
					}
				}
			}
			
			if(!update.isEmpty()) {
				for(int i = 0; i < update.size(); i++) {
					
					String rename = update.get(i).getImageReName();
					int index = update.get(i).getImageOrder();
					
					images.get(index).transferTo( new File( filePath+ rename));
				}
			}
			
			rowCount = dao.updateLibAdd(lib);
			
			if(rowCount == 0) {
				throw new FileUploadException();
			}
		}else {
			throw new FileUploadException();
		}
		
		return rowCount;
	}

	// 주변 도서관 삭제 서비스
	@Override
	public int deleteLibAn(int boardNo) {
		return dao.deleteLibAn(boardNo);
	}

	// 주변 도서관 이미지 가져오기 서비스
	@Override
	public List<BoardImage> getImageList(int boardNo) {
		return dao.getImageList(boardNo);
	}
}
