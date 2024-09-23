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
	public int bookcancel(int rNo) {
		return dao.bookcancel(rNo);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int reservcancel(int rNo) {
		return dao.reservcancel(rNo);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int classcancel(int boardNo) {
		return dao.classcancel(boardNo);
	}

	@Override
	public int bookmarkcancel(int bookNo) {
		return dao.bookmarkcancel(bookNo);
	}
	
}
