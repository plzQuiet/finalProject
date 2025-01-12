package com.fin.project.intro.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fin.project.intro.model.dao.IntroDAO2;
import com.fin.project.intro.model.dto.Calendar;

@Service
public class IntroServiceImpl2 implements IntroService2 {
	
	@Autowired
	private IntroDAO2 dao;

	// 캘랜더에서 type 별로 가져오기 서비스
	@Override
	public List<Calendar> getTypeCalendar(int type) {
		
		if(type == 4) {
			return dao.getCalendarClass(type);
		}
		
		return dao.getTypeCalendar(type);
	}

	// 캘랜더에서 type 별로 특정일 일정 가져오기 서비스
	@Override
	public List<Calendar> getDateCalendar(Calendar cal) {
		
		if(cal.getCalendarType() == 4) {
			return dao.getDateClass(cal);
		}
		return dao.getDateCalendar(cal);
	}

	// 캘랜더에서 휴관일, 행사 일정 가져오기 서비스
	@Override
	public List<Calendar> getHECal() {
		return dao.getHECal();
	}

	// 특정일 휴관일, 행사 일정 가져오기 서비스
	@Override
	public List<Calendar> selectGetDate(String date) {
		return dao.selectGetDate(date);
	}

	// 특정 일정 삭제 서비스
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteShedule(int calNo) {
		return dao.deleteShedule(calNo);
	}

	// 특정 일정 추가 서비스
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertShedule(Calendar insertCal) {
		return dao.insertShedule(insertCal);
	}

	// 특정 일정 수정 서비스
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateShedule(Calendar updateCal) {
		return dao.updateShedule(updateCal);
	}

}
