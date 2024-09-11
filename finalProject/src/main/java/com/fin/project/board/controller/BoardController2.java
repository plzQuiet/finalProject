package com.fin.project.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fin.project.board.model.dto.Board;
import com.fin.project.board.model.service.BoardService;
import com.fin.project.board.model.service.BoardService2;
import com.fin.project.member.model.dto.Member;

@SessionAttributes({"loginMember"})
@RequestMapping("/board2")
@Controller
public class BoardController2 {
	
	/* ** 컨트롤러 따로 사용 예정 **
	 * 삽입 : /board2/insert?code=1 (code == CAT_CODE, 게시판 종류)
	 * 수정 : /board2/15/320/update (no == BOARD_NO, 게시글 번호)
	 * 삭제 : /board2/15/320/delete
	 * */ 
	
	@Autowired
	private BoardService2 service;
	
	@Autowired
	private BoardService boardService;
	
	// 게시글 작성 화면 전환 
	// cateCode: 15,18
	@GetMapping("/{cateCode:15|18}/insert")
	public String boardInsert(@PathVariable("cateCode") int cateCode) {
		return "board/boardWrite";
	}
	
	// 게시글 작성 화면 전환 
	// cateCode: 16 
	@GetMapping("{cateCode:16}/insert")
	public String qnaInsert() {
		return "board/qnaWrite";
	}
	
	// 게시글 작성
	@PostMapping("/{cateCode:15|18}/insert")
	public String boardInsert(@PathVariable("cateCode") int cateCode,
							  @SessionAttribute("loginMember") Member loginMember,
							  @RequestParam(value="images", required=false) List<MultipartFile> images,
							  Board board, HttpSession session, RedirectAttributes ra
							  ) throws IOException, IllegalStateException {
		
		board.setMemberNo(loginMember.getMemberNo());
		
		board.setCateCode(cateCode);
		
		String webPath = "/resources/images/board";
		String filePath = session.getServletContext().getRealPath(webPath);
		
		int boardNo = service.boardInsert(board, images, webPath, filePath);
		
		return null;
	}
	

}
