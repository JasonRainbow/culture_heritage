package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.pojo.ActivityPromotionApply;
import org.example.pojo.User;

public interface UserMapper extends BaseMapper<User> {
    int insertActivityPromotionApply(ActivityPromotionApply activityPromotionApply);
}
