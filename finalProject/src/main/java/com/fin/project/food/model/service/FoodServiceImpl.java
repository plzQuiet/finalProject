package com.fin.project.food.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.project.food.model.dao.FoodDAO;
import com.fin.project.food.model.dto.Food;

@Service
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	private FoodDAO dao;

	// 백반 메뉴 가져오기
	@Override
	public List<Food> selectFoodList() {
		return dao.selectFoodList();
	}

	// 커피 메뉴 가져오기
	@Override
	public List<Food> selectCoffeeList() {
		
		List<Food> foodList = new ArrayList<Food>();
		
		List<Food> foodList2 = dao.selectFoodList();
		

		for(Food food : foodList2) {
			if(food.getTypeNo() == 2) {
				foodList.add(food);
			}
		}
		
		return foodList;
	}
	

	
	
	

}
