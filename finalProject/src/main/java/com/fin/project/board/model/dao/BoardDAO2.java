package com.fin.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.board.model.dto.Board;
import com.fin.project.board.model.dto.BoardImage;

@Repository
public class BoardDAO2 {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 게시글 작성 dao
	 * @param board
	 * @return 
	 */
	public int boardInsert(Board board) {
		
		int result = sqlSession.insert("boardMapper.boardInsert", board);
		
		if(result > 0)	result = board.getBoardNo();
		
		return result;
	}

	/** 이미지 리스트 삽입 dao
	 * @param uploadList
	 * @return
	 */
	public int insertImageList(List<BoardImage> uploadList) {
		
		return sqlSession.insert("boardMapper.insertImageList", uploadList);
	}

	/** 게시글 수정
	 * @param board
	 * @return 
	 */
	public int boardUpdate(Board board) {
		
		return sqlSession.update("boardMapper.boardUpdate", board);
	}

	/** 이미지 삭제
	 * @param deleteMap
	 * @return
	 */
	public int imageDelete(Map<String, Object> deleteMap) {
		
		return sqlSession.delete("boardMapper.imageDelete", deleteMap);
	}

	/** 이미지 수정
	 * @param img
	 * @return
	 */
	public int imageUpdate(BoardImage img) {

		return sqlSession.update("boardMapper.imageUpdate", img);
	}

	/** 이미지 삽입
	 * @param img
	 * @return
	 */
	public int imageInsert(BoardImage img) {
		
		return sqlSession.insert("boardMapper.imageInsert", img);
	}

 	/** 게시글 삭제
	 * @param map
	 * @return
	 */
	public int boardDelete(Map<String, Object> map) {
		
		return sqlSession.update("boardMapper.boardDelete", map);
	} 

}
