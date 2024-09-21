package com.fin.project.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.member.model.dto.Member;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int signUp(Member inputMember) {
		return sqlSession.insert("memberMapper.signUp", inputMember);
	}

	public Member login(Member inputMember) {
		return sqlSession.selectOne("memberMapper.login", inputMember);
	}

	public String findId(Member inputMember) {
		return sqlSession.selectOne("memberMapper.findId", inputMember);
	}

	public int resetPw(Map<String, Object> map) {
		return sqlSession.update("memberMapper.resetPw", map);
	}
	
}
