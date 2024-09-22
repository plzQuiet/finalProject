package com.fin.project.book.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {
	
    private int bookNo;
    private String bookAuthor;
    private String bookTitle;
    private String bookPub;
    private String bookPubDt;
    private String isbn;
    private String thumbnail;
    private String bookState;
    private String bookSupple;
    
    private String returnDueDate;
    private int resvCount;

}
