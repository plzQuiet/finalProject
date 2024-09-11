package com.fin.project.scheduling.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fin.project.scheduling.model.service.ClassService;

@SessionAttributes("loginMember")
@Controller
@RequestMapping("/scheduling")
public class ClassController {

	@Autowired
	private ClassService service;

	@GetMapping("/{cateCode:12}")
	public String selectBoardList(@PathVariable("cateCode") int cateCode,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp,
			Model model,
			@RequestParam Map<String, Object> paramMap) {

		if (paramMap.get("query") == null) { // 검색X

			// 게시글 목록 조회 서비스 호출
			Map<String, Object> map = service.selectClassBoard(cateCode, cp);

			// 조회 결과를 request scope에 세팅 후 forward
			model.addAttribute("map", map);

		} else { // 검색O

			/*
			 * paramMap.put("boardCode", cateCode);
			 * 
			 * Map<String, Object> map = service.selectClassBoard(paramMap, cp);
			 * model.addAttribute("map", map);
			 */

		}

		return "scheduling/classBoard";
	}

	@GetMapping("/{cateCode:13}")
	public String SeatGuide() {
		return "scheduling/study";
	}

	@GetMapping("/{cateCode:14}")
	public String SeminarGuide() {
		return "scheduling/seminar";
	}

}
