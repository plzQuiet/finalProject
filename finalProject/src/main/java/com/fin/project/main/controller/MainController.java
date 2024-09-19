package com.fin.project.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fin.project.board.model.service.BoardService;
import com.fin.project.food.model.dto.Food;
import com.fin.project.food.model.service.FoodService;

@Controller
public class MainController {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private FoodService service2;

	@RequestMapping("/")
	public String mainForward(Model model) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cateCode", 15);
		
		Map<String, Object> map = service.selectBoardList(paramMap, 1);
		model.addAttribute("map", map);

		List<Food> foodList = service2.selectFoodList();
		model.addAttribute("foodList", foodList);
		
		return "common/main";
	}
		
	
	@RequestMapping("/food") 
	public String menuForward() { 
		return "food/food"; 
	}
	 

	@RequestMapping("/cafe")
	public String cafeForward() {
		return "food/cafe";
	}
	
	@GetMapping("/search")
	public String searchForward() {
		return "search/search";
	}
	
	@GetMapping("/searchDetail")
	public String searchDetailForward() {
		return "search/searchDetail";
	}
	
	@GetMapping("/searchBook")
	public String searchBookForward() {
		return "search/searchBook";
	}


	@GetMapping("/bookRequest")
	public String bookRequestForward() {
		return "search/bookRequest";
	}
	
	@GetMapping("/bookRequestForm")
	public String bookRequestFormForward() {
		return "search/bookRequestForm";
	}
	
	@GetMapping("/requestHistory")
	public String requestHistoryForward() {
		return "search/requestHistory";
	}


}
