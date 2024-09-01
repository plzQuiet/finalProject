package com.fin.project.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmailDAO {

	@Autowired
	private SqlSessionTemplate sqlSesison;

	public int updateAuthKey(Map<String, String> map) {
		return sqlSesison.update("emailMapper.updateAuthKey", map);
	}

	public int insertAuthKey(Map<String, String> map) {
		return sqlSesison.insert("emailMapper.insertAuthKey", map);
	}

	public int checkAuthKey(Map<String, Object> paramMap) {
		return sqlSesison.selectOne("emailMapper.checkAuthKey", paramMap);
	}
	
}
