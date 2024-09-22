package com.fin.project.book.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.board.model.dto.Pagination;
import com.fin.project.book.model.dto.Book;
import com.fin.project.book.model.dto.BookRequest;

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

	public int insertRequest(Map<String, Object> paramMap) {
		return sqlSession.insert("bookMapper.insertRequest", paramMap);
	}

	public int getRequestCount() {
		return sqlSession.selectOne("bookMapper.getRequestCount");
	}

	public List<BookRequest> selectRequestList(Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("bookMapper.selectRequestList", pagination, rowBounds);
	}

}
