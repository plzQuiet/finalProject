package com.fin.project.search.model.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SearchDAO {
    
	@Autowired
    private SqlSessionTemplate sqlSession;

    // 책 검색 리스트
    public List<SearchDAO> selectBookList() {
		return sqlSession.selectList("search-mapper.selectBookList");
    	
    	
        
    }

  
}


