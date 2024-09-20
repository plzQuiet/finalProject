package com.fin.project.book.model.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.project.book.model.dao.BookDAO;
import com.fin.project.book.model.dto.Book;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO dao;

	@Override
	public List<Book> selectBookList(Map<String, Object> paramMap) {
		
		List<Book> bookList = new ArrayList<Book>();
		
		if(paramMap.containsKey("key")) {
			bookList = dao.selectBookList(paramMap);
		}else {
			bookList = dao.selectBookList(paramMap, 5);
		}
		
		return bookList;
	}
    
}
