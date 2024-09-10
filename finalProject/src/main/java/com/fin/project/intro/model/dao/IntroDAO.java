package com.fin.project.intro.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.board.model.dto.Board;
import com.fin.project.board.model.dto.BoardImage;
import com.fin.project.intro.model.dto.LibAnother;

@Repository
public class IntroDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/**카테고리 목록 가져오는 DAO
	 * @return category
	 */
	public List<Map<String, Object>> selectCategoryList() {
		return sqlSession.selectList("introMapper.selectCategoryList");
	}

	/** 다른 도서관 명 가져오는 DAO
	 * @param catLevel3
	 * @return libTitle
	 */
	public List<Map<String, Object>> getAnLibTitle(int catLevel3) {
		return sqlSession.selectList("introMapper.getAnLib", catLevel3);
	}

	/** 다른 도서관 삽입 및 boardNo DAO
	 * @param board
	 * @return boardNo
	 */
	public int anLibInsert(Board board) {
		int result = sqlSession.insert("introMapper.anLibInsert", board);
		
		if(result > 0) result = board.getBoardNo();
		return result;
	}

	/** 다른 도서관 이미지 삽입 DAO
	 * @param uploadList
	 * @return result
	 */
	public int insertImageList(List<BoardImage> uploadList) {
		return sqlSession.insert("introMapper.insertImageList", uploadList);
	}

	/** 다른 도서관 주소, 위도, 경도 삽입 DAO
	 * @param lib
	 * @return result
	 */
	public int insertLibAn(LibAnother lib) {
		return sqlSession.insert("introMapper.insertLibAn", lib);
	}

	/** 다른 도서관 상세 정보 DAO
	 * @param map
	 * @return
	 */
	public Board getAnLibBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("introMapper.getAnLibBoard", map);
	}

	/** 다른 도서관 주소, 위도, 경도 DAO
	 * @param map
	 * @return libAdd
	 */
	public LibAnother getAnAdd(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("introMapper.getAnAdd", map);
	}

	/** 다른 도서관 수정(제목, 내용) DAO
	 * @param board
	 * @return rowCount
	 */
	public int boardUpdate(Board board) {
		return sqlSession.update("introMapper.updateLibAn", board);
	}

	/** 다른 도서관 수정 시 이미지 삭제 DAO
	 * @param map
	 * @return rowCount
	 */
	public int deleteImageList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.delete("introMapper.deleteImageList", map);
	}

	/** 다른 도서관 수정시 이미지 update DAO 
	 * @param b
	 * @return rowCount
	 */
	public int imageUpdate(BoardImage b) {
		return sqlSession.update("introMapper.updateImage", b);
	}

	/** 다른 도서관 수정시 이미지 insert DAO
	 * @param b
	 * @return rowCount
	 */
	public int insertImage(BoardImage b) {
		return sqlSession.insert("introMapper.insertImage", b);
	}

	/** 주변 도서관 수정시 주소, 위도, 경도 DAO
	 * @param lib
	 * @return rowCount
	 */
	public int updateLibAdd(LibAnother lib) {
		return sqlSession.update("introMapper.updateLibAdd", lib);
	}

	/** 주변 도서관 삭제 DAO
	 * @param boardNo
	 * @return result
	 */
	public int deleteLibAn(int boardNo) {
		return sqlSession.update("introMapper.deleteLibAdd", boardNo);
	}

	/** 주변 도서관 imageList DAO
	 * @param boardNo
	 * @return imageList
	 */
	public List<BoardImage> getImageList(int boardNo) {
		return sqlSession.selectList("introMapper.selectImageList", boardNo);
	}

}
