package com.fin.project.scheduling.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.scheduling.model.dto.ReservationPlace;

@Repository
public class ReservationDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * 좌석 조회(예약석, 공석)
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<ReservationPlace> selectSeats(Map<String, Object> paramMap) {

		return sqlSession.selectList("reservationMapper.selectSeats", paramMap);
	}

	/**좌석 예약
	 * @param bookMap
	 * @return
	 */
	public int insertSeat(Map<String, Object> bookMap) {

		return sqlSession.insert("reservationMapper.insertSeat", bookMap);
	}

	/**해당 날짜 시간 슬롯 조회
	 * @param date
	 * @return
	 */
	public List<Map<String, Object>> selectTimeSlots(String date) {
		
		return sqlSession.selectList("reservationMapper.selectTimeSlots", date);
	}

	/**세미나실 예약
	 * @param request
	 * @return
	 */
	public int insertSeminar(ReservationPlace request) {
		
		return sqlSession.insert("reservationMapper.insertSeminar", request);
	}

}
