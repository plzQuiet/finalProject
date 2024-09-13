package com.fin.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fin.project.member.model.dao.AjaxDAO;

@Service
public class AjaxServiceImpl implements AjaxService {

	@Autowired
	private AjaxDAO dao;

	@Override
	public int dupCheckEmail(String email) {
		return dao.dupCheckEmail(email);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int bookCancle(int rNo) {
		return dao.bookCancle(rNo);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int reservCancle(int rNo) {
		return dao.reservCancle(rNo);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int classCancle(int boardNo) {
		return dao.classCancle(boardNo);
	}

	@Override
	public int bookmarkCancle(int bookNo) {
		return dao.bookmarkCancle(bookNo);
	}
	
}
