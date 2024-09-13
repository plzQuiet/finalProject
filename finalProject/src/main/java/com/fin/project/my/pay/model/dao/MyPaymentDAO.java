package com.fin.project.my.pay.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.board.model.dto.Pagination;

@Repository
public class MyPaymentDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public int getPayment(int memberNo) {
		System.out.println(memberNo);
		return sqlSession.selectOne("myLibraryMapper.getPayment", memberNo);
	}

	public List<Map<String, Object>> payment(int memberNo, Pagination pagination) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("myLibraryMapper.payment", memberNo, rowBounds);
	}
	
}
