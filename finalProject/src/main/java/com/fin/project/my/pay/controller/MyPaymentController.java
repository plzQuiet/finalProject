package com.fin.project.my.pay.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.fin.project.member.model.dto.Member;
import com.fin.project.my.pay.model.service.MyPaymentService;

@Controller
public class MyPaymentController {
	
	@Autowired
	private MyPaymentService service;
	
	@GetMapping("/myPayment")
	public String payment(@SessionAttribute("loginMember") Member loginMember,
			Model model,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {
		
		Map<String, Object> map = service.payment(loginMember.getMemberNo(), cp);
		model.addAttribute("map", map);

		return "my/payment/payment";
	}
	
}
