package com.fin.project.scheduling.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardImage {
	
	private int imageNo;
	private int boardNo;
	private String imagePath;
	private String imageOriginal;
	private String imageReName;
	private int imageOrder;


}
