package com.fin.project.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fin.project.board.model.dto.Comment;
import com.fin.project.board.model.service.CommentService;

@RestController // @Controller + @ResponseBody
public class CommentController {
	
	@Autowired
	private CommentService service;
	
	// 댓글 목록 조회
	@GetMapping(value="/comment", produces = "applicaiton/json; charset=UTF-8")
	public List<Comment> select(int boardNo) {
		
		return service.select(boardNo);
	}
	
	// 댓글 작성
	@PostMapping("/comment")
	public int insert(@RequestBody Comment comment) {
		
		return service.insert(comment);
	}
	
	// 댓글 수정
	@PutMapping("/comment")
	public int update(@RequestBody Comment comment) {
		
		return service.update(comment);
	}
	
	// 댓글 삭제
	@DeleteMapping("/comment")
	public int delete(@RequestBody int commentNo) {
		
		return service.update(commentNo);
	}

}
