package com.fin.project.member.model.service;


public interface AjaxService {

	int dupCheckEmail(String email);

	int bookcancel(int rNo);

	int reservcancel(int rNo);

	int classcancel(int boardNo);

	int bookmarkcancel(int bookNo);
	
}
