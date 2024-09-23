package com.fin.project.book.model.service;

import java.util.List;
import java.util.Map;

import com.fin.project.book.model.dto.Book;
import com.fin.project.book.model.dto.BookRequest;

public interface BookService {

	Map<String, Object> selectBookList(Map<String, Object> paramMap);

	int reservation(Map<String, Object> paramMap);

	int insertRequest(Map<String, Object> paramMap);

	Map<String, Object> selectRequestList(int cp);

	BookRequest selectRequestDetail(int requestNo);

	int like(Map<String, Integer> paramMap);

}
