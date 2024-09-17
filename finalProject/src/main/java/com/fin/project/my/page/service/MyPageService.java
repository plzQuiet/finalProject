package com.fin.project.my.page.service;

import java.util.Map;

import com.fin.project.member.model.dto.Member;

public interface MyPageService {

	int update(Member inputMember);

	int changePw(String currentPw, String newPw, int memberNo);

	Map<String, Object> boardMap(int memberNo, int cp);

	Map<String, Object> commentMap(int memberNo, int cp);

	int secession(String memberPw, int memberNo);

}
