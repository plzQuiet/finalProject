package com.fin.project.book.model.service;

import java.util.List;
import java.util.Map;

import com.fin.project.book.model.dto.Book;

public interface BookService {

	List<Book> selectBookList(Map<String, Object> paramMap);

}
