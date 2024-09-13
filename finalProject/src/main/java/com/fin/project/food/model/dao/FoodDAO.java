package com.fin.project.food.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.food.model.dto.Food;

@Repository
public class FoodDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
 

	/** 음식 메뉴 가져오기
	 * @return foodList
	 */
	public List<Food> selectFoodList() {
		return sqlSession.selectList("foodMapper.selectFoodList");
	}


	/** 음식 메뉴 추가하기
	 * @param newFood
	 * @return int
	 */
	public int insertFoodMenu(Food newFood) {
		return sqlSession.insert("foodMapper.insertFoodMenu", newFood);
		
	}


	/** 음식 메뉴 삭제하기
	 * @param foodNo
	 * @return int
	 */
	public int delFoodMenu(int foodNo) {
		return sqlSession.update("foodMapper.delFoodMenu", foodNo);
	}


	/** 백반 메뉴 보여주기
	 * @param typeNo
	 * @return Food
	 */
	public List<Food> showMealMenu(int typeNo) {
		return sqlSession.selectList("foodMapper.selectMealList", typeNo);
	}


	public int updateMealMenu(Food food) {
		return sqlSession.update("foodMapper.updateMealMenu", food);
	}

		
	
}
