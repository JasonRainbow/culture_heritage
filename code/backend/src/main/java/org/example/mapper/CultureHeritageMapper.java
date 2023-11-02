package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.pojo.CultureHeritage;
import org.example.pojo.CultureHeritageDistributeVO;

import java.util.List;

public interface CultureHeritageMapper extends BaseMapper<CultureHeritage> {

    public List searchAllPostTime();

    public List searchAllArea();

    /**
     * 查询非物质文化遗产的分布情况
     * @return 列表
     */
    List<CultureHeritageDistributeVO> selectCultureHeritageDistribute();
}
