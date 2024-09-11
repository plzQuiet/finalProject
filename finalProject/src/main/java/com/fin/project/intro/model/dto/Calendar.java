package com.fin.project.intro.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Calendar {
	
	private int calendarNo; // 캘랜더 id
	private String calendarName; // 일정명
	private String startDt; // 시작일
	private String endDt; // 종료일
	private String rstartDt; // 모집 시작일
	private String rendDt; // 모종료일
	private int calendarType; // 일정종류(1=공휴일, 2=휴관일, 3=행사)
}
