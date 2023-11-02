package org.example.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzx
 * 湖南省的地级市表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("city")
public class City {
    /**
     * 地级市ID
     */
    @TableId(type = IdType.AUTO)
    private Integer cityId;

    /**
     * 地级市名
     */
    private String cityName;
}
