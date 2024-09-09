package com.fin.project.member.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fin.project.member.model.dao.EmailDAO;
import com.fin.project.member.model.dao.MemberDAO;
import com.fin.project.member.model.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private EmailDAO emailDAO;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Override
	public int signUp(Member inputMember) {
		
		inputMember.setMemberPw(bcrypt.encode(inputMember.getMemberPw()));
		
		return dao.signUp(inputMember);
	}

	@Override
	public Member login(Member inputMember) {
		
		Member loginMember = dao.login(inputMember);
		
		if(loginMember != null) {
			
			if(bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw())) {
				loginMember.setMemberPw(null);
				
			}else {
				loginMember = null;
			}
		}
		
		return loginMember;
	}

	@Override
	public int findId(Member inputMember) {
		return dao.findId(inputMember);
	}

	@Override
	public int resetPw(String memberEmail) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberEmail", memberEmail);
		map.put("memberPw", bcrypt.encode("000000"));
		
		return dao.resetPw(map);
	}
	
}
