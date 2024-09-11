package com.fin.project.scheduling.model.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClassSchedule {
	
	private int boardNo;
	private Date startDt; // 클래스 시작일 
	private Date EndDt; // 클래스 종료일
	private Date recruitmentStartDt; // 신청 시작일
	private Date recruitmentEndDt; // 신청 종료일
	private int maxParticipant; // 신청 최대 인원수

}
