package com.fin.project.intro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fin.project.intro.model.dto.Calendar;
import com.fin.project.intro.model.service.IntroService2;

@RestController
@RequestMapping("/intro2")
public class IntroController2 {
	
	@Autowired
	private IntroService2 service;
	
	// 캘랜더 타입별로 일정 가져오기
	@GetMapping(value="/getTypeCalendar",produces = "application/json; charset=UTF-8")
	public List<Calendar> getTypeCalendar(int type){
		return service.getTypeCalendar(type);
	}
	
	// 캘랜더 특정일 일정 가져오기
	@PostMapping(value="/getDateCal",produces = "application/json; charset=UTF-8")
	public List<Calendar> getDateCalendar(@RequestBody Calendar cal) {
		return service.getDateCalendar(cal);
	}
	
	// 캘랜더 휴관일, 행사 일정 가져오기
	@GetMapping(value="/getHECal", produces = "application/json; charset=UTF-8")
	public List<Calendar> getHECal(){
		return service.getHECal();
	}
	
	// 특정일 휴관일, 행사 일정 가져오기
	@GetMapping(value="/selectGetDate", produces = "application/json; charset=UTF-8")
	public List<Calendar> selectGetDate(String date){
		return service.selectGetDate(date);
	}
	
}