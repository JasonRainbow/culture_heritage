package org.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzx
 * 数字非物质文化遗产
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("digital_culture_heritage")
@ApiModel(description = "数字非物质文化遗产表")
public class DigitalCultureHeritage {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键ID")
    private Integer id;

    /**
     * 数字非遗的名称
     */
    @ApiModelProperty("数字非遗的名称")
    private String modelName;

    /**
     * 数字非遗的描述
     */
    @ApiModelProperty("数字非遗的描述")
    private String description;

    /**
     * 数字非遗3D模型的Uri
     */
    @ApiModelProperty("数字非遗3D模型的Uri")
    private String modelUri;

    /**
     * 点赞数
     */
    @ApiModelProperty("点赞数")
    private Integer likes;
}
