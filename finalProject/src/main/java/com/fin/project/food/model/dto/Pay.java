package com.fin.project.food.model.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pay {
	private int memberNo;
	private int foodNo;
	private Date payDate;
	private int foodQty; 
	
	private List<Integer> foodNoList;
	private List<Integer> foodQtyList;
}
