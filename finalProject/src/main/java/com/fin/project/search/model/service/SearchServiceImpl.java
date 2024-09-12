package com.fin.project.search.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fin.project.search.model.dao.SearchDAO;

@Service
public class SearchServiceImpl implements SearchService{
	
	@Autowired
	private SearchDAO dao;

}
