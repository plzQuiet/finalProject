package com.fin.project.scheduling.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.fin.project.board.model.exception.FileUploadException;
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
		Pagination pagination = new Pagination(listCount, cp);
		
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
		
		return dao.selectClass(map);
	}
	
	// 클레스 작성
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int classInsert(ClassSchedule classSchedule, MultipartFile image, String webPath, String filePath) throws IllegalStateException, IOException {
		
		// XSS방지
		classSchedule.setBoardTitle(Util.XSSHandling(classSchedule.getBoardTitle()));
		classSchedule.setBoardContent(Util.XSSHandling(classSchedule.getBoardContent()));
		
		int boardNo = dao.classInsert(classSchedule);
		
		// 삽입 후 BOARD_NO를 classSchedule에 설정
	    classSchedule.setBoardNo(boardNo);
	    
	    // CLASS_SCHEDULE 테이블에 삽입
	    int result = dao.insertClassSchedule(classSchedule);
		
		if (boardNo > 0) { // 게시글 삽입 성공
	        
	        if (image != null && !image.isEmpty()) {
	            BoardImage classImage = new BoardImage();
	            classImage.setImagePath(webPath); // 웹 접근 경로
	            classImage.setBoardNo(boardNo); // 게시글 번호
	            classImage.setImageOrder(0); // 단일 이미지의 경우 순서 0
	            
	            // 파일 원본명 (by MultipartFile)
	            String fileName = image.getOriginalFilename();
	            classImage.setImageOriginal(fileName); // 원본명
	            classImage.setImageReName(Util.fileRename(fileName)); // 변경명
	            
	            // BOARD_IMG 테이블에 INSERT 하는 DAO 호출
	            result = dao.insertClassImage(classImage);
	            
	            if (result == 1) { // 삽입 성공
	                // 서버에 파일 저장 (transferTo())
	                File file = new File(filePath + classImage.getImageReName());
	                image.transferTo(file);
	            } else { // 삽입 실패
	                // 삽입 실패 시 예외를 강제로 발생시켜 롤백
	                throw new FileUploadException(); // 사용자 정의 예외 발생
	            }
	        }
	    }
	    
	    return boardNo;
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
