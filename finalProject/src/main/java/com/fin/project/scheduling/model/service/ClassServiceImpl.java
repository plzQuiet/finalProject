package com.fin.project.scheduling.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.project.scheduling.model.dao.ClassDAO;

@Service
public class ClassServiceImpl implements ClassService{
	
	@Autowired
	private ClassDAO dao;

}
