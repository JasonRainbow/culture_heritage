package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hzx
 * 湖南省非物质文化遗产分布类
 */
@Data
@AllArgsConstructor
public class CultureHeritageDistributeVO {
    /**
     * 地级市名
     */
    private String cityName;

    /**
     * 非物质文化遗产数量
     */
    private Integer num;

    public CultureHeritageDistributeVO() {
        this.num = 0;
    }
}
