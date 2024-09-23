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

@RestController
public class AjaxController {

	@Autowired
	private AjaxService service;
	
	@GetMapping("/dupCheck/email")
	public int dupCheckEmail(String email) {
		return service.dupCheckEmail(email);
	}
	
	@DeleteMapping("/bookcancel")
	public int bookcancel(@RequestBody int rNo) {
		return service.bookcancel(rNo);
	}
	
	@DeleteMapping("/reservcancel")
	public int reservcancel(@RequestBody int rNo) {
		return service.reservcancel(rNo);
	}
	
	@DeleteMapping("/classcancel")
	public int classcancel(@RequestBody int boardNo) {
		return service.classcancel(boardNo);
	}
	
	@DeleteMapping("/bookmarkcancel")
	public int bookmarkcancel(@RequestBody int bookNo) {
		return service.bookmarkcancel(bookNo);
	}
	
}
