package com.fin.project.board.model.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.fin.project.board.model.dao.BoardDAO2;
import com.fin.project.board.model.dto.Board;
import com.fin.project.board.model.dto.BoardImage;
import com.fin.project.board.model.exception.FileUploadException;
import com.fin.project.common.utility.Util;

@Service
public class BoardServiceImpl2 implements BoardService2 {
	
	@Autowired
	private BoardDAO2 dao;

	// 게시글 삽입(DML) - cateCode: 15,18
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int boardInsert(Board board, List<MultipartFile> images, String webPath, String filePath) throws IllegalStateException, IOException {
		
		board.setBoardTitle(Util.XSSHandling(board.getBoardTitle()));
		board.setBoardContent(Util.XSSHandling(board.getBoardContent()));
		
		int boardNo = dao.boardInsert(board);
		
		if(boardNo > 0) {
			
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

}
