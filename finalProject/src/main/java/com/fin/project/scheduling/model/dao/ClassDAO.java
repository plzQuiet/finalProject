package com.fin.project.scheduling.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.scheduling.model.dto.Board;
import com.fin.project.scheduling.model.dto.Pagination;

@Repository
public class ClassDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 게시글 상태 N인 게시판 게시글 수 조회
	public int getListCount(int cateCode) {
		
		return sqlSession.selectOne("classMapper.getListCount", cateCode);
	}

	public List<Board> selectClassBoard(int cateCode, Pagination pagination) {
		
		int offset = (pagination.getCurrentPage()-1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit()); 
		
		return sqlSession.selectList("classMapper.selectClassBoard", cateCode, rowBounds);
	}

}
