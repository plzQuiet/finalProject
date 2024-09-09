package com.fin.project.food.model.service;

import java.util.List;
import java.util.Map;

public interface FoodService {

	/** 음식 메뉴 갖고 오기
	 * @return list
	 */
	List<Map<String, Object>> selectFoodList();
	
	

}
