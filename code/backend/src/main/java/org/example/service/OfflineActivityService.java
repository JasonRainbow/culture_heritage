package org.example.service;

import org.example.pojo.OfflineActivity;
import org.example.utils.Result;

public interface OfflineActivityService {
    Result getAllOfflineActivity();

    Result getAllOfflineActivityByPage(Integer pageSize, Integer pageNumber);

    Result activityPromotionApply(OfflineActivity offlineActivity);
}
