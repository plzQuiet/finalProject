package com.fin.project.common.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fin.project.intro.service.IntroService;

public class CategoryInterceptor implements HandlerInterceptor {
	
	@Autowired
	private IntroService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		ServletContext application = request.getServletContext();
		
		if(application.getAttribute("category") == null) {
			List<Map<String, Object>> category = service.selectCategoryList();
			System.out.println(category);
			
			application.setAttribute("category", category);
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
