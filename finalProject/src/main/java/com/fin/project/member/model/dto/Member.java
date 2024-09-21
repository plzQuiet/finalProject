package com.fin.project.member.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {

	private int memberNo;
	private String memberEmail;
	private String memberPw;
	private String memberName;
	private String memberPhoneNo;
	private String memberGender;
	private String memberDateOfBirth;
	private String memberAddress;
	private String memberDeleteFlag;
	private String enrollDate;
	private int authority;
	
	private int loanBook;
	private int overdueBook;
	private int resvBook;
	
}
