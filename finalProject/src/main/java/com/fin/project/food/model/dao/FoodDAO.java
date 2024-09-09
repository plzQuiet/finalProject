package com.fin.project.food.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
 
	/** 음식 메뉴 갖고 오기
	 * @return
	 */
	public List<Map<String, Object>> selectFoodList() {
		return sqlSession.selectList("foodMapper.selectFoodList");
	}

		
	
}
