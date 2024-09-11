package com.fin.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.board.model.dto.Board;
import com.fin.project.board.model.dto.Pagination;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	/** 특정 게시판의 삭제되지 않은 게시글 수 조회 dao
	 * @param cateCode
	 * @return 
	 */
	public int getListCount(int cateCode) {
		return sqlSession.selectOne("boardMapper.getListCount", cateCode);
	}


	/** 특정 게시판에서 현재 페이지에 해당하는 부분에 대한 게시글 목록 조회 dao
	 * @param cateCode
	 * @param pagination
	 * @return boardList
	 */
	public List<Board> selectBoardList(int cateCode, Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowbounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("boardMapper.selectBoardList", cateCode, rowbounds);
	}


	/** 게시글 상세 조회 dao
	 * @param map
	 * @return result
	 */
	public Board selectBoard(Map<String, Object> map) {
		
		return sqlSession.selectOne("boardMapper.selectBoard", map);
	}


	/** 조회수 증가 dao
	 * @param boardNo
	 * @return result
	 */
	public int increaseReadCount(int boardNo) {
		
		return sqlSession.update("boardMapper.increaseReadCount", boardNo);
	}


	/** 게시글 수 조회(검색)
	 * @param paramMap
	 * @return
	 */
	public int getListCount(Map<String, Object> paramMap) {
		
		return sqlSession.selectOne("boardMapper.getListSearchCount", paramMap);
	}


	/** 게시글 목록 조회(검색)
	 * @param paramMap
	 * @param pagination
	 * @return
	 */
	public List<Board> selectBoardList(Map<String, Object> paramMap, Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowbounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("boardMapper.selectBoardSearchList", paramMap, rowbounds);
	}

	


}
