package com.fin.project.food.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Food {
	private int foodNo;
	private int typeNo;
	private String foodName; 
	private int foodPrice;
	private String foodImg;
	private String foodDes;
}
