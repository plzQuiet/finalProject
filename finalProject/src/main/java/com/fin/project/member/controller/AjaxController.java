package com.fin.project.member.controller;

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

}
