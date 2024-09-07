package com.fin.project.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fin.project.member.model.dto.Member;
import com.fin.project.member.model.service.MemberService;

import oracle.jdbc.proxy.annotation.Post;

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

	@GetMapping("/findPw")
	public String findPw() {
		return "member/findPw";
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
	
}
