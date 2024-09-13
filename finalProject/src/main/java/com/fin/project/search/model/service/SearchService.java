package com.fin.project.search.model.service;

import java.util.List;

import com.fin.project.search.model.dto.Search;

public interface SearchService {
    // Search 객체를 받아서 검색 결과 리스트를 반환
    List<Search> selectBookList(Search search);
}
