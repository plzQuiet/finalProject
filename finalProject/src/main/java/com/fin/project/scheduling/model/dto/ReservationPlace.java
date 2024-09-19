package com.fin.project.scheduling.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservationPlace {
	
	private int reservationNo;
	private int seatNo;
	
	private String reservationDt;
	private String startTime;
	private String endTime;

	// 회원 
	private int memberNo;
	private String memberName;
	
	private String seatStatus;

}
