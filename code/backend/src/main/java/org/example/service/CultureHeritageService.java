package org.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.pojo.CultureHeritage;
import org.example.pojo.CultureHeritageDistributeVO;
import org.example.pojo.SearchHeritage;
import org.example.utils.Result;

import java.util.List;
import java.util.Map;

/**
 * @author hzx
 */
public interface CultureHeritageService {
    /**
     * 分页查询所有的非物质文化遗产
     * @param pageSize 页大小
     * @param pageNumber 页号
     * @return 结果
     */
    Result getAllHeritageByPage(Integer pageSize, Integer pageNumber);

    /**
     * 带参数的分页查询非物质文化遗产
     * @param searchHeritage 查询实体
     * @return 结果
     */
    Result searchHeritage(SearchHeritage searchHeritage);

    /**
     * 查询非物质文化遗产在各地级市的分布情况
     * @return 列表
     */
    List<CultureHeritageDistributeVO> getCultureHeritageDistribute();

    /**
     * 分页查询所有的热点非物质文化遗产
     * @param pageNum 页大小
     * @param pageSize 页号
     * @return 页
     */
    Page<CultureHeritage> getHotHeritageByPage(int pageNum, int pageSize);
}
