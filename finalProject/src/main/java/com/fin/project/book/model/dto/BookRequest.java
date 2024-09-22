package com.fin.project.book.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookRequest {

	private int requestNo;
	private int memberNo;
	private String memberName;
	private String requestTitle;
	private String requestDate;
	private String requestApprove;
	private String requestOpinion;
	private String bookAuthor;
	private String bookTitle;
	private String bookPub;
	private String bookPubDate;
	
}
