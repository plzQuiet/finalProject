package com.fin.project.my.library.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.fin.project.member.model.dto.Member;
import com.fin.project.my.library.model.service.MyLibraryService;

@Controller
@RequestMapping("/myLibrary")
public class MyLibraryController {
	
	@Autowired
	private MyLibraryService service;

	@GetMapping("/book")
	public String book(@SessionAttribute("loginMember") Member loginMember,
			Model model,
			@RequestParam(value = "m", required = false, defaultValue = "1") int m,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {
		
		if(m == 1) {
			List<Map<String, Object>> bList = service.booksLoan(loginMember.getMemberNo());
			model.addAttribute("bList", bList);
			
			return "my/library/booksLoan";
		}
		
		if(m == 2) {
			Map<String, Object> map = service.loanHistory(loginMember.getMemberNo(), cp);
			model.addAttribute("map", map);
			
			return "my/library/loanHistory";
		}
		
		if(m == 3) {
			Map<String, Object> map = service.reservationBook(loginMember.getMemberNo(), cp);
			model.addAttribute("map", map);
			
			return "my/library/reservationBook";
		}
		
		Map<String, Object> map = service.bookRequestHistory(loginMember.getMemberNo(), cp);
		model.addAttribute("map", map);
		
		return "my/library/bookRequestHistory";
	}
	
}
