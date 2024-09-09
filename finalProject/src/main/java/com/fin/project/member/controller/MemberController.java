package com.fin.project.member.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fin.project.member.model.dto.Member;
import com.fin.project.member.model.service.MemberService;

@Controller
@RequestMapping("/member")
@SessionAttributes("loginMember")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/signUp")
	public String signUp() {
		return "member/signUp";
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}
	
	@GetMapping("/findId")
	public String findId() {
		return "member/findId";
	}

	@GetMapping("/resetPw")
	public String findPw() {
		return "member/resetPw";
	}
	
	@PostMapping("/signUp")
	public String signUp(Member inputMember, String[] memberAddress) {
		
		if(inputMember.getMemberAddress().equals(",,")) {
			inputMember.setMemberAddress(null);
			
		}else {
			String addr = String.join("^^^", memberAddress);
			inputMember.setMemberAddress(addr);
		}
		
		int result = service.signUp(inputMember);
		
		String path = "redirect:";
		
		if(result > 0) {
			path += "/";
			
		}else {
			path += "signUp";
		}
		
		return path;
	}
	
	@PostMapping("/login")
	public String login(Member inputMember,
			Model model,
			@RequestHeader(value = "referer") String referer,
			@RequestParam(value = "saveId", required = false) String saveId,
			HttpServletResponse resp) {
		
		Member loginMember = service.login(inputMember);
		
		String path = "redirect:";
		
		if(loginMember != null) {
			path += "/";
			model.addAttribute("loginMember", loginMember);
			
			Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());
			
			if(saveId != null) {
				cookie.setMaxAge(60 * 60 * 24 * 30);
				
			}else {
				cookie.setMaxAge(0);
			}
			
			cookie.setPath("/");
			
			resp.addCookie(cookie);
			
		}else {
			path += referer;
		}
		
		return path;
	}
	
	@PostMapping("/findId")
	public String findId(Member inputMember, RedirectAttributes ra) {
		
		int result = service.findId(inputMember);
		
		String message = null;
		String path = "redirect:";
		
		if(result > 0) {
			message = "아이디 찾기 성공";
			path += "/";
			
		}else {
			message = "아이디 찾기 실패 ㅠㅠ";
			path += "findId";
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
	@PostMapping("/resetPw")
	public String resetPw(String memberEmail, RedirectAttributes ra) {
		
		int result = service.resetPw(memberEmail);
		
		String message = null;
		String path = "redirect:";
		
		if(result > 0) {
			message = "초기화 된 비밀번호 000000";
			path += "/";
			
		}else {
			message = "아이디 찾기 실패 ㅠㅠ";
			path += "findId";
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
}
