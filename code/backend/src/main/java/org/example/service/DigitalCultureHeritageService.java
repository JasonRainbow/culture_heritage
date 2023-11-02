package org.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.pojo.DigitalCultureHeritage;

/**
 * @author hzx
 */
public interface DigitalCultureHeritageService {
    /**
     * 分页查询数字非物质文化遗产
     * @param pageNum 页号
     * @param pageSize 页大小
     * @return 列表
     */
    Page<DigitalCultureHeritage> findAllByPage(int pageNum, int pageSize);
}
