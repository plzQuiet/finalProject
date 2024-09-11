package com.fin.project.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.board.model.dto.Board;
import com.fin.project.board.model.dto.BoardImage;

@Repository
public class BoardDAO2 {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 게시글 삽입 dao
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

}
