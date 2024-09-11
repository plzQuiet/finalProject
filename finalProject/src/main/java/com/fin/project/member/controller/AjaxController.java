package com.fin.project.member.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fin.project.member.model.service.AjaxService;
import com.fin.project.my.library.model.service.MyLibraryService;

@RestController
public class AjaxController {

	@Autowired
	private AjaxService service;
	
	@Autowired
	private MyLibraryService libService;
	
	@GetMapping("/dupCheck/email")
	public int dupCheckEmail(String email) {
		return service.dupCheckEmail(email);
	}
	
	@DeleteMapping("/bookCancle")
	public int bookCancle(@RequestBody int rNo) {
		return service.bookCancle(rNo);
	}
	
}
