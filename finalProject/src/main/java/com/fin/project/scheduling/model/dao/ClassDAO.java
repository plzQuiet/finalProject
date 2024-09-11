package com.fin.project.scheduling.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClassDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

}
