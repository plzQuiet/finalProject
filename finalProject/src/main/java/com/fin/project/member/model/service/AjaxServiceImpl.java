package com.fin.project.member.model.service;

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
	
}
