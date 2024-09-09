package com.fin.project.board.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardImage {
	
	private int imageNo;
	private String imageOriginal;
	private String imageReName;
	private int imageOrder;
	private int boardNo;
	private String imagePath;


}
