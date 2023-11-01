package org.example.service;

import org.example.pojo.SearchHeritage;
import org.example.utils.Result;

import java.util.Map;

public interface CultureHeritageService {
    Result getAllHeritageByPage(Integer pageSize, Integer pageNumber);

    Result searchHeritage(SearchHeritage searchHeritage);
}
