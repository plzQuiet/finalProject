package com.fin.project.scheduling.model.service;

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

import com.fin.project.board.model.exception.FileUploadException;
import com.fin.project.common.ImageDeleteException;
import com.fin.project.common.utility.Util;
import com.fin.project.scheduling.model.dao.ClassDAO;
import com.fin.project.scheduling.model.dto.BoardImage;
import com.fin.project.scheduling.model.dto.ClassSchedule;
import com.fin.project.scheduling.model.dto.Pagination;




@Service
public class ClassServiceImpl implements ClassService{
	
	@Autowired
	private ClassDAO dao;

	// 클래스 게시판 게시글 목록 조회
	@Override
	public Map<String, Object> selectClassBoard(int cateCode, int cp) {
		
		int listCount = dao.getListCount(cateCode);
		
		// Pagination 객체 생성
		// 위에서 얻은 listCount와 cp이용
		Pagination pagination = new Pagination(cp, listCount);
		
		// cateCode==12, pagination.currentPage 의 게시물 목록 조회
		List<ClassSchedule> classBoardList = dao.selectClassBoard(cateCode, pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("classBoardList", classBoardList);
		
		return map;
	}
	// 검색 + 게시판 목록 조회
	@Override
	public Map<String, Object> selectClassBoard(Map<String, Object> paramMap, int cp) {
		
		int listCount = dao.getListCount(paramMap);
		
		Pagination pagination = new Pagination(cp, listCount);
		
		//특정 게시판에서 현재 페이지에 해당하는 부분에 대한 게시글 목록 조회 + 검색
		List<ClassSchedule> classBoardList = dao.selectClassBoard(paramMap, pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("classBoardList", classBoardList);
		return map;
	}
	
	// 클래스 상세 페이지
	@Override
	public ClassSchedule selectClass(Map<String, Object> map) {
		
		ClassSchedule classSchedule = dao.selectClass(map);
		
		// 조회 시 <br> 태그를 줄바꿈으로 변환하여 보여줌
	    classSchedule.setBoardContent(Util.reverseNewLineHandling(classSchedule.getBoardContent()));
		
		
		return classSchedule;
	}
	
	// 클레스 작성
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int classInsert(ClassSchedule classSchedule,List<MultipartFile> images, String webPath, String filePath) throws IllegalStateException, IOException {
		
		// XSS방지
		classSchedule.setBoardTitle(Util.XSSHandling(classSchedule.getBoardTitle()));
		classSchedule.setBoardContent(Util.XSSHandling(classSchedule.getBoardContent()));
		
		// 줄바꿈을 <br>로 변환
		classSchedule.setBoardTitle(Util.newLineHandling(classSchedule.getBoardTitle()));
		classSchedule.setBoardContent(Util.newLineHandling(classSchedule.getBoardContent()));
		
		
		
		int boardNo = dao.classInsert(classSchedule);
		
		// 삽입 후 BOARD_NO를 classSchedule에 설정
	    classSchedule.setBoardNo(boardNo);
	    
	    // CLASS_SCHEDULE 테이블에 삽입
	    int result = dao.insertClassSchedule(classSchedule);
		
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

				result = dao.insertClassImageList(uploadList);

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
	
	// 클래스 수정
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int classUpdate(ClassSchedule classSchedule, List<MultipartFile> images, String webPath, String filePath,
			String deleteList) throws IllegalStateException, IOException {
		
		classSchedule.setBoardTitle(Util.XSSHandling(classSchedule.getBoardTitle()));
		classSchedule.setBoardContent(Util.XSSHandling(classSchedule.getBoardContent()));
		
		// 줄바꿈을 <br>로 변환
		classSchedule.setBoardTitle(Util.newLineHandling(classSchedule.getBoardTitle()));
		classSchedule.setBoardContent(Util.newLineHandling(classSchedule.getBoardContent()));
		
		
		int result = dao.classUpdate(classSchedule);
				
		
		result = dao.updateClassSchedule(classSchedule);
		
		
	    if(result > 0) {
	        
	        if(!deleteList.equals("")) {
	            
	            Map<String, Object> deleteMap =  new HashMap<>();
	            deleteMap.put("boardNo", classSchedule.getBoardNo());
	            deleteMap.put("deleteList", deleteList);
	            
	            result = dao.imageDelete(deleteMap);
	            
	            if(result == 0) {
	                
	                throw new ImageDeleteException();
	            }
	            
	        }

	        if (images != null && !images.isEmpty()) {
	            List<BoardImage> uploadList = new ArrayList<>();

	            for(int i = 0; i < images.size(); i++) {
	                
	                if(images.get(i).getSize() > 0) {  
	                    
	                    BoardImage img = new BoardImage();
	                    img.setImagePath(webPath);
	                    img.setImageOrder(i);
	                    img.setBoardNo(classSchedule.getBoardNo());
	                    
	                    String fileName = images.get(i).getOriginalFilename();
	                    
	                    img.setImageOriginal(fileName);
	                    img.setImageReName(Util.fileRename(fileName));
	                    
	                    uploadList.add(img);
	                    
	                    result = dao.updateClassImage(img);
	                    
	                    if(result == 0) {
	                    	result = dao.insertClassImage(img);
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

	    return result;
	}
	
	
	// 클래스 삭제
	@Override
	@Transactional(rollbackFor=Exception.class)
	public int classDelete(Map<String, Object> map) {
		return dao.classDelete(map);
	}
	
	// 클래스 신청
	@Override
	public int applyClass(Map<String, Object> map) {
		
		// 클래스 신청 중복 체크
		boolean result = dao.checkApplyClass(map);
		if(result) {
			
			return 0;
		}
		
		return dao.applyClass(map);
	}
	
	
	
	

}
