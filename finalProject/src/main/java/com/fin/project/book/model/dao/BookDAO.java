package com.fin.project.book.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.book.model.dto.Book;

@Repository
public class BookDAO {
    
    @Autowired
    private SqlSessionTemplate sqlSession;

	public List<Book> selectBookList(Map<String, Object> paramMap) {
		return sqlSession.selectList("bookMapper.selectBookList", paramMap);
	}

	public List<Book> selectBookList(Map<String, Object> paramMap, int limit) {
		
		RowBounds rowBounds = new RowBounds(0, limit);
		
		return sqlSession.selectList("bookMapper.selectBookList", paramMap, rowBounds);
	}

	public List<Integer> selectlikeList(int memberNo) {
		return sqlSession.selectList("bookMapper.selectLikeList", memberNo);
	}

	public int countReservation(Map<String, Object> paramMap) {
		return sqlSession.selectOne("bookMapper.countReservation", paramMap);
	}

	public int insertReservation(Map<String, Object> paramMap) {
		return sqlSession.insert("bookMapper.insertReservation", paramMap);
	}

}