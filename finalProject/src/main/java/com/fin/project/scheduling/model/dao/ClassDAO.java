package com.fin.project.scheduling.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.scheduling.model.dto.BoardImage;
import com.fin.project.scheduling.model.dto.ClassSchedule;
import com.fin.project.scheduling.model.dto.Pagination;

@Repository
public class ClassDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**게시글 상태 N인 게시판 게시글 수 조회
	 * @param cateCode
	 * @return
	 */
	public int getListCount(int cateCode) {
		
		return sqlSession.selectOne("classMapper.getListCount", cateCode);
	}

	/** 특정 게시판에서 현재 페이지에 해당하는 부분에 대한 게시글 목록 조회
	 * @param cateCode
	 * @param pagination
	 * @return
	 */
	public List<ClassSchedule> selectClassBoard(int cateCode, Pagination pagination) {
		
		int offset = (pagination.getCurrentPage()-1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit()); 
		
		return sqlSession.selectList("classMapper.selectClassBoard", cateCode, rowBounds);
	}

	/** 게시글 상태 N인 게시판 게시글 수 조회 + 검색
	 * @param paramMap
	 * @return
	 */
	public int getListCount(Map<String, Object> paramMap) {
		
		return sqlSession.selectOne("classMapper.getListCountForSearch", paramMap);
	}

	/** 특정 게시판에서 현재 페이지에 해당하는 부분에 대한 게시글 목록 조회 + 검색
	 * @param paramMap
	 * @param pagination
	 * @return
	 */
	public List<ClassSchedule> selectClassBoard(Map<String, Object> paramMap, Pagination pagination) {
		
		int offset = (pagination.getCurrentPage()-1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("classMapper.selectBoardListForSearch",paramMap,rowBounds);

	}

	/** 클래스 상세 조회
	 * @param map
	 * @return
	 */
	public ClassSchedule selectClass(Map<String, Object> map) {
		
		return sqlSession.selectOne("classMapper.selectClass", map);
	}

	/** 클래스 작성(일정, 이미지 제외)
	 * @param classSchedule
	 * @return 
	 */
	public int classInsert(ClassSchedule classSchedule) {
		
		int result = sqlSession.insert("classMapper.classInsert", classSchedule);
		
		if(result>0) {
			result = classSchedule.getBoardNo();
		}
		
		return result;
	}

	/** 클래스 '일정' 작성
	 * @param classSchedule
	 * @return
	 */
	public int insertClassSchedule(ClassSchedule classSchedule) {
		
		return sqlSession.insert("classMapper.insertClassSchedule", classSchedule);
		
	}
	
	
	/** 클래스 '이미지' 작성 (이미지 1개)
	 * @param boardImage
	 * @return
	 */
	public int insertClassImage(BoardImage img) {
		
		return sqlSession.insert("classMapper.insertClassImage", img);
	}

	public int classDelete(Map<String, Object> map) {
		
		return sqlSession.update("classMapper.classDelete", map);
	}

	/** 클래스 신청
	 * @param map
	 * @return
	 */
	public int applyClass(Map<String, Object> map) {
		
		return sqlSession.insert("classMapper.applyClass", map);
	}

	/** 클래스 신청 중복 체크
	 * @param map
	 * @return
	 */
	public boolean checkApplyClass(Map<String, Object> map) {
		
		int count = sqlSession.selectOne("classMapper.checkApplyClass", map);
		
		return count>0; // count>0 : true, 아니면 false
	}
	
	
	/** 클래스 수정(일정, 이미지 제외)
	 * @param classSchedule
	 * @return
	 */
	public int classUpdate(ClassSchedule classSchedule) {
		
		return sqlSession.update("classMapper.classUpdate",classSchedule);
	}

	/** 클래스'일정' 수정
	 * @param classSchedule
	 * @return
	 */
	public int updateClassSchedule(ClassSchedule classSchedule) {
		
		return sqlSession.update("classMapper.updateClassSchedule",classSchedule);
	}

	/** 클래스 '이미지' 삭제
	 * @param deleteMap
	 * @return
	 */
	public int imageDelete(Map<String, Object> deleteMap) {
		
		return sqlSession.delete("classMapper.imageDelete", deleteMap);
	}

	/**클래스 '이미지' 수정
	 * @param img
	 * @return
	 */
	public int updateClassImage(BoardImage img) {
		
		return sqlSession.update("classMapper.updateClassImage", img);
	}
	
	
	/**클래스 이미지 리스트 삽입
	 * @param uploadList
	 * @return
	 */
	public int insertClassImageList(List<BoardImage> uploadList) {
		
		return sqlSession.insert("classMapper.insertClassImageList", uploadList);
	}


	


}
