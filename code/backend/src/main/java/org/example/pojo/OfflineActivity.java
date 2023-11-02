package org.example.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("offlineexperience")
public class OfflineActivity {
    @TableField("activityId")
    private Integer activityId;
    @TableField("cultureId")
    private Integer cultureId;
    @TableField("contactId")
    private Integer contactId;
    @TableField("activityName")
    private String activityName;
    @TableField("tradeName")
    private String tradeName;
    @TableField("businessHours")
    private String businessHours;
    private String venue;
    private String introduction;
    @TableField("activityPhoto")
    private String activityPhoto;
    @TableField("praiseNumber")
    private Integer praiseNumber;
    private Integer status;
    private String detail;
}
