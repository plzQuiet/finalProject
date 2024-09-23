package com.fin.project.book.controller;

import java.util.List;
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

import com.fin.project.book.model.dto.Book;
import com.fin.project.book.model.dto.BookRequest;
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
	
	@GetMapping("/2/1")
	public String requestHistory(Model model
			, @RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {
		
		Map<String, Object> map = service.selectRequestList(cp);
		
		model.addAttribute("map", map);
		
		return "search/requestHistory";
	}
	
	@GetMapping("/2/1/{requestNo}")
	public String requestHistoryDetail(Model model,
			@PathVariable("requestNo") int requestNo,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp){
		
		BookRequest request = service.selectRequestDetail(requestNo);
		
		model.addAttribute("request", request);
		
		return "search/bookRequestDetail";
	}
	
	@GetMapping("/2/2")
	public String requestForm() {
		return "search/bookRequestForm";
	}
	
	@GetMapping("/search")
	@ResponseBody
	private Map<String, Object> search(@RequestParam Map<String, Object> paramMap) {
		return service.selectBookList(paramMap);
	}
	
	@GetMapping("/resv")
	@ResponseBody
	private int reservation(@RequestParam Map<String, Object> paramMap) {
		return service.reservation(paramMap);
	}
	
	@PostMapping("/2/2")
	@ResponseBody
	public int insertRequest(@RequestBody Map<String, Object> paramMap) {
		return service.insertRequest(paramMap);
	}
	
}
