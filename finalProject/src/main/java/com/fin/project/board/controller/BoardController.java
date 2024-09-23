package com.fin.project.board.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fin.project.board.model.dto.Board;
import com.fin.project.board.model.service.BoardService;
import com.fin.project.member.model.dto.Member;

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
	 * 수정 : /board2/15/320/update (no == BOARD_NO, 게시글 번호)
	 * 삭제 : /board2/15/320/delete
	 * */ 
	
	// 게시글 목록 조회
	// 공지사항, 문의사항, 책 후기 나눠요
	@GetMapping("/{cateCode:15|16|18}")
	public String selectBoardList(@PathVariable("cateCode") int cateCode,
			 					  @RequestParam(value="query", required=false) String query,
			 					  @RequestParam(value="keyword", required=false) String keyword,
								  @RequestParam(value="cp", required=false, defaultValue = "1") int cp,
								  Model model,
								  @RequestParam Map<String, Object> paramMap
								  ) {
		
		
		if(query != null && keyword != null) { 
			Map<String, Object> map = service.selectBoardList(cateCode, cp, query, keyword);
			model.addAttribute("map", map);
			
		}else {
			paramMap.put("cateCode", cateCode);
			
			Map<String, Object> map = service.selectBoardList(paramMap, cp);
			model.addAttribute("map", map);
		}
		
		return "board/boardList";
	}
	
	
	// 자주 묻는 질문
	@GetMapping("/{cateCode:17}")
	public String faqList(@PathVariable("cateCode") int cateCode) {
		return "board/faq";
	}

	// 게시글 상세 조회(조회수/검색)
	@GetMapping("/{cateCode:15|16|18}/{boardNo}")
	public String boardDetail(@PathVariable("cateCode") int cateCode,
							  @PathVariable("boardNo") int boardNo,
							  Model model, RedirectAttributes ra,
							  @SessionAttribute(value="loginMember", required=false) Member loginMember,
							  HttpServletRequest req, 
							  HttpServletResponse resp) throws ParseException {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cateCode", cateCode);
		map.put("boardNo", boardNo);
	
		Board board = service.selectBoard(map);
		
		String path = null;
		
		if(board != null) {
			
			if(board.getBoardSecretFlag().equals("Y")) {
				
				if(loginMember == null || board.getMemberNo() != loginMember.getMemberNo() && loginMember.getAuthority() == 1) {
					path =  "redirect:/board/" + cateCode;
					
					ra.addFlashAttribute("message", "작성자만 확인할 수 있습니다.");
					
					return path;
				}
			}
			
			if(loginMember != null) {
				map.put("memberNo", loginMember.getMemberNo());
			}

			if(loginMember == null || loginMember.getMemberNo() != board.getMemberNo()) {

				Cookie c = null;

				Cookie[] cookies = req.getCookies();
				 
				if(cookies != null) {
					
					for(Cookie cookie : cookies) {
						if(cookie.getName().equals("readBoardNo")) {
							c = cookie;
							break;
						}
					}
				}
		
				int result = 0;
				
				if(c == null) {
					
					c = new Cookie("readBoardNo", "|" + boardNo + "|");
					
					result = service.increaseReadCount(boardNo);
					
				}else { 
					
					if(c.getValue().indexOf("|" + boardNo + "|") == - 1) {
						
						c.setValue(c.getValue() + "|" + boardNo + "|");
						
						result = service.increaseReadCount(boardNo);
					}
					
				} 
				
				if(result > 0) {
					
					board.setReadCount(board.getReadCount() + 1);
					
					c.setPath("/");
					
					Calendar cal = Calendar.getInstance();
					cal.add(cal.DATE, 1); 
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
					
					Date now = new Date();
					
					Date temp = new Date(cal.getTimeInMillis()); 
					
					Date tmr = sdf.parse(sdf.format(temp)); 
	
					long differ = (tmr.getTime() - now.getTime()) / 1000;
					
					c.setMaxAge((int)differ); 
					
					resp.addCookie(c); 
				}
			} 
			
			path = "board/boardDetail";
			model.addAttribute("board", board);
		
		}else { 
			path =  "redirect:/board/" + cateCode;
			
			ra.addFlashAttribute("message", "해당 게시글 번호가 없습니다.");
		
		}
		
		return path;
	}
	


}
