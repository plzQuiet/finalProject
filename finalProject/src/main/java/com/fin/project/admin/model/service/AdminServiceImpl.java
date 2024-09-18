package com.fin.project.admin.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fin.project.admin.model.dao.AdminDAO;
import com.fin.project.board.model.dto.Board;
import com.fin.project.board.model.dto.Comment;
import com.fin.project.board.model.dto.Pagination;
import com.fin.project.member.model.dto.Member;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO dao;
	
	@Override
	public Map<String, Object> selectMemberList(int cp) {
		
		int listCount = dao.getMemberCount();
		
		Pagination pagination = new Pagination(cp, listCount);
		
		List<Member> memberList = dao.selectMemberList(pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("memberList", memberList);
		
		return map;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int member(String updateList) {
		return dao.member(updateList);
	}

	@Override
	public Map<String, Object> selectboardList(int cp) {
		
		int listCount = dao.getboardCount();
		
		Pagination pagination = new Pagination(cp, listCount);
		
		List<Board> boardList = dao.selectboardList(pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		return map;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int board(String updateList) {
		return dao.board(updateList);
	}

	@Override
	public Map<String, Object> selectCommentList(int cp) {
		
		int listCount = dao.getCommentCount();
		
		Pagination pagination = new Pagination(cp, listCount);
		
		List<Comment> commentList = dao.selectCommentList(pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("commentList", commentList);
		
		return map;
	}

	@Override
	public int comment(String updateList) {
		return dao.comment(updateList);
	}
	
}
