package com.fin.project.member.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GetMapping("/booksLoan")
	public List<Map<String, Object>> booksLoan(int memberNo){
		return service.booksLoan(memberNo);
	}
	
	@GetMapping("/loanHistory")
	public List<Map<String, Object>> loanHistory(int memberNo){
		return service.loanHistory(memberNo);
	}
	
	@GetMapping("/reservationBook")
	public List<Map<String, Object>> reservationBook(int memberNo){
		return service.reservationBook(memberNo);
	}
	
	@GetMapping("/bookRequestHistory")
	public List<Map<String, Object>> bookRequestHistory(int memberNo){
		return service.bookRequestHistory(memberNo);
	}

}
