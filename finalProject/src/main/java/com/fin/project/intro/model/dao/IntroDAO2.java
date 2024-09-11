package com.fin.project.intro.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.intro.model.dto.Calendar;

@Repository
public class IntroDAO2 {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 일정중 클래스 일정 가져오는 DAO
	 * @param type
	 * @return event
	 */
	public List<Calendar> getCalendarClass(int type) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("introMapper.getCalendarClass", type);
	}

	/** 일정중 타입별로 가져오는 DAO
	 * @param type
	 * @return event
	 */
	public List<Calendar> getTypeCalendar(int type) {
		return sqlSession.selectList("introMapper.getTypeCalendar", type);
	}

	/** 일정중 클래스 특정일 일정을 가져오는 DAO
	 * @param cal
	 * @return
	 */
	public List<Calendar> getDateClass(Calendar cal) {
		return sqlSession.selectList("introMapper.getDateClass", cal);
	}

	/** 일정중 타입별로 특정일 일정을 가져오는 DAO
	 * @param cal
	 * @return
	 */
	public List<Calendar> getDateCalendar(Calendar cal) {
		return sqlSession.selectList("introMapper.getDateCalendar", cal);
	}

	/** 캘랜더에서 휴관일, 행사 일정 가져오기 DAO
	 * @return eventList
	 */
	public List<Calendar> getHECal() {
		return sqlSession.selectList("introMapper.getHECal");
	}

	/** 특정일 휴관일, 행사 일정 가져오기 DAO
	 * @param date
	 * @return result
	 */
	public List<Calendar> selectGetDate(String date) {
		return sqlSession.selectList("introMapper.selectGetDate", date);
	}

	/** 특정 일정 삭제 DAO
	 * @param calNo
	 * @return result
	 */
	public int deleteShedule(int calNo) {
		return sqlSession.delete("introMapper.deleteShedule", calNo);
	}

	/** 특정 일정 추가 DAO
	 * @param insertCal
	 * @return result
	 */
	public int insertShedule(Calendar insertCal) {
		// TODO Auto-generated method stub
		return sqlSession.insert("introMapper.insertShedule", insertCal);
	}

	/** 특정 일정 수정 DAO
	 * @param updateCal
	 * @return result
	 */
	public int updateShedule(Calendar updateCal) {
		return sqlSession.update("introMapper.updateShedule", updateCal);
	}

}
