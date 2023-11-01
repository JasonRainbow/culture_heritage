package org.example.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Offlineexperience {
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
