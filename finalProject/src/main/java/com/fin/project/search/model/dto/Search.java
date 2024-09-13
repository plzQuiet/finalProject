package com.fin.project.search.model.dto;

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

    // 검색에 필요한 필드 추가
    private String key;   // 검색 카테고리
    private String query; // 검색어
}
