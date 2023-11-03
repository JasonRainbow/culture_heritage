package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.pojo.CultureHeritage;
import org.example.pojo.CultureHeritageDistributeVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yt
 */
@Repository
public interface CultureHeritageMapper extends BaseMapper<CultureHeritage> {

    /**
     * 查询所有的非遗的公布时间
     * @return 列表
     */
     List<String> searchAllPostTime();

    /**
     * 查询所有的发布单位
     * @return 列表
     */
     List<String> searchAllArea();

    /**
     * 查询非物质文化遗产的分布情况
     * @return 列表
     */
    List<CultureHeritageDistributeVO> selectCultureHeritageDistribute();
}
