package com.fin.project.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fin.project.member.model.dto.Member;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter(filterName = "/AdminFilter", urlPatterns = {"/intro/1/8/30/calEdit"})
public class AdminFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("---관리자 필터 생성---");
	}
	
	public void destroy() {
		System.out.println("---이전 관리자 필터 파괴---");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember == null) {
			resp.sendRedirect("/");
		}else if(loginMember.getAuthority() != 2) {
			resp.sendRedirect("/");
		}
		
		chain.doFilter(request, response);
	}

	

}
