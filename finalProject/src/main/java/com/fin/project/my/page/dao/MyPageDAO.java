package com.fin.project.my.page.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
}
