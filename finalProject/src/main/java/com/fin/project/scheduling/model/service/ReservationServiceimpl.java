package com.fin.project.scheduling.model.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.project.scheduling.model.dao.ReservationDAO;
import com.fin.project.scheduling.model.dto.ReservationPlace;

@Service
public class ReservationServiceimpl implements ReservationService{
	
	@Autowired
	private ReservationDAO dao;
	
	// 좌석 조회
	@Override
	public List<ReservationPlace> selectSeats(Map<String, Object> paramMap) {
		return dao.selectSeats(paramMap);
	}

	
	// 좌석 예약
	@Override
	public int insertSeat(Map<String, Object> bookMap) {
		
		 int result = dao.insertSeat(bookMap);
		
		return result;
	}

	// 해당 날짜 시간 슬롯 조회
	@Override
	public List<Map<String, Object>> selectTimeSlots(String date) {
		
		return dao.selectTimeSlots(date);
	}

	// 세미나실 예약
	@Override
	public int insertSeminar(ReservationPlace request) {
		
		return dao.insertSeminar(request);
	}



}
