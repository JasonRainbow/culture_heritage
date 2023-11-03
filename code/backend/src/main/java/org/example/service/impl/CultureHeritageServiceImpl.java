package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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


/**
 * @author yt
 */
@Service
public class CultureHeritageServiceImpl implements CultureHeritageService {

    @Autowired
    CultureHeritageMapper cultureHeritageMapper;


    @Override
    public Result getAllHeritageByPage(Integer pageSize, Integer pageNumber) {
        IPage<CultureHeritage> page =new Page<>(pageNumber, pageSize);
        LambdaQueryWrapper<CultureHeritage> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByDesc(CultureHeritage :: getAnnouncementTime);
        cultureHeritageMapper.selectPage(page,lambdaQueryWrapper);
        Map<String, Object> map = new HashMap<>(10);
        map.put("current",page.getCurrent());
        map.put("total", page.getTotal());
        map.put("size",page.getSize());
        map.put("records", page.getRecords());
        map.put("totalPage",(page.getTotal()+page.getSize()-1)/page.getSize());
        List<String> postTimeList = cultureHeritageMapper.searchAllPostTime();
        map.put("postTimeList",postTimeList);
        List<String> areaList = cultureHeritageMapper.searchAllArea();
        map.put("areaList",areaList);
        return Result.success(map);
    }

    @Override
    public Result searchHeritage(SearchHeritage searchHeritage) {
        Page<CultureHeritage> page = new Page<>(searchHeritage.getPageNumber(), searchHeritage.getPageSize());
        QueryWrapper<CultureHeritage> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!StringUtils.isBlank(searchHeritage.getArea()),"declaringUnit",searchHeritage.getArea())
                .like(!StringUtils.isBlank(searchHeritage.getPostTime()),"announcementTime",searchHeritage.getPostTime())
                .like(!StringUtils.isBlank(searchHeritage.getName()),"name",searchHeritage.getName());
        queryWrapper.orderByDesc("announcementTime");
        cultureHeritageMapper.selectPage(page,queryWrapper);
        Map<String, Object> map = new HashMap<>(5);
        map.put("current",page.getCurrent());
        map.put("total", page.getTotal());
        map.put("size",page.getSize());
        map.put("records", page.getRecords());
        map.put("totalPage",(page.getTotal()+page.getSize()-1)/page.getSize());
        return Result.success(map);
    }

    @Override
    public List<CultureHeritageDistributeVO> getCultureHeritageDistribute() {
        return cultureHeritageMapper.selectCultureHeritageDistribute();
    }

    @Override
    public Page<CultureHeritage> getHotHeritageByPage(int pageNum, int pageSize) {
        QueryWrapper<CultureHeritage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("topic", 1);

        return cultureHeritageMapper.selectPage(new Page<>(pageNum, pageSize), queryWrapper);
    }
}
