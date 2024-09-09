package com.fin.project.my.page.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fin.project.member.model.dto.Member;
import com.fin.project.my.page.dao.MyPageDAO;

@Service
public class MyPageServiceImpl implements MyPageService{

	@Autowired
	private MyPageDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int update(Member inputMember) {
		return dao.update(inputMember);
	}

	@Override
	public int changePw(String currentPw, String newPw, int memberNo) {
		
		String encPw = dao.selectEncPw(memberNo);
		
		if(bcrypt.matches(currentPw, encPw)) {
			return dao.changePw(bcrypt.encode(newPw), memberNo);
		}
		
		return 0;
	}

}
