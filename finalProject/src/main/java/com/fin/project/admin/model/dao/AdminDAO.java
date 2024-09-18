package com.fin.project.admin.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.project.board.model.dto.Board;
import com.fin.project.board.model.dto.Comment;
import com.fin.project.board.model.dto.Pagination;
import com.fin.project.member.model.dto.Member;

@Repository
public class AdminDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int getMemberCount() {
		return sqlSession.selectOne("memberMapper.getMemberCount");
	}
	
	public List<Member> selectMemberList(Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("memberMapper.selectMemberList", null, rowBounds);
	}

	public int member(String updateList) {
		return sqlSession.update("adminMapper.updateMember", updateList);
	}

	public int getboardCount() {
		return sqlSession.selectOne("boardMapper.getBoardCount");
	}

	public List<Board> selectboardList(Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("boardMapper.selectBoardListAdmin", null, rowBounds);
	}

	public int board(String updateList) {
		return sqlSession.update("adminMapper.updateBoard", updateList);
	}

	public int getCommentCount() {
		return sqlSession.selectOne("boardMapper.getCommentCount");
	}

	public List<Comment> selectCommentList(Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("boardMapper.selectCommentList", null, rowBounds);
	}

	public int comment(String updateList) {
		return sqlSession.update("adminMapper.updateComment", updateList);
	}

}
