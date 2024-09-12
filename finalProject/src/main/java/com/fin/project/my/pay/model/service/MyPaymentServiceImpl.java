package com.fin.project.my.pay.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.project.board.model.dto.Pagination;
import com.fin.project.my.pay.model.dao.MyPaymentDAO;

@Service
public class MyPaymentServiceImpl implements MyPaymentService {

	@Autowired
	private MyPaymentDAO dao;

	@Override
	public Map<String, Object> payment(int memberNo, int cp) {
		int listCount = dao.getPayment(memberNo);
		
		Pagination pagination = new Pagination(cp, listCount);
		List<Map<String, Object>> list = dao.payment(memberNo, pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("list", list);
		
		return map;
	}
	
	
}
