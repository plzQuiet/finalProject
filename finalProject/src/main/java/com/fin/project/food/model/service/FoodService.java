package com.fin.project.food.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

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


	/** 분식 메뉴 추가하기
	 * @param newFood
	 * @param webPath 
	 * @param menuImage 
	 * @param filePath
	 * @return int
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	int insertFoodMenu(Food newFood, MultipartFile menuImage, String webPath, String filePath) throws IllegalStateException, IOException;



	
	
}
