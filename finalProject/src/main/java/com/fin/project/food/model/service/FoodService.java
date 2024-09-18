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


	/** 분식 메뉴 없애기
	 * @param foodNo
	 * @return
	 */
	int delFoodMenu(int foodNo);


	/** 백반 메뉴 보여주기
	 * @param typeNo
	 * @return map
	 */
	List<Food> showMealMenu(int typeNo);


	/** 백반 업데이트
	 * @param food
	 * @return result
	 */
	int updateMealMenu(Food food);


	/** 스넥 업데이트
	 * @param food
	 * @param filePath 
	 * @param webPath 
	 * @param foodImage 
	 * @return result
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	int updateSnackMenu(Food food, MultipartFile foodImage, String webPath, String filePath) throws IllegalStateException, IOException;


	/** 카페 메뉴 추가
	 * @param newFood
	 * @param menuImage
	 * @param webPath
	 * @param filePath
	 * @return
	 */
	int insertCafeMenu(Food newFood, MultipartFile menuImage, String webPath, String filePath) throws IllegalStateException, IOException;


	/** 카페 업데이트
	 * @param food
	 * @param menuImage
	 * @param webPath
	 * @param filePath
	 * @return
	 */
	int updateMenu(Food food, MultipartFile menuImage, String webPath, String filePath) throws IllegalStateException, IOException;



	
	
}
