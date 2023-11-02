package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.micrometer.common.util.StringUtils;
import org.example.mapper.CultureHeritageMapper;
import org.example.pojo.CultureHeritage;
import org.example.pojo.CultureHeritageDistributeVO;
import org.example.pojo.SearchHeritage;
import org.example.service.CultureHeritageService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CultureHeritageServiceImpl implements CultureHeritageService {

    @Autowired
    CultureHeritageMapper cultureHeritageMapper;

    @Override
    public Result getAllHeritageByPage(Integer pageSize, Integer pageNumber) {
        IPage<CultureHeritage> page =new Page<>(pageNumber, pageSize);
        cultureHeritageMapper.selectPage(page,null);
        Map map = new HashMap();
        map.put("current",page.getCurrent());
        map.put("total", page.getTotal());
        map.put("size",page.getSize());
        map.put("records", page.getRecords());
        return Result.success(map);
    }

    @Override
    public Result searchHeritage(SearchHeritage searchHeritage) {
        Page<CultureHeritage> page = new Page<>(searchHeritage.getPageNumber(), searchHeritage.getPageSize());
        QueryWrapper<CultureHeritage> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!StringUtils.isBlank(searchHeritage.getArea()),"declaringUnit",searchHeritage.getArea())
                .like(!StringUtils.isBlank(searchHeritage.getPostTime()),"announcementTime",searchHeritage.getPostTime())
                .like(!StringUtils.isBlank(searchHeritage.getName()),"name",searchHeritage.getName());
        cultureHeritageMapper.selectPage(page,queryWrapper);
        Map map = new HashMap();
        map.put("current",page.getCurrent());
        map.put("total", page.getTotal());
        map.put("size",page.getSize());
        map.put("records", page.getRecords());
        return Result.success(map);
    }

    @Override
    public List<CultureHeritageDistributeVO> getCultureHeritageDistribute() {
        return cultureHeritageMapper.selectCultureHeritageDistribute();
    }
}
