package com.fin.project.my.library.model.service;

import java.util.List;
import java.util.Map;

public interface MyLibraryService {

	List<Map<String, Object>> booksLoan(int memberNo);

	Map<String, Object> loanHistory(int memberNo, int cp);

	Map<String, Object> reservationBook(int memberNo, int cp);

	Map<String, Object> bookRequestHistory(int memberNo, int cp);

	Map<String, Object> readingRoomReserv(int memberNo, int cp);

	Map<String, Object> seminarReserv(int memberNo, int cp);

	Map<String, Object> classRegist(int memberNo, int cp);
	
}
