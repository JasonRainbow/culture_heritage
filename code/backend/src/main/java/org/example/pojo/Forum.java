package org.example.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

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
