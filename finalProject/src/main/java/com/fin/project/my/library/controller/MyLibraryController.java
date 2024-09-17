package com.fin.project.my.library.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
		
		List<Map<String, Object>> bList = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		String path = "my/library/book/";
		
		if(m == 1) {
			bList = service.booksLoan(loginMember.getMemberNo());
			path += "booksLoan";
		}
		
		if(m == 2) {
			map = service.loanHistory(loginMember.getMemberNo(), cp);
			path += "loanHistory";
		}
		
		if(m == 3) {
			bList = service.reservationBook(loginMember.getMemberNo());
			path += "reservationBook";
		}
		
		if(m == 4) {
			map = service.bookRequestHistory(loginMember.getMemberNo(), cp);
			path += "bookRequestHistory";
		}
		
		model.addAttribute("bList", bList);
		model.addAttribute("map", map);
		
		return path;
	}
	
	@GetMapping("/reserv")
	public String reserv(@SessionAttribute("loginMember") Member loginMember,
			Model model,
			@RequestParam(value = "m", required = false, defaultValue = "1") int m) {
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		String path = "my/library/reserv/";
		
		switch(m) {
		case 1: list = service.readingRoomReserv(loginMember.getMemberNo());
				path += "readingRoom";
			break;
			
		case 2: list = service.seminarReserv(loginMember.getMemberNo());
				path += "seminar";
			break;
			
		case 3: list = service.classRegist(loginMember.getMemberNo());
				path += "class";
			break;
		}
		
		model.addAttribute("list", list);
		
		return path;
	}
	
	@GetMapping("/bookmark")
	public String bookmark(@SessionAttribute("loginMember") Member loginMember,
			Model model,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {
		
		Map<String, Object> map = service.bookmark(loginMember.getMemberNo(), cp);
		model.addAttribute("map", map);
		
		return "my/library/bookmark/bookmark";
		
	}
	
}
