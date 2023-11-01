package org.example.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("offlineexperience")
public class OfflineActivity {
    private Integer activityId;
    private Integer cultureId;
    private Integer contactId;
    private String activityName;
    private String tradeName;
    private String businessHours;
    private String venue;
    private String introduction;
    private String activityPhoto;
    private Integer praiseNumber;
    private Integer status;
}
