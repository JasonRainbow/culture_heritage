package org.example.service;

import org.example.utils.Result;

public interface ForumService {
    Result getAllForum(Integer pageSize, Integer pageNumber);
}
