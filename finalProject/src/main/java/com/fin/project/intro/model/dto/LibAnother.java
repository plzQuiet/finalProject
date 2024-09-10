package com.fin.project.intro.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LibAnother {
	
	
	private int boardNo; // 보드번호
	private String libraryAddress; // 주변 도서관 주소
	private String searchLat; // 주변 도서관 위도
	private String searchLng; // 주변 도서관 경도

}
