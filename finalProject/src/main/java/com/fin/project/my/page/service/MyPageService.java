package com.fin.project.my.page.service;

import com.fin.project.member.model.dto.Member;

public interface MyPageService {

	int update(Member inputMember);

	int changePw(String currentPw, String newPw, int memberNo);

}
