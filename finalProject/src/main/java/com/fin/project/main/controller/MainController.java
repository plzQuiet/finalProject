package com.fin.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String mainForward() {
		return "common/main";
	}
		
	@GetMapping("/menu")
	public String menuForward() {
		return "menu/menu";
	}
	

	@GetMapping("/cafe")
	public String cafeForward() {
		return "menu/cafe";
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
}
