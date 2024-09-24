package com.fin.project.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fin.project.admin.model.service.AdminService;
import com.fin.project.board.model.service.BoardService;
import com.fin.project.board.model.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private CommentService CommentService;

	@GetMapping("/1")
	private String member(Model model,
			@RequestParam(value="cp", required=false, defaultValue="1") int cp) {
		
		Map<String, Object> map = service.selectMemberList(cp);
		
		model.addAttribute("map", map);
		
		return "admin/member";
	}
	
	@GetMapping("/2")
	private String board(Model model,
			@RequestParam(value="cp", required=false, defaultValue="1") int cp) {
		
		Map<String, Object> map = boardService.selectBoardList(cp);
		
		model.addAttribute("map", map);
		
		return "admin/board";
	}
	
	@GetMapping("/3")
	private String comment(Model model,
			@RequestParam(value="cp", required=false, defaultValue="1") int cp) {
		
		Map<String, Object> map = CommentService.selectCommentList(cp);
		
		model.addAttribute("map", map);
		
		return "admin/comment";
	}
	
	@PostMapping("/1")
	private String member(String updateList,
			RedirectAttributes ra) {
		
		int result = service.member(updateList);
		
		String message = null;
		
		if(result > 0) {
			message = "탈퇴여부 수정 성공";
			
		}else {
			message = "탈퇴여부 수정 실패";
		}
		
		ra.addFlashAttribute("message", message);
		
		return "redirect:1";
	}
	
	@PostMapping("/2")
	private String board(String updateList,
			RedirectAttributes ra) {
		
		int result = service.board(updateList);
		
		String message = null;
		
		if(result > 0) {
			message = "삭제여부 수정 성공";
			
		}else {
			message = "삭제여부 수정 실패";
		}
		
		ra.addFlashAttribute("message", message);
		
		return "redirect:2";
	}
	
	@PostMapping("/3")
	private String comment(String updateList,
			RedirectAttributes ra) {
		
		int result = service.comment(updateList);
		
		String message = null;
		
		if(result > 0) {
			message = "삭제여부 수정 성공";
			
		}else {
			message = "삭제여부 수정 실패";
		}
		
		ra.addFlashAttribute("message", message);
		
		return "redirect:3";
	}
	
}
