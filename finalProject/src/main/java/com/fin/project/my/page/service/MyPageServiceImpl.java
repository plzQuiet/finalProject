package com.fin.project.my.page.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fin.project.board.model.dto.Pagination;
import com.fin.project.member.model.dto.Member;
import com.fin.project.my.page.dao.MyPageDAO;

@Service
public class MyPageServiceImpl implements MyPageService{

	@Autowired
	private MyPageDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int update(Member inputMember) {
		return dao.update(inputMember);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int changePw(String currentPw, String newPw, int memberNo) {
		
		String encPw = dao.selectEncPw(memberNo);
		
		if(bcrypt.matches(currentPw, encPw)) {
			return dao.changePw(bcrypt.encode(newPw), memberNo);
		}
		
		return 0;
	}

	@Override
	public Map<String, Object> boardMap(int memberNo, int cp) {
		
		int listCount = dao.getBoardCount(memberNo);
		
		Pagination pagination = new Pagination(cp, listCount);
		
		List<Map<String, Object>> list = dao.selectBoardList(memberNo, pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("list", list);
		
		return map;
	}

	@Override
	public Map<String, Object> commentMap(int memberNo, int cp) {
		
		int listCount = dao.getCommentCount(memberNo);
		
		Pagination pagination = new Pagination(cp, listCount);
		
		List<Map<String, Object>> list = dao.selectCommentList(memberNo, pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("list", list);
		
		return map;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int secession(String memberPw, int memberNo) {
		
		String encPw = dao.selectEncPw(memberNo);

		if(bcrypt.matches(memberPw, encPw)) {
			return dao.secession(memberNo);
		}

		return 0;
	}

}
