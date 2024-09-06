package com.fin.project.intro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IntroController {
	
	@GetMapping("/{catLevel1:1}")
	public String gotoPage() {
		return "intro/lib_greeting";
	}
	
	@GetMapping("/{catLevel1:1}/{catLevel2}")
	public String intro(@PathVariable("catLevel1") int catLevel1, @PathVariable("catLevel2") int catLevel2 ) {
		return "intro/lib_greeting";
	}
	
	@GetMapping("/{catLevel1:1}/{catLevel2}/{catLevel3}")
	public String pageIntro() {
		return null;
	}
	

}
