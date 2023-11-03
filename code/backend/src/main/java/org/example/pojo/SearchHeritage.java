package org.example.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * @author yt
 */
@Schema(title="分页查询文化遗产参数")
@Data
@Builder
public class SearchHeritage {
    @Schema(title = "地区")
    private String area;
    @Schema(title="公布时间")
    private String postTime;
    @Schema(title="项目名称")
    private String name;
    @Schema(title="当前页面")
    private Integer pageNumber;
    @Schema(title="每页大小")
    private Integer pageSize;
}
