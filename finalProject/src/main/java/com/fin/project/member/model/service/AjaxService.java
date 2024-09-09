package com.fin.project.member.model.service;

import java.util.List;
import java.util.Map;

public interface AjaxService {

	int dupCheckEmail(String email);

	List<Map<String, Object>> booksLoan(int memberNo);

	List<Map<String, Object>> loanHistory(int memberNo);

	List<Map<String, Object>> reservationBook(int memberNo);

	List<Map<String, Object>> bookRequestHistory(int memberNo);
	
}
