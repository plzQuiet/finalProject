package com.fin.project.intro.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IntroDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/**카테고리 목록 가져오는 DAO
	 * @return category
	 */
	public List<Map<String, Object>> selectCategoryList() {
		return sqlSession.selectList("introMapper.selectCategoryList");
	}

}
