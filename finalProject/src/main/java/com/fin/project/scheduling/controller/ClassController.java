package com.fin.project.scheduling.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fin.project.member.model.dto.Member;
import com.fin.project.scheduling.model.dto.ClassSchedule;
import com.fin.project.scheduling.model.service.ClassService;



@SessionAttributes("loginMember")
@Controller
@RequestMapping("/scheduling")
public class ClassController {

	@Autowired
	private ClassService service;

	// 게시글 목록 조회
	@GetMapping("/{cateCode:12}")
	public String selectBoardList(@PathVariable("cateCode") int cateCode,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp, Model model,
			@RequestParam Map<String, Object> paramMap) {

		if (paramMap.get("query") == null) { // 검색X

			// 게시글 목록 조회 서비스 호출
			Map<String, Object> map = service.selectClassBoard(cateCode, cp);

			// 조회 결과를 request scope에 세팅 후 forward
			model.addAttribute("map", map);

		} else { // 검색O
			paramMap.put("cateCode", cateCode);
			Map<String, Object> map = service.selectClassBoard(paramMap, cp);

			model.addAttribute("map", map);
		}
		return "scheduling/classBoard";
	}

	// 게시글 상세 조회
	@GetMapping("/{cateCode}/{boardNo}")
	public String classDetail(@PathVariable("cateCode") int cateCode, @PathVariable("boardNo") int boardNo, Model model,
			@SessionAttribute(value = "loginMember", required = false) Member loginMember,
			 @RequestParam(value = "cp", defaultValue = "1") int cp) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cateCode", cateCode);
		map.put("boardNo", boardNo);
		map.put("loginMember", loginMember);

		// 게시글 상세 조회 서비스 호출
		ClassSchedule classBoard = service.selectClass(map);
		
		model.addAttribute("cp", cp);
		model.addAttribute("classBoard", classBoard);

		return "scheduling/classDetail";

	}

	// 클래스 작성 페이지
	@GetMapping("/{cateCode:12}/insert")
	public String classInsert(@PathVariable("cateCode") int cateCode) {

		return "scheduling/classWrite";

	}

	// 클래스 작성
	@PostMapping("/{cateCode:12}/insert")
	public String boardInsert(@PathVariable("cateCode") int cateCode, @ModelAttribute ClassSchedule classSchedule,
			@RequestParam(value = "image", required = false) MultipartFile image,
			@RequestParam(value = "existingImage", required = false) String existingImage,HttpSession session,
			@SessionAttribute("loginMember") Member loginMember) throws IllegalStateException, IOException {

		classSchedule.setMemberNo(loginMember.getMemberNo());

		classSchedule.setCateCode(cateCode);

		// 업로드된 이미지 서버에 실제로 저장되는 경로 + 웹에서 요청 시 이미지를 볼 수 있는 경로(웹 접근 경로)
		String webPath = "/resources/images/scheduling/";
		String filePath = session.getServletContext().getRealPath(webPath);
		
		
		// 게시글 삽입 서비스 호출 후 삽입된 게시글 번호(boardNo) 반환 받기
		int boardNo = service.classInsert(classSchedule, image, webPath, filePath);

		String path = "redirect:";

		if (boardNo > 0) { // 게시글 성공 시

			path += "/scheduling/" + cateCode + "/" + boardNo;

		} else {

			path += "insert";

		}

		return path;
	}
	
	// 클래스 수정 화면 전환
	@GetMapping("/{cateCode:12}/{boardNo}/update")
	public String classUpdate(@PathVariable("cateCode") int cateCode
							  , @PathVariable("boardNo") int boardNo
							  , Model model // 데이터 전달용 객체(기본적으로 request scope)
							  ) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cateCode", cateCode);
		map.put("boardNo", boardNo);
		
		ClassSchedule classSchedule = service.selectClass(map);
		
		model.addAttribute("classSchedule", classSchedule);
		
		return "scheduling/classUpdate";
	}
	
	// 클래스 수정
	@PostMapping("/{cateCode:12}/{boardNo}/update")
	public String classUpdate(ClassSchedule classSchedule //커맨드 객체
			, @RequestParam(value="deleteList", required=false) String deleteList // 삭제할 이미지
			, @RequestParam(value="cp", required=false, defaultValue="1") int cp // 쿼리 스트링 유지
			, @RequestParam(value="image", required=false) MultipartFile image // 업로드된 이미지
			, @PathVariable("cateCode") int cateCode
			, @PathVariable("boardNo") int boardNo
			, HttpSession session // 서버 파일 저장 경로 얻어올 용도 
				)throws IllegalStateException, IOException {
		
		classSchedule.setCateCode(cateCode);
		classSchedule.setBoardNo(boardNo);
		
		
		String webPath = "/resources/images/scheduling/";
		String filePath = session.getServletContext().getRealPath(webPath);
		
		// 클래스 수정 서비스 호출
		int rowCount = service.classUpdate(classSchedule, image, webPath, filePath, deleteList);
		
		String path = "redirect:";
		
		if(rowCount > 0) {
			path += "/scheduling/"+cateCode+"/"+boardNo+"?cp="+cp;
		} else {
			path += "update";
		}
		
		return path;
	}

	// 클래스 삭제  
	@GetMapping("/{cateCode}/{boardNo}/delete")
	public String boardDelete(@PathVariable("cateCode") int cateCode,
							  @PathVariable("boardNo") int boardNo,
							  @RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cateCode", cateCode);
		map.put("boardNo", boardNo);

		int result = service.classDelete(map);

		String path = "redirect:";

		if (result > 0) {
			path += "/scheduling/" + cateCode;

		} else {
			path += "/scheduling/" + cateCode + "/" + boardNo + "?cp=" + cp;
		}

		return path;
	}
	
	// 클래스 신청
	@PostMapping("/12/{boardNo}/apply")
	@ResponseBody
	public Map<String, Object> applyClass(
	        @PathVariable("boardNo") int boardNo,
	        @SessionAttribute("loginMember") Member loginMember,
	        @RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {
	    
	    Map<String, Object> map = new HashMap<>();
	    map.put("boardNo", boardNo);
	    map.put("memberNo", loginMember.getMemberNo());
	    map.put("cp", cp); // cp 값 추가

	    // 클래스를 신청하고 결과를 받음
	    int result = service.applyClass(map);

	    // 응답 결과를 담을 Map 생성
	    Map<String, Object> response = new HashMap<>();
	    if (result > 0) {
	        // 신청 성공
	        response.put("status", "success");
	    } else {
	        // 신청 실패 (이미 신청한 경우)
	        response.put("status", "error");
	    }

	    // JSON 형태로 응답 반환
	    return response;
	}
	
	
	

	@GetMapping("/{cateCode:13}")
	public String SeatGuide() {
		return "scheduling/study";
	}

	@GetMapping("/{cateCode:14}")
	public String SeminarGuide() {
		return "scheduling/seminar";
	}

}
