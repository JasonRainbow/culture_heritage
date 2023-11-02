package org.example.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @author hzx
 * 论坛实体类
 */
@Data
@Builder
@TableName("comment")
public class Forum {
    @TableField("commentId")
    private Integer commentId;
    @TableField("cultureId")
    private Integer cultureId;
    @TableField("releaseTime")
    private String releaseTime;

    private String summary;

    private String picture;

    private String more;

    private String title;
}
