package org.example.service;

import org.example.pojo.OfflineActivity;
import org.example.utils.Result;

/**
 * @author yt
 */
public interface OfflineActivityService {
    /**
     * 查询所有的线下活动列表
     * @return 线下活动列表
     */
    Result getAllOfflineActivity();

    /**
     * 分页查询线下活动信息
     * @param pageSize 页大小
     * @param pageNumber 页号
     * @return 页
     */
    Result getAllOfflineActivityByPage(Integer pageSize, Integer pageNumber);

    /**
     * 添加活动信息
     * @param offlineActivity 活动
     * @return 响应结果
     */
    Result activityPromotionApply(OfflineActivity offlineActivity);
}
