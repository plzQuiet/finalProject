package com.fin.project.board.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Comment {
	
	private int commentNo;
	private int memberNo;
	private int boardNo;
	private String commentContent;
	private String commentCreateDate;
	private String commentDeleteFlag;

}
