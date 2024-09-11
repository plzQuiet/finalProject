package com.fin.project.scheduling.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.project.scheduling.model.dao.ClassDAO;
import com.fin.project.scheduling.model.dto.Board;
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
		List<Board> classBoardList = dao.selectClassBoard(cateCode, pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("classBoardList", classBoardList);
		
		return map;
	}

}
