package com.fin.project.book.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO2 {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public int update(Map<String, Object> paramMap) {
		return sqlSession.update("bookMapper.updateRequest", paramMap);
	}

	public int approve(Map<String, Object> paramMap) {
		return sqlSession.update("bookMapper.updateApprove", paramMap);
	}
	
}
