package com.fin.project.search.controller;


import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fin.project.search.model.service.SearchService;

@Controller
@SessionAttributes("loginMember")
@RequestMapping("/search")

public class SearchController {
	
	@Autowired
    private SearchService Service;
	
	// 책 검색 
	@GetMapping("/{cateCode:10}")
	public String selectBookList(String query, String key) {
		System.out.println(query);
		System.out.println(key);
		return null;
	}

    
}

