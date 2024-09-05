package com.fin.project.my.library;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myLibrary")
public class MyLibraryController {

	@GetMapping("/book")
	public String book() {
		return "my/library/book";
	}
	
	@GetMapping("/reservation")
	public String reservation() {
		return "my/library/reservation";
	}
	
	@GetMapping("/bookmark")
	public String bookmark() {
		return "my/library/bookmark";
	}
	
}
