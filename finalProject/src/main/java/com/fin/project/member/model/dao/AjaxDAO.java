package com.fin.project.member.model.dao;

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

	public int bookcancel(int rNo) {
		return sqlSession.delete("ajaxMapper.bookcancel", rNo);
	}

	public int reservcancel(int rNo) {
		return sqlSession.delete("ajaxMapper.reservcancel", rNo);
	}

	public int classcancel(int boardNo) {
		return sqlSession.delete("ajaxMapper.classcancel", boardNo);
	}

	public int bookmarkcancel(int bookNo) {
		return sqlSession.delete("ajaxMapper.bookmarkcancel", bookNo);
	}
	
}
