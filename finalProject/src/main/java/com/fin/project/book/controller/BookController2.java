package com.fin.project.book.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fin.project.book.model.dto.BookRequest;
import com.fin.project.book.model.service.BookService;
import com.fin.project.book.model.service.BookService2;

@Controller
@RequestMapping("/book2")
public class BookController2 {

	@Autowired
	private BookService2 service;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/2/1/{requestNo}/update")
	private String update(@PathVariable("requestNo") int requestNo,
			Model model) {
		
		BookRequest bookReq = bookService.selectRequestDetail(requestNo);
		model.addAttribute("bookReq", bookReq);
		
		return "search/bookRequestUpdate";
	}
	
	@PostMapping("/2/1/{requestNo}/update")
	@ResponseBody
	private int update(@RequestBody Map<String, Object> paramMap) {
		
		return service.update(paramMap);
	}
	
	@PostMapping("/admin/approve")
	@ResponseBody
	private int approve(@RequestBody Map<String, Object> paramMap) {
		return service.approve(paramMap);
	}
	
}
