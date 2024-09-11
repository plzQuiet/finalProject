package com.fin.project.intro.model.service;

import java.util.List;

import com.fin.project.intro.model.dto.Calendar;

public interface IntroService2 {

	/** 캘랜더 타입별로 가져오기 Service
	 * @param type
	 * @return eventList
	 */
	List<Calendar> getTypeCalendar(int type);

	/** 캘랜더 타입별로 특정일 가져오기 Service
	 * @param cal
	 * @return result
	 */
	List<Calendar> getDateCalendar(Calendar cal);

	/** 캘랜더 휴관일, 행사 가져오기 Service
	 * @return eventList
	 */
	List<Calendar> getHECal();

	/** 특정일 휴관일, 행사 가져오기 Service
	 * @param date
	 * @return
	 */
	List<Calendar> selectGetDate(String date);

	/** 특정 일정 삭제
	 * @param calNo
	 * @return result
	 */
	int deleteShedule(int calNo);

	/** 특정 일정 추가
	 * @param insertCal
	 * @return result
	 */
	int insertShedule(Calendar insertCal);

	/** 특정일 일정 수정
	 * @param updateCal
	 * @return result
	 */
	int updateShedule(Calendar updateCal);

}
