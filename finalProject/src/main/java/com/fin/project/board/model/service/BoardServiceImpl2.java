package com.fin.project.board.model.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.fin.project.board.model.dao.BoardDAO2;
import com.fin.project.board.model.dto.Board;
import com.fin.project.board.model.dto.BoardImage;
import com.fin.project.board.model.exception.FileUploadException;
import com.fin.project.common.ImageDeleteException;
import com.fin.project.common.utility.Util;

@Service
public class BoardServiceImpl2 implements BoardService2 {

	@Autowired
	private BoardDAO2 dao;

	// 게시글 작성(DML) 
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int boardInsert(Board board, List<MultipartFile> images, String webPath, String filePath) throws IllegalStateException, IOException {

		board.setBoardTitle(Util.XSSHandling(board.getBoardTitle()));
		board.setBoardContent(Util.XSSHandling(board.getBoardContent()));

		int boardNo = dao.boardInsert(board);

		if(boardNo > 0 && images != null) {

			List<BoardImage> uploadList = new ArrayList<BoardImage>();

			for(int i=0; i<images.size(); i++) {

				if(images.get(i).getSize() > 0) {

					BoardImage img = new BoardImage();

					img.setBoardNo(boardNo);
					img.setImagePath(webPath);
					img.setImageOrder(i);

					String fileName = images.get(i).getOriginalFilename();
					img.setImageOriginal(fileName);
					img.setImageReName(Util.fileRename(fileName));

					uploadList.add(img);

				}
			}

			if(!uploadList.isEmpty()) {

				int result = dao.insertImageList(uploadList);

				if(result == uploadList.size()) {

					for(int i=0; i<uploadList.size(); i++) {

						String rename = uploadList.get(i).getImageReName();

						int index = uploadList.get(i).getImageOrder();

						images.get(index).transferTo(new File(filePath + rename));
					}
				}else {

					throw new FileUploadException();
				}
			}
		}

		return boardNo;
	}

	// 게시글 수정
//	@Transactional(rollbackFor = Exception.class)
//	@Override
//	public int boardUpdate(Board board, List<MultipartFile> images, String webPath, String filePath, 
//							String deleteList) throws IllegalStateException, IOException {
//
//		board.setBoardTitle(Util.XSSHandling(board.getBoardTitle()));
//		board.setBoardContent(Util.XSSHandling(board.getBoardContent()));
//		
//		int rowCount = dao.boardUpdate(board);
//		
//		if(rowCount > 0) {
//			
//			if(!deleteList.equals("")) {
//				
//				Map<String, Object> deleteMap =  new HashMap<>();
//				deleteMap.put("boardNo", board.getBoardNo());
//				deleteMap.put("deleteList", deleteList);
//				
//				rowCount = dao.imageDelete(deleteMap);
//				
//				if(rowCount == 0) {
//					
//					throw new ImageDeleteException();
//				}
//				
//			}
//			
//			List<BoardImage> uploadList = new ArrayList<>();
//		
//			for(int i=0; i<images.size(); i++) {
//				
//				if(images.get(i).getSize() > 0) {
//					
//					BoardImage img = new BoardImage();
//					img.setImagePath(webPath);
//					img.setImageOrder(i);
//					img.setBoardNo(board.getBoardNo());
//					
//					String fileName = images.get(i).getOriginalFilename();
//					
//					img.setImageOriginal(fileName);
//					img.setImageReName(Util.fileRename(fileName));
//					
//					uploadList.add(img);
//					
//					rowCount = dao.imageUpdate(img);
//					
//					if(rowCount == 0) {
//						rowCount = dao.imageInsert(img);
//					}
//				}
//			}
//			
//			if(!uploadList.isEmpty()) {
//				
//				for(int i=0; i < uploadList.size(); i++) {
//					
//					int index = uploadList.get(i).getImageOrder();
//					
//					String rename = uploadList.get(i).getImageReName();
//					
//					images.get(index).transferTo(new File(filePath + rename));
//							
//				}
//			}
//		}
//
//		return rowCount;
//	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int boardUpdate(Board board, List<MultipartFile> images, String webPath, String filePath, 
	                        String deleteList) throws IllegalStateException, IOException {

	    board.setBoardTitle(Util.XSSHandling(board.getBoardTitle()));
	    board.setBoardContent(Util.XSSHandling(board.getBoardContent()));
	    
	    int rowCount = dao.boardUpdate(board);
	    
	    if(rowCount > 0) {
	        
	        if(!deleteList.equals("")) {
	            
	            Map<String, Object> deleteMap =  new HashMap<>();
	            deleteMap.put("boardNo", board.getBoardNo());
	            deleteMap.put("deleteList", deleteList);
	            
	            rowCount = dao.imageDelete(deleteMap);
	            
	            if(rowCount == 0) {
	                
	                throw new ImageDeleteException();
	            }
	            
	        }

	        // 이미지가 없거나 모든 이미지의 크기가 0인 경우 처리
	        if (images != null && !images.isEmpty()) {
	            List<BoardImage> uploadList = new ArrayList<>();

	            for(int i = 0; i < images.size(); i++) {
	                
	                if(images.get(i).getSize() > 0) {  // 파일 크기가 0보다 큰 경우만 처리
	                    
	                    BoardImage img = new BoardImage();
	                    img.setImagePath(webPath);
	                    img.setImageOrder(i);
	                    img.setBoardNo(board.getBoardNo());
	                    
	                    String fileName = images.get(i).getOriginalFilename();
	                    
	                    img.setImageOriginal(fileName);
	                    img.setImageReName(Util.fileRename(fileName));
	                    
	                    uploadList.add(img);
	                    
	                    rowCount = dao.imageUpdate(img);
	                    
	                    if(rowCount == 0) {
	                        rowCount = dao.imageInsert(img);
	                    }
	                }
	            }
	            
	            if(!uploadList.isEmpty()) {
	                
	                for(int i = 0; i < uploadList.size(); i++) {
	                    
	                    int index = uploadList.get(i).getImageOrder();
	                    
	                    String rename = uploadList.get(i).getImageReName();
	                    
	                    images.get(index).transferTo(new File(filePath + rename));
	                            
	                }
	            }
	        }
	    }

	    return rowCount;
	}

	// 게시글 삭제
	@Override
	public int boardDelete(Map<String, Object> map) {
		
		return dao.boardDelete(map);
	}
	




}
