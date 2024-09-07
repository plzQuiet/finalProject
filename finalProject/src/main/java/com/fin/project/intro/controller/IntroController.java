package com.fin.project.intro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/intro")
public class IntroController {
	
	@GetMapping("/{catLevel1:1}")
	public String gotoPage(@PathVariable("catLevel1") int catLevel1,
			Model model
			) {
		model.addAttribute("catLevel2", 7);
		model.addAttribute("catLevel3", 24);
		
		return "intro/lib_greeting";
	}
	
	@GetMapping("/{catLevel1:1}/{catLevel2}")
	public String intro(@PathVariable("catLevel1") int catLevel1, 
			@PathVariable("catLevel2") int catLevel2,
			Model model) {
		
		if(catLevel2 == 9) {
			return "intro/lib_map";
		}
		
		model.addAttribute("catLevel3", 24);
		
		if(catLevel2 == 8) {
			return "intro/lib_hours";
		}
		
		return "intro/lib_greeting";
	}
	
	@GetMapping("/{catLevel1:1}/{catLevel2}/{catLevel3}")
	public String pageIntro(@PathVariable("catLevel1") int catLevel1, 
			@PathVariable("catLevel2") int catLevel2,
			@PathVariable("catLevel3") int catLevel3) {
		
		if(catLevel3 == 30) {
			return "intro/lib_calender";
		}
		
		if(catLevel3 == 29) {
			return "intro/lib_hours";
		}
		
		if(catLevel3 == 28) {
			return "intro/lib_intro_another";
		}
		
		if(catLevel3 == 27) {
			return "intro/lib_intro";
		}
		
		if(catLevel3 == 26) {
			return "intro/lib_organization";
		}
		
		if(catLevel3 == 25) {
			return "intro/lib_history";
		}
		
		return "intro/lib_greeting";
	}
	

}
