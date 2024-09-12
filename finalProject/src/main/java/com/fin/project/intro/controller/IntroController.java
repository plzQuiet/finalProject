package com.fin.project.intro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fin.project.board.model.dto.Board;
import com.fin.project.board.model.dto.BoardImage;
import com.fin.project.intro.model.dto.LibAnother;
import com.fin.project.intro.model.service.IntroService;
import com.fin.project.member.model.dto.Member;

@Controller
@RequestMapping("/intro")
@SessionAttributes("loginMember")
public class IntroController {
	
	@Autowired
	private IntroService service;
	
	@GetMapping("/{catLevel1:1}")
	public String gotoPage(@PathVariable("catLevel1") int catLevel1,
			Model model
			) {
		model.addAttribute("catLevel2", 7);
		model.addAttribute("catLevel3", 24);
		
		return "intro/lib_greeting";
	}
	
	@GetMapping("/{catLevel1:1}/{catLevel2}")
	public String intro(@PathVariable("catLevel1") int catLevel1, 
			@PathVariable("catLevel2") int catLevel2,
			Model model) {
		
		if(catLevel2 == 9) {
			return "intro/lib_map";
		}
		
		model.addAttribute("catLevel3", 24);
		
		if(catLevel2 == 8) {
			model.addAttribute("catLevel3", 29);
			return "intro/lib_hours";
		}
		
		return "intro/lib_greeting";
	}
	
	@GetMapping("/{catLevel1:1}/{catLevel2}/{catLevel3}")
	public String pageIntro(@PathVariable("catLevel1") int catLevel1, 
			@PathVariable("catLevel2") int catLevel2,
			@PathVariable("catLevel3") int catLevel3,
			Model model) {
		
		if(catLevel3 == 30) {
			return "intro/lib_calender";
		}
		
		if(catLevel3 == 29) {
			return "intro/lib_hours";
		}
		
		if(catLevel3 == 28) {
			
			Map<String, Object> another = service.selectAnotherLib(catLevel3);
			List<Map<String, Object>> libTitle = new ArrayList<Map<String,Object>>();
			if(another != null) {
				libTitle = (List<Map<String, Object>>) another.get("libTitle");
			}
			
			if(!libTitle.isEmpty()) {
				System.out.println(libTitle);
				Map<String,Object> another2 = service.selectLibAn( catLevel3, Integer.parseInt( String.valueOf((libTitle.get(0).get("BOARD_NO")))) );
				model.addAttribute("another", another2);
				
			}else {
				model.addAttribute("another", another);
			}
			
			return "intro/lib_intro_another";
		}
		
		if(catLevel3 == 27) {
			return "intro/lib_intro";
		}
		
		if(catLevel3 == 26) {
			return "intro/lib_organization";
		}
		
		if(catLevel3 == 25) {
			return "intro/lib_history";
		}
		
		return "intro/lib_greeting";
	}
	
	// 주변 도서관 생성
	@PostMapping("/{catLevel1:1}/{catLevel2:7}/{catLevel3:28}/insert")
	public String insertAnotherLib(@PathVariable("catLevel1") int catLevel1, 
			@PathVariable("catLevel2") int catLevel2,
			@PathVariable("catLevel3") int catLevel3,
			Board board, LibAnother lib,
			@RequestParam(value = "images", required = false) List<MultipartFile> images,
			Model model,
			@SessionAttribute(value="loginMember", required=false) Member loginMember,
			RedirectAttributes ra,
			HttpSession session
			) throws Exception {
		
		board.setCateCode(catLevel3);
		
		board.setMemberNo(loginMember.getMemberNo());
		board.setMemberName(loginMember.getMemberName());
		
		System.out.println(board);
		System.out.println(lib);
		System.out.println(images);
		
		String webPath = "/resources/images/board/";
		String filePath = session.getServletContext().getRealPath(webPath);
		
		int result = service.insertAnLib(board, images, lib ,webPath, filePath);
		
		String path = "redirect:";
		String message = null;
		if(result > 0) {
			message = "주변 도서관이 등록 되었습니다.";
			path += "/intro/" + catLevel1+"/" + catLevel2 + "/" + catLevel3 + "/" + result;
			
		}else {
			message = "주변 도서관 등록을 실패했습니다.";
			path += "/intro/" + catLevel1+"/"+catLevel2 + "/" + catLevel3;
		}
		
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
	// 주변 도서관 상세
	@GetMapping("/{catLevel1:1}/{catLevel2:7}/{catLevel3:28}/{boardNo}")
	public String selectLibAn(@PathVariable("catLevel1") int catLevel1, 
			@PathVariable("catLevel2") int catLevel2,
			@PathVariable("catLevel3") int catLevel3,
			@PathVariable("boardNo") int boardNo,
			Model model) {
		
		Map<String, Object> another = service.selectLibAn(catLevel3, boardNo);
		
		model.addAttribute("another", another);
		
		return "intro/lib_intro_another";
		
	}
	
	// 주변 도서관 수정
	@PostMapping("/{catLevel1:1}/{catLevel2:7}/{catLevel3:28}/update/{boardCode}")
	public String updateLibAn(@PathVariable("catLevel1") int catLevel1, 
			@PathVariable("catLevel2") int catLevel2,
			@PathVariable("catLevel3") int catLevel3,
			@PathVariable("boardCode") int boardNo,
			Model model,
			Board board, LibAnother lib,
			@RequestParam(value="deleteList", required = false) String deleteList, // 삭제 이미지
			@RequestParam(value = "images", required = false) List<MultipartFile> images,
			@SessionAttribute(value="loginMember", required=false) Member loginMember,
			RedirectAttributes ra,
			HttpSession session) throws IllegalStateException, IOException {
		
		board.setCateCode(catLevel3);
		board.setBoardNo(boardNo);
		
		lib.setBoardNo(boardNo);
		
		String webPath = "/resources/images/board/";
		String filePath = session.getServletContext().getRealPath(webPath);
		
		int rowCount = service.libAnUpdate(board,webPath, filePath, lib, deleteList, images);
		
		String message = null;
		String path = "redirect:/intro/";
		if(rowCount > 0 ) {
			message = "주변 도서관 수정을 성공했습니다.";
			path += catLevel1+"/"+catLevel2 + "/" + catLevel3 + "/" + boardNo;
		}else {
			message = "주변 도서관 수정을 실패했습니다.";
			path += catLevel1+"/"+catLevel2 + "/" + catLevel3;
		}
		
		System.out.println(message);
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
	// 주변 도서관 삭제
	@GetMapping("/{catLevel1:1}/{catLevel2:7}/{catLevel3:28}/delete/{boardCode}")
	public String deleteLibAn(@PathVariable("catLevel1") int catLevel1, 
			@PathVariable("catLevel2") int catLevel2,
			@PathVariable("catLevel3") int catLevel3,
			@PathVariable("boardCode") int boardNo,
			RedirectAttributes ra) {
		int result = service.deleteLibAn(boardNo);
		
		String message = null;
		String path = "redirect:/intro/";
		if(result > 0) {
			message = "주변 도서관 삭제를 성공했습니다.";
			path += catLevel1+"/"+catLevel2 + "/" + catLevel3;
		}else {
			message = "주변 도서관 삭제를 실패했습니다.";
			path += catLevel1+"/"+catLevel2 + "/" + catLevel3 + "/" + boardNo;
		}
		
		System.out.println(message);
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
	// 주변 도서관 이미지 목록 조회 비동기
	@GetMapping(value="/getImageList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<BoardImage> getImageList(int boardNo) {
		
		return service.getImageList(boardNo);
		
	}
	
	// 일정 편집 페이지 이동
	@GetMapping("/{catLevel1:1}/{catLevel2:8}/{catLevel3:30}/calEdit")
	public String gotoEditCal(@PathVariable("catLevel1") int catLevel1, 
			@PathVariable("catLevel2") int catLevel2,
			@PathVariable("catLevel3") int catLevel3) {
		return "intro/lib_cal_edit";
	}

}
