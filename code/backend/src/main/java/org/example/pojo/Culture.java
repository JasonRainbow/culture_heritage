package org.example.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Culture {
    @TableField("cultureId")
    private Integer cultureId;
    private String name;
    private String category;
    private String kind;
    @TableField("announcementTime")
    private String announcementTime;
    @TableField("productNumber")
    private Integer productNumber;
    @TableField("declaringUnit")
    private String  declaringUnit;
    @TableField("protectionUnit")
    private String protectionUnit;
    private String introduction;
    private String model;
}
