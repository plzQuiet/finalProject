package com.fin.project.my.page.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.board.model.dto.Pagination;
import com.fin.project.member.model.dto.Member;

@Repository
public class MyPageDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public int update(Member inputMember) {
		return sqlSession.update("myPageMapper.update", inputMember);
	}

	public String selectEncPw(int memberNo) {
		return sqlSession.selectOne("myPageMapper.selectEncPw", memberNo);
	}

	public int changePw(String encode, int memberNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("encode", encode);
		map.put("memberNo", memberNo);
		return sqlSession.update("myPageMapper.changePw", map);
	}

	public int getBoardCount(int memberNo) {
		return sqlSession.selectOne("myPageMapper.getBoardCount", memberNo);
	}

	public List<Map<String, Object>> selectBoardList(int memberNo, Pagination pagination) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("myPageMapper.selectBoardList", memberNo, rowBounds);
	}

	public int getCommentCount(int memberNo) {
		return sqlSession.selectOne("myPageMapper.getCommentCount", memberNo);
	}

	public List<Map<String, Object>> selectCommentList(int memberNo, Pagination pagination) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("myPageMapper.selectCommentList", memberNo, rowBounds);
	}

	public int secession(int memberNo) {
		return sqlSession.update("myPageMapper.secession", memberNo);
	}
	
}
