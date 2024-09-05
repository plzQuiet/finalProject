package com.fin.project.my.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myPage")
public class MyPageController {
	
	@GetMapping("/changePw")
	public String changePw() {
		return "my/page/changePw";
	}
}
