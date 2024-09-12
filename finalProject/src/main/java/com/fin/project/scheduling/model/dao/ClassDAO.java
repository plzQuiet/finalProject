package com.fin.project.scheduling.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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


}
