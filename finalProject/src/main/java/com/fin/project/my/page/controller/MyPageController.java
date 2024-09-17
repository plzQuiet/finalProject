package com.fin.project.my.page.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fin.project.member.model.dto.Member;
import com.fin.project.my.page.service.MyPageService;

@Controller
@RequestMapping("/myPage")
@SessionAttributes("loginMember")
public class MyPageController {
	
	@Autowired
	private MyPageService service;
	
	@GetMapping("/info")
	public String info() {
		return "my/page/info";
	}
	
	@GetMapping("/writing")
	public String writing(@SessionAttribute("loginMember") Member loginMember,
			@RequestParam(value = "m", required = false, defaultValue = "1") int m,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp,
			Model model) {
		
		int memberNo = loginMember.getMemberNo();
		String path = "my/page/";
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(m == 1) {
			map = service.boardMap(memberNo, cp);
			path += "board";
		}
		
		if(m == 2){
			map = service.commentMap(memberNo, cp);
			path += "comment";
		}
		
		model.addAttribute("map", map);
		return path;
	}
	
	@GetMapping("/changePw")
	public String changePw() {
		return "my/page/changePw";
	}
	
	@GetMapping("/secession")
	public String secession() {
		return "my/page/secession";
	}
	
	@PostMapping("/info")
	public String update(Member updateMember,
			@SessionAttribute("loginMember") Member loginMember,
			String[] memberAddress,
			RedirectAttributes ra) {
		
		updateMember.setMemberNo(loginMember.getMemberNo());
		
		if(updateMember.getMemberAddress().equals(",,")) {
			updateMember.setMemberAddress(null);
		}else {
			String addr = String.join("^^^", memberAddress);
			updateMember.setMemberAddress(addr);
		}
		
		int result = service.update(updateMember);
		
		String message = null;
		
		if(result > 0) {
			message = "정보 수정 성공";
			loginMember.setMemberName(updateMember.getMemberName());
			loginMember.setMemberPhoneNo(updateMember.getMemberPhoneNo());
			loginMember.setMemberAddress(updateMember.getMemberAddress());
		}else {
			message = "정보 수정 실패 ㅠㅠ";
		}
		
		ra.addFlashAttribute("message", message);
		
		return "redirect:info";
	}
	
	@PostMapping("/changePw")
	public String changePw(String currentPw, String newPw,
			@SessionAttribute("loginMember") Member loginMember,
			RedirectAttributes ra) {
		
		int memberNo = loginMember.getMemberNo();
		
		int result = service.changePw(currentPw, newPw, memberNo);
		
		String message = null;
		String path = "redirect:";
		
		if(result > 0) {
			message = "비밀번호 변경 성공";
			path += "info";
			
		}else {
			message = "비밀번호 변경 실패 ㅠㅠ";
			path += "changePw";
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
	@PostMapping("/secession")
	public String secession(String memberPw,
			@SessionAttribute("loginMember") Member loginMember,
			SessionStatus status, HttpServletResponse resp,
			RedirectAttributes ra) {
		int memberNo = loginMember.getMemberNo();
		int result = service.secession(memberPw, memberNo);
		
		String path = "redirect:";
		String message = null;
		if(result > 0) {
			message = "탈퇴 되었습니다.";
			status.setComplete();
			path += "/";
			
			Cookie cookie = new Cookie("saveId", null);
			
			cookie.setMaxAge(0);
			cookie.setPath("/");
			resp.addCookie(cookie);
			
		}else {
			message = "현재 비밀번호가 일치하지 않습니다.";
			path += "secession";
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
}
