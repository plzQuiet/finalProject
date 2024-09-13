package com.fin.project.food.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fin.project.food.model.dto.Food;
import com.fin.project.food.model.service.FoodService;

@Controller
@SessionAttributes({"loginMember"})
public class FoodController {

	@Autowired
	private FoodService service;
	
	// 메뉴 삽입 컨트롤러
	@GetMapping("/food")
	public String selectFood(Model model) {		
		
		List<Food> foodList = service.selectFoodList();
		
		model.addAttribute("foodList", foodList);
		
		return "food/food"; 
	}
	
	// 메뉴 삽입 컨트롤러
	@PostMapping("/food/insert")
	public String insertFoodMenu(@RequestParam("menuImage") MultipartFile menuImage
							, @RequestParam("menuName") String menuName
							, HttpSession session
							, RedirectAttributes ra
							)throws IllegalStateException, IOException {
		
		// 웹 접근 경로
		String webPath = "/resources/images/food/";
		
		// 실제로 이미지 파일이 저장돼야 하는 서버 컴퓨터 경로
		String filePath = session.getServletContext().getRealPath(webPath);
		
		Food newFood = new Food();
		
		newFood.setFoodName(menuName);
		
		int result =service.insertFoodMenu(newFood, menuImage, webPath, filePath);
		
		ra.addFlashAttribute("AddMenu", result);
		
		return "redirect:/food";
	}
	
	
	@PutMapping("/food/del")
	@ResponseBody
	public int delFoodMenu(@RequestBody int foodNo) {
		return service.delFoodMenu(foodNo);
	}
	
	@ResponseBody
	@GetMapping("/food/showMeal")
	public List<Food> showMealMenu(int typeNo){
		return service.showMealMenu(typeNo);
	}
	
	
	@PutMapping("/food/updateMeal")
	@ResponseBody
	public int updateMealMenu(@RequestBody Food food) {
		return service.updateMealMenu(food);
	}
}
