package com.fin.project.scheduling.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.project.scheduling.model.dao.ClassDAO;
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

}
