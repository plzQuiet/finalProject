package com.fin.project.search.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.project.search.model.dao.SearchDAO;
import com.fin.project.search.model.dto.Search;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchDAO searchDAO;

    @Override
    public List<Search> selectBookList(Search search) {
        return searchDAO.selectBookList(search);
    }
}
