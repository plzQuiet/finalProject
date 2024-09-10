package com.fin.project.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fin.project.food.model.dto.Food;
import com.fin.project.food.model.service.FoodService;


@Controller
public class CafeController {

	@Autowired
	private FoodService service;
	
	@GetMapping("/cafe")
	public String selectFood(Model model){
		
		List<Food> foodList = service.selectFoodList();
		
		model.addAttribute("foodList", foodList);
		
		return "food/cafe";
	}
	
	@GetMapping("/api/cafe")
	@ResponseBody
	public List<Food> selectCoffeeList(Model model){
		
		return service.selectCoffeeList();
	}
}
