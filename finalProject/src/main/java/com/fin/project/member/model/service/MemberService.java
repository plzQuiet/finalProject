package com.fin.project.member.model.service;

import com.fin.project.member.model.dto.Member;

public interface MemberService {

	int signUp(Member inputMember);

	Member login(Member inputMember);

}
