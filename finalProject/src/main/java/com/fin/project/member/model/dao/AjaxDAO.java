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

	public int bookCancle(int rNo) {
		return sqlSession.delete("ajaxMapper.bookCancle", rNo);
	}

	public int reservCancle(int rNo) {
		return sqlSession.delete("ajaxMapper.reservCancle", rNo);
	}

	public int classCancle(int boardNo) {
		return sqlSession.delete("ajaxMapper.classCancle", boardNo);
	}

	public int bookmarkCancle(int bookNo) {
		return sqlSession.delete("ajaxMapper.bookmarkCancle", bookNo);
	}
	
}
