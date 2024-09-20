package com.fin.project.book.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fin.project.book.model.dto.Book;
import com.fin.project.book.model.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/1/1")
	public String search() {
		return "search/search";
	}
	
	@GetMapping("/1/2")
	public String searchDetail() {
		return "search/searchDetail";
	}

	@GetMapping("/2")
	public String bookRequest() {
		return "search/bookRequest";
	}
	
	@GetMapping("/3")
	public String test() {
		return "search/searchDetail";
	}
	
	@GetMapping("/search")
	@ResponseBody
	private List<Book> search(@RequestParam Map<String, Object> paramMap) {
		return service.selectBookList(paramMap);
	}
	
}
