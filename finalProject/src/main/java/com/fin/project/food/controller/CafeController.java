package com.fin.project.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fin.project.food.model.dto.Food;
import com.fin.project.food.model.dto.Pay;
import com.fin.project.food.model.service.FoodService;


@Controller
@SessionAttributes("loginMember")
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
	
	// 카페 메뉴 삽입 컨트롤러
	@PostMapping("/cafe/insert")
	public String insertCafeMenu(@RequestParam("menuImage") MultipartFile menuImage
							, @RequestParam("menuName") String menuName
							, @RequestParam("menuDes") String menuDes
							, @RequestParam("menuPrice") int menuPrice
							, HttpSession session
							, RedirectAttributes ra
							)throws IllegalStateException, IOException {
		
		// 웹 접근 경로
		String webPath = "/resources/images/food/";
		
		// 실제로 이미지 파일이 저장돼야 하는 서버 컴퓨터 경로
		String filePath = session.getServletContext().getRealPath(webPath);
		
		Food newFood = new Food();
		
		newFood.setFoodName(menuName);
		newFood.setFoodPrice(menuPrice);
		newFood.setFoodDes(menuDes);
		
		int result =service.insertCafeMenu(newFood, menuImage, webPath, filePath);
		
		ra.addFlashAttribute("AddMenu", result);
		
		return "redirect:/cafe";
	}
	
	// 카페 메뉴 업데이트
	@PostMapping("/cafe/update")
	public String updateSnackMenu(@RequestParam(value = "menuImage", required = false) MultipartFile menuImage
								, @RequestParam("menuName") String menuName
								, @RequestParam("menuNo") int menuNo
								, @RequestParam("menuPrice") int menuPrice
								, @RequestParam("menuDes") String menuDes
								, @RequestParam(value = "existingImage", required = false) String existingImage // 기존 이미지 받기
								, HttpSession session
								, RedirectAttributes ra
								)throws IllegalStateException, IOException {
		// 웹 접근 경로
		String webPath = "/resources/images/food/";
		
		// 실제로 이미지 파일이 저장돼야 하는 서버 컴퓨터 경로
		String filePath = session.getServletContext().getRealPath(webPath);
		
		Food food = new Food();
		
		food.setFoodNo(menuNo);
		food.setFoodName(menuName);
		food.setFoodDes(menuDes);
		food.setFoodPrice(menuPrice);
		food.setFoodImg(existingImage);
		
		int result =service.updateMenu(food, menuImage, webPath, filePath);
		
		ra.addFlashAttribute("UpdateMenu", result);
		
		return "redirect:/cafe";
	}
	
	// 카페 결제
	@PostMapping("/cafe/pay")
	@ResponseBody
	public int insertCafePay(@RequestBody Pay pay) {
		return service.insertCafePay(pay);
	}
}
