package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.pojo.ActivityPromotionApply;
import org.example.pojo.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    int insertActivityPromotionApply(ActivityPromotionApply activityPromotionApply);

}
