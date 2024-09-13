package com.fin.project.member.model.service;


public interface AjaxService {

	int dupCheckEmail(String email);

	int bookCancle(int rNo);

	int reservCancle(int rNo);

	int classCancle(int boardNo);

	int bookmarkCancle(int bookNo);
	
}
