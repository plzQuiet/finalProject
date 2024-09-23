package com.fin.project.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
}
