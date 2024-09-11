package com.fin.project.my.library.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.board.model.dto.Pagination;

@Repository
public class MyLibraryDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Map<String, Object>> booksLoan(int memberNo) {
		return sqlSession.selectList("myLibraryMapper.booksLoan", memberNo);
	}
	
	public int getLoanHistory(int memberNo) {
		return sqlSession.selectOne("myLibraryMapper.getLoanHistory", memberNo);
	}

	public List<Map<String, Object>> loanHistory(int memberNo, Pagination pagination) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("myLibraryMapper.loanHistory", memberNo, rowBounds);
	}

	public int getReservationBook(int memberNo) {
		return sqlSession.selectOne("myLibraryMapper.getReservationBook", memberNo);
	}
	
	public List<Map<String, Object>> reservationBook(int memberNo, Pagination pagination) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("myLibraryMapper.reservationBook", memberNo, rowBounds);
	}
	
	public int getBookRequestHistory(int memberNo) {
		return sqlSession.selectOne("myLibraryMapper.getBookRequestHistory", memberNo);
	}

	public List<Map<String, Object>> bookRequestHistory(int memberNo, Pagination pagination) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("myLibraryMapper.bookRequestHistory", memberNo, rowBounds);
	}
	
}
