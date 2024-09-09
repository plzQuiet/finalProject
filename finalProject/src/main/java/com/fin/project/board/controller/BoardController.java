package com.fin.project.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fin.project.board.model.service.BoardService;

@SessionAttributes("loginMember")
@RequestMapping("/board")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	/* 목록 조회 : /board/15?cp=1 (cp: current page (현재 페이지))
	 * 상세 조회 : /board/15/200?cp=1
	 * 
	 * ** 컨트롤러 따로 사용 예정 **
	 * 삽입 : /board2/insert?code=1 (code == CAT_CODE, 게시판 종류)
	 * 수정 : /board2/15/200/update (no == BOARD_NO, 게시글 번호)
	 * 삭제 : /board2/15/200/delete
	 * */ 
	
	// 게시글 목록 조회
	@GetMapping("/{cateCode:(15|16|18)}")
	public String selectBoardList(@PathVariable("cateCode") int cateCode) {
		
		
		return null;
		
	}
	
	// 게시글 상세 조회(조회수, 검색)


}
