package com.fin.project.intro.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.project.intro.dao.IntroDAO;

@Service
public class IntroServiceImpl implements IntroService {
	
	@Autowired
	private IntroDAO dao;

	// 카테고리 목록을 가져오는 서비스
	@Override
	public List<Map<String, Object>> selectCategoryList() {
		return dao.selectCategoryList();
	}

}
