package com.fin.project.member.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AjaxDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public int dupCheckEmail(String email) {
		return sqlSession.selectOne("ajaxMapper.dupCheckEmail", email);
	}
	
	public List<Map<String, Object>> booksLoan(int memberNo) {
		return sqlSession.selectList("ajaxMapper.booksLoan", memberNo);
	}

	public List<Map<String, Object>> loanHistory(int memberNo) {
		return sqlSession.selectList("ajaxMapper.loanHistory", memberNo);
	}

	public List<Map<String, Object>> reservationBook(int memberNo) {
		return sqlSession.selectList("ajaxMapper.reservationBook", memberNo);
	}

	public List<Map<String, Object>> bookRequestHistory(int memberNo) {
		return sqlSession.selectList("ajaxMapper.bookRequestHistory", memberNo);
	}
	
}
