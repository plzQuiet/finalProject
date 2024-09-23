package com.fin.project.book.model.service;

import java.util.Map;

public interface BookService2 {

	int update(Map<String, Object> paramMap);

	int approve(Map<String, Object> paramMap);

	int delete(int requestNo);

}
