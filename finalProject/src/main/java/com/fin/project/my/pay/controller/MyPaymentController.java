package com.fin.project.my.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myPayment")
public class MyPaymentController {
	
	@GetMapping("")
	public String payment() {
		return "my/payment/payment";
	}
	
}
