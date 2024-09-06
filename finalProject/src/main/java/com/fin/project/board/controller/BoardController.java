package com.fin.project.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fin.project.board.model.service.BoardService;

@SessionAttributes("loginMember")
@RequestMapping("/board")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;


}
