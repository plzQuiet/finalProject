package com.fin.project.book.model.service;

import java.util.List;
import java.util.Map;

import com.fin.project.book.model.dto.Book;

public interface BookService {

	Map<String, Object> selectBookList(Map<String, Object> paramMap);

	int reservation(Map<String, Object> paramMap);

}
