package com.fin.project.scheduling.model.service;

import java.util.List;
import java.util.Map;

import com.fin.project.scheduling.model.dto.ReservationPlace;

public interface ReservationService {

	/** 좌석 조회(예약석, 공석)
	 * @param paramMap
	 * @return
	 */
	List<ReservationPlace> selectSeats(Map<String, Object> paramMap);

	/** 좌석 예약
	 * @param bookMap
	 * @return
	 */
	int insertSeat(Map<String, Object> bookMap);

	/** 세미나실 해당 날짜 시간 슬롯 조회
	 * @param date
	 * @return
	 */
	List<Map<String, Object>> selectTimeSlots(String date);
	

	/**세미나실 예약
	 * @param request
	 * @return
	 */
	int insertSeminar(ReservationPlace request);


}
