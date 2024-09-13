package com.fin.project.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fin.project.search.model.dto.Search;
import com.fin.project.search.model.service.SearchService;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping("/searchBook")
    @ResponseBody
    public List<Search> searchBook(@RequestBody Search search) {
        return searchService.selectBookList(search);
    }
}
