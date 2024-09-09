package com.fin.project.food.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fin.project.food.model.service.FoodService;

@RequestMapping("/food")
@Controller
public class FoodController {

	@Autowired
	private FoodService service;
	
	public List<Map<String, Object>> selectFoodList(){
		
		List<Map<String, Object>> foodList = service.selectFoodList();
		System.out.println(foodList);
		
		return foodList;
	}
	
}
