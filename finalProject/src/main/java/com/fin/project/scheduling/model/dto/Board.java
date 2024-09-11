package com.fin.project.scheduling.model.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Board {
	
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardCreateDate;
	private String boardUpdateDate;
	private int readCount;
	private String boardDeleteFlag;
	private String boardSecretFlag;
	
	private int commentCount; 

	// 회원 
	private int memberNo;
	private String memberName;

	//boardCode
	private int cateCode;
	
	// 이미지
	private List<BoardImage> imageList;
	
	// 클래스 게시판
	private Date recruitmentStartDt; // 신청 시작일
	private Date recruitmentEndDt; // 신청 종료일
	private int maxParticipant; // 신청 최대 인원수
	
}
