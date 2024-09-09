package com.fin.project.member.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.project.member.model.dao.AjaxDAO;

@Service
public class AjaxServiceImpl implements AjaxService {

	@Autowired
	private AjaxDAO dao;

	@Override
	public int dupCheckEmail(String email) {
		return dao.dupCheckEmail(email);
	}
	
	@Override
	public List<Map<String, Object>> booksLoan(int memberNo) {
		return dao.booksLoan(memberNo);
	}

	@Override
	public List<Map<String, Object>> loanHistory(int memberNo) {
		return dao.loanHistory(memberNo);
	}

	@Override
	public List<Map<String, Object>> reservationBook(int memberNo) {
		return dao.reservationBook(memberNo);
	}

	@Override
	public List<Map<String, Object>> bookRequestHistory(int memberNo) {
		return dao.bookRequestHistory(memberNo);
	}
	
}
