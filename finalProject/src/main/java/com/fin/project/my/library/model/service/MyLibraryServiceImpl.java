package com.fin.project.my.library.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.project.board.model.dto.Pagination;
import com.fin.project.my.library.model.dao.MyLibraryDAO;

@Service
public class MyLibraryServiceImpl implements MyLibraryService {
	
	@Autowired
	private MyLibraryDAO dao;

	@Override
	public List<Map<String, Object>> booksLoan(int memberNo) {
		return dao.booksLoan(memberNo);
	}

	@Override
	public Map<String, Object> loanHistory(int memberNo, int cp) {
		
		int listCount = dao.getLoanHistory(memberNo);
		
		Pagination pagination = new Pagination(cp, listCount);
		List<Map<String, Object>> list = dao.loanHistory(memberNo, pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("list", list);
		
		return map;
	}

	@Override
	public Map<String, Object> reservationBook(int memberNo, int cp) {
		
		int listCount = dao.getReservationBook(memberNo);
		
		Pagination pagination = new Pagination(cp, listCount);
		List<Map<String, Object>> list = dao.reservationBook(memberNo, pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("list", list);
		
		return map;
	}

	@Override
	public Map<String, Object> bookRequestHistory(int memberNo, int cp) {
		
		int listCount = dao.getBookRequestHistory(memberNo);
		
		Pagination pagination = new Pagination(cp, listCount);
		List<Map<String, Object>> list = dao.bookRequestHistory(memberNo, pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("list", list);
		
		return map;
	}

	@Override
	public Map<String, Object> readingRoomReserv(int memberNo, int cp) {
		
		int listCount = dao.getReadingRoomReserv(memberNo);
		
		Pagination pagination = new Pagination(cp, listCount);
		List<Map<String, Object>> list = dao.readingRoomReserv(memberNo, pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("list", list);
		
		return map;
	}

	@Override
	public Map<String, Object> seminarReserv(int memberNo, int cp) {
		
		int listCount = dao.getSeminarReserv(memberNo);
		
		Pagination pagination = new Pagination(cp, listCount);
		List<Map<String, Object>> list = dao.seminarReserv(memberNo, pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("list", list);
		
		return map;
	}

	@Override
	public Map<String, Object> classRegist(int memberNo, int cp) {
		
		int listCount = dao.getClassRegist(memberNo);
		
		Pagination pagination = new Pagination(cp, listCount);
		List<Map<String, Object>> list = dao.classRegist(memberNo, pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("list", list);
		
		return map;
	}

	@Override
	public Map<String, Object> bookmark(int memberNo, int cp) {
		
		int listCount = dao.getBookmark(memberNo);
		
		Pagination pagination = new Pagination(cp, listCount);
		List<Map<String, Object>> list = dao.bookmark(memberNo, pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("list", list);
		
		return map;
	}

}
