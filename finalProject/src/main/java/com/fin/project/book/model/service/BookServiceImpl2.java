package com.fin.project.book.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.project.book.model.dao.BookDAO2;

@Service
public class BookServiceImpl2 implements BookService2 {

	@Autowired
	private BookDAO2 dao;
	
}
