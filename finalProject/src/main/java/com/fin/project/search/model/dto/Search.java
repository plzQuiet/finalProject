package com.fin.project.search.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Search {
    private int bookNo;
    private String bookAuthor;
    private String bookTitle;
    private String bookPub;
    private String bookPubDt;
    private String bookIsbn;
    private String bookThumbnail;
    private String bookState;
    private String bookSupple;

    // Getters and Setters
    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookPub() {
        return bookPub;
    }

    public void setBookPub(String bookPub) {
        this.bookPub = bookPub;
    }

    public String getBookPubDt() {
        return bookPubDt;
    }

    public void setBookPubDt(String bookPubDt) {
        this.bookPubDt = bookPubDt;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getBookThumbnail() {
        return bookThumbnail;
    }

    public void setBookThumbnail(String bookThumbnail) {
        this.bookThumbnail = bookThumbnail;
    }

    public String getBookState() {
        return bookState;
    }

    public void setBookState(String bookState) {
        this.bookState = bookState;
    }

    public String getBookSupple() {
        return bookSupple;
    }

    public void setBookSupple(String bookSupple) {
        this.bookSupple = bookSupple;
    }
}

