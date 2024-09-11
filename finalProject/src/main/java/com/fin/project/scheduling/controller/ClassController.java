package com.fin.project.scheduling.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fin.project.scheduling.model.service.ClassService;

@SessionAttributes("loginMember")
@Controller
@RequestMapping("/scheduling")
public class ClassController {
	
	@Autowired
	private ClassService service;
	
	@GetMapping("/{cateCode:12}")
	public String selectBoardList(@PathVariable("cateCode") int cateCode,
								  @RequestParam(value="cp", required=false, defaultValue = "1") int cp,
								  Model model,
								  @RequestParam Map<String, Object> paramMap) {
		
		
		
		
		return "scheduling/classBoard";
	}
	
	
	
	
	
	
	
	
	@GetMapping("/{cateCode:13}")
	public String SeatGuide() {
		return "scheduling/study";
	}
	
	@GetMapping("/{cateCode:14}")
	public String SeminarGuide() {
		return "scheduling/seminar";
	}

}
