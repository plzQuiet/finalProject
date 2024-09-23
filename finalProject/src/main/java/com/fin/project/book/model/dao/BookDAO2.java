package com.fin.project.book.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO2 {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
}
