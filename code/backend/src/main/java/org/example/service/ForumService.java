package org.example.service;

import org.example.utils.Result;

public interface ForumService {
    /**
     * 获取所有的论坛信息
     * @param pageSize 页大小
     * @param pageNumber 页号
     * @return 响应结果
     */
    Result getAllForum(Integer pageSize, Integer pageNumber);
}
