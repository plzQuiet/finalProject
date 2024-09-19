package com.fin.project.scheduling.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fin.project.member.model.dto.Member;
import com.fin.project.scheduling.model.dto.ReservationPlace;
import com.fin.project.scheduling.model.service.ReservationService;

@SessionAttributes("loginMember")
@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService service;

	// 열람실 예약 페이지로 이동
	@GetMapping("/study")
	public String studyReservation() {

		return "scheduling/studyReservation";
	}

	// 좌석 조회(예약석, 공석)
	@PostMapping(value = "/study", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<ReservationPlace> selectSeats(@RequestBody Map<String, Object> paramMap) {

		String reservationDt = (String) paramMap.get("reservationDt");
		String start = (String) paramMap.get("startTime");
		String end = (String) paramMap.get("endTime");

		String startTime = reservationDt + " " + start;
		String endTime = reservationDt + " " + end;

		paramMap.put("startTime", startTime);
		paramMap.put("endTime", endTime);

		return service.selectSeats(paramMap);
	}

	// 좌석 예약
	@PostMapping(value = "/study/book", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> insertSeat(@RequestBody Map<String, Object> bookMap,
			@SessionAttribute(value = "loginMember", required = false) Member loginMember) {

		String reservationDt = (String) bookMap.get("reservationDt");
		String start = (String) bookMap.get("startTime");
		String end = (String) bookMap.get("endTime");

		String startTime = reservationDt + " " + start;
		String endTime = reservationDt + " " + end;

		bookMap.put("startTime", startTime);
		bookMap.put("endTime", endTime);

		bookMap.put("memberNo", loginMember.getMemberNo());

		// 서비스 호출하여 예약 처리
		int result = service.insertSeat(bookMap);

		// 결과를 담을 Map 생성
		Map<String, Object> response = new HashMap<>();
		response.put("result", result);

		return response;
	}

	// 세미나실 예약 페이지로 이동
	@GetMapping("/seminar")
	public String seminarReservation() {

		return "scheduling/seminarReservation";
	}

	// 세미나실 시간 슬롯 조회
	@GetMapping("/seminar/select")
	@ResponseBody
	public Map<String, Object> selectTimeSlots(@RequestParam("date") String date) {

		// 예약된 전체 시간 슬롯을 저장할 리스트
		List<String> bookedSlots = new ArrayList<>();

		// 시간을 30분 단위로 나누기 위한 포맷 설정
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		

		// 예약된 시간 슬롯 조회
		List<Map<String, Object>> results = service.selectTimeSlots(date);

		// 예약된 시간 슬롯을 기준으로 범위를 계산
		for (Map<String, Object> result : results) {
			
			
			String startTimeStr = (String) result.get("START_TIME");
			String endTimeStr = (String) result.get("END_TIME");
			
			if (startTimeStr == null || endTimeStr == null) {
				// startTimeStr 또는 endTimeStr이 null인 경우 로그를 남기고 계속 진행
				System.out.println("예약 시간 오류: 시작 시간 또는 종료 시간이 null입니다.");
				continue;
			}

			try {
				LocalDateTime startTime = LocalDateTime.parse(date + " " + startTimeStr, formatter);
				LocalDateTime endTime = LocalDateTime.parse(date + " " + endTimeStr, formatter);

				// 시작 시간부터 종료 시간까지 30분 단위로 예약된 시간 슬롯 추가
				while (!startTime.isAfter(endTime)) {
					String formattedTime = startTime.format(DateTimeFormatter.ofPattern("HH:mm"));
					bookedSlots.add(formattedTime);
					
					startTime = startTime.plusMinutes(30); // 30분 단위로 증가
				}
			} catch (DateTimeParseException e) {
				// 날짜 형식이 잘못된 경우 예외 처리
				System.out.println("시간 파싱 오류: " + e.getMessage());
			}
		}

		// 응답 맵 생성
		Map<String, Object> response = new HashMap<>();
		response.put("bookedSlots", bookedSlots);
		
		return response;
	}

	// 세미나실 예약
	@PostMapping("/seminar/book")
	@ResponseBody
	public Map<String, Object> insertSeminar(@RequestBody ReservationPlace request,
			@SessionAttribute(value = "loginMember", required = false) Member loginMember) {


		String reservationDt = (String) request.getReservationDt();
		String start = (String) request.getStartTime();
		String end = (String) request.getEndTime();

		String startTime = reservationDt + " " + start;
		String endTime = reservationDt + " " + end;

		request.setStartTime(startTime);
		request.setEndTime(endTime);

		request.setMemberNo(loginMember.getMemberNo());

		int result = service.insertSeminar(request);

		Map<String, Object> response = new HashMap<>();

		if (result > 0) {
			response.put("status", "success");
		} else {
			response.put("status", "error");
			response.put("message", "예약 처리 중 오류가 발생했습니다.");
		}

		return response;
	}
}
