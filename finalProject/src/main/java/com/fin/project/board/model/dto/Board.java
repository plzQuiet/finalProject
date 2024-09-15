package com.fin.project.board.model.dto;

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

	// == boardCode
	private int cateCode;
	
	// 이미지
	private List<BoardImage> imageList;
	
	// 댓글
	private List<Comment> commentList;
	private String cateName;
}
