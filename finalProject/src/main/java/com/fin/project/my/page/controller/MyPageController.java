package com.fin.project.my.page.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fin.project.member.model.dto.Member;
import com.fin.project.my.page.service.MyPageService;

@Controller
@RequestMapping("/myPage")
public class MyPageController {
	
	@Autowired
	private MyPageService service;
	
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
	
	@PostMapping("/update")
	public String update(Member inputMember,
			@SessionAttribute("loginMember") Member loginMember,
			String[] memberAddress,
			RedirectAttributes ra) {
		
		inputMember.setMemberNo(loginMember.getMemberNo());
		
		if(inputMember.getMemberAddress().equals(",,")) {
			inputMember.setMemberAddress(null);
		}else {
			String addr = String.join("^^^", memberAddress);
			inputMember.setMemberAddress(addr);
		}
		
		int result = service.update(inputMember);
		
		String message = null;
		String path = "redirect:";
		
		if(result > 0) {
			message = "정보 수정 성공";
			path += "/";
		}else {
			message = "정보 수정 실패 ㅠㅠ";
			path += "update";
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
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
			path += "/";
			
		}else {
			message = "비밀번호 변경 실패 ㅠㅠ";
			path += "changePw";
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
}
