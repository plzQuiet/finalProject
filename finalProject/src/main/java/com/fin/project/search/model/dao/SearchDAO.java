package com.fin.project.search.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.search.model.dto.Search;

@Repository
public class SearchDAO {
    
    @Autowired
    private SqlSessionTemplate sqlSession;

    // 책 검색 리스트
    public List<Search> selectBookList(Search search) {
        // Search 객체 자체를 파라미터로 전달
        return sqlSession.selectList("searchMapper.selectBookList", search);
    }
}
