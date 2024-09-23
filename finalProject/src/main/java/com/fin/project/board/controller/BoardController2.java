package com.fin.project.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@GetMapping("/{cateCode:15|16|18}/insert")
	public String boardInsert(@PathVariable("cateCode") int cateCode) {
		
		if(cateCode == 16) {
			return "board/qnaWrite";
		}
		
		return "board/boardWrite";
	}

	// 게시글 작성
	@PostMapping("/{cateCode:15|16|18}/insert")
	public String boardInsert(@PathVariable("cateCode") int cateCode,
							  @SessionAttribute("loginMember") Member loginMember,
							  @RequestParam(value="images", required=false) List<MultipartFile> images,
							  Board board, HttpSession session, RedirectAttributes ra
							  ) throws IOException, IllegalStateException {

		board.setMemberNo(loginMember.getMemberNo());

		board.setCateCode(cateCode);

		String webPath = "/resources/images/board/";
		String filePath = session.getServletContext().getRealPath(webPath);

		int boardNo = service.boardInsert(board, images, webPath, filePath);

		String path = "redirect:";
		String message = null;

		if(boardNo > 0) {
			path += "/board/" + cateCode + "/" + boardNo;
			message = "게시글이 등록되었습니다.";

		}else {
			path += "insert";
			message = "게시글 등록에 실패하였습니다.";
		}

		ra.addFlashAttribute("message", message);

		return path;
	}
	
	
	// 게시글 수정 화면 전환
	@GetMapping("/{cateCode:15|16|18}/{boardNo}/update")
	public String boardUpdate(@PathVariable("cateCode") int cateCode,
							  @PathVariable("boardNo") int boardNo,
							  Model model) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cateCode", cateCode);
		map.put("boardNo", boardNo);
		
		Board board = boardService.selectBoard(map);
		
		model.addAttribute("board", board);
		
		if(cateCode == 16) {
			
			return "board/qnaUpdate";
		}
		
		return "board/boardUpdate";
		
	}

	// 게시글 수정
	@PostMapping("{cateCode:15|16|18}/{boardNo}/update")
	public String boardUpdate(@PathVariable("cateCode") int cateCode,
							  @PathVariable("boardNo") int boardNo,
							  @RequestParam(value="cp", required=false, defaultValue="1") int cp,
						      @RequestParam(value="deleteList", required=false, defaultValue="") String deleteList,
							  @RequestParam(value="images", required=false) List<MultipartFile> images,
							  Board board, HttpSession session, RedirectAttributes ra,
							  @SessionAttribute("loginMember") Member loginMember) 
							  throws IllegalStateException, IOException {

		board.setBoardNo(boardNo);
		board.setCateCode(cateCode);

		String webPath = "/resources/images/board/";
		String filePath = session.getServletContext().getRealPath(webPath);

		boardNo = service.boardUpdate(board, images, webPath, filePath, deleteList);

		String path = "redirect:";
		String message = null;

		if(boardNo > 0) {
			path += "/board/" + cateCode + "/" + board.getBoardNo() + "?cp=" + cp;
			message = "게시글이 수정되었습니다.";

		}else {
			path += "update";
			message = "게시글 수정에 실패하였습니다.";
		}

		ra.addFlashAttribute("message", message);

		return path;

	}
	
	// 게시글 삭제
	@GetMapping("/{cateCode:15|16|18}/{boardNo}/delete")
	public String boardDelete(@PathVariable("cateCode") int cateCode,
							  @PathVariable("boardNo") int boardNo,
							  @RequestParam(value="cp", required=false, defaultValue="1") int cp,
							  RedirectAttributes ra) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cateCode", cateCode);
		map.put("boardNo", boardNo);
		
		int result = service.boardDelete(map);
		
		String path = "redirect:";
		String message = null;
		
		if(result > 0) {
			path += "/board/" + cateCode;
			message = "게시글이 삭제되었습니다.";
			
		}else {
			path += "/board/" + cateCode + "/" + boardNo + "?cp=" + cp;
			message = "게시글 삭제에 실패했습니다.";
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}


}
