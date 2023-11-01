package org.example.service;

import org.example.utils.Result;

public interface OfflineActivityService {
    Result getAllOfflineActivity();

    Result getAllOfflineActivityByPage(Integer pageSize, Integer pageNumber);
}
