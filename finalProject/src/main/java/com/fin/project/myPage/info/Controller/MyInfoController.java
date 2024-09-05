package com.fin.project.myPage.info.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/6")
public class MyInfoController {

	@GetMapping("/1")
	public String book() {
		return "myPage/book";
	}
}
