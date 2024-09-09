package com.fin.project.food.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.project.food.model.dao.FoodDAO;

@Service
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	private FoodDAO dao;

	@Override
	public List<Map<String, Object>> selectFoodList() {
		return dao.selectFoodList();
	}
	

	
	
	

}
