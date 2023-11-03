package org.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.micrometer.common.util.StringUtils;
import org.example.common.ResponseStatusEnum;
import org.example.mapper.OfflineActivityMapper;
import org.example.pojo.OfflineActivity;
import org.example.service.OfflineActivityService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yt
 */
@Service
public class OfflineActivityServiceImpl implements OfflineActivityService {

    @Autowired
    OfflineActivityMapper offlineActivityMapper;

    @Override
    public Result getAllOfflineActivity() {
        List<OfflineActivity> list = offlineActivityMapper.selectList(null);
        return Result.success(list);
    }

    @Override
    public Result getAllOfflineActivityByPage(Integer pageSize, Integer pageNumber) {
        IPage<OfflineActivity> page =new Page<>(pageNumber, pageSize);
        offlineActivityMapper.selectPage(page,null);
        Map<String, Object> map = new HashMap<>(5);
        map.put("current",page.getCurrent());
        map.put("total", page.getTotal());
        map.put("size",page.getSize());
        map.put("records", page.getRecords());
        map.put("totalPage",(page.getTotal()+page.getSize()-1)/page.getSize());
        return Result.success(map);
    }

    @Override
    public Result activityPromotionApply(OfflineActivity offlineActivity) {
        if(StringUtils.isBlank(String.valueOf(offlineActivity.getContactId()))){
            return Result.error(ResponseStatusEnum.USERNAME_EMPTY);
        }
        offlineActivity.setCultureId(1);
        offlineActivity.setIsPassed(0);
        int rows = offlineActivityMapper.insert(offlineActivity);
        if(rows>0){
            return Result.success();
        }
        return Result.error(ResponseStatusEnum.ERROR);
    }
}
