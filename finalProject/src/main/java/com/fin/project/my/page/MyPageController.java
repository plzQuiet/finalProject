package com.fin.project.my.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myPage")
public class MyPageController {
	
	@GetMapping("/info")
	public String info() {
		return "my/page/info";
	}
	
	@GetMapping("/update")
	public String update() {
		return "my/page/update";
	}
	
	@GetMapping("/writing")
	public String writing() {
		return "my/page/writing";
	}
	
	@GetMapping("/changePw")
	public String changePw() {
		return "my/page/changePw";
	}
	
	@GetMapping("/secession")
	public String secession() {
		return "my/page/secession";
	}
	
}
