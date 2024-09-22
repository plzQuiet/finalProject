package com.fin.project.book.model.service;


import java.util.ArrayList;
import java.util.HashMap;
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
	public Map<String, Object> selectBookList(Map<String, Object> paramMap) {
		
		List<Book> bookList = new ArrayList<Book>();
		List<Integer> likeList = new ArrayList<Integer>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(paramMap.containsKey("limit")) {
			bookList = dao.selectBookList(paramMap, Integer.parseInt(String.valueOf(paramMap.get("limit"))));
		}else {
			bookList = dao.selectBookList(paramMap);
		}
		
		if(paramMap.get("memberNo") != "") {
			likeList = dao.selectlikeList(Integer.parseInt(String.valueOf(paramMap.get("memberNo"))));
		}
		
		map.put("bookList", bookList);
		map.put("likeList", likeList);
		
		return map;
	}
    
}
