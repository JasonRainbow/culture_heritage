package org.example.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@TableName("activity_promotion_apply")
public class ActivityPromotionApply {

    private Integer id;
    @TableField("userId")
    private Integer userId;
    @TableField("activityName")
    private String activityName;
    @TableField("activityArea")
    private String activityArea;
    @TableField("activityTime")
    private Date activityTime;
    @TableField("promotionalWebsite")
    private String promotionalWebsite;
    @TableField("activityIntroduction")
    private String activityIntroduction;

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getActivityArea() {
        return activityArea;
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public String getPromotionalWebsite() {
        return promotionalWebsite;
    }

    public String getActivityIntroduction() {
        return activityIntroduction;
    }
}
