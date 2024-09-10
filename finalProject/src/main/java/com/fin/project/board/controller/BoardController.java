package com.fin.project.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	// 공지사항, 문의사항, 책 후기 나눠요
	@GetMapping("/{cateCode:15|16|18}")
	public String selectBoardList(@PathVariable("cateCode") int cateCode,
								  @RequestParam(value="cp", required=false, defaultValue = "1") int cp,
								  Model model,
								  @RequestParam Map<String, Object> paramMap
								  ) {
		
//		System.out.println("cateCode : " + cateCode);
		
		if(paramMap.get("key") == null) { // 검색어 미 입력 == 검색 X 
			
			Map<String, Object> map = service.selectBoardList(cateCode, cp);
			
			model.addAttribute("map", map);
			
		}else { // 검색어 입력
			paramMap.put("cateCode", cateCode);
			
			Map<String, Object> map = service.selectBoardList(paramMap, cp);
			model.addAttribute("map", map);
		}
		
		return "board/boardList";
	}
	
	
	// 자주 묻는 질문
	@GetMapping("/17")
	public String faqList() {
		return "board/faq";
	}
	

	
	
	
	
	// 게시글 상세 조회(조회수, 검색)


}
