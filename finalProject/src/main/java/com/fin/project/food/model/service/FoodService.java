package com.fin.project.food.model.service;

import java.util.List;
import java.util.Map;

import com.fin.project.food.model.dto.Food;

public interface FoodService {

	/** 메뉴 갖고 오기
	 * @return foodList
	 */
	List<Food> selectFoodList();

	
	/** 커피 메뉴 갖고 오기
	 * @return coffeeList
	 */
	List<Food> selectCoffeeList();
	
	

}
